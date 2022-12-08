package com.softart.dfe.components.security;

import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.config.Config;

import javax.net.ssl.*;
import java.security.KeyStore;

final class SocketFactoryServiceImpl extends SocketFactory {

    private final static String PROTOCOL = "TLSv1.2";

    private static KeyManager[] createKeyManagers(final Config config) throws SecurityException {
        return new KeyManager[] {getKeyManagerForKeystore(config.info().certificate(), config.info().certificatePassword())};
    }

    private static TrustManager[] createTrustManagers(final Config config) throws SecurityException {
        try {
            final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(config.info().certificateChain());
            return trustManagerFactory.getTrustManagers();
        } catch (Exception e) {
            throw new SSLContextException(e);
        }
    }

    private static X509KeyManager getKeyManagerForKeystore(KeyStore keyStore, String password) throws SSLContextException {
        try {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509", "SunJSSE");
            keyManagerFactory.init(keyStore, password.toCharArray());
            for (KeyManager keyManager : keyManagerFactory.getKeyManagers()) {
                if (keyManager instanceof X509KeyManager) {
                    return (X509KeyManager) keyManager;
                }
            }
            throw new IllegalStateException("Não foi possível encontrar um X509KeyManager");
        } catch (Exception e) {
            throw new SSLContextException(e);
        }
    }

    public SSLContext context(Config config) throws SSLContextException {
        try {
            SSLContext context = SSLContext.getInstance(PROTOCOL);
            context.init(createKeyManagers(config), createTrustManagers(config), null);
            return context;
        } catch (Exception e) {
            throw new SSLContextException(e);
        }
    }
}
