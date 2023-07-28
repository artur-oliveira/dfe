package com.softart.dfe.enums.internal.nf;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.allow.AllowUF;
import com.softart.dfe.interfaces.internal.nf.NfceURL;
import com.softart.dfe.util.ClassUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public enum NfceAuthorizer implements AllowUF, NfceURL {
    SVRS {
        public Collection<UF> ufs() {
            return Arrays.asList(UF.AC, UF.AL, UF.AP, UF.BA, UF.DF, UF.ES, UF.MA, UF.PA, UF.PB, UF.PE, UF.PI, UF.RJ, UF.RN, UF.RO, UF.RR, UF.SC, UF.SE, UF.TO);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return ufs();
        }

        @Override
        public Collection<UF> allowedUfsProduction() {
            return ufs();
        }


        @Override
        public String inutilizationNfProd() {
            return "https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String eventNfProd() {
            return "https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String eventNfHom() {
            return "https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }


        @Override
        public String queryProtocolNfProd() {
            return "https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String authorizationNfHom() {
            return "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }
    },

    AM {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singleton(UF.AM);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singleton(UF.AM);
        }

        @Override
        public String inutilizationNfProd() {
            return "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://homnfce.sefaz.am.gov.br/nfce-services/services/NfeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfce.sefaz.am.gov.br/nfce-services/services/RecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://homnfce.sefaz.am.gov.br/nfce-services/services/RecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeConsulta4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://homnfce.sefaz.am.gov.br/nfce-services/services/NfeConsulta4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://homnfce.sefaz.am.gov.br/nfce-services/services/NfeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://homnfce.sefaz.am.gov.br/nfce-services/services/NfeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://homnfce.sefaz.am.gov.br/nfce-services/services/NfeRetAutorizacao4";
        }
    },

    GO {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singleton(UF.GO);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singleton(UF.GO);
        }

        @Override
        public String inutilizationNfProd() {
            return "https://nfe.sefaz.go.gov.br/nfe/services/NFeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://homolog.sefaz.go.gov.br/nfe/services/NFeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://homolog.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.sefaz.go.gov.br/nfe/services/NFeConsultaProtocolo4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://homolog.sefaz.go.gov.br/nfe/services/NFeConsultaProtocolo4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.sefaz.go.gov.br/nfe/services/NFeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://homolog.sefaz.go.gov.br/nfe/services/NFeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.sefaz.go.gov.br/nfe/services/NFeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://homolog.sefaz.go.gov.br/nfe/services/NFeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.sefaz.go.gov.br/nfe/services/NFeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://homolog.sefaz.go.gov.br/nfe/services/NFeRetAutorizacao4";
        }
    },

    MG {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singleton(UF.MG);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singleton(UF.MG);
        }

        @Override
        public String inutilizationNfProd() {
            return "https://nfce.fazenda.mg.gov.br/nfce/services/NFeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfce.fazenda.mg.gov.br/nfce/services/NFeRecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeRecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfce.fazenda.mg.gov.br/nfce/services/NFeConsultaProtocolo4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeConsultaProtocolo4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfce.fazenda.mg.gov.br/nfce/services/NFeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfce.fazenda.mg.gov.br/nfce/services/NFeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfce.fazenda.mg.gov.br/nfce/services/NFeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeRetAutorizacao4";
        }
    },

    MS {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singleton(UF.MS);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singleton(UF.MS);
        }

        @Override
        public String inutilizationNfProd() {
            return "https://nfce.sefaz.ms.gov.br/ws/NFeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://hom.nfce.sefaz.ms.gov.br/ws/NFeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfce.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://hom.nfce.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfce.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://hom.nfce.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfce.sefaz.ms.gov.br/ws/NFeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://hom.nfce.sefaz.ms.gov.br/ws/NFeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfce.sefaz.ms.gov.br/ws/NFeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://hom.nfce.sefaz.ms.gov.br/ws/NFeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfce.sefaz.ms.gov.br/ws/NFeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://hom.nfce.sefaz.ms.gov.br/ws/NFeRetAutorizacao4";
        }
    },

    MT {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singleton(UF.MT);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singleton(UF.MT);
        }

        @Override
        public String inutilizationNfProd() {
            return "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfce.sefaz.mt.gov.br/nfcews/services/RecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfcews/services/RecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeConsulta4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeConsulta4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeRetAutorizacao4";
        }
    },

    PR {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singleton(UF.PR);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singleton(UF.PR);
        }

        @Override
        public String inutilizationNfProd() {
            return "https://nfce.sefa.pr.gov.br/nfce/NFeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfce.sefa.pr.gov.br/nfce/NFeRecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeRecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfce.sefa.pr.gov.br/nfce/NFeConsultaProtocolo4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeConsultaProtocolo4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfce.sefa.pr.gov.br/nfce/NFeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfce.sefa.pr.gov.br/nfce/NFeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfce.sefa.pr.gov.br/nfce/NFeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeRetAutorizacao4";
        }
    },

    RS {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singleton(UF.RS);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singleton(UF.RS);
        }

        @Override
        public String inutilizationNfProd() {
            return "https://nfce.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://nfce-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String eventNfProd() {
            return "https://nfce.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String eventNfHom() {
            return "https://nfce-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfce.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfce.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfce.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String authorizationNfHom() {
            return "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfce.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }
    },

    SP {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singleton(UF.SP);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singleton(UF.SP);
        }

        @Override
        public String inutilizationNfProd() {
            return "https://nfce.fazenda.sp.gov.br/ws/NFeInutilizacao4.asmx";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeInutilizacao4.asmx";
        }

        @Override
        public String eventNfProd() {
            return "https://nfce.fazenda.sp.gov.br/ws/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfHom() {
            return "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfce.fazenda.sp.gov.br/ws/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfce.fazenda.sp.gov.br/ws/NFeStatusServico4.asmx";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeStatusServico4.asmx";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfce.fazenda.sp.gov.br/ws/NFeAutorizacao4.asmx";
        }

        @Override
        public String authorizationNfHom() {
            return "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfce.fazenda.sp.gov.br/ws/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeRetAutorizacao4.asmx";
        }
    };

    public static Collection<String> get(UF uf, Environment environment) throws NoProviderFound {
        NfceAuthorizer serviceURL = Arrays.stream(NfceAuthorizer.values()).filter(it -> it.allow(uf, environment)).findFirst().orElseThrow(NoProviderFound::new);

        return environment.production() ? serviceURL.prod() : serviceURL.hom();
    }

    public Collection<String> hom() {
        return Arrays.stream(this.getClass().getDeclaredMethods()).filter(it -> it.getName().toLowerCase().endsWith("hom")).map(it -> ClassUtils.get(it, this)).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.toSet());
    }

    public Collection<String> prod() {
        return Arrays.stream(this.getClass().getDeclaredMethods()).filter(it -> it.getName().toLowerCase().endsWith("prod")).map(it -> ClassUtils.get(it, this)).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.toSet());
    }

}
