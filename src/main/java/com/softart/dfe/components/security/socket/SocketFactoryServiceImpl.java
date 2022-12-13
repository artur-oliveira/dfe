package com.softart.dfe.components.security.socket;

import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.config.Config;

import javax.net.ssl.*;
import java.security.KeyStore;

final class SocketFactoryServiceImpl extends SocketFactory {

    private final static String PROTOCOL = "TLSv1.2";

    /**
     * Create a key manager for the given certificate and password.
     *
     * @param config The configuration object that contains the certificate and password
     * @return A KeyManager[]
     */
    private static KeyManager[] createKeyManagers(final Config config) throws SecurityException {
        return new KeyManager[] {getKeyManagerForKeystore(config.info().certificate(), config.info().certificatePassword())};
    }

    /**
     * Create a trust manager that trusts the certificate chain in the config.
     *
     * @param config The configuration object that contains the information about the certificate chain and the private
     *               key.
     * @return TrustManager[]
     */
    private static TrustManager[] createTrustManagers(final Config config) throws SecurityException {
        try {
            final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(config.info().certificateChain());
            return trustManagerFactory.getTrustManagers();
        } catch (Exception e) {
            throw new SSLContextException(e);
        }
    }

    /**
     * It creates a KeyManagerFactory, initializes it with the keystore and password, and then returns the first
     * X509KeyManager it finds in the list of KeyManagers
     *
     * @param keyStore The keystore containing the private key and certificate.
     * @param password The password to access the keystore.
     * @return A X509KeyManager
     */
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

    /**
     * Create an SSLContext using the given configuration.
     *
     * @param config The configuration object that contains the keystore and truststore information.
     * @return A SSLContext object
     */
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
