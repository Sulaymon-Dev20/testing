package asdum.uz.service;

import asdum.uz.config.CacheConfig;
import asdum.uz.entity.enums.ResStatusEnum;
import asdum.uz.model.Bus;
import asdum.uz.model.VectorBus;
import asdum.uz.model.VectorStation;
import asdum.uz.model.ViaResponse;
import asdum.uz.payload.ApiResponseModel;
import asdum.uz.payload.RealTime;
import asdum.uz.payload.ResStations;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class ApiMobileV2Service {

    @Autowired
    CacheConfig cacheConfig;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private Comparator<ViaResponse> distanceComparator;

    public ApiResponseModel routeProps() {
        try {
            IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
            List<Map<String, Object>> list = new ArrayList<>();
            for (Map.Entry<Long, Map<String, Object>> route : routeProps.entrySet()) {
                Long key = route.getKey();
                Map<String, Object> value = route.getValue();
                value.put("route_id", key);
                list.add(value);
            }
            return new ApiResponseModel(ResStatusEnum.INFO, "200", list);
        } catch (Exception e) {
            return new ApiResponseModel(ResStatusEnum.WARNING, "200", null);
        }
    }

    public List<Map<String, Object>> stationRoutes(Long id) {
        List<Long> list = (List<Long>) cacheConfig.getRoutes().getMap("stationRoutes").get(id);
        List<Map<String, Object>> list1 = new ArrayList<>();
        if (list != null) {
            Set<Long> targetSet = new HashSet<>(list);
            IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
            Map<Long, Map<String, Object>> routePropsAll = routeProps.getAll(targetSet);
            for (Map.Entry<Long, Map<String, Object>> route : routePropsAll.entrySet()) {
                Long key = route.getKey();
                Map<String, Object> value = route.getValue();
                value.put("route_id", key);
                list1.add(value);
            }
        }
        return list1;
    }

    public IMap<Long, List<Long>> stationRoutesAll() {
        return cacheConfig.getRoutes().getMap("stationRoutes");
    }

    public IMap<Long, Object> routeStations() {
        return cacheConfig.getRoutes().getMap("routeStations");
    }

    public ApiResponseModel routeStationsByBusId(Long id) {
        try {
            String query = "select s.id, p.id as pid,  s.name sn, p.distance d, p.marshrut_id mid, p.lat, p.lng from stations s left join points p on p.station_id=s.id where s.id>0 and length(s.name)>0 and s.deleted=false and p.distance>=0 and p.marshrut_id = (select id from marshrut where id=" + id + " and  viamobile=true) order by length(s.name), name, p.distance";
            return new ApiResponseModel(ResStatusEnum.INFO, "200", jdbcTemplate.queryForList(query));
        } catch (Exception e) {
            return new ApiResponseModel(ResStatusEnum.WARNING, "200", null);
        }
    }

    public ApiResponseModel routeNamesMap(Integer page, Integer size) {
        IMap<Object, Object> routeNamesMap = cacheConfig.getRoutes().getMap("routeNamesMap");
        ArrayList<Object> keyList = new ArrayList<>(routeNamesMap.values());
        int number = page > 0 ? page * size : 0;
        return new ApiResponseModel(ResStatusEnum.INFO, "200", keyList.subList(number, number + size));
    }

    public ApiResponseModel vectorBusesMap(Integer page, Integer size) {
        IMap<Long, LinkedList<VectorBus>> vectorBusesMap = cacheConfig.getRoutes().getMap("vectorBusesMap");
        ArrayList<Object> keyList = new ArrayList<>(vectorBusesMap.values());
        int number = page > 0 ? page * size : 0;
        return new ApiResponseModel(ResStatusEnum.INFO, "200", keyList.subList(number, number + size));
    }

    public ApiResponseModel busesInfo(Integer page, Integer size) {
        IMap<Long, Bus> busesInfo = cacheConfig.getRoutes().getMap("busesInfo");
        ArrayList<Object> keyList = new ArrayList<>(busesInfo.values());
        int number = page > 0 ? page * size : 0;
        return new ApiResponseModel(ResStatusEnum.INFO, "200", keyList.subList(number, number + size));
    }

    public ApiResponseModel vectorData(Integer page, Integer size) {
        Map<String, Map<String, List<VectorStation>>> vectorData = cacheConfig.getRoutes().getMap("vectorData");
        ArrayList<Object> keyList = new ArrayList<Object>(vectorData.values());
        int number = page > 0 ? page * size : 0;
        return new ApiResponseModel(ResStatusEnum.INFO, "200", keyList.subList(number, number + size));
    }

    public ResStations getByRoot(Long id) {
        try {
            String sql = "select s.id,  s.name sn, p.distance d, p.lat, p.lng, case  when s.id=m.kpp1 then '1' when s.id =m.kpp2 then '2' end side from stations s left join points p on p.station_id=s.id left join marshrut m on m.id=" + id + " and m.viamobile=true and m.deleted=false where length(s.name)>0 and s.deleted=false and p.distance>=0 and p.marshrut_id = m.id and m.deleted=false order by p.distance";
            String sql1 = "select p.id, p.marshrut_id, p.station_id, p.lat, p.lng, case when p.station_id = m.kpp1 then '1' when p.station_id = m.kpp2 then '2' end sidePoint from points p join marshrut m on p.marshrut_id = m.id where p.marshrut_id =" + id + " and m.deleted=false ";
            ResStations resStations = new ResStations();
            List<Object> kpp1 = new ArrayList<>();
            List<Object> kpp2 = new ArrayList<>();
            boolean side1 = true;
            for (Map<String, Object> map : jdbcTemplate.queryForList(sql)) {
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
            resStations.setKpp1Point(kpp1Point);
            resStations.setKpp2Point(kpp2Point);
            resStations.setKpp1(kpp1);
            resStations.setKpp2(kpp2);
            return resStations;
        } catch (Exception e) {
            return null;
        }
    }

    public RealTime getBusByTime(Long routeId, Long stationId) {
        try {
            List<ViaResponse> responseList = new LinkedList<>();
            Map<Long, Map<Long, Object>> stationDistances = cacheConfig.getRoutes().getMap("routeStations");
            Map<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
            Double stationDist = Double.parseDouble(stationDistances.get(routeId).get(stationId).toString());
            LinkedList<VectorBus> vectorBuses = getVectorBuses(routeId);
            if (vectorBuses != null) {
                for (VectorBus bus : vectorBuses) {
                    ViaResponse viaResponse = new ViaResponse();
                    viaResponse.setGosNo(bus.getGos_no());
                    viaResponse.setRegDateTime(bus.getInput_time());
                    viaResponse.setOnOff(bus.getOnoff());
                    viaResponse.setModel(bus.getModel());
                    viaResponse.setModelNameInUz(bus.getModelNameInUz());
                    viaResponse.setSpeed(bus.getSpeed());
                    viaResponse.setBusId(bus.getBusID());
                    viaResponse.setRemainingDistance(bus.getMileage() <= stationDist ? Math.round((stationDist - bus.getMileage()) * 1000) : Math.round(Double.parseDouble(routeProps.get(routeId).get("total").toString()) - bus.getMileage() + stationDist) * 1000);
//                    viaResponse.setRemainingDistance(viaResponse.getRemainingDistance() > Util.VIA_STATION_POGRESHNOST ? viaResponse.getRemainingDistance() - Util.VIA_STATION_POGRESHNOST : 0);
                    viaResponse.setRemainingTime(Math.round(viaResponse.getRemainingDistance() / 7.5d));
                    responseList.add(viaResponse);
                }
            }
            responseList.sort(distanceComparator);
            return new RealTime(routeProps.get(routeId), jdbcTemplate.queryForMap("select * from stations s where id=" + stationId + ""), responseList);
        } catch (Exception e) {
            return new RealTime(null, null, null);
        }
    }

    public ApiResponseModel getPointsByMarshrut(Long id) {
        try {
            String sql = "select p.id, p.marshrut_id, p.station_id, p.lng,p.lat from points p where p.marshrut_id=" + id + " order by p.distance";
            return new ApiResponseModel(ResStatusEnum.INFO, "200", jdbcTemplate.queryForList(sql));
        } catch (Exception e) {
            return new ApiResponseModel(ResStatusEnum.WARNING, "200", null);
        }
    }

    public ApiResponseModel test(Integer page, Integer size, String search) {
        try {
            int number = page > 0 ? page * size : 0;
            String station = "select s.id,s.name,s.lat,s.lng,s.distance,s.routes from stations s where UPPER(s.name) like upper('%" + search + "%') and s.deleted=false order by s.distance limit " + size + " offset " + number + "";
            return new ApiResponseModel(ResStatusEnum.INFO, "200", jdbcTemplate.queryForList(station));
        } catch (Exception e) {
            return new ApiResponseModel(ResStatusEnum.WARNING, "200", null);
        }
    }

    public ApiResponseModel getBySearch(Integer page, Integer size, String search) {
        try {
            IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
            IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
            int number = page > 0 ? page * size : 0;
            String station = "select s.id,s.name,s.lat,s.lng,s.routes from stations s where UPPER(s.name) like upper('%" + uzConcertUz(search) + "%') and s.deleted=false order by s.distance limit " + size + " offset " + number + "";
            List<Map<String, Object>> maps = jdbcTemplate.queryForList(station);
            int size1 = maps.size();
            int index = 0;
            while (size1 != index) {
                Map<String, Object> map = maps.get(index);
                List<Long> list = stationRoutes.get(Long.valueOf(map.get("id").toString()));
                if (list != null) {
                    for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(list)).entrySet()) {
                        Map<String, Object> value = route.getValue();
                        value.put("route_id", route.getKey());
                        map.put("routeDataList", value);
                    }
                }
                index++;
            }
            return new ApiResponseModel(ResStatusEnum.INFO, "200", maps);
        } catch (Exception e) {
            return new ApiResponseModel(ResStatusEnum.WARNING, "200", null);
        }
    }

    public LinkedList<VectorBus> getVectorBuses(Long route) {
        IMap<Long, LinkedList<VectorBus>> vectorBusesMap = cacheConfig.getRoutes().getMap("vectorBusesMap");
        return vectorBusesMap.get(route);
    }

    public static String uzConcertUz(String message) {
        StringBuilder krill = new StringBuilder();
        message = message.toLowerCase();
        int i = 0;
        while (i < message.length()) {
            if (message.charAt(i) == 's' && message.charAt(i + 1) == 'h') {
                krill.append("ш");
                i++;
            } else if (message.charAt(i) == 'c' && message.charAt(i + 1) == 'h') {
                krill.append("ч");
                i++;
            } else if (message.charAt(i) == 'a') {
                krill.append("а");
            } else if (message.charAt(i) == 'b') {
                krill.append("б");
            } else if (message.charAt(i) == 'v') {
                krill.append("в");
            } else if (message.charAt(i) == 'g') {
                krill.append("г");
            } else if (message.charAt(i) == 'd') {
                krill.append("д");
            } else if (message.charAt(i) == 'e') {
                krill.append("е");
            } else if (message.charAt(i) == 'j') {
                krill.append("ж");
            } else if (message.charAt(i) == 'z') {
                krill.append("з");
            } else if (message.charAt(i) == 'i') {
                krill.append("и");
            } else if (message.charAt(i) == 'y') {
                krill.append("й");
            } else if (message.charAt(i) == 'k') {
                krill.append("к");
            } else if (message.charAt(i) == 'l') {
                krill.append("л");
            } else if (message.charAt(i) == 'm') {
                krill.append("м");
            } else if (message.charAt(i) == 'n') {
                krill.append("н");
            } else if (message.charAt(i) == 'o') {
                krill.append("о");
            } else if (message.charAt(i) == 'p') {
                krill.append("п");
            } else if (message.charAt(i) == 'r') {
                krill.append("р");
            } else if (message.charAt(i) == 's') {
                krill.append("с");
            } else if (message.charAt(i) == 't') {
                krill.append("т");
            } else if (message.charAt(i) == 'u') {
                krill.append("у");
            } else if (message.charAt(i) == 'f') {
                krill.append("ф");
            } else if (message.charAt(i) == 'h') {
                krill.append("х");
            } else if (message.charAt(i) == 'e') {
                krill.append("э");
            } else if (message.charAt(i) == 'а') {
                krill.append("а");
            } else if (message.charAt(i) == 'б') {
                krill.append("б");
            } else if (message.charAt(i) == 'в') {
                krill.append("в");
            } else if (message.charAt(i) == 'г') {
                krill.append("г");
            } else if (message.charAt(i) == 'д') {
                krill.append("д");
            } else if (message.charAt(i) == 'е') {
                krill.append("е");
            } else if (message.charAt(i) == 'ж') {
                krill.append("ж");
            } else if (message.charAt(i) == 'з') {
                krill.append("з");
            } else if (message.charAt(i) == 'и') {
                krill.append("и");
            } else if (message.charAt(i) == 'й') {
                krill.append("й");
            } else if (message.charAt(i) == 'к') {
                krill.append("к");
            } else if (message.charAt(i) == 'л') {
                krill.append("л");
            } else if (message.charAt(i) == 'м') {
                krill.append("м");
            } else if (message.charAt(i) == 'н') {
                krill.append("н");
            } else if (message.charAt(i) == 'о') {
                krill.append("о");
            } else if (message.charAt(i) == 'п') {
                krill.append("п");
            } else if (message.charAt(i) == 'р') {
                krill.append("р");
            } else if (message.charAt(i) == 'с') {
                krill.append("с");
            } else if (message.charAt(i) == 'т') {
                krill.append("т");
            } else if (message.charAt(i) == 'у') {
                krill.append("у");
            } else if (message.charAt(i) == 'ф') {
                krill.append("ф");
            } else if (message.charAt(i) == 'х') {
                krill.append("х");
            } else if (message.charAt(i) == 'э') {
                krill.append("э");
            }
            if (message.charAt(i) < 97) {
                krill.setCharAt(krill.length() - 1, (char) (krill.charAt(krill.length()) - 32));
            }
            i++;
        }

        return krill.toString();
    }

    @PostConstruct
    private void init() {
        distanceComparator = (o1, o2) -> (int) (o1.getRemainingDistance() - o2.getRemainingDistance());
    }
}
