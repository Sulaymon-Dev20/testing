package asdum.uz.map.dataaccess;

import asdum.uz.map.model.BusStop;
import asdum.uz.map.model.enums.BusStopStatusEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BusMapAccessor {
    // Attributes --------------------------------------------------------
    private static HashMap<Long, BusStop> busMap;
    private static HashMap<BusStopStatusEnum, List<BusStop>> statusMap;
    // -------------------------------------------------------------------

    // SINGLETON Implementation ------------------------------------------
    private static BusMapAccessor INSTANCE = new BusMapAccessor();

    private BusMapAccessor() {
        initialize();
    }

    public static BusMapAccessor getInstance() {
        return INSTANCE;
    }

    private static void initialize() {
        busMap = new HashMap<Long, BusStop>();
        statusMap = new HashMap<BusStopStatusEnum, List<BusStop>>();
    }

    public List<BusStop> getAllBusStops() {
        synchronized (BusMapAccessor.class) {
            return new ArrayList<BusStop>(busMap.values());
        }
    }

    public List<BusStop> getBusStops(BusStopStatusEnum status) {
        synchronized (BusMapAccessor.class) {
            if (status == BusStopStatusEnum.ALL) {
                return getAllBusStops();
            } else if (status == BusStopStatusEnum.BUS_STOP) {
                return new ArrayList<BusStop>();
            } else {
                return statusMap.get(status);
            }
        }
    }

    public boolean busStopExist(long id) {
        synchronized (BusMapAccessor.class) {
            return busMap.containsKey(id);
        }
    }

    public BusStop getBusStop(long id) {
        synchronized (BusMapAccessor.class) {
            return busMap.get(id);
        }
    }

    public void addBusStop(BusStop busStop) {
        synchronized (BusMapAccessor.class) {
            busMap.put(busStop.getId(), busStop);
            addToStatusMap(busStop);
        }
    }

    public void updateBusStop(BusStop busStop) {
        synchronized (BusMapAccessor.class) {
            updateStatusChange(busStop);
            busMap.put(busStop.getId(), busStop);
        }
    }

    public BusStop removeBusStop(long id) {
        synchronized (BusMapAccessor.class) {
            removeFromStatusMap(busMap.get(id));
            return busMap.remove(id);
        }
    }

    public void removeAllBusStop() {
        synchronized (BusMapAccessor.class) {
            List<BusStop> busStops = BusMapAccessor.getInstance().getBusStops(BusStopStatusEnum.ALL);
            for (BusStop busStop : busStops) {
                removeFromStatusMap(busStop);
            }
        }
    }

    private void addToStatusMap(BusStop busStop) {
        synchronized (BusMapAccessor.class) {
            BusStopStatusEnum status = busStop.getStatusEnum();
            List<BusStop> busStops;

            if (statusMap.containsKey(status)) {
                busStops = statusMap.get(status);
            } else {
                busStops = new ArrayList<BusStop>();
                statusMap.put(status, busStops);
            }
            busStops.add(busStop);
        }
    }

    private void updateStatusChange(BusStop updatedBusStop) {
        synchronized (BusMapAccessor.class) {
            if (busMap.containsKey(updatedBusStop.getId())) {
                BusStop existingBusStop = busMap.get(updatedBusStop.getId());
                if (existingBusStop.getStatusEnum() != updatedBusStop.getStatusEnum()) {
                    removeFromStatusMap(existingBusStop);
                    addToStatusMap(updatedBusStop);
                }
            }
        }
    }

    private void removeFromStatusMap(BusStop busStop) {
        synchronized (BusMapAccessor.class) {
            if (busMap.containsKey(busStop.getId())) {
                if (statusMap.containsKey(busStop.getStatusEnum())) {
                    statusMap.get(busStop.getStatusEnum()).remove(busStop);
                }
            }
        }
    }
}
