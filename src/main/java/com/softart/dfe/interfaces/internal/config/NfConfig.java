package com.softart.dfe.interfaces.internal.config;

import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;

public interface NfConfig extends Config {

    NFEmissionType emission();

    NFSend send();

    String cscId();

    String csc();
}
