package com.softart.dfe.components.security.socket;

import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.config.Config;

import javax.net.ssl.SSLContext;

final class SocketFactoryServiceImpl extends SocketFactory {

    private final static String PROTOCOL = "TLSv1.2";

    /**
     * Create an SSLContext using the given configuration.
     *
     * @param config The configuration object that contains the keystore and truststore information.
     * @return A SSLContext object
     */
    public SSLContext context(Config config) throws SSLContextException {
        try {
            SSLContext context = SSLContext.getInstance(PROTOCOL);
            context.init(config.info().getKeyManagers(), config.info().getTrustManagers(), null);
            return context;
        } catch (Exception e) {
            throw new SSLContextException(e);
        }
    }
}
