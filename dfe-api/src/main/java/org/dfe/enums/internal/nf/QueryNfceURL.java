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
        protected String url() {
            return "www.sefaznet.ac.gov.br/nfce/consulta";
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
    AL {
        protected String url() {
            return "www.sefaz.al.gov.br/nfce/consulta";
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
    AP {
        protected String url() {
            return "www.sefaz.ap.gov.br/nfce/consulta";
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
            return "www.sefaz.ba.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "http://hinternet.sefaz.ba.gov.br/nfce/consulta";
        }
    },
    DF {
        protected String url() {
            return "www.fazenda.df.gov.br/nfce/consulta";
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
    ES {
        protected String url() {
            return "www.sefaz.es.gov.br/nfce/consulta";
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
    GO {
        protected String url() {
            return "www.sefaz.go.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, MA {
        protected String url() {
            return "www.sefaz.ma.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, MS {
        protected String url() {
            return "www.dfe.ms.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, MT {
        @Override
        public String production() {
            return "http://homologacao.sefaz.mt.gov.br/nfce/consultanfce";
        }

        @Override
        public String homologation() {
            return "http://www.sefaz.mt.gov.br/nfce/consultanfce";
        }
    }, MG {
        @Override
        public String production() {
            return "http://nfce.fazenda.mg.gov.br/portalnfce ";
        }

        @Override
        public String homologation() {
            return "http://hnfce.fazenda.mg.gov.br/portalnfce/";
        }
    }, PA {
        protected String url() {
            return "www.sefa.pa.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, PB {
        @Override
        public String production() {
            return "www.receita.pb.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "www.receita.pb.gov.br/nfcehom";
        }
    }, PE {
        protected String url() {
            return "nfce.sefaz.pe.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, PI {
        protected String url() {
            return "www.sefaz.pi.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, PR {
        protected String url() {
            return "www.fazenda.pr.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, RJ {
        protected String url() {
            return "www.fazenda.rj.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, RN {
        protected String url() {
            return "www.set.rn.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, RO {
        protected String url() {
            return "www.sefin.ro.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, RR {
        protected String url() {
            return "www.sefaz.rr.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, RS {
        protected String url() {
            return "www.sefaz.rs.gov.br/nfce/consulta";
        }

        @Override
        public String production() {
            return url();
        }

        @Override
        public String homologation() {
            return url();
        }
    }, SC {
        @Override
        public String production() {
            return "https://sat.sef.sc.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "https://hom.sat.sef.sc.gov.br/nfce/consulta";
        }
    }, SP {
        @Override
        public String production() {
            return "https://www.nfce.fazenda.sp.gov.br/consulta";
        }

        @Override
        public String homologation() {
            return "https://www.homologacao.nfce.fazenda.sp.gov.br/consulta";
        }
    }, SE {
        @Override
        public String production() {
            return "http://www.nfce.se.gov.br/nfce/consulta";
        }

        @Override
        public String homologation() {
            return "http://www.hom.nfe.se.gov.br/nfce/consulta";
        }
    }, TO {
        @Override
        public String production() {
            return "www.sefaz.to.gov.br/nfce/consulta";
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
