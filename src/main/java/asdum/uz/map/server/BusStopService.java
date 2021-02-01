package asdum.uz.map.server;

import asdum.uz.config.CacheConfig;
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
import asdum.uz.service.ApiMobileV2Service;
import com.hazelcast.core.IMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
@PropertySource("classpath:application.properties")
//@PropertySource("classpath:metro.yml")
public class BusStopService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CacheConfig cacheConfig;

    @Autowired
    ApiMobileV2Service mobileService;

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
            if (root2.getBPoint().getStatus() == null && root2.getAPoint().getStatus() == null) {
                IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
                IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
                List<Map<String, Object>> list1 = new ArrayList<>();
                List<Map<String, Object>> list2 = new ArrayList<>();
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

    public ApiResponseModel test4(double aPointLat, double aPointLng, double bPointLat, double bPointLng) {
        Test2 test2 = BusMapQueryHandler.getInstance().test(aPointLat, aPointLng, bPointLat, bPointLng);
        List<Response> responses = new ArrayList<>();
        int indexA = 0;
        int size = test2.getA().size();
        List<BusStop> a = test2.getA();
        while (size != indexA) {
            BusStop busStop = a.get(indexA);
            indexA++;
            int indexB = 0;
            int size1 = test2.getB().size();
            while (size1 != indexB) {
                BusStop stop = test2.getB().get(indexB);
                indexB++;
                List<Object> routs = new ArrayList<>();
                int bigIndex = 0;
                int size2 = busStop.getRouteDataList().size();
                while (size2 != bigIndex) {
                    Map<String, Object> aPointRoots = busStop.getRouteDataList().get(bigIndex);
                    int index = 0;
                    int size3 = stop.getRouteDataList().size();
                    while (size3 != index) {
                        Map<String, Object> bPointRoots = stop.getRouteDataList().get(index);
                        if (aPointRoots.hashCode() == bPointRoots.hashCode()) {
                            routs.add(aPointRoots);
                        }
                        index++;
                    }
                    bigIndex++;
                }
                if (routs.size() > 0) {
                    responses.add(new Response(busStop, stop, routs, distance(aPointLat, aPointLat, busStop.getLat(), busStop.getLng(), 'M'), distance(busStop.getLat(), busStop.getLng(), stop.getLat(), stop.getLng(), 'M'), distance(stop.getLat(), stop.getLng(), bPointLat, bPointLng, 'M')));
                }
            }
        }
        return new ApiResponseModel(ResStatusEnum.INFO, "200", responses);
    }

    public Object getRoot(Long aPointId, Long bPointId, Long busId) {
        String kpp1 = "select p.id, p.distance, p.lat, p.lng, p.marshrut_id, p.station_id ,s.name,case when p.station_id = " + aPointId + " then '1' when p.station_id = " + bPointId + " then '2' end side from points p left join stations s on s.id=p.station_id where p.marshrut_id=" + busId + " and p.distance > 0 order by p.distance ";
        List<Object> objects = new ArrayList<>();
        boolean status = false;
        if (aPointId.hashCode() != bPointId.hashCode()) {
            List<Map<String, Object>> maps = jdbcTemplate.queryForList(kpp1);
            for (Map<String, Object> map : maps) {
                System.out.println(map.get("side"));
                if (map.get("side") != null) {
                    String i = map.get("side").toString();
                    if (i.hashCode() == "1".hashCode()) {
                        status = true;
                    } else if (i.hashCode() == "2".hashCode()) {
                        break;
                    }
                }
                if (status) {
                    objects.add(map);
                }
            }
            if (objects.size() == 0) {
                List<Map<String, Object>> maps2 = jdbcTemplate.queryForList(kpp1 + " desc");
                for (Map<String, Object> map : maps2) {
                    int i = Integer.parseInt(map.get("side").toString());
                    if (i == 1) {
                        status = true;
                    } else if (i == 2) {
                        break;
                    }
                    if (status) {
                        objects.add(map);
                    }
                }
            }
        }
        return objects;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(lon1 - lon2));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = unit == 'M' ? dist * 1.609344 * 1000 : dist * 1.609344;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}

@Data
@AllArgsConstructor
class Response {
    private BusStop aPoint;
    private BusStop bPoint;
    private Object Root;
    private double distanceA;
    private double distance;
    private double distanceB;
}
