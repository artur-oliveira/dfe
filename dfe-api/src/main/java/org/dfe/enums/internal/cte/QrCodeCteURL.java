package org.dfe.enums.internal.cte;

import org.dfe.components.internal.cte.QrCodeGeneratorFactory;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.allow.AllowUF;
import org.dfe.models.internal.cte.Cte4QrCode;
import org.dfe.models.internal.cte.CteOs4QrCode;
import org.dfe.models.internal.cte.Gtve4QrCode;

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
    SVSP {
        @Override
        public String production() {
            return "https://nfe.fazenda.sp.gov.br/CTeConsulta/qrCode";
        }

        @Override
        public String homologation() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/CTeConsulta/qrCode";
        }

        Collection<UF> ufs() {
            return Arrays.asList(UF.AP, UF.PE, UF.RR, UF.SP);
        }

        @Override
        public Collection<UF> allowedUfsProduction() {
            return ufs();
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return ufs();
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

        Collection<UF> ufs() {
            return Arrays.asList(UF.AC, UF.AL, UF.AM, UF.BA, UF.CE, UF.DF, UF.ES, UF.GO, UF.MA, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RS, UF.RO, UF.SC, UF.SE, UF.TO);
        }

        @Override
        public Collection<UF> allowedUfsProduction() {
            return ufs();
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return ufs();
        }
    },
    ;

    public static String get(UF uf, Environment environment) throws NoProviderFound {
        QrCodeCteURL serviceURL = Arrays.stream(QrCodeCteURL.values()).filter(it -> it.allow(uf, environment)).findFirst().orElseThrow(NoProviderFound::new);
        return environment.production() ? serviceURL.production() : serviceURL.homologation();
    }

    public static String generate(org.dfe.models.cte4.reception_sync.Cte cte) throws NoProviderFound {
        return QrCodeGeneratorFactory.getInstance().generate(Cte4QrCode.builder().cte(cte).build());
    }

    public static String generate(org.dfe.models.cte4.reception_gtve.Gtve gtve) throws NoProviderFound {
        return QrCodeGeneratorFactory.getInstance().generate(Gtve4QrCode.builder().gtve(gtve).build());
    }

    public static String generate(org.dfe.models.cte4.reception_os.CteOs cteOs) throws NoProviderFound {
        return QrCodeGeneratorFactory.getInstance().generate(CteOs4QrCode.builder().cteOs(cteOs).build());
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
