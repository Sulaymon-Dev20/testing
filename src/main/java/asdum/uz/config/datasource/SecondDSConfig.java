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
@EnableJpaRepositories(basePackages = "asdum.uz.repository.second",
        entityManagerFactoryRef = "secondEntityManagerFactory",
        transactionManagerRef= "secondTransactionManager")
public class SecondDSConfig {

    @Bean
    @ConfigurationProperties("app.datasource.second")
    public DataSourceProperties locSenderDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.second.configuration")
    public HikariDataSource locSenderDataSource() {
        return locSenderDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "secondEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(locSenderDataSource())
//                .packages("uz.ssd.locationsender.domain.entity.locsender")
                .packages("asdum.uz.entity.secoud")
                .build();
    }

    @Bean
    public PlatformTransactionManager secondTransactionManager(
            final @Qualifier("secondEntityManagerFactory") LocalContainerEntityManagerFactoryBean secondEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(secondEntityManagerFactory.getObject()));
    }
}
