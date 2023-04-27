package com.softart.dferestapi.components.config;

import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.CteConfig;

public final class NoOpCteConfig implements CteConfig {

    @Override
    public UF uf() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public String cnpj() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public String cpf() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public Environment environment() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public KeyStoreInfo info() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public CteEmissionType emission() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public CteConfig withEmissionType(CteEmissionType emissionType) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public CteConfig withWebServiceUf(UF uf) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public UF webServiceUF() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public CteConfig withEnviroment(Environment environment) {
        throw new UnsupportedOperationException("not implemented");
    }
}
