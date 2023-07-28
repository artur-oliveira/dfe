package com.softart.dfe.components.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public final class PfxNfceConfigImpl extends PfxConfigImpl implements NfceConfig {
    @EqualsAndHashCode.Include
    private final NFEmissionType emissionType;
    private final NFSend send;
    private final String cscId;
    private final String csc;
    private final UF webServiceUF;

    public PfxNfceConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info) throws SSLContextException {
        this(uf, cnpj, environment, info, NFEmissionType.NORMAL, null, null);
    }

    public PfxNfceConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, NFEmissionType emissionType, String cscId, String csc) throws SSLContextException {
        this(uf, cnpj, environment, info, emissionType, NFSend.SYNC, cscId, csc);
    }

    public PfxNfceConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, NFEmissionType emissionType, NFSend send, String cscId, String csc) throws SSLContextException {
        this(uf, cnpj, environment, info, emissionType, send, cscId, csc, uf);
    }

    public PfxNfceConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, NFEmissionType emissionType, NFSend send, String cscId, String csc, UF webServiceUF) throws SSLContextException {
        super(uf, cnpj, environment, info);
        this.emissionType = emissionType;
        this.send = send;
        this.cscId = cscId;
        this.csc = csc;
        this.webServiceUF = webServiceUF;
    }

    @Override
    public NFSend send() {
        return send;
    }

    @Override
    public NFEmissionType emission() {
        return emissionType;
    }

    @Override
    public String cscId() {
        return cscId;
    }

    @Override
    public String csc() {
        return csc;
    }

    @Override
    public UF webServiceUF() {
        return webServiceUF;
    }

    @Override
    @SneakyThrows
    public NfceConfig withWebServiceUf(UF uf) {
        return new PfxNfceConfigImpl(this.uf, cnpj, environment, info, emissionType, send, cscId, csc, uf);
    }

    @Override
    @SneakyThrows
    public NfceConfig withEnviroment(Environment environment) {
        return new PfxNfceConfigImpl(this.uf, cnpj, environment, info, emissionType, send, cscId, csc, webServiceUF);
    }
}
