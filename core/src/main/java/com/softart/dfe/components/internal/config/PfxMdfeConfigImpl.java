package com.softart.dfe.components.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public final class PfxMdfeConfigImpl extends PfxConfigImpl implements MdfeConfig {

    @EqualsAndHashCode.Include
    private final MdfeEmissionType emissionType;
    private final UF webServiceUF;

    public PfxMdfeConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info) throws SSLContextException {
        this(uf, cnpj, environment, info, MdfeEmissionType.NORMAL);
    }

    public PfxMdfeConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, MdfeEmissionType emissionType) throws SSLContextException {
        this(uf, cnpj, environment, info, emissionType, uf);
    }

    public PfxMdfeConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, MdfeEmissionType emissionType, UF webServiceUF) throws SSLContextException {
        super(uf, cnpj, environment, info);
        this.emissionType = emissionType;
        this.webServiceUF = webServiceUF;
    }

    @Override
    public MdfeEmissionType emission() {
        return getEmissionType();
    }

    @Override
    public UF webServiceUF() {
        return webServiceUF;
    }

    @Override
    @SneakyThrows
    public MdfeConfig withWebServiceUf(UF uf) {
        return new PfxMdfeConfigImpl(this.uf, cnpj, environment, info, emissionType, uf);
    }

    @Override
    @SneakyThrows
    public MdfeConfig withEnviroment(Environment environment) {
        return new PfxMdfeConfigImpl(this.uf, cnpj, environment, info, emissionType, webServiceUF);
    }
}
