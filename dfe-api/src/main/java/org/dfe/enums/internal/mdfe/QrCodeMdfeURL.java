package org.dfe.enums.internal.mdfe;

import org.dfe.components.internal.mdfe.QrCodeGeneratorFactory;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.security.XMLSignException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.allow.AllowUF;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.internal.mdfe.MdfeQrCode;
import org.dfe.models.mdfe.reception_sync.Mdfe;

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

    public static String generate(Mdfe mdfe, MdfeConfig config, XMLSignerService xmlSignerService) throws NoProviderFound, XMLSignException {
        return QrCodeGeneratorFactory.getInstance().generate(MdfeQrCode.builder().mdfe(mdfe).config(config).xmlSigner(xmlSignerService).build());
    }

    public abstract String production();

    public abstract String homologation();

}
