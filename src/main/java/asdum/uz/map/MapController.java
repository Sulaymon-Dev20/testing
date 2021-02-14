package asdum.uz.map;

import asdum.uz.config.CacheConfig;
import asdum.uz.entity.enums.ResStatusEnum;
import asdum.uz.map.ctrl.BusMapQueryHandler;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.model.BusStop;
import asdum.uz.map.server.BusStopService;
import asdum.uz.payload.ApiResponseModel;
import com.hazelcast.core.IMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/mobile/v2")
public class MapController {

    @Autowired
    BusStopService busStopService;

    @Autowired
    CacheConfig cacheConfig;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(produces = "application/json")
    public List<BusStop> getBusStopsData() {
        return BusMapAccessor.getInstance().getAllBusStops();
    }

    @GetMapping(value = "/radius", produces = "application/json")
    public Object getBusStopByQuery(@RequestParam(value = "latitude", required = false) Double latitude, @RequestParam(value = "longitude", required = false) Double longitude) {
        return BusMapQueryHandler.getInstance().getBusStop(latitude, longitude);
    }

/*    @GetMapping("/point")
    public ApiResponseModel test(@RequestParam(name = "aPointLng") double aPointLng, @RequestParam(name = "aPointLat") double aPointLat, @RequestParam(name = "bPointLng") double bPointLng, @RequestParam(name = "bPointLat") double bPointLat) {
        return busStopService.test4(aPointLat, aPointLng, bPointLat, bPointLng);
    }

    @GetMapping("/point/{busId}")
    public ApiResponseModel root(@PathVariable(name = "busId") Long busId, @RequestParam(name = "aPointId") Long aPointId, @RequestParam(name = "bPointId") Long bPointId) {
        return new ApiResponseModel(ResStatusEnum.INFO, "200", busStopService.getRoot(aPointId, bPointId, busId));
    }*/

    @GetMapping("/query")
    public List<Map<String, Object>> query(@RequestParam(name = "query", defaultValue = "select * from stations s where s.deleted = false") String query) {
        return jdbcTemplate.queryForList(query);
    }

    @GetMapping("/stations")
    public List<Response> shunaqa() {
        IMap<Long, List<Long>> routeStations = cacheConfig.getRoutes().getMap("stationRoutes");
        int i = 0;
        int size = routeStations.size();
        List<Long> stringsList = new ArrayList<>(routeStations.keySet());
        List<Response> responses = new ArrayList<>();
        while (i != size) {
            Long aLong = stringsList.get(i++);
            responses.add(new Response(aLong, routeStations.get(aLong)));
        }
        return responses;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Response {
    private Long id;
    private List<Long> routeId;

    public static void main(String[] args) {
        Integer index = 1;
        for (int i = 0; i < 10; i++) {
//            if (index == 4) {
//                index = 1;
//            }else {
//                index++;
//            }
//            System.out.println(index);
            System.out.println(index == 4 ? index = 1 : index++);
        }
    }
}
