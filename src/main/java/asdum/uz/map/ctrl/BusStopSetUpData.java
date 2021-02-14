package asdum.uz.map.ctrl;

import asdum.uz.config.CacheConfig;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.entity.MyBusBusStop;
import asdum.uz.map.entity.MyBusBusStopRepository;
import asdum.uz.map.entity.MyBusRoute;
import asdum.uz.map.entity.MyBusRouteRepository;
import asdum.uz.map.model.BusStop;
import asdum.uz.service.ApiMobileV2Service;
import asdum.uz.utils.ColorsTerminal;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Component
public class BusStopSetUpData implements CommandLineRunner {

    private static final String DATA_URL = "/api/mobile/v2/query";

    @Value("${server.port}")
    private String port;

    @Autowired
    CacheConfig cacheConfig;

//    @Autowired
//    MyBusBusStopRepository myBusBusStopRepository;

//    @Autowired
//    MyBusRouteRepository myBusRouteRepository;

    @Override
    public void run(String... args) {
        boolean fixed;
        System.out.println("Installing BUS STOP Data...");
        synchronized (BusMapAccessor.class) {
            try {
//                URL url = new URL("http://asfd:" + port + DATA_URL);
                URL url = new URL("http://localhost:" + port + DATA_URL);
                List<BusStop> busStopList = new ObjectMapper().readValue(url, new TypeReference<List<BusStop>>() {
                });
                IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
                IMap<Long, Map<String, Object>> routeProps = cacheConfig.getRoutes().getMap("routeProps");
                ColorsTerminal colorsTerminal = new ColorsTerminal();
                System.out.println(LocalDate.now() + " " + LocalTime.now() + colorsTerminal.GET_ANSI_BLUE()+"INFO 🧐 "+ManagementFactory.getRuntimeMXBean().getName().split("@")[0]+ "\u001B[0m--- [" + InetAddress.getLocalHost().getHostAddress() + ":" + port + "]\u001B[0m  please wait 20 minutes ⏳");
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
                                System.out.println(busStop.getName());
                                System.out.println(ApiMobileV2Service.ltConcertKr(busStop.getName()));
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
                fixed = true;
            } catch (Exception e) {
                fixed = false;
            }
        }
        System.out.println(fixed ? LocalDate.now() + " " + LocalTime.now() + "\u001B[34m" + "  INFO 🤓 " + ManagementFactory.getRuntimeMXBean().getName().split("@")[0] + "\u001B[0m" + "The data has been uploaded !" : LocalDate.now() + " " + LocalTime.now() + "\u001B[33m" + "  WARN 🤕 "+ManagementFactory.getRuntimeMXBean().getName().split("@")[0] + "\u001B[0m" + "Data retrieval error");
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
