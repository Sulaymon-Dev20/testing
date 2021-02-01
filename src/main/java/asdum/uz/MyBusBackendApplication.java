package asdum.uz;

import asdum.uz.config.InitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class MyBusBackendApplication {
    public static void main(String[] args) {
        if(InitConfig.isStart())SpringApplication.run(MyBusBackendApplication.class, args);
//        BusStopSetUpData.getInstance().initialize();
    }
}
