package com.softart.dfe.models.internal.security;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.interfaces.security.CertificateChain;
import lombok.Builder;

import java.util.Objects;


/**
 * `Certificate` is a `CertificateChain` that is a `JKS` file
 */
@Builder
public record Certificate(
        UF uf,
        Environment environment,
        Model model
) implements CertificateChain {


    @Override
    public String fileName() {
        return hashCode() + ".jks";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Certificate that)) return false;
        return uf == that.uf && environment == that.environment && model == that.model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uf, environment, model);
    }
}
