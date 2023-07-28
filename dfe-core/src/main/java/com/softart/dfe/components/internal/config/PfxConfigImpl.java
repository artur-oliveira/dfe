package com.softart.dfe.components.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.Config;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter(AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class PfxConfigImpl implements Config {

    @EqualsAndHashCode.Include
    protected final UF uf;
    @EqualsAndHashCode.Include
    protected final String cnpj;
    protected final Environment environment;
    protected final KeyStoreInfo info;

    public PfxConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info) throws SSLContextException {
        this.uf = uf;
        this.cnpj = cnpj;
        this.environment = environment;
        this.info = info;
    }

    @Override
    public UF uf() {
        return uf;
    }

    @Override
    public String cnpj() {
        return cnpj;
    }

    @Override
    public String cpf() {
        return null;
    }

    @Override
    public Environment environment() {
        return environment;
    }

    @Override
    public KeyStoreInfo info() {
        return info;
    }
}
