package asdum.uz.map.ctrl;

import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.model.BusStop;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BusStopSetUpData {

    //    private static final String DATA_URL = "http://103.214.108.154:5432/api/mobile/v2/query";
    private static final String DATA_URL = "http://localhost:8010/api/mobile/v2/query";

    private static boolean initialized = false;
    private static final BusStopSetUpData INSTANCE = new BusStopSetUpData();

    private BusStopSetUpData() {
    }

    public static BusStopSetUpData getInstance() {
        return INSTANCE;
    }

    public void initialize() {
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
                        BusMapAccessor.getInstance().addBusStop(busStop);
                    }
//                    initialized = true;
                    fixed = true;
                } catch (Exception e) {
                    fixed = false;
                    e.printStackTrace();
                }
            }
        }
        System.err.println(fixed ? "The data has been uploaded !" : "Data retrieval error");
    }
}
