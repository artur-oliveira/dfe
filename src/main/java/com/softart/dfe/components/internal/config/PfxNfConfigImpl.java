package com.softart.dfe.components.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public final class PfxNfConfigImpl extends PfxConfigImpl implements NfConfig {
    @EqualsAndHashCode.Include
    private final NFEmissionType emissionType;
    private final NFSend send;
    private final String cscId;
    private final String csc;

    public PfxNfConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info) throws SSLContextException {
        this(uf, cnpj, environment, info, NFEmissionType.NORMAL, null, null);
    }

    public PfxNfConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, NFEmissionType emissionType, String cscId, String csc) throws SSLContextException {
        this(uf, cnpj, environment, info, emissionType, NFSend.SYNC, cscId, csc);
    }

    public PfxNfConfigImpl(UF uf, String cnpj, Environment environment, KeyStoreInfo info, NFEmissionType emissionType, NFSend send, String cscId, String csc) throws SSLContextException {
        super(uf, cnpj, environment, info);
        this.emissionType = emissionType;
        this.send = send;
        this.cscId = cscId;
        this.csc = csc;
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
    public String cscId() {
        return cscId;
    }

    @Override
    public String csc() {
        return csc;
    }
}
