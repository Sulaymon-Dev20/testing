package asdum.uz.map;

import asdum.uz.entity.enums.ResStatusEnum;
import asdum.uz.map.ctrl.BusMapQueryHandler;
import asdum.uz.map.ctrl.BusStopSetUpData;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.model.BusStop;
import asdum.uz.map.model.Root2;
import asdum.uz.map.server.BusStopService;
import asdum.uz.payload.ApiResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/radiusBusStop", produces = "application/json")
    public List<BusStop> getBusStopByQuery(@RequestParam(value = "latitude", required = false) String latitude, @RequestParam(value = "longitude", required = false) String longitude, @RequestParam(value = "radius", defaultValue = "0.5", required = false) String radius) {
        return BusMapQueryHandler.getInstance().getBusStop(latitude, longitude, radius);
    }

    @GetMapping("/point")
    public ApiResponseModel getAtoBPoint2(@RequestParam(name = "aPointLng") double aPointLng, @RequestParam(name = "aPointLat") double aPointLat, @RequestParam(name = "bPointLng") double bPointLng, @RequestParam(name = "bPointLat") double bPointLat, @RequestParam(value = "radius", defaultValue = "0.05", required = false) String radius) {
        Root2 response = BusMapQueryHandler.getInstance().toAtoB(aPointLat, aPointLng, bPointLat, bPointLng, radius);
        return new ApiResponseModel(response != null ? ResStatusEnum.INFO : ResStatusEnum.WARNING, response != null ? "200" : "100", response != null ? busStopService.filter(response) : null);
    }

    @GetMapping("/point/byId")
    public ApiResponseModel root(@RequestParam(name = "aPointId") Long aPointId, @RequestParam(name = "bPointId") Long bPointId, @RequestParam(name = "busId") String busId) {
        return new ApiResponseModel(ResStatusEnum.INFO, "200", busStopService.getRoot(aPointId, bPointId, busId));
    }

    @GetMapping("/updateData")
    public void updateData() {
        BusMapAccessor.getInstance().removeAllBusStop();
        BusStopSetUpData.getInstance().initialize();
    }

    @GetMapping("/query")
    public List<Map<String, Object>> query(@RequestParam(name = "query", defaultValue = "select * from stations") String query) {
        return jdbcTemplate.queryForList(query);
    }
}
