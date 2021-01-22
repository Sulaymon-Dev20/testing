package asdum.uz.controller;

import asdum.uz.config.CacheConfig;
import asdum.uz.entity.enums.ResStatusEnum;
import asdum.uz.model.Bus;
import asdum.uz.model.VectorBus;
import asdum.uz.model.VectorStation;
import asdum.uz.model.ViaResponse;
import asdum.uz.payload.ApiResponseModel;
import asdum.uz.payload.ResStations;
import asdum.uz.utils.AppConstants;
import asdum.uz.utils.Util;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;


@RestController
@RequestMapping("/api/mobile/v2")
public class MarshrutController {

    @Autowired
    CacheConfig cacheConfig;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private Comparator<ViaResponse> distanceComparator;

    @PostConstruct
    private void init() {
        distanceComparator = (o1, o2) -> (int) (o1.getRemainingDistance() - o2.getRemainingDistance());
    }

    public LinkedList<VectorBus> getVectorBuses(Long route) {
        IMap<Long, LinkedList<VectorBus>> vectorBusesMap = cacheConfig.getRoutes().getMap("vectorBusesMap");
        return vectorBusesMap.get(route);
    }

    @GetMapping("/routeProps") //TODO marshrut all
    public ApiResponseModel getAll() {
        IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map.Entry<Long, Map<String, Object>> route : routeProps.entrySet()) {
            Long key = route.getKey();
            Map<String, Object> value = route.getValue();
            value.put("route_id", key);
            list.add(value);
        }
        return new ApiResponseModel(ResStatusEnum.INFO, "Ok", list);
    }

    @GetMapping("/stationRoutes/{id}") //TODO
    public HttpEntity<?> stationRoutes(@PathVariable Long id) {
        List<Long> list = (List<Long>) cacheConfig.getRoutes().getMap("stationRoutes").get(id);

        Set<Long> targetSet = new HashSet<>(list);
        IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
        Map<Long, Map<String, Object>> routePropsAll = routeProps.getAll(targetSet);
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (Map.Entry<Long, Map<String, Object>> route : routePropsAll.entrySet()) {
            Long key = route.getKey();
            Map<String, Object> value = route.getValue();
            value.put("route_id", key);
            list1.add(value);
        }

//        list1.add((Map<String, Object>) targetSet);

        return ResponseEntity.ok(list1);
    }

    @GetMapping("/stationRoutes") //TODO
    public HttpEntity<?> stationRoutesAll() {
        IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
        return ResponseEntity.ok(stationRoutes);
    }

    @GetMapping("/routeStations")
    public HttpEntity<?> routeStations() {
        IMap<Object, Object> routeStations = cacheConfig.getRoutes().getMap("routeStations");
//        ArrayList<Object> keyList = new ArrayList<Object>(routeStations.values());
//        int number = 0;
//        if (page > 0) {
//            number = page * size;
//        }
        return ResponseEntity.ok(routeStations);
    }

    @GetMapping("/routeStations/{id}")
    public HttpEntity<?> routeStations(@PathVariable String id) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select s.id, p.id as pid,  s.name sn, p.distance d, p.marshrut_id mid, p.lat, p.lng from stations s left join points p on p.station_id=s.id where s.id>0 and length(s.name)>0 and s.deleted=false and p.distance>=0 and p.marshrut_id = (select id from marshrut where id=" + id + " and  viamobile=true) order by length(s.name), name, p.distance");

        return ResponseEntity.ok(new ApiResponseModel(ResStatusEnum.INFO, "Ok", maps));
    }

    @GetMapping("/routeNamesMap")
    public ApiResponseModel routeNamesMap(@RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
                                          @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        IMap<Object, Object> routeNamesMap = cacheConfig.getRoutes().getMap("routeNamesMap");
        ArrayList<Object> keyList = new ArrayList<>(routeNamesMap.values());
        int number = 0;
        if (page > 0) {
            number = page * size;
        }
        return new ApiResponseModel(ResStatusEnum.INFO, "Ok", keyList.subList(number, number + size));
    }

    @GetMapping("/vectorBusesMap")
    public ApiResponseModel vectorBusesMap(@RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
                                           @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        IMap<Long, LinkedList<VectorBus>> vectorBusesMap = cacheConfig.getRoutes().getMap("vectorBusesMap");
        ArrayList<Object> keyList = new ArrayList<>(vectorBusesMap.values());
        int number = 0;
        if (page > 0) {
            number = page * size;
        }
        return new ApiResponseModel(ResStatusEnum.INFO, "Ok", keyList.subList(number, number + size));
    }

    @GetMapping("/busesInfo")
    public ApiResponseModel busesInfo(@RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
                                      @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        IMap<Long, Bus> busesInfo = cacheConfig.getRoutes().getMap("busesInfo");
        ArrayList<Object> keyList = new ArrayList<>(busesInfo.values());
        int number = 0;
        if (page > 0) {
            number = page * size;
        }
        return new ApiResponseModel(ResStatusEnum.INFO, "Ok", keyList.subList(number, number + size));
    }

    @GetMapping("/vectorData")
    public ApiResponseModel vectorData(@RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
                                       @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        Map<String, Map<String, List<VectorStation>>> vectorData = cacheConfig.getRoutes().getMap("vectorData");
        ArrayList<Object> keyList = new ArrayList<Object>(vectorData.values());
        int number = 0;
        if (page > 0) {
            number = page * size;
        }
        return new ApiResponseModel(ResStatusEnum.INFO, "Ok", keyList.subList(number, number + size));
    }

    @GetMapping("/getByRoot/{id}")
    public ResStations getStationsBySort(@PathVariable Long id) {
        String sql = "select s.id,  s.name sn, p.distance d, p.lat, p.lng, case  when s.id=m.kpp1 then '1' when s.id =m.kpp2 then '2' end side from stations s " +
                " left join points p on p.station_id=s.id left join marshrut m on m.id=" + id + " and m.viamobile=true and m.deleted=false " +
                " where length(s.name)>0 and s.deleted=false and p.distance>=0 and p.marshrut_id = m.id and m.deleted=false" +
                " order by p.distance";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        ResStations resStations = new ResStations();
        List<Object> kpp1 = new ArrayList<>();
        List<Object> kpp2 = new ArrayList<>();

        boolean side1 = true;
        for (Map<String, Object> map : maps) {
            Object sides = map.get("side");
            int side = sides == null ? 0 : Integer.parseInt(sides.toString());
            if (side == 2 || !side1) {
                side1 = false;
                kpp2.add(map);
            }
            if (side1 || side == 1) {
                kpp1.add(map);
            }

        }

        String sql1 = "select p.id, p.marshrut_id, p.station_id,p.lat,p.lng, case when p.station_id = m.kpp1 then '1' when p.station_id = m.kpp2 then '2' end sidePoint\n" +
                "from points p\n" +
                "         join marshrut m on p.marshrut_id = m.id\n" +
                "where p.marshrut_id =" + id + " and m.deleted=false";
        List<Map<String, Object>> points = jdbcTemplate.queryForList(sql1);
        List<Object> kpp1Point = new ArrayList<>();
        List<Object> kpp2Point = new ArrayList<>();
        boolean pointSide = true;
        for (Map<String, Object> point : points) {
            Object sidePoint = point.get("sidePoint");
            int point1 = sidePoint == null ? 0 : Integer.parseInt(sidePoint.toString());
            if (point1 == 2 || !pointSide) {
                pointSide = false;
                kpp2Point.add(point);
            }
            if (pointSide || point1 == 1) {
                kpp1Point.add(point);
            }
        }

//        resStations.setKpp1Point(kpp1Point);
//        resStations.setKpp2Point(kpp2Point);
        resStations.setKpp1(kpp1);
        resStations.setKpp2(kpp2);

        return resStations;
    }

    @GetMapping("/getBusByTime")
    public ApiResponseModel getBusByTime(@RequestParam Long routeId,
                                         @RequestParam Long stationId) {
        List<ViaResponse> responseList = new LinkedList<>();
        Map<Long, Map<Long, Double>> stationDistances = cacheConfig.getRoutes().getMap("routeStations");
        Map<Long, Map<Long, Double>> routeProps = cacheConfig.getRoutes().getMap("routeProps");

        Double stationDist = stationDistances.get(routeId).get(stationId);
        Double totalDistance = (Double) routeProps.get(routeId).get("total");
        LinkedList<VectorBus> vectorBuses = getVectorBuses(routeId);
        if (vectorBuses != null) {
            for (VectorBus bus : vectorBuses) {
                ViaResponse viaResponse = new ViaResponse();
                viaResponse.setGosNo(bus.getGos_no());
                viaResponse.setRegDateTime(bus.getInput_time());
                viaResponse.setOnOff(bus.getOnoff());
//                viaResponse.setPolygonType(bus.getPolygonType());
                viaResponse.setModel(bus.getModel());
                viaResponse.setModelNameInUz(bus.getModelNameInUz());
                viaResponse.setSpeed(bus.getSpeed());
                viaResponse.setBusId(bus.getBusID());

                if (bus.getMileage() <= stationDist) {
                    viaResponse.setRemainingDistance(Math.round((stationDist - bus.getMileage()) * 1000));
                } else {
                    viaResponse.setRemainingDistance(Math.round((totalDistance - bus.getMileage() + stationDist) * 1000));
                }
                viaResponse.setRemainingDistance(viaResponse.getRemainingDistance() > Util.VIA_STATION_POGRESHNOST ? viaResponse.getRemainingDistance() - Util.VIA_STATION_POGRESHNOST : 0);
                viaResponse.setRemainingTime(Math.round(viaResponse.getRemainingDistance() / 7.5d));
                responseList.add(viaResponse);
            }
        }
        Collections.sort(responseList, distanceComparator);
        return new ApiResponseModel(ResStatusEnum.INFO, "Ok", responseList);
    }

    @GetMapping("/getPointsByMarshrut/{id}")
    public ApiResponseModel getPointsByMarshrut(@PathVariable Long id) {
        String sql = "select p.id, p.marshrut_id, p.station_id, p.lng,p.lat from points p where p.marshrut_id=" + id + " order by p.distance";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        // System.out.println(maps);
        return new ApiResponseModel(ResStatusEnum.INFO, "Ok", maps);
    }

    @GetMapping("/station/search")
    public ApiResponseModel getBySearch(
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "search", defaultValue = "all") String search) {
        int number = 0;
        if (page > 0) {
            number = page * size;
        }
        String station = "select s.id,s.name,s.lat,s.lng,s.distance,s.routes from stations s where UPPER(s.name) like upper('%" + search + "%') and s.deleted=false order by s.distance limit " + size + " offset " + number + "";
        List<Map<String, Object>> search_station = jdbcTemplate.queryForList(station);
        return new ApiResponseModel(ResStatusEnum.INFO, "Ok", search_station);
    }

//    @GetMapping("/getBusLocation")
//    public ApiResponseModel getBusLocation() {
//        return new ApiResponseModel(ResStatusEnum.INFO, "Ok", currentLocationRepository.findAllByGpsstatus("A"));
//    }
}
