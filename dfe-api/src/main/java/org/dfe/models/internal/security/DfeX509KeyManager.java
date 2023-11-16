package org.dfe.models.internal.security;

import lombok.Builder;

import javax.net.ssl.X509KeyManager;
import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

@Builder
public record DfeX509KeyManager(X509KeyManager keyManager, String alias) implements X509KeyManager {
    @Override
    public String chooseClientAlias(String[] keyTypes, Principal[] issuers, Socket socket) {
        return alias();
    }

    @Override
    public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
        return alias();
    }

    @Override
    public X509Certificate[] getCertificateChain(String alias) {
        return keyManager().getCertificateChain(alias);
    }

    @Override
    public String[] getClientAliases(String keyType, Principal[] issuers) {
        return keyManager().getClientAliases(keyType, issuers);
    }

    @Override
    public PrivateKey getPrivateKey(String alias) {
        return keyManager().getPrivateKey(alias);
    }

    @Override
    public String[] getServerAliases(String keyType, Principal[] issuers) {
        return keyManager().getServerAliases(keyType, issuers);
    }

}
