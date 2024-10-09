package org.dfe.components.sefaz.port.nfe;

public final class NfeSoapConfigurationProperties {
    public static final boolean LAZY_INITIALIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.lazy", "true"));

    public static final boolean CACHE_HOM_AUTHORIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-authorization", "true"));
    public static final boolean CACHE_HOM_RETURN_AUTHORIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-return-authorization", "false"));
    public static final boolean CACHE_HOM_CANCEL = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-cancel", "false"));
    public static final boolean CACHE_HOM_INUTILIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-inutilization", "false"));
    public static final boolean CACHE_HOM_CORRECTION_LETTER = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-correction-letter", "false"));
    public static final boolean CACHE_HOM_QUERY_PROTOCOL = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-query-protocol", "false"));
    public static final boolean CACHE_HOM_QUERY_REGISTER = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-query-register", "false"));
    public static final boolean CACHE_HOM_QUERY_STATUS_SERVICE = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-query-status-service", "true"));
    public static final boolean CACHE_HOM_INTERESTED_ACTOR = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-interested-actor", "false"));
    public static final boolean CACHE_HOM_EPEC = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-epec", "false"));
    public static final boolean CACHE_HOM_DISTRIBUTION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-distribution", "true"));
    public static final boolean CACHE_HOM_MANIFESTATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.hom-manifestation", "false"));

    public static final boolean CACHE_PROD_AUTHORIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-authorization", "true"));
    public static final boolean CACHE_PROD_RETURN_AUTHORIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-return-authorization", "false"));
    public static final boolean CACHE_PROD_CANCEL = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-cancel", "false"));
    public static final boolean CACHE_PROD_INUTILIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-inutilization", "false"));
    public static final boolean CACHE_PROD_CORRECTION_LETTER = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-correction-letter", "false"));
    public static final boolean CACHE_PROD_QUERY_PROTOCOL = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-query-protocol", "false"));
    public static final boolean CACHE_PROD_QUERY_REGISTER = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-query-register", "false"));
    public static final boolean CACHE_PROD_QUERY_STATUS_SERVICE = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-query-status-service", "true"));
    public static final boolean CACHE_PROD_INTERESTED_ACTOR = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-interested-actor", "false"));
    public static final boolean CACHE_PROD_EPEC = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-epec", "false"));
    public static final boolean CACHE_PROD_DISTRIBUTION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-distribution", "true"));
    public static final boolean CACHE_PROD_MANIFESTATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.prod-manifestation", "false"));

    public static final boolean CACHE_QUERY_GTIN = Boolean.parseBoolean(System.getProperty("org.dfe.soap.nfe.cache.query-gtin", "false"));

}
