 package asdum.uz.map.server;

import asdum.uz.config.CacheConfig;
import asdum.uz.controller.MarshrutController;
import asdum.uz.entity.enums.ResStatusEnum;
import asdum.uz.map.ctrl.BusMapQueryHandler;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.metro.MetroRepository;
import asdum.uz.map.model.BusStop;
import asdum.uz.map.model.Root;
import asdum.uz.map.model.Root2;
import asdum.uz.map.test.Test2;
import asdum.uz.payload.ApiResponseModel;
import asdum.uz.payload.ResStations;
import com.hazelcast.core.IMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
@PropertySource("classpath:application.properties")
//@PropertySource("classpath:metro.yml")
public class BusStopService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CacheConfig cacheConfig;

    @Autowired
    MarshrutController marshrutController;

    @Autowired
    MetroRepository metroRepository;
/*
    @Value("${first}")
    private String firstLine;

    @Value("${second}")
    private String secondLine;

    @Value("${third}")
    private String thirdLine;

    @Value("${fourth}")
    private String fourthLine;*/

    public Root filter(Root2 root2) {
        try {
            List<Object> routs = new ArrayList<>();
            Object root = null;
            if (root2.getBPoint().getStatus() == null && root2.getAPoint().getStatus() == null) {
                IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
                IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
                List<Map<String, Object>> list1 = new ArrayList<>();
                List<Map<String, Object>> list2 = new ArrayList<>();
                System.out.println(list1);
                System.out.println(list2);
                if (list1.toString().length() > 5 && list2.toString().length() > 5) {
                    for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(stationRoutes.get(root2.getAPoint().getId()))).entrySet()) {
                        Map<String, Object> value = route.getValue();
                        value.put("route_id", route.getKey());
                        list1.add(value);
                    }
                    for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(stationRoutes.get(root2.getBPoint().getId()))).entrySet()) {
                        Map<String, Object> value = route.getValue();
                        value.put("route_id", route.getKey());
                        list2.add(value);
                    }
                    for (Map<String, Object> stringObjectMap : list1) {
                        for (Map<String, Object> objectMap : list2) {
                            if (stringObjectMap.hashCode() == objectMap.hashCode()) {
                                routs.add(stringObjectMap);
                            }
                        }
                    }
                }
/*                boolean status = true;
                for (Long s : idListA) {
                    if (status) {
                        for (Long s1 : idListB) {
                            if (status) {
                                if (s.hashCode() == s1.hashCode()) {
                                    root = getRoot(root2.getAPoint().getId(), root2.getBPoint().getId(), s1);
                                    System.out.println(root);
                                    status = false;
                                }
                            }
                        }
                    }
                }*/
            }
           /* else {
                List<MetroStop> all = root2.getAPoint().getId() < root2.getBPoint().getId() ? metroRepository.findAllByRoute(root2.getAPoint().getRoute()) : metroRepository.findAllByRoute2(root2.getAPoint().getRoute());
                if (root2.getAPoint().getRoute().hashCode() == root2.getBPoint().getRoute().hashCode()) {
                    boolean status = false;
                    if (root2.getAPoint().getRoute().hashCode() == root2.getBPoint().getRoute().hashCode()) {
                        routs.add(root2.getAPoint().getRoute());
                        for (MetroStop metroStop : all) {
                            if (metroStop.getTunnels().contains(String.valueOf(root2.getAPoint().getId()))) {
                                status = true;
                            }
                            if (status) {
                                routs.add(metroStop);
                            }
                            if (metroStop.getTunnels().contains(String.valueOf(root2.getBPoint().getId()))) {
                                status = false;
                            }
                        }
                    } else if (root2.getAPoint().getRoute().hashCode() != root2.getBPoint().getRoute().hashCode()) {
                        routs.add(root2.getAPoint().getRoute());
                        routs.add(root2.getBPoint().getRoute());
                        if (root2.getAPoint().getRoute().hashCode() == firstLine.hashCode()) {
                            Optional<MetroStop> metroStop = metroRepository.selectStations("paxtakor");
                            if (metroStop.isPresent()) {
                                for (MetroStop chilonzor : all) {
                                    if (chilonzor.getTunnels().contains(String.valueOf(root2.getAPoint().getId()))) {
                                        status = true;
                                    }
                                    if (status) {
                                        routs.add(chilonzor);
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
                            routs.add(firstLine);
                        }
                    }
                }
            }*/
            return new Root(root2.getAPoint().getStatus() == null ? "BUS_STOP" : "METRO", root2.getAPoint(), root2.getBPoint(), routs, root2.getDistanceA(), root2.getDistance(), root2.getDistanceB());
        } catch (Exception e) {
            return new Root(null, null, null, null, null, null, null);
        }
    }

