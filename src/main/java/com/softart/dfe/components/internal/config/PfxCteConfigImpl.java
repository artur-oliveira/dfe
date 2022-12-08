package com.softart.dfe.components.internal.config;

import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public final class PfxCteConfigImpl extends PfxConfigImpl implements CteConfig {

    @EqualsAndHashCode.Include
    private final CteEmissionType emissionType;

    public PfxCteConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info) throws SSLContextException {
        this(uf, cnpj, environment, info, CteEmissionType.NORMAL);
    }

    public PfxCteConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, CteEmissionType emissionType) throws SSLContextException {
        super(uf, cnpj, environment, info);
        this.emissionType = emissionType;
    }

    @Override
    public CteEmissionType emission() {
        return getEmissionType();
    }
}
