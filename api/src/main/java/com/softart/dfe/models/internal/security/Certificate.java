package com.softart.dfe.models.internal.security;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.interfaces.security.CertificateChain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * `Certificate` is a `CertificateChain` that is a `JKS` file
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public final class Certificate implements CertificateChain {

    private UF uf;
    private Environment environment;
    private Model model;

    @Override
    public String fileName() {
        return hashCode() + ".jks";
    }
}
