package asdum.uz.map.ctrl;

import asdum.uz.config.CacheConfig;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.model.BusStop;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Component
public class BusStopSetUpData implements CommandLineRunner {

    private static final String DATA_URL = "/api/mobile/v2/query";

    @Value("${server.port}")
    private String port;

    @Autowired
    CacheConfig cacheConfig;

    @Override
    public void run(String... args) {
        boolean fixed;
        System.out.println("Installing BUS STOP Data...");
        synchronized (BusMapAccessor.class) {
            try {
                URL url = new URL("http://asfd:" + port + DATA_URL);
//                URL url = new URL("http://localhost:" + port + DATA_URL);
                ObjectMapper jsonMapper = new ObjectMapper();
                List<BusStop> busStopList = jsonMapper.readValue(url, new TypeReference<List<BusStop>>() {
                });
                IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
                IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
                System.out.println(LocalDate.now() + " " + LocalTime.now() + "\u001B[34m" + "  INFO 🧐 " + "\u001B[0m" + "please wait 20 minutes ⏳");
                for (BusStop busStop : busStopList) {
                    List<Long> list = stationRoutes.get(busStop.getId());
                    if (list != null) {
                        List<Map<String, Object>> list1 = new ArrayList<>();
                        for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(list)).entrySet()) {
                            Long key = route.getKey();
                            Map<String, Object> value = route.getValue();
                            value.put("route_id", key);
                            list1.add(value);
                        }
                        busStop.setRouteDataList(list1);
                        BusMapAccessor.getInstance().addBusStop(busStop);
                    }
                }
                fixed = true;
            } catch (Exception e) {
                fixed = false;
            }
        }
        System.out.println(fixed ? LocalDate.now() + " " + LocalTime.now() + "\u001B[34m" + "  INFO 🤓 " + "\u001B[0m" + "The data has been uploaded !" : LocalDate.now() + " " + LocalTime.now() + "\u001B[33m" + "  WARN 🤕 " + "\u001B[0m" + "Data retrieval error");
    }
}
