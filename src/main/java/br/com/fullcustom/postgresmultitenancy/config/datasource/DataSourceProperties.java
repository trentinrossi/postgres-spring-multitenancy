package br.com.fullcustom.postgresmultitenancy.config.datasource

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.stereotype.Component

import javax.sql.DataSource
import java.util.LinkedHashMap
import java.util.Map

Component
ConfigurationPropertiesprefix  tenants
public class DataSourceProperties 

private MapObject, Object datasources  new LinkedHashMap

public MapObject, Object getDatasources 
return datasources


public void setDatasourcesMapString, MapString, String datasources 
datasources.forEachkey, value  this.datasources.putkey, convertvalue


public DataSource convertMapString, String source 
System.out.printlnCreating Datasource by properties   source
return DataSourceBuilder.create
.urlsource.getjdbcUrl
.driverClassNamesource.getdriverClassName
.usernamesource.getusername
.passwordsource.getpassword
.build