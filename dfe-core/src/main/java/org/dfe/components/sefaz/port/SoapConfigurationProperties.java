package org.dfe.components.sefaz.port;

public final class SoapConfigurationProperties {
    public static final int RETRY_TIMES_IF_FAIL = Integer.parseInt(System.getProperty("org.dfe.soap.retry", "5"));
}
