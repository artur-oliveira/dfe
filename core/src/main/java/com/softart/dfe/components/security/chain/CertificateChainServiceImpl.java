package com.softart.dfe.components.security.chain;

import com.softart.dfe.components.security.chain.cache.CertificateChainCacheFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.cte.CteAuthorizer;
import com.softart.dfe.enums.internal.mdfe.MdfeAuthorizer;
import com.softart.dfe.enums.internal.nf.NfceAuthorizer;
import com.softart.dfe.enums.internal.nf.NfeAuthorizer;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.security.CertificateChain;
import com.softart.dfe.util.OutputStreamUtils;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.security.*;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.stream.Collectors;

@Log4j2
final class CertificateChainServiceImpl extends CertificateChainFactory {

    private static final String DEFAULT_PASSWORD = System.getProperty("com.softart.dfe.security.chain.password", "123456");
    private static final int PORT = 443;
    private static final String PROTOCOL = "TLSv1.2";
    private static final int SOCKET_TIMEOUT = Math.min(Integer.parseInt(System.getProperty("com.softart.dfe.security.chain.socket.timeout", "5000")), 5000);

    private static void get(final KeyStore keyStore, final String host) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, CertificateEncodingException {
        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);

        final X509TrustManager defaultTrustManager = (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
        final DFTrustManager savingTrustManager = new DFTrustManager(defaultTrustManager);

        final SSLContext sslContext = SSLContext.getInstance(PROTOCOL);
        sslContext.init(null, new TrustManager[]{savingTrustManager}, null);

        try (SSLSocket sslSocket = (SSLSocket) sslContext.getSocketFactory().createSocket(host, PORT)) {
            sslSocket.setSoTimeout(CertificateChainServiceImpl.SOCKET_TIMEOUT);
            sslSocket.startHandshake();
        } catch (Exception ignored) {
        }

        if (savingTrustManager.getChain() != null) {
            final MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            for (int i = 0; i < savingTrustManager.getChain().length; i++) {
                final X509Certificate certificate = savingTrustManager.getChain()[i];
                sha1.update(certificate.getEncoded());
                md5.update(certificate.getEncoded());

                final String alias = String.format("%s.%s", host, i + 1);
                keyStore.setCertificateEntry(alias, certificate);
            }
        }
    }

    private static byte[] generateForUrls(Collection<String> urls) {
        try {
            final KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, DEFAULT_PASSWORD.toCharArray());
            try (ByteArrayOutputStream out = OutputStreamUtils.newByteArrayOutputStream()) {

                urls = urls.stream().map(it -> {
                    try {
                        return new URI(it).getHost();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).distinct().sorted().collect(Collectors.toList());

                log.info(urls.size() + " HOSTS FOR GENERATING CERTIFICATES CHAIN");

                for (String url : urls) {
                    get(keyStore, url);
                    log.debug("GENERATED FOR HOST: " + url);
                }
                keyStore.store(out, DEFAULT_PASSWORD.toCharArray());
                return out.toByteArray();
            }
        } catch (IOException | GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    private static byte[] getFromCache(CertificateChain generate) {
        return CertificateChainCacheFactory.getInstance().getFromCache(generate);
    }

    @SneakyThrows
    private static byte[] addToCache(CertificateChain generate, byte[] bytes) {
        CertificateChainCacheFactory.getInstance().addToCache(generate, bytes);
        return bytes;
    }

    private static Collection<String> getUrls(CertificateChain generate) {

        Collection<String> hosts = new HashSet<>();
        Collection<UF> ufs = Objects.isNull(generate.getUf()) ? UF.states() : Collections.singletonList(generate.getUf());
        Collection<Environment> environments = Objects.isNull(generate.getUf()) ? Arrays.asList(Environment.values()) : Collections.singletonList(generate.getEnvironment());
        Collection<Model> models = Objects.isNull(generate.getModel()) ? Model.hasAuthorizers() : Collections.singletonList(generate.getModel());

        for (Model model : models) {
            switch (model) {
                case NFE:
                    for (Environment env : environments) {
                        for (UF uf : ufs) {
                            try {
                                hosts.addAll(NfeAuthorizer.get(uf, env));
                            } catch (NoProviderFound ignored) {
                            }
                        }
                    }
                    break;
                case NFCE:
                    for (Environment env : environments) {
                        for (UF uf : ufs) {
                            try {
                                hosts.addAll(NfceAuthorizer.get(uf, env));
                            } catch (NoProviderFound ignored) {
                            }
                        }
                    }
                    break;
                case CTE:
                    for (Environment env : environments) {
                        for (UF uf : ufs) {
                            try {
                                hosts.addAll(CteAuthorizer.get(uf, env));
                            } catch (NoProviderFound ignored) {
                            }
                        }
                    }
                    break;
                case MDFE:
                    for (Environment env : environments) {
                        for (UF uf : ufs) {
                            try {
                                hosts.addAll(MdfeAuthorizer.get(uf, env));
                            } catch (NoProviderFound ignored) {
                            }
                        }
                    }
                default:
                    break;
            }
        }

        return hosts;
    }

    @Override
    public byte[] generate(CertificateChain generate) {
        byte[] cached = getFromCache(generate);
        if (Objects.nonNull(cached)) return cached;
        return addToCache(generate, generateForUrls(getUrls(generate)));
    }

    @Override
    public String getPassword() {
        return CertificateChainServiceImpl.DEFAULT_PASSWORD;
    }

    @Getter
    private static class DFTrustManager implements X509TrustManager {
        private final X509TrustManager trustManager;
        private X509Certificate[] chain;

        DFTrustManager(final X509TrustManager trustManager) {
            this.trustManager = trustManager;
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return this.trustManager.getAcceptedIssuers();
        }

        @Override
        public void checkClientTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
            this.trustManager.checkClientTrusted(chain, authType);
        }

        @Override
        public void checkServerTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
            this.chain = chain;
            this.trustManager.checkServerTrusted(chain, authType);
        }
    }
}
