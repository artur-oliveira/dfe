package com.softart.dfe.components.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public final class PfxNfeConfigImpl extends PfxConfigImpl implements NfeConfig {
    @EqualsAndHashCode.Include
    private final NFEmissionType emissionType;
    private final NFSend send;
    private final UF webServiceUF;

    public PfxNfeConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info) throws SSLContextException {
        this(uf, cnpj, environment, info, NFEmissionType.NORMAL);
    }

    public PfxNfeConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, NFEmissionType emissionType) throws SSLContextException {
        this(uf, cnpj, environment, info, emissionType, NFSend.SYNC);
    }

    public PfxNfeConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, NFEmissionType emissionType, NFSend send) throws SSLContextException {
        this(uf, cnpj, environment, info, emissionType, send, uf);
    }

    public PfxNfeConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, NFEmissionType emissionType, NFSend send, UF webServiceUF) throws SSLContextException {
        super(uf, cnpj, environment, info);
        this.emissionType = emissionType;
        this.send = send;
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
    public UF webServiceUF() {
        return webServiceUF;
    }

    @Override
    @SneakyThrows
    public NfeConfig withWebServiceUf(UF uf) {
        return new PfxNfeConfigImpl(this.uf, cnpj, environment, info, emissionType, send, uf);
    }

    @Override
    @SneakyThrows
    public NfeConfig withEnviroment(Environment environment) {
        return new PfxNfeConfigImpl(this.uf, cnpj, environment, info, emissionType, send, webServiceUF);
    }
}
