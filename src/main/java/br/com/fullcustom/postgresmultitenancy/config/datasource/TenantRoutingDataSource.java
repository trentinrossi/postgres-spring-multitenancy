package br.com.fullcustom.postgresmultitenancy.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import br.com.fullcustom.postgresmultitenancy.config.web.ThreadTenantStorage;

public class TenantRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("Getting tenantId by currentLookupKey: "+ThreadTenantStorage.getTenantId());
        return ThreadTenantStorage.getTenantId();
    }
}