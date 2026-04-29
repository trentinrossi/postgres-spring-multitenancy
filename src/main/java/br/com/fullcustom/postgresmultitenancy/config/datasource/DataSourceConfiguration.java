package br.com.fullcustom.postgresmultitenancy.config.datasource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    private final DataSourceProperties dataSourceProperties;

    public DataSourceConfiguration(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource dataSource() {
        var customDataSource = new TenantRoutingDataSource();
        customDataSource.setTargetDataSources(dataSourceProperties.getDatasources());
        customDataSource.setDefaultTargetDataSource(dataSourceProperties.getDatasources().get("default"));
        System.out.println("Bean setting Target DataSource: " + dataSourceProperties.getDatasources());
        return customDataSource;
    }

    @PostConstruct
    public void migrate() {
        dataSourceProperties
                .getDatasources()
                .values()
                .stream()
                .map(dataSource -> (DataSource) dataSource)
                .forEach(this::migrate);
    }

    private void migrate(DataSource dataSource) {
        var flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
    }
}