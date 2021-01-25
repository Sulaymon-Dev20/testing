package asdum.uz.map.server;

import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.model.BusStop;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Component
public class BusStopSetUpData implements CommandLineRunner {

    private static final String DATA_URL = "http://localhost:8010/api/mobile/v2/query";

    private static boolean initialized = false;

    @Override
    public void run(String... args) throws Exception {
        boolean fixed = false;
        System.out.println("Installing BUS STOP Data...");
        synchronized (BusMapAccessor.class) {
            if (!initialized) {
                try {
                    URL url = new URL(DATA_URL);
                    ObjectMapper jsonMapper = new ObjectMapper();
                    List<BusStop> busStopList = jsonMapper.readValue(url, new TypeReference<List<BusStop>>() {
                    });
                    for (BusStop busStop : busStopList) {
                        if (busStop.getRoutes() != null) {
                            String[] strings = busStop.getRoutes().split(",");
                            busStop.setRouteList(strings);
                        }
                        if (busStop.getId() != null) {

                        }
                        BusMapAccessor.getInstance().addBusStop(busStop);
                    }
//                    initialized = true;
                    fixed = true;
                } catch (Exception e) {
                    fixed = false;
                }
            }
        }
        System.err.println(fixed ? "The data has been uploaded !" : "Data retrieval error");

    }
}
