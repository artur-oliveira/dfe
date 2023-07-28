package com.softart.dfe.enums.internal.nf;

import com.softart.dfe.components.internal.nfe.QrCodeGeneratorFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.security.XMLSignException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.allow.AllowUF;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.models.internal.nf.NfQrCode;
import com.softart.dfe.models.nf.authorization.Nf;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("unused")
public enum QrCodeNfceURL implements AllowUF {
    AC {
        @Override
        public String production() {
            return "http://www.sefaznet.ac.gov.br/nfce/qrcode";
        }

        @Override
        public String homologation() {
            return "http://www.hml.sefaznet.ac.gov.br/nfce/qrcode";
        }
    },
    AL {
        @Override
        public String production() {
            return "http://nfce.sefaz.al.gov.br/QRCode/consultarNFCe.jsp";
        }

        @Override
        public String homologation() {
            return "http://nfce.sefaz.al.gov.br/QRCode/consultarNFCe.jsp";
        }
    },
    AP {
        @Override
        public String production() {
            return "https://www.sefaz.ap.gov.br/nfce/nfcep.php";
        }

        @Override
        public String homologation() {
            return "https://www.sefaz.ap.gov.br/nfcehml/nfce.php";
        }
    },
    AM {
        @Override
        public String production() {
            return "https://sistemas.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp";
        }

        @Override
        public String homologation() {
            return "https://sistemas.sefaz.am.gov.br/nfceweb-hom/consultarNFCe.jsp";
        }
    },
    BA {
        @Override
        public String production() {
            return "http://nfe.sefaz.ba.gov.br/servicos/nfce/qrcode.aspx";
        }

        @Override
        public String homologation() {
            return "http://hnfe.sefaz.ba.gov.br/servicos/nfce/qrcode.aspx";
        }
    },
    DF {
        @Override
        public String production() {
            return "http://www.fazenda.df.gov.br/nfce/qrcode";
        }

        @Override
        public String homologation() {
            return "http://www.fazenda.df.gov.br/nfce/qrcode";
        }
    },
    ES {
        @Override
        public String production() {
            return "http://app.sefaz.es.gov.br/ConsultaNFCe/";
        }

        @Override
        public String homologation() {
            return "http://homologacao.sefaz.es.gov.br/ConsultaNFCe";
        }
    },
    GO {
        @Override
        public String production() {
            return "http://nfe.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe";
        }

        @Override
        public String homologation() {
            return "http://homolog.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe";
        }
    },
    MA {
        @Override
        public String production() {
            return "nfce.sefaz.ma.gov.br/portal/consultarNFCe.jsp";
        }

        @Override
        public String homologation() {
            return "homologacao.sefaz.ma.gov.br/portal/consultarNFCe.jsp";
        }
    },
    MT {
        @Override
        public String production() {
            return "http://www.sefaz.mt.gov.br/nfce/consultanfce";
        }

        @Override
        public String homologation() {
            return "http://homologacao.sefaz.mt.gov.br/nfce/consultanfce";
        }
    },
    MS {
        @Override
        public String production() {
            return "http://www.dfe.ms.gov.br/nfce/qrcode";
        }

        @Override
        public String homologation() {
            return "http://www.dfe.ms.gov.br/nfce/qrcode";
        }
    },
    MG {
        @Override
        public String production() {
            return "https://portalsped.fazenda.mg.gov.br/portalnfce/sistema/qrcode.xhtml";
        }

        @Override
        public String homologation() {
            return "https://portalsped.fazenda.mg.gov.br/portalnfce/sistema/qrcode.xhtml";
        }
    },
    PA {
        @Override
        public String production() {
            return "https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/nfceForm.seam";
        }

        @Override
        public String homologation() {
            return "https://appnfc.sefa.pa.gov.br/portal-homologacao/view/consultas/nfce/nfceForm.seam";
        }
    },
    PB {
        @Override
        public String production() {
            return "http://www.sefaz.pb.gov.br/nfce";
        }

        @Override
        public String homologation() {
            return "http://www.sefaz.pb.gov.br/nfcehom";
        }
    },
    PR {
        @Override
        public String production() {
            return "http://www.fazenda.pr.gov.br/nfce/qrcode";
        }

        @Override
        public String homologation() {
            return "http://www.fazenda.pr.gov.br/nfce/qrcode";
        }
    },
    PE {
        @Override
        public String production() {
            return "http://nfce.sefaz.pe.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "http://nfcehomolog.sefaz.pe.gov.br/nfce/consulta";
        }
    },
    PI {
        @Override
        public String production() {
            return "http://www.sefaz.pi.gov.br/nfce/qrcode";
        }

        @Override
        public String homologation() {
            return "http://www.sefaz.pi.gov.br/nfce/qrcode";
        }
    },
    RJ {
        @Override
        public String production() {
            return "http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode";
        }

        @Override
        public String homologation() {
            return "http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode";
        }
    },
    RN {
        @Override
        public String production() {
            return "http://nfce.set.rn.gov.br/consultarNFCe.aspx";
        }

        @Override
        public String homologation() {
            return "http://hom.nfce.set.rn.gov.br/consultarNFCe.aspx";
        }
    },
    RS {
        @Override
        public String production() {
            return "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx";
        }

        @Override
        public String homologation() {
            return "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx";
        }
    },
    RO {
        @Override
        public String production() {
            return "http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp";
        }

        @Override
        public String homologation() {
            return "http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp";
        }
    },
    RR {
        @Override
        public String production() {
            return "https://www.sefaz.rr.gov.br/nfce/servlet/qrcode";
        }

        @Override
        public String homologation() {
            return "http://200.174.88.103:8080/nfce/servlet/qrcode";
        }
    },
    SC {
        @Override
        public String production() {
            return "https://sat.sef.sc.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "https://hom.sat.sef.sc.gov.br/nfce/consulta";
        }
    },
    SP {
        @Override
        public String production() {
            return "https://www.nfce.fazenda.sp.gov.br/qrcode";
        }

        @Override
        public String homologation() {
            return "https://www.homologacao.nfce.fazenda.sp.gov.br/qrcode";
        }
    },
    SE {
        @Override
        public String production() {
            return "http://www.nfce.se.gov.br/nfce/qrcode";
        }

        @Override
        public String homologation() {
            return "http://www.hom.nfe.se.gov.br/nfce/qrcode";
        }
    },
    TO {
        @Override
        public String production() {
            return "http://www.sefaz.to.gov.br/nfce/qrcode";
        }

        @Override
        public String homologation() {
            return "http://homologacao.sefaz.to.gov.br/nfce/qrcode";
        }
    },
    ;

    public static String get(UF uf, Environment environment) throws NoProviderFound {
        QrCodeNfceURL serviceURL = Arrays.stream(QrCodeNfceURL.values()).filter(it -> it.allow(uf, environment)).findFirst().orElseThrow(NoProviderFound::new);

        return environment.production() ? serviceURL.production() : serviceURL.homologation();
    }

    public static String generate(Nf nf, NfceConfig config, XMLSignerService xmlSigner) throws NoProviderFound, GeneralSecurityException, XMLSignException {
        return QrCodeGeneratorFactory.getInstance().generate(NfQrCode.builder().nf(nf).config(config).xmlSigner(xmlSigner).build());
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
