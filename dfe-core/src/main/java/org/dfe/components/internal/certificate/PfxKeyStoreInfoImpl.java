package org.dfe.components.internal.certificate;

import org.dfe.components.security.chain.CertificateChainFactory;
import org.dfe.components.security.keystore.KeyStoreParserFactory;
import org.dfe.components.security.socket.SocketFactory;
import org.dfe.enums.internal.KeyType;
import org.dfe.exceptions.security.CertificateException;
import org.dfe.exceptions.security.ExpiredCertificateException;
import org.dfe.models.internal.security.Certificate;
import org.dfe.util.DateUtils;
import org.dfe.util.InputStreamUtils;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import java.io.InputStream;
import java.security.KeyStore;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

public class PfxKeyStoreInfoImpl extends KeyStoreFactory {
    private KeyStore certificateKeyStore;
    private String certificateAlias;
    private KeyStore.PrivateKeyEntry keyEntry;
    private KeyManager[] keyManagers;
    private TrustManager[] trustManagers;
    private ZonedDateTime certificateExpiration;
    private KeyStore certificateChainKeyStore;

    public PfxKeyStoreInfoImpl(String certPath, String certPassword, String chainPath, String chainPassword) throws CertificateException {
        this(InputStreamUtils.newFileInputStream(certPath), certPassword, InputStreamUtils.newFileInputStream(chainPath), chainPassword);
    }

    public PfxKeyStoreInfoImpl(final InputStream cert, String certPassword) throws CertificateException {
        this(cert, certPassword, CertificateChainFactory.getInstance().generate(Certificate.builder().build()), CertificateChainFactory.getInstance().getPassword());
    }

    public PfxKeyStoreInfoImpl(final InputStream cert, String certPassword, final byte[] certChain, String certChainPassword) throws CertificateException {
        this(cert, certPassword, InputStreamUtils.newByteArrayInputStream(certChain), certChainPassword);
    }

    public PfxKeyStoreInfoImpl(final InputStream cert, String certPassword, final InputStream chain, String certChainPassword) throws CertificateException {
        loadCertificate(cert, KeyType.PFX.getType(), certPassword);
        loadCertificateChain(chain, KeyType.JKS.getType(), certChainPassword);
    }

    public void loadCertificate(final InputStream inputStream, String type, String certificatePassword) throws CertificateException {
        if (Objects.isNull(certificateKeyStore)) {
            try {
                this.certificateKeyStore = KeyStoreParserFactory.getInstance().read(inputStream, type, certificatePassword);
                this.certificateAlias = KeyStoreParserFactory.getInstance().getAlias(this.certificateKeyStore);
                this.certificateExpiration = DateUtils.zonedDateTime(KeyStoreParserFactory.getInstance().getExpiration(this.certificateKeyStore));

                if (ZonedDateTime.now().isAfter(getExpiration())) {
                    throw new ExpiredCertificateException("certificate expired at " + this.certificateExpiration);
                }
                this.keyManagers = SocketFactory.createKeyManagers(this.certificateKeyStore, certificatePassword, this.certificateAlias);
                this.keyEntry = KeyStoreParserFactory.getInstance().getPrivateKeyEntry(this.certificateAlias, certificatePassword, this.certificateKeyStore);
            } catch (Exception e) {
                throw new CertificateException(e);
            }
        }

        if (Objects.isNull(certificateKeyStore))
            throw new CertificateException("Certificate cannot be null");
    }

    public void loadCertificateChain(final InputStream inputStream, String type, String certificateChainPassword) throws CertificateException {
        if (Objects.isNull(certificateChainKeyStore)) {
            try (final InputStream is = inputStream) {
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
    public KeyManager[] getKeyManagers() {
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
