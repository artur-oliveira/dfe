package com.softart.dfe.components.internal.config;

import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Objects;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public final class PfxCteConfigImpl extends PfxConfigImpl implements CteConfig {

    private final UF webServiceUF;
    @EqualsAndHashCode.Include
    private final CteEmissionType emissionType;

    public PfxCteConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info) throws SSLContextException {
        this(uf, cnpj, environment, info, CteEmissionType.NORMAL);
    }

    public PfxCteConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, CteEmissionType emissionType) throws SSLContextException {
        this(uf, cnpj, environment, info, emissionType, uf);
    }

    public PfxCteConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, CteEmissionType emissionType, UF webServiceUF) throws SSLContextException {
        super(uf, cnpj, environment, info);
        this.emissionType = emissionType;
        this.webServiceUF = webServiceUF;
    }

    @Override
    public CteEmissionType emission() {
        return getEmissionType();
    }

    @Override
    @SneakyThrows
    public CteConfig withEmissionType(CteEmissionType emissionType) {
        return Objects.equals(emissionType, this.emissionType) ? this : new PfxCteConfigImpl(uf, cnpj, environment, info, emissionType, webServiceUF);
    }

    @Override
    public UF webServiceUF() {
        return webServiceUF;
    }

    @Override
    @SneakyThrows
    public CteConfig withWebServiceUf(UF uf) {
        return Objects.equals(uf, this.webServiceUF) ? this : new PfxCteConfigImpl(this.uf, cnpj, environment, info, emissionType, uf);
    }

    @Override
    @SneakyThrows
    public CteConfig withEnviroment(Environment environment) {
        return Objects.equals(environment, this.environment) ? this : new PfxCteConfigImpl(this.uf, cnpj, environment, info, emissionType, webServiceUF);
    }
}
