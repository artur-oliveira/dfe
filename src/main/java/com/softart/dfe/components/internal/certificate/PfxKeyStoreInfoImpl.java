package com.softart.dfe.components.internal.certificate;

import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.util.InputStreamUtils;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Objects;
import java.util.Optional;

public final class PfxKeyStoreInfoImpl extends KeyStoreFactory {
    private final String certificatePassword;
    private final String certificateChainPassword;
    private KeyStore certificateKeyStore;
    private KeyStore certificateChainKeyStore;

    public PfxKeyStoreInfoImpl(String certPath, String certPassword, String chainPath, String chainPassword) throws CertificateException {
        this(InputStreamUtils.newFileInputStream(certPath), certPassword, InputStreamUtils.newFileInputStream(chainPath), chainPassword);
    }

    /**
     * @see com.softart.dfe.components.internal.certificate.KeyStoreFactory
     */
    public PfxKeyStoreInfoImpl(InputStream cert, String certPassword, InputStream chain, String chainPassword) throws CertificateException {
        this.certificatePassword = certPassword;
        this.certificateChainPassword = chainPassword;
        loadCertificate(cert);
        loadCertificateChain(chain);
    }

    @Override
    public void loadCertificate(InputStream inputStream, String type) throws CertificateException {
        if (Objects.isNull(certificateKeyStore)) {
            try (InputStream is = inputStream) {
                certificateKeyStore = KeyStore.getInstance(type);
                certificateKeyStore.load(is, certificatePassword().toCharArray());
            } catch (Exception e) {
                throw new CertificateException(e);
            }
        }

        if (Objects.isNull(certificateKeyStore))
            throw new CertificateException("Certificate cannot be null");
    }

    @Override
    public void loadCertificateChain(InputStream inputStream, String type) throws CertificateException {
        if (Objects.isNull(certificateChainKeyStore)) {
            try (InputStream is = inputStream) {
                certificateChainKeyStore = KeyStore.getInstance(type);
                certificateChainKeyStore.load(is, certificateChainPassword().toCharArray());
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

    @Override
    public String certificatePassword() {
        return certificatePassword;
    }

    public KeyStore certificateChain() throws CertificateException {
        return Optional.ofNullable(certificateChainKeyStore).orElseThrow(() -> new CertificateException("Certificate chain cannot be null"));
    }

    @Override
    public String certificateChainPassword() {
        return certificateChainPassword;
    }

    public String getAlias() throws CertificateException {
        try {
            return certificate().aliases().nextElement();
        } catch (KeyStoreException e) {
            throw new CertificateException(e);
        }
    }

}
