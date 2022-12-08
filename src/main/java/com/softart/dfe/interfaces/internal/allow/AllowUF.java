package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;

import java.util.Collection;
import java.util.Objects;

public interface AllowUF {

    Collection<UF> allowedUfsProduction();

    Collection<UF> allowedUfsHomologation();

    default boolean allow(UF uf, Environment environment) {
        return Objects.equals(environment, Environment.PRODUCTION) ? allowedUfsProduction().contains(uf) : allowedUfsHomologation().contains(uf);
    }
}
