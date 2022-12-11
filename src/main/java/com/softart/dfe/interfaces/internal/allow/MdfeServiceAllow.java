package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;

public interface MdfeServiceAllow extends AllowUF {

    boolean allow(UF uf, Environment environment, MdfeEmissionType emissionType);

}
