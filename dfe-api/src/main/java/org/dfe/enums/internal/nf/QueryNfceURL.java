package org.dfe.enums.internal.nf;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.allow.AllowUF;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("unused")
public enum QueryNfceURL implements AllowUF {

    AC {
        @Override
        public String production() {
            return "www.sefaznet.ac.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "http://hml.sefaznet.ac.gov.br/nfce/consulta";
        }
    },
    AL {
        @Override
        public String production() {
            return "http://nfce.sefaz.al.gov.br/consultaNFCe.htm";
        }

        @Override
        public String homologation() {
            return "http://nfce.sefaz.al.gov.br/consultaNFCe.htm";
        }
    },
    AP {
        @Override
        public String production() {
            return "https://www.sefaz.ap.gov.br/sate/seg/SEGf_AcessarFuncao.jsp?cdFuncao=FIS_1261";
        }

        @Override
        public String homologation() {
            return "https://www.sefaz.ap.gov.br/sate1/seg/SEGf_AcessarFuncao.jsp?cdFuncao=FIS_1261";
        }
    },
    AM {
        protected String url() {
            return "www.sefaz.am.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    },
    BA {
        @Override
        public String production() {
            return "nfe.sefaz.ba.gov.br/servicos/nfce/default.aspx";
        }

        @Override
        public String homologation() {
            return "http://hnfe.sefaz.ba.gov.br/servicos/nfce/default.aspx";
        }
    },
    CE {
        @Override
        public String production() {
            return "http://nfceh.sefaz.ce.gov.br/pages/consultaNota.jsf";
        }

        @Override
        public String homologation() {
            return "http://nfce.sefaz.ce.gov.br/pages/consultaNota.jsf";
        }
    },
    DF {
        @Override
        public String production() {
            return "http://dec.fazenda.df.gov.br/NFCE/";
        }

        @Override
        public String homologation() {
            return "http://dec.fazenda.df.gov.br/NFCE/";
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
    ES {
        @Override
        public String production() {
            return "http://app.sefaz.es.gov.br/ConsultaNFCe";
        }

        @Override
        public String homologation() {
            return "www.sefaz.es.gov.br/nfce/consulta";
        }
    },
    MA {
        @Override
        public String production() {
            return "http://www.sefaz.ma.gov.br/nfce/consulta/";
        }

        @Override
        public String homologation() {
            return "http://www.hom.nfce.sefaz.ma.gov.br/portal/consultarNFCe.jsp";
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
            return "http://www.dfe.ms.gov.br/nfce";
        }

        @Override
        public String homologation() {
            return "http://www.dfe.ms.gov.br/nfce";
        }
    },
    MG {
        @Override
        public String production() {
            return "https://portalsped.fazenda.mg.gov.br/portalnfce";
        }

        @Override
        public String homologation() {
            return "https://hportalsped.fazenda.mg.gov.br/portalnfce";
        }
    },
    PA {
        @Override
        public String production() {
            return "https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/consultanfce.seam";
        }

        @Override
        public String homologation() {
            return "https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/consultanfce.seam";
        }
    },
    PB {
        @Override
        public String production() {
            return "www.receita.pb.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "www.receita.pb.gov.br/nfcehom";
        }
    },
    PR {
        @Override
        public String production() {
            return "http://www.fazenda.pr.gov.br";
        }

        @Override
        public String homologation() {
            return "http://www.fazenda.pr.gov.br";
        }
    },
    PE {
        @Override
        public String production() {
            return "nfce.sefaz.pe.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "nfce.sefaz.pe.gov.br/nfce/consulta";
        }
    },
    PI {
        @Override
        public String production() {
            return "http://www.sefaz.pi.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "http://www.sefaz.pi.gov.br/nfce/consulta";
        }
    },
    RJ {
        @Override
        public String production() {
            return "www.fazenda.rj.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "www.fazenda.rj.gov.br/nfce/consulta";
        }
    },
    RN {
        @Override
        public String production() {
            return "http://nfce.set.rn.gov.br/consultarNFCe.aspx";
        }

        @Override
        public String homologation() {
            return "http://nfce.set.rn.gov.br/consultarNFCe.aspx";
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
            return "http://www.nfce.sefin.ro.gov.br";
        }

        @Override
        public String homologation() {
            return "http://www.nfce.sefin.ro.gov.br";
        }
    },
    RR {
        @Override
        public String production() {
            return "https://www.sefaz.rr.gov.br/nfce/servlet/wp_consulta_nfce";
        }

        @Override
        public String homologation() {
            return "http://200.174.88.103:8080/nfce/servlet/wp_consulta_nfce";
        }
    },
    SP {
        @Override
        public String production() {
            return "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica";
        }

        @Override
        public String homologation() {
            return "https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica";
        }
    },
    SC {
        @Override
        public String production() {
            return " https://sat.sef.sc.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "https://hom.sat.sef.sc.gov.br/nfce/consulta";
        }
    },
    SE {
        @Override
        public String production() {
            return "http://www.nfce.se.gov.br/portal/portalNoticias.jsp";
        }

        @Override
        public String homologation() {
            return "http://www.hom.nfe.se.gov.br/portal/portalNoticias.jsp";
        }
    },
    TO {
        @Override
        public String production() {
            return "http://www.sefaz.to.gov.br/nfce/consulta.jsf";
        }

        @Override
        public String homologation() {
            return "http://homologacao.sefaz.to.gov.br/nfce/consulta.jsf";
        }
    },
    ;

    public static String get(UF uf, Environment environment) throws NoProviderFound {
        QueryNfceURL url = Arrays.stream(QueryNfceURL.values()).filter(it -> it.allow(uf, environment)).findFirst().orElseThrow(NoProviderFound::new);

        return environment.production() ? url.production() : url.homologation();
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
