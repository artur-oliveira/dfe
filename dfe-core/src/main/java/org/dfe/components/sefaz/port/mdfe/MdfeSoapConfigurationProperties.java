package org.dfe.components.sefaz.port.mdfe;

public final class MdfeSoapConfigurationProperties {
    public static final boolean LAZY_INITIALIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.lazy", "true"));

    public static final boolean CACHE_HOM_RECEPTION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.hom-reception", "false"));
    public static final boolean CACHE_HOM_QUERY_RECEIPT = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.hom-query-receipt", "false"));
    public static final boolean CACHE_HOM_EVENT = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.hom-event", "true"));
    public static final boolean CACHE_HOM_QUERY_SITUATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.hom-query-situation", "false"));
    public static final boolean CACHE_HOM_STATUS_SERVICE = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.hom-status-service", "false"));
    public static final boolean CACHE_HOM_QUERY_UNCLOSED = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.hom-query-unclosed", "false"));
    public static final boolean CACHE_HOM_DISTRIBUTION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.hom-distribution", "false"));
    public static final boolean CACHE_HOM_DISTRIBUTION_OLD = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.hom-distribution-old", "false"));
    public static final boolean CACHE_HOM_RECEPTION_SYNC = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.hom-reception-sync", "true"));

    public static final boolean CACHE_PROD_RECEPTION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.prod-reception", "false"));
    public static final boolean CACHE_PROD_QUERY_RECEIPT = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.prod-query-receipt", "false"));
    public static final boolean CACHE_PROD_EVENT = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.prod-event", "true"));
    public static final boolean CACHE_PROD_QUERY_SITUATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.prod-query-situation", "false"));
    public static final boolean CACHE_PROD_STATUS_SERVICE = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.prod-status-service", "false"));
    public static final boolean CACHE_PROD_QUERY_UNCLOSED = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.prod-query-unclosed", "false"));
    public static final boolean CACHE_PROD_DISTRIBUTION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.prod-distribution", "false"));
    public static final boolean CACHE_PROD_DISTRIBUTION_OLD = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.prod-distribution-old", "false"));
    public static final boolean CACHE_PROD_RECEPTION_SYNC = Boolean.parseBoolean(System.getProperty("org.dfe.soap.mdfe.cache.prod-reception-sync", "true"));

}
