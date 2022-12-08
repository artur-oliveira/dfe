package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.identification.NFEmissionType;

public interface NfServiceAllow extends AllowUF {

    boolean allow(UF uf, Environment environment, NFEmissionType emissionType);

}
