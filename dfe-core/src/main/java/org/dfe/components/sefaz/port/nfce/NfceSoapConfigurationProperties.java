package org.dfe.components.sefaz.port.nfce;

public final class NfceSoapConfigurationProperties {
    public static final boolean LAZY_INITIALIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.lazy", "true"));

    public static final boolean CACHE_HOM_AUTHORIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.hom-authorization", "true"));
    public static final boolean CACHE_HOM_RETURN_AUTHORIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.hom-return-authorization", "false"));
    public static final boolean CACHE_HOM_CANCEL = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.hom-cancel", "false"));
    public static final boolean CACHE_HOM_INUTILIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.hom-inutilization", "false"));
    public static final boolean CACHE_HOM_SUBSTITUTE_CANCEL = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.hom-substitute-cancel", "false"));
    public static final boolean CACHE_HOM_QUERY_PROTOCOL = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.hom-query-protocol", "false"));
    public static final boolean CACHE_HOM_QUERY_STATUS_SERVICE = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.hom-query-status-service", "true"));

    public static final boolean CACHE_PROD_AUTHORIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.prod-authorization", "true"));
    public static final boolean CACHE_PROD_RETURN_AUTHORIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.prod-return-authorization", "false"));
    public static final boolean CACHE_PROD_CANCEL = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.prod-cancel", "false"));
    public static final boolean CACHE_PROD_INUTILIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.prod-inutilization", "false"));
    public static final boolean CACHE_PROD_SUBSTITUTE_CANCEL = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.prod-substitute-cancel", "false"));
    public static final boolean CACHE_PROD_QUERY_PROTOCOL = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.prod-query-protocol", "false"));
    public static final boolean CACHE_PROD_QUERY_STATUS_SERVICE = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfce.cache.prod-query-status-service", "true"));
}
