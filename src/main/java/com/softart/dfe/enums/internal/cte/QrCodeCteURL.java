package com.softart.dfe.enums.internal.cte;

import com.softart.dfe.components.internal.cte.QrCodeGeneratorFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.allow.AllowUF;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.models.cte.reception.Cte;
import com.softart.dfe.models.internal.cte.CteQrCode;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("unused")
public enum QrCodeCteURL implements AllowUF {
    MG {
        @Override
        public String production() {
            return "https://cte.fazenda.mg.gov.br/portalcte/sistema/qrcode.xhtml";
        }

        @Override
        public String homologation() {
            return "https://cte.fazenda.mg.gov.br/portalcte/sistema/qrcode.xhtml";
        }
    },
    MS {
        @Override
        public String production() {
            return "https://www.dfe.ms.gov.br/cte/qrcode";
        }

        @Override
        public String homologation() {
            return "https://www.dfe.ms.gov.br/cte/qrcode";
        }
    },
    MT {
        @Override
        public String production() {
            return "https://www.sefaz.mt.gov.br/cte/qrcode";
        }

        @Override
        public String homologation() {
            return "https://homologacao.sefaz.mt.gov.br/cte/qrcode";
        }
    },
    PR {
        @Override
        public String production() {
            return "https://www.fazenda.pr.gov.br/cte/qrcode";
        }

        @Override
        public String homologation() {
            return "https://www.fazenda.pr.gov.br/cte/qrcode";
        }
    },
    SP {
        @Override
        public String production() {
            return "https://nfe.fazenda.sp.gov.br/CTeConsulta/qrCode";
        }

        @Override
        public String homologation() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/CTeConsulta/qrCode";
        }
    },
    SVRS {
        @Override
        public String production() {
            return "https://dfe-portal.svrs.rs.gov.br/cte/qrCode";
        }

        @Override
        public String homologation() {
            return "https://dfe-portal.svrs.rs.gov.br/cte/qrCode";
        }
    },
    ;

    public static String get(UF uf, Environment environment) throws NoProviderFound {
        QrCodeCteURL serviceURL = Arrays.stream(QrCodeCteURL.values()).filter(it -> it.allow(uf, environment)).findFirst().orElseThrow(NoProviderFound::new);
        return environment.production() ? serviceURL.production() : serviceURL.homologation();
    }

    public static String generate(Cte cte) throws NoProviderFound, GeneralSecurityException {
        return QrCodeGeneratorFactory.getInstance().generate(CteQrCode.builder().cte(cte).build());
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return Collections.singletonList(UF.valueOf(name()));
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return Collections.singletonList(UF.valueOf(name()));
    }

    public abstract String production();

    public abstract String homologation();

}
