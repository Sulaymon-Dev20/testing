package asdum.uz.map.server;

import asdum.uz.config.CacheConfig;
import asdum.uz.controller.MarshrutController;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.metro.MetroRepository;
import asdum.uz.map.metro.MetroStop;
import asdum.uz.map.model.BusStop;
import asdum.uz.map.model.Root;
import asdum.uz.map.model.Root2;
import asdum.uz.map.model.enums.BusStopStatusEnum;
import asdum.uz.payload.ResStations;
import com.hazelcast.core.IFunction;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@PropertySource("classpath:application.properties")
@PropertySource("classpath:metro.yml")
public class BusStopService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CacheConfig cacheConfig;

    @Autowired
    MarshrutController marshrutController;

    @Autowired
    MetroRepository metroRepository;

    @Value("${first}")
    private String firstLine;

    @Value("${second}")
    private String secondLine;

    @Value("${third}")
    private String thirdLine;

    @Value("${fourth}")
    private String fourthLine;

    public Root filter(Root2 root2) {
        try {
            List<Object> objects = new ArrayList<>();
//            List<MetroStop> metroStops = new ArrayList<>();
            if (root2.getBPoint().getStatus() == null && root2.getAPoint().getStatus() == null) {
                IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
                IMap<Long, Object> routeProps = cacheConfig.getRoutes().getMap("routeProps");
                List<Long> listA = stationRoutes.get(root2.getAPoint().getId());
                List<Long> listB = stationRoutes.get(root2.getBPoint().getId());
                if (listA != null && listB != null) {
                    for (Long aLong : new HashSet<>(listA)) {
                        Object o = routeProps.get(aLong);
                        for (Long bLong : new HashSet<>(listB)) {
                            if (aLong.hashCode() == bLong.hashCode()) {
                                objects.add(o);
                            }
                        }
                    }
                }
//                IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
//                Set<Long> targetSet = new HashSet<>(list);
//                Map<Long, Map<String, Object>> routePropsAll = routeProps.getAll(targetSet);
//                List<Map<String, Object>> list1 = new ArrayList<>();
//                for (Map.Entry<Long, Map<String, Object>> route : routePropsAll.entrySet()) {
//                    Long key = route.getKey();
//                    Map<String, Object> value = route.getValue();
//                    value.put("route_id", key);
//                    list1.add(value);
//                }
            } else {
                List<MetroStop> all = root2.getAPoint().getId() < root2.getBPoint().getId() ? metroRepository.findAllByRoute(root2.getAPoint().getRoute()) : metroRepository.findAllByRoute2(root2.getAPoint().getRoute());
                if (root2.getAPoint().getRoute().hashCode() == root2.getBPoint().getRoute().hashCode()) {
                    boolean status = false;
                    if (root2.getAPoint().getRoute().hashCode() == root2.getBPoint().getRoute().hashCode()) {
                        objects.add(root2.getAPoint().getRoute());
                        for (MetroStop metroStop : all) {
                            if (metroStop.getTunnels().contains(String.valueOf(root2.getAPoint().getId()))) {
                                status = true;
                            }
                            if (status) {
                                objects.add(metroStop);
                            }
                            if (metroStop.getTunnels().contains(String.valueOf(root2.getBPoint().getId()))) {
                                status = false;
                            }
                        }
                    } else if (root2.getAPoint().getRoute().hashCode() != root2.getBPoint().getRoute().hashCode()) {
                        objects.add(root2.getAPoint().getRoute());
                        objects.add(root2.getBPoint().getRoute());
                        if (root2.getAPoint().getRoute().hashCode() == firstLine.hashCode()) {
                            Optional<MetroStop> metroStop = metroRepository.selectStations("paxtakor");
                            if (metroStop.isPresent()) {
                                for (MetroStop chilonzor : all) {
                                    if (chilonzor.getTunnels().contains(String.valueOf(root2.getAPoint().getId()))) {
                                        status = true;
                                    }
                                    if (status) {
                                        objects.add(chilonzor);
                                    }
                                    if (chilonzor.getId().hashCode() == metroStop.get().getId().hashCode()) {
                                        status = false;
                                    }
                                }
                            }
                        } else if (root2.getAPoint().getRoute().hashCode() == secondLine.hashCode()) {

                        } else if (root2.getAPoint().getRoute().hashCode() == thirdLine.hashCode()) {

                        }
                        if (root2.getAPoint().getRoute().hashCode() == fourthLine.hashCode() || root2.getBPoint().getRoute().hashCode() == fourthLine.hashCode()) {
                            objects.add(firstLine);
                        }
                    }
                }
            }
            return new Root(root2.getAPoint().getStatus() == null ? "BUS_STOP" : "METRO", root2.getAPoint(), root2.getBPoint(), null, objects, root2.getDistanceA(), root2.getDistance(), root2.getDistanceB());
//            return new Root("BUS_STOP", root2.getAPoint(), root2.getBPoint(), null, objects, root2.getDistanceA(), root2.getDistance(), root2.getDistanceB());
        } catch (Exception e) {
            return new Root("Bus null", root2.getAPoint(), root2.getBPoint(), null, null, root2.getDistanceA(), root2.getDistance(), root2.getDistanceB());
        }
    }

    public Object getRoot(Long aPointId, Long bPointId, String busId) {
        List<Object> objects = new ArrayList<>();
        if (busId.hashCode() != "METRO".hashCode()) {
            ResStations stationsBySort = marshrutController.getStationsBySort(Long.parseLong(busId));
            boolean status = false;
            for (Object o : stationsBySort.getKpp1()) {
                if (o.toString().substring(3, 10).contains(aPointId.toString())) {
                    System.out.println(o.toString().substring(3, 8));
                    status = true;
                }
                if (status) {
                    objects.add(o.toString().substring(3, 8));
                }
                if (o.toString().substring(0, 10).contains(bPointId.toString())) {
                    status = false;
                }
            }
        } else {
            for (BusStop busStop : BusMapAccessor.getInstance().getBusStops(BusStopStatusEnum.ALL)) {
                if (busStop.getId() < 100) {
                    objects.add(busStop);
                }
            }
        }
        return objects;
    }
}
