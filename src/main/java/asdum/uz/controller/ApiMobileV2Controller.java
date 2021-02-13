package asdum.uz.controller;

import asdum.uz.entity.enums.ResStatusEnum;
import asdum.uz.model.ViaResponse;
import asdum.uz.payload.ApiResponseModel;
import asdum.uz.payload.RealTime;
import asdum.uz.service.ApiMobileV2Service;
import asdum.uz.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mobile/v2")
public class ApiMobileV2Controller {

    @Autowired
    ApiMobileV2Service service;

    @GetMapping("/routeProps")
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok(service.routeProps());
    }

    @GetMapping("/stationRoutes/{id}")
    public HttpEntity<?> stationRoutes(@PathVariable Long id) {
        return ResponseEntity.ok(service.stationRoutes(id));
    }

    @GetMapping("/stationRoutes")
    public HttpEntity<?> stationRoutesAll() {
        return ResponseEntity.ok(service.stationRoutesAll());
    }

    @GetMapping("/routeStations")
    public HttpEntity<?> routeStations() {
        return ResponseEntity.ok(service.routeStations());
    }

    @GetMapping("/routeStations/{id}")
    public HttpEntity<?> routeStations(@PathVariable Long id) {
        return ResponseEntity.ok(service.routeStationsByBusId(id));
    }

    @GetMapping("/routeNamesMap")
    public HttpEntity<?> routeNamesMap(
            @RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        return ResponseEntity.ok(service.routeNamesMap(page, size));
    }

    @GetMapping("/vectorBusesMap")
    public HttpEntity<?> vectorBusesMap(
            @RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        return ResponseEntity.ok(service.vectorBusesMap(page, size));
    }

    @GetMapping("/busesInfo")
    public HttpEntity<?> busesInfo(
            @RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        return ResponseEntity.ok(service.busesInfo(page, size));
    }

    @GetMapping("/vectorData")
    public HttpEntity<?> vectorData(
            @RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        return ResponseEntity.ok(service.vectorData(page, size));
    }

    @GetMapping("/getByRoot/{id}")
    public HttpEntity<?> getStationsBySort(@PathVariable Long id) {
        return ResponseEntity.ok(service.getByRoot(id));
    }

    @GetMapping("/getBusByTime")
    public HttpEntity<?> getBusByTime(@RequestParam Long routeId, @RequestParam Long stationId) {
        List<ViaResponse> list = service.getBusByTime(routeId, stationId).getList();
        return ResponseEntity.ok(new ApiResponseModel(ResStatusEnum.INFO, "200", list != null ? list : new ArrayList<>()));
    }

    @GetMapping("/getPointsByMarshrut/{id}")
    public HttpEntity<?> getPointsByMarshrut(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPointsByMarshrut(id));
    }

    @PutMapping("/favourite")
    public HttpEntity<?> getFavourite(@RequestBody List<Map<String, Long>> object) {
        try {
            int size = object.size();
            int i = 0;
            List<RealTime> response = new ArrayList<>();
            while (size != i) {
                response.add(service.getBusByTime(object.get(i).get("routeId"), object.get(i).get("stationId")));
                i++;
            }
            return ResponseEntity.ok(new ApiResponseModel(ResStatusEnum.INFO, "200", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseModel(ResStatusEnum.WARNING, "400"));
        }
    }

    @GetMapping("/station/search")
    public HttpEntity<?> getBySearch(
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "search") String search) {
        return ResponseEntity.ok(service.getBySearch(page, size, search));
    }
}
