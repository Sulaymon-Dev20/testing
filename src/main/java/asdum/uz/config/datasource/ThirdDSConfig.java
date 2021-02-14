package asdum.uz.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Objects;

@Configuration
@EnableJpaRepositories(basePackages = "asdum.uz.repository.third",
        entityManagerFactoryRef = "thirdEntityManagerFactory",
        transactionManagerRef = "thirdTransactionManager")
public class ThirdDSConfig {

    @Bean
    @ConfigurationProperties("app.datasource.third")
    public DataSourceProperties thirdDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.third.configuration")
    public HikariDataSource thirdDataSource() {
        return thirdDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "thirdEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean thirdEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(thirdDataSource())
                .packages("asdum.uz.entity.third")
                .build();
    }

    @Bean
    public PlatformTransactionManager thirdTransactionManager(
            final @Qualifier("thirdEntityManagerFactory") LocalContainerEntityManagerFactoryBean thirdEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(thirdEntityManagerFactory.getObject()));
    }
}