/*
    public ApiResponseModel test(double aPointLat, double aPointLng, double bPointLat, double bPointLng) {
        IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
        IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
        Test2 test2 = BusMapQueryHandler.getInstance().test(aPointLat, aPointLng, bPointLat, bPointLng);
        List<Map<String, Object>> list1 = new ArrayList<>();
        List<Map<String, Object>> list2 = new ArrayList<>();
        List<Object> routs = new ArrayList<>();
        List<Response> responses = new ArrayList<>();
        if (list1.toString().length() >= 3 && list2.toString().length() >= 3) {
            for (BusStop busStop : test2.getA()) {
                for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(stationRoutes.get(busStop.getId()))).entrySet()) {
                    Map<String, Object> value = route.getValue();
                    value.put("route_id", route.getKey());
                    list1.add(value);
                }
            }
            for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(stationRoutes.get(test2.getB().getId()))).entrySet()) {
                Map<String, Object> value = route.getValue();
                value.put("route_id", route.getKey());
                list2.add(value);
            }
            for (Map<String, Object> stringObjectMap : list1) {
                for (Map<String, Object> objectMap : list2) {
                    if (stringObjectMap.hashCode() == objectMap.hashCode()) {
                        routs.add(stringObjectMap);
                    }
                }
            }
            for (BusStop busStop : test2.getA()) {
                responses.add(new Response(busStop, test2.getB(), routs, distance(aPointLat, aPointLat, busStop.getLat(), busStop.getLng(), 'M'), distance(busStop.getLat(), busStop.getLng(), test2.getB().getLat(), test2.getB().getLng(), 'M'), distance(test2.getB().getLat(), test2.getB().getLng(), bPointLat, bPointLng, 'M')));
            }
        }
        return new ApiResponseModel(ResStatusEnum.INFO, "200", responses);
    }
*/

    public ApiResponseModel test2(double aPointLat, double aPointLng, double bPointLat, double bPointLng) {
        IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
        IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
        Test2 test2 = BusMapQueryHandler.getInstance().test(aPointLat, aPointLng, bPointLat, bPointLng);
        List<Response> responses = new ArrayList<>();
        int indexA = 0;
        List<BusStop> a = test2.getA();
        while (a.size() != indexA) {
            BusStop busStop = a.get(indexA);
            indexA++;
            List<Map<String, Object>> list1 = new ArrayList<>();
            List<Map<String, Object>> list2 = new ArrayList<>();
            List<Long> longList = stationRoutes.get(busStop.getId());
            if (longList != null) {
                for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(longList)).entrySet()) {
                    Map<String, Object> value = route.getValue();
                    value.put("route_id", route.getKey());
                    list1.add(value);
                }
            }
            int indexB = 0;
            while (test2.getB().size() != indexB) {
                BusStop stop = test2.getB().get(indexB);
                indexB++;
                List<Object> routs = new ArrayList<>();
                List<Long> list = stationRoutes.get(stop.getId());
                if (list != null) {
                    for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(list)).entrySet()) {
                        Map<String, Object> value = route.getValue();
                        value.put("route_id", route.getKey());
                        list2.add(value);
                    }
                }
                int bigIndex = 0;
                while (list1.size() != bigIndex) {
                    int index = 0;
                    while (list2.size() != index) {
                        Map<String, Object> stringObjectMap1 = list2.get(index);
                        if (list1.get(bigIndex).hashCode() == stringObjectMap1.hashCode()) {
                            routs.add(stringObjectMap1);
                        }
                        index++;
                    }
                    bigIndex++;
                }
                responses.add(new Response(busStop, stop, routs, distance(aPointLat, aPointLat, busStop.getLat(), busStop.getLng(), 'M'), distance(busStop.getLat(), busStop.getLng(), stop.getLat(), stop.getLng(), 'M'), distance(stop.getLat(), stop.getLng(), bPointLat, bPointLng, 'M')));
            }
        }
        return new ApiResponseModel(ResStatusEnum.INFO, "200", responses);
    }

    public ApiResponseModel test3(double aPointLat, double aPointLng, double bPointLat, double bPointLng) {
        IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
        IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
        Test2 test2 = BusMapQueryHandler.getInstance().test(aPointLat, aPointLng, bPointLat, bPointLng);
        List<Response> responses = new ArrayList<>();
        int indexA = 0;
        List<BusStop> a = test2.getA();
        while (a.size() != indexA) {
            BusStop busStop = a.get(indexA);
            indexA++;
            List<Map<String, Object>> list1 = new ArrayList<>();
            List<Map<String, Object>> list2 = new ArrayList<>();
            List<Long> longList = stationRoutes.get(busStop.getId());
            if (longList != null) {
                for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(longList)).entrySet()) {
                    Map<String, Object> value = route.getValue();
                    value.put("route_id", route.getKey());
                    list1.add(value);
                }
            }
            int indexB = 0;
            while (test2.getB().size() != indexB) {
                BusStop stop = test2.getB().get(indexB);
                indexB++;
                List<Object> routs = new ArrayList<>();
                List<Long> list = stationRoutes.get(stop.getId());
                if (list != null) {
                    for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(list)).entrySet()) {
                        Map<String, Object> value = route.getValue();
                        value.put("route_id", route.getKey());
                        list2.add(value);
                    }
                }
                int bigIndex = 0;
                while (list1.size() != bigIndex) {
                    int index = 0;
                    while (list2.size() != index) {
                        Map<String, Object> stringObjectMap1 = list2.get(index);
                        if (list1.get(bigIndex).hashCode() == stringObjectMap1.hashCode()) {
                            routs.add(stringObjectMap1);
                        }
                        index++;
                    }
                    bigIndex++;
                }
                responses.add(new Response(busStop, stop, routs, distance(aPointLat, aPointLat, busStop.getLat(), busStop.getLng(), 'M'), distance(busStop.getLat(), busStop.getLng(), stop.getLat(), stop.getLng(), 'M'), distance(stop.getLat(), stop.getLng(), bPointLat, bPointLng, 'M')));
            }
        }
        return new ApiResponseModel(ResStatusEnum.INFO, "200", responses);
    }

    public Object getRoot(Long aPointId, Long bPointId, Long busId) {
        List<Object> objects = new ArrayList<>();
//        if (busId.hashCode() != "METRO".hashCode()) {
        boolean status = false;
        if (aPointId.hashCode() != bPointId.hashCode()) {
            ResStations f = marshrutController.getStationsBySort(busId);
            for (Object o : f.getKpp1()) {
                if (o.toString().substring(3, 10).contains(aPointId.toString())) {
                    status = true;
                }
                if (status) {
                    objects.add(o.toString().substring(3, 8));
                }
                if (o.toString().substring(3, 10).contains(bPointId.toString())) {
                    break;
                }
            }
            List<Object> object = new ArrayList<>();
            for (Object o : f.getKpp2()) {
                if (o.toString().substring(3, 10).contains(aPointId.toString())) {
                    System.out.println(o.toString().substring(3, 8));
                    status = true;
                }
                if (status) {
                    object.add(o);
                }
                if (o.toString().substring(3, 10).contains(bPointId.toString())) {
                    break;
                }
            }
//        } else {
//            for (BusStop busStop : BusMapAccessor.getInstance().getBusStops(BusStopStatusEnum.ALL)) {
//                if (busStop.getId() < 100) {
//                    objects.add(busStop);
//                }
//            }
//        }
            return objects.size() > object.size() ? objects : object;
        }
        return null;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        synchronized (BusMapAccessor.class) {
            double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(lon1 - lon2));
            dist = Math.acos(dist);
            dist = rad2deg(dist);
            dist = dist * 60 * 1.1515;
            dist = unit == 'M' ? dist * 1.609344 * 1000 : dist * 1.609344;
            return (dist);
        }
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            Date date = new Date();
            LocalTime localTime = LocalTime.now();
            System.out.println(i + " - " + localTime);
        }
    }
}

@Data
@AllArgsConstructor
class Response {
    private BusStop apoint;
    private BusStop bpoint;
    private Object object;
    private double distanceA;
    private Double distance;
    private Double distanceB;
}
