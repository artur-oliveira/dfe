package com.softart.dfe.components.internal.certificate;

import com.softart.dfe.components.security.chain.CertificateChainFactory;
import com.softart.dfe.components.security.keystore.KeyStoreParserFactory;
import com.softart.dfe.components.security.socket.SocketFactory;
import com.softart.dfe.enums.internal.KeyType;
import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.exceptions.security.ExpiredCertificateException;
import com.softart.dfe.models.internal.security.Certificate;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.InputStreamUtils;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509KeyManager;
import java.io.InputStream;
import java.security.KeyStore;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

public class PfxKeyStoreInfoImpl extends KeyStoreFactory {
    private KeyStore certificateKeyStore;
    private String certificateAlias;
    private KeyStore.PrivateKeyEntry keyEntry;
    private X509KeyManager[] keyManagers;
    private TrustManager[] trustManagers;
    private ZonedDateTime certificateExpiration;
    private KeyStore certificateChainKeyStore;

    public PfxKeyStoreInfoImpl(String certPath, String certPassword, String chainPath, String chainPassword) throws CertificateException {
        this(InputStreamUtils.newFileInputStream(certPath), certPassword, InputStreamUtils.newFileInputStream(chainPath), chainPassword);
    }

    /**
     * @see KeyStoreFactory
     */
    public PfxKeyStoreInfoImpl(InputStream cert, String certPassword) throws CertificateException {
        this(cert, certPassword, InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());
    }

    public PfxKeyStoreInfoImpl(InputStream cert, String certPassword, InputStream chain, String certChainPassword) throws CertificateException {
        loadCertificate(cert, KeyType.PFX.getType(), certPassword);
        loadCertificateChain(chain, KeyType.JKS.getType(), certChainPassword);
    }

    public void loadCertificate(InputStream inputStream, String type, String certificatePassword) throws CertificateException {
        if (Objects.isNull(certificateKeyStore)) {
            try {
                this.certificateKeyStore = KeyStoreParserFactory.getInstance().read(inputStream, type, certificatePassword);
                this.certificateAlias = KeyStoreParserFactory.getInstance().getAlias(this.certificateKeyStore);
                this.certificateExpiration = DateUtils.zonedDateTime(KeyStoreParserFactory.getInstance().getExpiration(this.certificateKeyStore));

                if (ZonedDateTime.now().isAfter(getExpiration())) {
                    throw new ExpiredCertificateException("certificate expired at " + this.certificateExpiration);
                }
                this.keyManagers = new X509KeyManager[]{SocketFactory.getKeyManagerForKeystore(this.certificateKeyStore, certificatePassword)};
                this.keyEntry = KeyStoreParserFactory.getInstance().getPrivateKeyEntry(this.certificateAlias, certificatePassword, this.certificateKeyStore);
            } catch (Exception e) {
                throw new CertificateException(e);
            }
        }

        if (Objects.isNull(certificateKeyStore))
            throw new CertificateException("Certificate cannot be null");
    }

    public void loadCertificateChain(InputStream inputStream, String type, String certificateChainPassword) throws CertificateException {
        if (Objects.isNull(certificateChainKeyStore)) {
            try (InputStream is = inputStream) {
                certificateChainKeyStore = KeyStore.getInstance(type);
                certificateChainKeyStore.load(is, certificateChainPassword.toCharArray());
                this.trustManagers = SocketFactory.createTrustManagers(certificateChainKeyStore);
            } catch (Exception e) {
                throw new CertificateException(e);
            }
        }

        if (Objects.isNull(certificateChainKeyStore))
            throw new CertificateException("Certificate chain cannot be null");
    }

    public KeyStore certificate() throws CertificateException {
        return Optional.ofNullable(certificateKeyStore).orElseThrow(() -> new CertificateException("Certificate cannot be null"));
    }

    public KeyStore certificateChain() throws CertificateException {
        return Optional.ofNullable(certificateChainKeyStore).orElseThrow(() -> new CertificateException("Certificate chain cannot be null"));
    }

    public String getAlias() {
        return certificateAlias;
    }

    @Override
    public KeyStore.PrivateKeyEntry getKeyEntry() {
        return keyEntry;
    }

    @Override
    public X509KeyManager[] getKeyManagers() {
        return keyManagers;
    }

    @Override
    public TrustManager[] getTrustManagers() {
        return trustManagers;
    }

    @Override
    public ZonedDateTime getExpiration() {
        return certificateExpiration;
    }
}