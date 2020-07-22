package br.com.fullcustom.postgresmultitenancy.config.web;

public class ThreadTenantStorage {

    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        System.out.println("Setting tenant id: " + tenantId);
        currentTenant.set(tenantId);
    }

    public static String getTenantId() {
        System.out.println("Request tenant: " + currentTenant.get());
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }
}