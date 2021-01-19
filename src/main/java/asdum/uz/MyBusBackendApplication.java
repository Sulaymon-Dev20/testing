package asdum.uz;

import asdum.uz.map.ctrl.BusStopSetUpData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class MyBusBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBusBackendApplication.class, args);
        BusStopSetUpData.getInstance().initialize();
    }
}
