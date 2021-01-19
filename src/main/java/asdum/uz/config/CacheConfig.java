package asdum.uz.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
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

}
