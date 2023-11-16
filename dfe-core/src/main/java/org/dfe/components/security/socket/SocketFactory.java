package org.dfe.components.security.socket;

import org.dfe.exceptions.security.SSLContextException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.security.SocketFactoryService;

import javax.net.ssl.*;
import java.security.KeyStore;

public abstract class SocketFactory implements SocketFactoryService {


    /**
     * The function creates and returns an array of trust managers using a given certificate chain.
     *
     * @param certificateChain The parameter "certificateChain" is a KeyStore object that contains a chain of certificates.
     *                         This chain is used to establish trust in the remote server during SSL/TLS communication.
     * @return The method is returning an array of TrustManagers.
     */
    public static TrustManager[] createTrustManagers(KeyStore certificateChain) throws SecurityException {
        try {
            final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(certificateChain);
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
    public static X509KeyManager getKeyManagerForKeystore(KeyStore keyStore, String password) throws SSLContextException {
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
     * If the instance is null, create it. If it's not null, return it.
     *
     * @return A singleton instance of the SocketFactory class.
     */
    public static SocketFactory getInstance() {
        return SocketFactoryHolder.INSTANCE;
    }

    private static class SocketFactoryHolder {
        static final SocketFactory INSTANCE = new SocketFactoryServiceImpl();
    }
}
