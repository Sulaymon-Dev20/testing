package asdum.uz.map;

    import asdum.uz.entity.enums.ResStatusEnum;
import asdum.uz.map.ctrl.BusMapQueryHandler;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.model.BusStop;
import asdum.uz.map.model.Root2;
import asdum.uz.map.server.BusStopService;
import asdum.uz.payload.ApiResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/mobile/v2")
public class MapController {

    @Autowired
    BusStopService busStopService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(produces = "application/json")
    public List<BusStop> getBusStopsData() {
        return BusMapAccessor.getInstance().getAllBusStops();
    }

    @GetMapping(value = "/radius", produces = "application/json")
    public List<BusStop> getBusStopByQuery(@RequestParam(value = "latitude", required = false) Double latitude, @RequestParam(value = "longitude", required = false) Double longitude, @RequestParam(value = "radius", defaultValue = "0.5", required = false) Double radius) {
        return BusMapQueryHandler.getInstance().getBusStop(latitude, longitude, radius);
    }

    @GetMapping("/point")
    public ApiResponseModel getAtoBPoint2(@RequestParam(name = "aPointLng") double aPointLng, @RequestParam(name = "aPointLat") double aPointLat, @RequestParam(name = "bPointLng") double bPointLng, @RequestParam(name = "bPointLat") double bPointLat) {
        Root2 response = BusMapQueryHandler.getInstance().toAtoB(aPointLat, aPointLng, bPointLat, bPointLng);
        return new ApiResponseModel(response != null ? ResStatusEnum.INFO : ResStatusEnum.WARNING, response != null ? "200" : "100", response != null ? busStopService.filter(response) : null);
    }

    @GetMapping("/test")
    public ApiResponseModel test(@RequestParam(name = "aPointLng") double aPointLng, @RequestParam(name = "aPointLat") double aPointLat, @RequestParam(name = "bPointLng") double bPointLng, @RequestParam(name = "bPointLat") double bPointLat) {
        return busStopService.test2(aPointLat, aPointLng, bPointLat, bPointLng);
//        return new ApiResponseModel(response != null ? ResStatusEnum.INFO : ResStatusEnum.WARNING, response != null ? "200" : "100", null);
    }

    @GetMapping("/point/{busId}")
    public ApiResponseModel root(@PathVariable(name = "busId") Long busId, @RequestParam(name = "aPointId") Long aPointId, @RequestParam(name = "bPointId") Long bPointId) {
        return new ApiResponseModel(ResStatusEnum.INFO, "200", busStopService.getRoot(aPointId, bPointId, busId));
    }

    @Scheduled(cron = "0 0 12 1 * ?")
    public void updateData() {
        BusMapAccessor.getInstance().removeAllBusStop();
//        BusStopSetUpData.getInstance().initialize();
    }

    @GetMapping("/query")
    public List<Map<String, Object>> query(@RequestParam(name = "query", defaultValue = "select * from stations s where s.deleted = false") String query) {
        return jdbcTemplate.queryForList(query);
    }
}
