package com.softart.dferestapi.components.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.NfeConfig;

public final class NoOpNfeConfig implements NfeConfig {
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
    public NFEmissionType emission() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public NFSend send() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public NfeConfig withWebServiceUf(UF uf) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public UF webServiceUF() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public NfeConfig withEnviroment(Environment environment) {
        throw new UnsupportedOperationException("not implemented");
    }
}
