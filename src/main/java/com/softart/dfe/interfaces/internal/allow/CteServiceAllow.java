package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;

public interface CteServiceAllow extends AllowUF {

    boolean allow(UF uf, Environment environment, CteEmissionType emissionType);

}
