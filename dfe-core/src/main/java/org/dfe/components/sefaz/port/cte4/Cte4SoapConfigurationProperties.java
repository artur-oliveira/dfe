package org.dfe.components.sefaz.port.cte4;

public final class Cte4SoapConfigurationProperties {
    public static final boolean LAZY_INITIALIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.lazy", "true"));

    public static final boolean CACHE_HOM_RECEPTION_SYNC = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.hom-reception-sync", "true"));
    public static final boolean CACHE_HOM_RECEPTION_OS = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.hom-reception-os", "false"));
    public static final boolean CACHE_HOM_RECEPTION_GTVE = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.hom-reception-gtve", "false"));
    public static final boolean CACHE_HOM_EVENT = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.hom-event", "true"));
    public static final boolean CACHE_HOM_QUERY_SITUATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.hom-query-situation", "false"));
    public static final boolean CACHE_HOM_STATUS_SERVICE = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.hom-status-service", "false"));
    public static final boolean CACHE_HOM_DISTRIBUTION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.hom-distribution", "true"));

    public static final boolean CACHE_PROD_RECEPTION_SYNC = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.prod-reception-sync", "true"));
    public static final boolean CACHE_PROD_RECEPTION_OS = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.prod-reception-os", "false"));
    public static final boolean CACHE_PROD_RECEPTION_GTVE = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.prod-reception-gtve", "false"));
    public static final boolean CACHE_PROD_EVENT = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.prod-event", "true"));
    public static final boolean CACHE_PROD_QUERY_SITUATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.prod-query-situation", "false"));
    public static final boolean CACHE_PROD_STATUS_SERVICE = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.prod-status-service", "false"));
    public static final boolean CACHE_PROD_DISTRIBUTION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.cte.cache.prod-distribution", "true"));

}
