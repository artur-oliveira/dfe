package com.softart.dferestapi.components.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;

public class NoOpMdfeConfig implements MdfeConfig {
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
    public MdfeEmissionType emission() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public MdfeConfig withWebServiceUf(UF uf) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public UF webServiceUF() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public MdfeConfig withEnviroment(Environment environment) {
        throw new UnsupportedOperationException("not implemented");
    }
}
