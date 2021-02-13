package asdum.uz.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@Configuration
public class CacheConfig {
    @Bean
    public HazelcastInstance getRoutes() {
        ClientConfig clientConfig = new ClientConfig();
//        clientConfig.getNetworkConfig().addAddress("192.168.0.46:9000");
        clientConfig.getNetworkConfig().addAddress("167.160.91.83:9000");
        clientConfig.getGroupConfig().setName("dev");
        clientConfig.getGroupConfig().setPassword("dev11");
        return HazelcastClient.newHazelcastClient(clientConfig);
    }

//    @Bean
//    public HazelcastInstance getLocation() {
//        ClientConfig clientConfig1 = new ClientConfig();
//        clientConfig1.getNetworkConfig().addAddress("192.168.0.30:5701");
//        clientConfig1.getGroupConfig().setName("location");
//        clientConfig1.getGroupConfig().setPassword("1234");
//        return HazelcastClient.newHazelcastClient(clientConfig1);
//    }

    @Bean
    public CacheManager cacheManager() {
        return new HazelcastCacheManager();
    }
}
