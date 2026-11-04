package br.com.fullcustom.postgresmultitenancy.config.datasource

import org.flywaydb.core.Flyway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.annotation.PostConstruct
import javax.sql.DataSource

Configuration
public class DataSourceConfiguration 

private final DataSourceProperties dataSourceProperties

public DataSourceConfigurationDataSourceProperties dataSourceProperties 

this.dataSourceProperties  dataSourceProperties



Bean
public DataSource dataSource 

TenantRoutingDataSource customDataSource  new TenantRoutingDataSource

customDataSource.setTargetDataSourcesdataSourceProperties.getDatasources

customDataSource.setDefaultTargetDataSourcedataSourceProperties.getDatasources.getdefault

System.out.printlnBean setting Target DataSource   dataSourceProperties.getDatasources

return customDataSource



PostConstruct
public void migrate 

dataSourceProperties

.getDatasources

.values

.stream

.mapdataSource  DataSource dataSource

.forEachthismigrate



private void migrateDataSource dataSource 

Flyway flyway  Flyway.configure.dataSourcedataSource.load

flyway.migrate