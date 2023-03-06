package com.softart.dfe.components.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public final class PfxMdfeConfigImpl extends PfxConfigImpl implements MdfeConfig {

    @EqualsAndHashCode.Include
    private final MdfeEmissionType emissionType;

    public PfxMdfeConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info) throws SSLContextException {
        this(uf, cnpj, environment, info, MdfeEmissionType.NORMAL);
    }

    public PfxMdfeConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, MdfeEmissionType emissionType) throws SSLContextException {
        super(uf, cnpj, environment, info);
        this.emissionType = emissionType;
    }

    @Override
    public MdfeEmissionType emission() {
        return getEmissionType();
    }
}
