package com.softart.dfe.enums.internal.mdfe;

import com.softart.dfe.components.internal.mdfe.QrCodeGeneratorFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.allow.AllowUF;
import com.softart.dfe.models.internal.mdfe.MdfeQrCode;
import com.softart.dfe.models.mdfe.reception_sync.Mdfe;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;

public enum QrCodeMdfeURL implements AllowUF {
    SVRS {
        @Override
        public String production() {
            return "https://dfe-portal.svrs.rs.gov.br/mdfe/qrCode";
        }

        @Override
        public String homologation() {
            return "https://dfe-portal.svrs.rs.gov.br/mdfe/qrCode";
        }

        @Override
        public Collection<UF> allowedUfsProduction() {
            return UF.states();
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return UF.states();
        }
    };


    public static String get(UF uf, Environment environment) throws NoProviderFound {
        QrCodeMdfeURL serviceURL = Arrays.stream(QrCodeMdfeURL.values()).filter(it -> it.allow(uf, environment)).findFirst().orElseThrow(NoProviderFound::new);
        return environment.production() ? serviceURL.production() : serviceURL.homologation();
    }

    public static String generate(Mdfe mdfe) throws NoProviderFound, GeneralSecurityException {
        return QrCodeGeneratorFactory.getInstance().generate(MdfeQrCode.builder().mdfe(mdfe).build());
    }

    public abstract String production();

    public abstract String homologation();

}
