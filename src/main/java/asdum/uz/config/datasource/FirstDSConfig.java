package asdum.uz.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Objects;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/16/20
 * Time: 11:34 PM
 */
@Configuration
@EnableJpaRepositories(basePackages = "asdum.uz.repository.first",
        entityManagerFactoryRef = "firstEntityManagerFactory",
        transactionManagerRef= "firstTransactionManager")
public class FirstDSConfig {

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.first")
    public DataSourceProperties asdumDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "firstEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(asdumDataSource())
                .packages("asdum.uz.entity.first")
                .build();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.first.configuration")
    public HikariDataSource asdumDataSource() {
        return asdumDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager firstTransactionManager(
            final @Qualifier("firstEntityManagerFactory") LocalContainerEntityManagerFactoryBean firstEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(firstEntityManagerFactory.getObject()));
    }
}
