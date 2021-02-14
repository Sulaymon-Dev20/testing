package asdum.uz.map.ctrl;

import asdum.uz.config.CacheConfig;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.model.BusStop;
import asdum.uz.service.ApiMobileV2Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static asdum.uz.utils.ColorsTerminal.*;

@Component
public class BusStopSetUpData implements CommandLineRunner {

    private static final String DATA_URL = "/api/mobile/v2/query";

    @Value("${server.port}")
    private String port;

    @Autowired
    CacheConfig cacheConfig;

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Autowired
//    MyBusBusStopRepository myBusBusStopRepository;

//    @Autowired
//    MyBusRouteRepository myBusRouteRepository;

    @Override
    public void run(String... args) {
        new Thread(() -> {
            boolean fixed;
            System.out.println(ANSI_BG_BLACK + ANSI_BLUE + "Installing BUS STOP Data... 🤨" + ANSI_RESET);
            String PID = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
            synchronized (BusMapAccessor.class) {
                try {
                    List<BusStop> busStopList = new ObjectMapper().readValue(new URL("http://localhost:" + port + DATA_URL), new TypeReference<List<BusStop>>() {
                    });
//                String ipAddress = InetAddress.getLocalHost().getHostAddress();
                    IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
                    IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");

                    int size = busStopList.size();
                    int firstQuarter = size / 4;
                    int secondQuarter = firstQuarter * 2;
                    int thirdQuarter = firstQuarter * 3;
                    System.out.println(ANSI_BG_BLACK + LocalDate.now() + " " + LocalTime.now() + ANSI_BLUE + "  INFO " + ANSI_PURPLE + PID + ANSI_RESET + ANSI_BG_BLACK + " --- [127.0.0.1:" + PID + "] " + ANSI_CYAN + "com.sulaymon.yahyo.alhamdulillah         " + ANSI_RESET + ANSI_BG_BLACK + ": " + ANSI_BG_GREEN + "please wait 2 minutes ⏳" + ANSI_RESET);
                    new Thread(() -> {
                        try {
                            int index = 0;
                            while (index != firstQuarter) {
                                BusStop busStop = busStopList.get(index);
                                List<Long> list = stationRoutes.get(busStop.getId());
                                List<Map<String, Object>> list1 = new ArrayList<>();
                                if (list != null) {
                                    for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(list)).entrySet()) {
                                        Map<String, Object> value = route.getValue();
                                        value.put("route_id", route.getKey());
                                        list1.add(value);
                                    }
                                    busStop.setNameLt(ApiMobileV2Service.ltConcertKr(busStop.getName()));
                                    busStop.setRouteDataList(list1);
                                    BusMapAccessor.getInstance().addBusStop(busStop);
                                }
                                if (index >= firstQuarter) {
                                    break;
                                }
                                index++;
                            }
                        } catch (Exception e) {
                            System.out.println(ANSI_BG_BLACK + LocalDate.now() + " " + LocalTime.now() + ANSI_YELLOW + "  WARN " + ANSI_PURPLE + PID + ANSI_RESET + ANSI_BG_BLACK + " --- [127.0.0.1:" + PID + "] " + ANSI_CYAN + "com.sulaymon.yahyo.subhanalloh           " + ANSI_RESET + ANSI_BG_BLACK + ": " + ANSI_BG_GREEN + "Error First thread     \uD83E\uDD75" + ANSI_RESET);
                        }
                    }).start();
                    new Thread(() -> {
                        try {
                            int index = 0;
                            while (index != size) {
                                if (index < firstQuarter) {
                                    index++;
                                    continue;
                                }
                                BusStop busStop = busStopList.get(index);
                                List<Long> list = stationRoutes.get(busStop.getId());
                                List<Map<String, Object>> list1 = new ArrayList<>();
                                if (list != null) {
                                    for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(list)).entrySet()) {
                                        Map<String, Object> value = route.getValue();
                                        value.put("route_id", route.getKey());
                                        list1.add(value);
                                    }
                                    busStop.setNameLt(ApiMobileV2Service.ltConcertKr(busStop.getName()));
                                    busStop.setRouteDataList(list1);
                                    BusMapAccessor.getInstance().addBusStop(busStop);
                                }
                                if (index >= secondQuarter) {
                                    break;
                                }
                                index++;
                            }
                        } catch (Exception e) {
                            System.out.println(ANSI_BG_BLACK + LocalDate.now() + " " + LocalTime.now() + ANSI_YELLOW + "  WARN " + ANSI_PURPLE + PID + ANSI_RESET + ANSI_BG_BLACK + " --- [127.0.0.1:" + PID + "] " + ANSI_CYAN + "com.sulaymon.yahyo.subhanalloh           " + ANSI_RESET + ANSI_BG_BLACK + ": " + ANSI_BG_GREEN + "Error Second thread     \uD83E\uDD75" + ANSI_RESET);
                        }
                    }).start();
                    new Thread(() -> {
                        try {
                            int index = 0;
                            while (index != size) {
                                if (index <= secondQuarter) {
                                    index++;
                                    continue;
                                }
                                BusStop busStop = busStopList.get(index);
                                List<Long> list = stationRoutes.get(busStop.getId());
                                List<Map<String, Object>> list1 = new ArrayList<>();
                                if (list != null) {
                                    for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(list)).entrySet()) {
                                        Map<String, Object> value = route.getValue();
                                        value.put("route_id", route.getKey());
                                        list1.add(value);
                                    }
                                    busStop.setNameLt(ApiMobileV2Service.ltConcertKr(busStop.getName()));
                                    busStop.setRouteDataList(list1);
                                    BusMapAccessor.getInstance().addBusStop(busStop);
                                }
                                if (index >= thirdQuarter) {
                                    break;
                                }
                                index++;
                            }
                        } catch (Exception e) {
                            System.out.println(ANSI_BG_BLACK + LocalDate.now() + " " + LocalTime.now() + ANSI_YELLOW + "  WARN " + ANSI_PURPLE + PID + ANSI_RESET + ANSI_BG_BLACK + " --- [127.0.0.1:" + PID + "] " + ANSI_CYAN + "com.sulaymon.yahyo.subhanalloh           " + ANSI_RESET + ANSI_BG_BLACK + ": " + ANSI_BG_GREEN + "Error Third Thread     \uD83E\uDD75" + ANSI_RESET);
                        }
                    }).start();
                    new Thread(() -> {
                        try {
                            int index = 0;
                            while (index != size) {
                                if (index <= thirdQuarter) {
                                    index++;
                                    continue;
                                }
                                BusStop busStop = busStopList.get(index);
                                List<Long> list = stationRoutes.get(busStop.getId());
                                List<Map<String, Object>> list1 = new ArrayList<>();
                                if (list != null) {
                                    for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(list)).entrySet()) {
                                        Map<String, Object> value = route.getValue();
                                        value.put("route_id", route.getKey());
                                        list1.add(value);
                                    }
                                    busStop.setNameLt(ApiMobileV2Service.ltConcertKr(busStop.getName()));
                                    busStop.setRouteDataList(list1);
                                    BusMapAccessor.getInstance().addBusStop(busStop);
                                }
                                index++;
                            }
                        } catch (Exception e) {
                            System.out.println(ANSI_BG_BLACK + LocalDate.now() + " " + LocalTime.now() + ANSI_YELLOW + "  WARN " + ANSI_PURPLE + PID + ANSI_RESET + ANSI_BG_BLACK + " --- [127.0.0.1:" + PID + "] " + ANSI_CYAN + "com.sulaymon.yahyo.subhanalloh           " + ANSI_RESET + ANSI_BG_BLACK + ": " + ANSI_BG_GREEN + "Error Fourth Thread     \uD83E\uDD75" + ANSI_RESET);
                        }
                    }).start();
                    fixed = true;
                } catch (Exception e) {
                    fixed = false;
                }
            }
            System.out.println(fixed ? ANSI_BG_BLACK + LocalDate.now() + " " + LocalTime.now() + ANSI_BLUE + "  INFO " + ANSI_PURPLE + PID + ANSI_RESET + ANSI_BG_BLACK + " --- [127.0.0.1:" + PID + "] " + ANSI_CYAN + "com.sulaymon.yahyo.alhamdulillah         " + ANSI_RESET + ANSI_BG_BLACK + ": " + ANSI_BG_GREEN + "The data has been uploaded !" + ANSI_RESET : ANSI_BG_BLACK + LocalDate.now() + " " + LocalTime.now() + ANSI_YELLOW + "  WARN " + ANSI_PURPLE + PID + ANSI_RESET + ANSI_BG_BLACK + " --- [127.0.0.1:" + PID + "] " + ANSI_CYAN + "com.sulaymon.yahyo.subhanalloh           " + ANSI_RESET + ANSI_BG_BLACK + ": " + ANSI_BG_GREEN + "Data retrieval error   \uD83E\uDD74" + ANSI_RESET);
        }).start();
        new Thread(() -> {
            System.out.println("Second thread");
            /*
                for (BusStop busStop : busStopList) {
                    List<Long> list = stationRoutes.get(busStop.getId());
                    if (list != null) {
                        new Thread(() -> {
                            try {
                                List<Map<String, Object>> list1 = new ArrayList<>();
                                for (Map.Entry<Long, Map<String, Object>> route : routeProps.getAll(new HashSet<>(list)).entrySet()) {
                                    Map<String, Object> value = route.getValue();
                                    value.put("route_id", route.getKey());
                                    list1.add(value);
                                }
                                busStop.setNameLt(ApiMobileV2Service.ltConcertKr(busStop.getName()));
                                busStop.setRouteDataList(list1);
                                BusMapAccessor.getInstance().addBusStop(busStop);
//                                new Thread(() -> {
//                                    try {
//                                        List<MyBusRoute> routeList = new ArrayList<>();
//                                        for (Map<String, Object> data : list1) {
//                                            routeList.add(new MyBusRoute(Double.valueOf(data.get("total").toString()), Double.valueOf(data.get("half").toString()), Integer.parseInt(data.get("route_id").toString()), data.get("kpp1").toString(), data.get("kpp2").toString(), data.get("name").toString()));
//                                        }
//                                        List<MyBusRoute> myBusRoutes = myBusRouteRepository.saveAll(routeList);
//                                        myBusBusStopRepository.save(new MyBusBusStop(busStop.getId(), busStop.getName(), busStop.getNameLt(), busStop.getRoutes(), busStop.getLat(), busStop.getLng(), busStop.getStatus(), busStop.getRoute(), myBusRoutes));
//                                    } catch (Exception e) {
//                                        System.out.println(LocalDate.now() + " " + LocalTime.now() + "\u001B[33m" + "  WARN 🥵 " + "\u001B[0m" + "Error 2 thread");
//                                    }
//                                }).start();
                            } catch (Exception e) {
                                System.out.println(LocalDate.now() + " " + LocalTime.now() + "\u001B[33m" + "  WARN 🥵 " + "\u001B[0m" + "Error First thread");
                            }
                        }).start();
                    }
                }
*/
        }).start();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("test6");
        list.add("test7");
        list.add("test8");
        list.add("test9");
        list.add("test10");
        new Thread(() -> {
            try {
                int index = 0;
                while (index != list.size()) {
                    if (index == 5) {
                        break;
                    }
                    System.out.println(list.get(index));
                    index++;
                }
            } catch (Exception e) {
                System.err.println("Error");
            }
        }).start();
        new Thread(() -> {
            try {
                int index = 0;
                while (index != list.size()) {
                    if (index < 5) {
                        index++;
                        continue;
                    } else {
                        System.err.println(list.get(index++));
                    }
                }
            } catch (Exception e) {
                System.err.println("Error");
            }
        }).start();
        for (int j = 0; j < 50; j++) {
            if (j < 30) {
                continue;
            }
            System.out.println(j);
        }
    }
}
