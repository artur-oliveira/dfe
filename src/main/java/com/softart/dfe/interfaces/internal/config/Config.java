package com.softart.dfe.interfaces.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;

public interface Config {

    UF uf();

    String cnpj();

    String cpf();

    Environment environment();

    default boolean production() {
        return environment().production();
    }

    KeyStoreInfo info();

}
