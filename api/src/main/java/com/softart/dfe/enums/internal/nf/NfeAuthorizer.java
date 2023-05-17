package com.softart.dfe.enums.internal.nf;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.allow.NfServiceAllow;
import com.softart.dfe.interfaces.internal.nf.NfeURL;
import com.softart.dfe.util.ClassUtils;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public enum NfeAuthorizer implements NfServiceAllow, NfeURL {

    AN {
        @Override
        public String inutilizationNfProd() {
            return null;
        }

        @Override
        public String inutilizationNfHom() {
            return null;
        }

        @Override
        public String eventNfProd() {
            return null;
        }

        @Override
        public String eventNfHom() {
            return null;
        }

        @Override
        public String queryProtocolNfProd() {
            return null;
        }

        @Override
        public String queryProtocolNfHom() {
            return null;
        }

        @Override
        public String statusServiceNfProd() {
            return null;
        }

        @Override
        public String statusServiceNfHom() {
            return null;
        }

        @Override
        public String authorizationNfProd() {
            return null;
        }

        @Override
        public String authorizationNfHom() {
            return null;
        }

        @Override
        public String returnAuthorizationNfProd() {
            return null;
        }

        @Override
        public String returnAuthorizationNfHom() {
            return null;
        }


        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public Collection<UF> allowedUfsProduction() {
            return UF.states();
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return UF.states();
        }


        @Override
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return true;
        }

        @Override
        public String queryRegisterHom() {
            return null;
        }

        @Override
        public String queryRegisterProd() {
            return null;
        }
    },


    SVRS {
        public Collection<UF> ufs() {
            return Arrays.asList(UF.AC, UF.AL, UF.AP, UF.CE, UF.DF, UF.ES, UF.PB, UF.PI, UF.PA, UF.RJ, UF.RN, UF.RO, UF.RR, UF.SC, UF.SE, UF.TO);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return ufs();
        }


        @Override
        public String queryRegisterHom() {
            return "https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx";
        }

        @Override
        public String queryRegisterProd() {
            return "https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx";
        }

        @Override
        public Collection<UF> allowedUfsProduction() {
            return ufs();
        }

        @Override
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String inutilizationNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String eventNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String authorizationNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
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
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return null;
        }

        @Override
        public String queryRegisterProd() {
            return null;
        }


        @Override
        public String inutilizationNfProd() {
            return "https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://homnfe.sefaz.am.gov.br/services2/services/NfeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.sefaz.am.gov.br/services2/services/RecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://homnfe.sefaz.am.gov.br/services2/services/RecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.sefaz.am.gov.br/services2/services/NfeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://homnfe.sefaz.am.gov.br/services2/services/NfeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.sefaz.am.gov.br/services2/services/NfeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://homnfe.sefaz.am.gov.br/services2/services/NfeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://homnfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao4";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }
    },

    BA {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singleton(UF.BA);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singleton(UF.BA);
        }

        @Override
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return "https://hnfe.sefaz.ba.gov.br/webservices/CadConsultaCadastro4/CadConsultaCadastro4.asmx";
        }

        @Override
        public String queryRegisterProd() {
            return "https://nfe.sefaz.ba.gov.br/webservices/CadConsultaCadastro4/CadConsultaCadastro4.asmx";
        }


        @Override
        public String inutilizationNfProd() {
            return "https://nfe.sefaz.ba.gov.br/webservices/NFeInutilizacao4/NFeInutilizacao4.asmx";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://hnfe.sefaz.ba.gov.br/webservices/NFeInutilizacao4/NFeInutilizacao4.asmx";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.sefaz.ba.gov.br/webservices/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfHom() {
            return "https://hnfe.sefaz.ba.gov.br/webservices/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.sefaz.ba.gov.br/webservices/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://hnfe.sefaz.ba.gov.br/webservices/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.sefaz.ba.gov.br/webservices/NFeStatusServico4/NFeStatusServico4.asmx";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://hnfe.sefaz.ba.gov.br/webservices/NFeStatusServico4/NFeStatusServico4.asmx";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.sefaz.ba.gov.br/webservices/NFeAutorizacao4/NFeAutorizacao4.asmx";
        }

        @Override
        public String authorizationNfHom() {
            return "https://hnfe.sefaz.ba.gov.br/webservices/NFeAutorizacao4/NFeAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.sefaz.ba.gov.br/webservices/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://hnfe.sefaz.ba.gov.br/webservices/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
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
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return "https://homolog.sefaz.go.gov.br/nfe/services/CadConsultaCadastro4";
        }

        @Override
        public String queryRegisterProd() {
            return "https://nfe.sefaz.go.gov.br/nfe/services/CadConsultaCadastro4";
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

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
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
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return "https://hnfe.fazenda.mg.gov.br/nfe2/services/CadConsultaCadastro4";
        }

        @Override
        public String queryRegisterProd() {
            return "https://nfe.fazenda.mg.gov.br/nfe2/services/CadConsultaCadastro4";
        }


        @Override
        public String inutilizationNfProd() {
            return "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeRecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeRecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeConsultaProtocolo4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeConsultaProtocolo4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeRetAutorizacao4";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
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
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return "https://hom.nfe.sefaz.ms.gov.br/ws/CadConsultaCadastro4";
        }

        @Override
        public String queryRegisterProd() {
            return "https://nfe.sefaz.ms.gov.br/ws/CadConsultaCadastro4";
        }


        @Override
        public String inutilizationNfProd() {
            return "https://nfe.sefaz.ms.gov.br/ws/NFeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://hom.nfe.sefaz.ms.gov.br/ws/NFeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://hom.nfe.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://hom.nfe.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.sefaz.ms.gov.br/ws/NFeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://hom.nfe.sefaz.ms.gov.br/ws/NFeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.sefaz.ms.gov.br/ws/NFeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://hom.nfe.sefaz.ms.gov.br/ws/NFeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.sefaz.ms.gov.br/ws/NFeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://hom.nfe.sefaz.ms.gov.br/ws/NFeRetAutorizacao4";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
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
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro4";
        }

        @Override
        public String queryRegisterProd() {
            return "https://nfe.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro4";
        }


        @Override
        public String inutilizationNfProd() {
            return "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao4";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }
    },


    PE {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singleton(UF.PE);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singleton(UF.PE);
        }

        @Override
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro4";
        }

        @Override
        public String queryRegisterProd() {
            return "https://nfe.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro4";
        }


        @Override
        public String inutilizationNfProd() {
            return "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeRecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeRecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeConsultaProtocolo4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeConsultaProtocolo4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeRetAutorizacao4";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
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
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return "https://homologacao.nfe.sefa.pr.gov.br/nfe/CadConsultaCadastro4";
        }

        @Override
        public String queryRegisterProd() {
            return "https://nfe.sefa.pr.gov.br/nfe/CadConsultaCadastro4";
        }


        @Override
        public String inutilizationNfProd() {
            return "https://nfe.sefa.pr.gov.br/nfe/NFeInutilizacao4";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeInutilizacao4";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.sefa.pr.gov.br/nfe/NFeRecepcaoEvento4";
        }

        @Override
        public String eventNfHom() {
            return "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeRecepcaoEvento4";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.sefa.pr.gov.br/nfe/NFeConsultaProtocolo4";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeConsultaProtocolo4";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.sefa.pr.gov.br/nfe/NFeStatusServico4";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeStatusServico4";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.sefa.pr.gov.br/nfe/NFeAutorizacao4";
        }

        @Override
        public String authorizationNfHom() {
            return "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.sefa.pr.gov.br/nfe/NFeRetAutorizacao4";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeRetAutorizacao4";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
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
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return "https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx";
        }

        @Override
        public String queryRegisterProd() {
            return "https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx";
        }


        @Override
        public String inutilizationNfProd() {
            return "https://nfe.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://nfe-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String eventNfHom() {
            return "https://nfe-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String authorizationNfHom() {
            return "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
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
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx";
        }

        @Override
        public String queryRegisterProd() {
            return "https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx";
        }


        @Override
        public String inutilizationNfProd() {
            return "https://nfe.fazenda.sp.gov.br/ws/nfeinutilizacao4.asmx";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeinutilizacao4.asmx";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.fazenda.sp.gov.br/ws/nferecepcaoevento4.asmx";
        }

        @Override
        public String eventNfHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/ws/nferecepcaoevento4.asmx";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.fazenda.sp.gov.br/ws/nfeconsultaprotocolo4.asmx";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeconsultaprotocolo4.asmx";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.fazenda.sp.gov.br/ws/nfestatusservico4.asmx";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfestatusservico4.asmx";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.fazenda.sp.gov.br/ws/nfeautorizacao4.asmx";
        }

        @Override
        public String authorizationNfHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeautorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.fazenda.sp.gov.br/ws/nferetautorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/ws/nferetautorizacao4.asmx";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }
    },


    SVAN {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Collections.singletonList(UF.MA);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Collections.singletonList(UF.MA);
        }

        @Override
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
        }

        @Override
        public String queryRegisterHom() {
            return null;
        }

        @Override
        public String queryRegisterProd() {
            return null;
        }


        @Override
        public String inutilizationNfProd() {
            return "https://www.sefazvirtual.fazenda.gov.br/NFeInutilizacao4/NFeInutilizacao4.asmx";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://hom.sefazvirtual.fazenda.gov.br/NFeInutilizacao4/NFeInutilizacao4.asmx";
        }

        @Override
        public String eventNfProd() {
            return "https://www.sefazvirtual.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfHom() {
            return "https://hom.sefazvirtual.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://www.sefazvirtual.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://hom.sefazvirtual.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://www.sefazvirtual.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://hom.sefazvirtual.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx";
        }

        @Override
        public String authorizationNfProd() {
            return "https://www.sefazvirtual.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx";
        }

        @Override
        public String authorizationNfHom() {
            return "https://hom.sefazvirtual.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://www.sefazvirtual.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://hom.sefazvirtual.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }
    },

    SVCRS {
        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Arrays.asList(UF.AM, UF.BA, UF.GO, UF.MA, UF.MS, UF.MT, UF.PE, UF.PI, UF.PR);
        }

        @Override
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && Objects.equals(emissionType, NFEmissionType.SVCRS);
        }

        @Override
        public String queryRegisterHom() {
            return null;
        }

        @Override
        public String queryRegisterProd() {
            return null;
        }

        @Override
        public Collection<UF> allowedUfsProduction() {
            return Arrays.asList(UF.AM, UF.BA, UF.GO, UF.MA, UF.MS, UF.MT, UF.PE, UF.PR);
        }

        @Override
        public String inutilizationNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String eventNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String eventNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String authorizationNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String authorizationNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://nfe.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }
    },


    SVCAN {
        @Override
        public Collection<UF> allowedUfsProduction() {
            return Arrays.asList(UF.AC, UF.AL, UF.AP, UF.CE, UF.DF, UF.ES, UF.MG, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RO, UF.RR, UF.RS, UF.SC, UF.SE, UF.SP, UF.TO);
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return Arrays.asList(UF.AC, UF.AL, UF.AP, UF.CE, UF.DF, UF.ES, UF.MG, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RO, UF.RR, UF.RS, UF.SC, UF.SE, UF.SP, UF.TO);
        }


        @Override
        public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
            return allow(uf, environment) && Objects.equals(emissionType, NFEmissionType.SVCAN);
        }


        @Override
        public String queryRegisterHom() {
            return null;
        }

        @Override
        public String queryRegisterProd() {
            return null;
        }

        @Override
        public String inutilizationNfProd() {
            return "https://www.svc.fazenda.gov.br/NFeInutilizacao4/NFeInutilizacao4.asmx";
        }

        @Override
        public String inutilizationNfHom() {
            return "https://hom.svc.fazenda.gov.br/NFeInutilizacao4/NFeInutilizacao4.asmx";
        }

        @Override
        public String eventNfProd() {
            return "https://www.svc.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfHom() {
            return "https://hom.svc.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String queryProtocolNfProd() {
            return "https://www.svc.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String queryProtocolNfHom() {
            return "https://hom.svc.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String statusServiceNfProd() {
            return "https://www.svc.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx";
        }

        @Override
        public String statusServiceNfHom() {
            return "https://hom.svc.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx";
        }

        @Override
        public String authorizationNfProd() {
            return "https://www.svc.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx";
        }

        @Override
        public String authorizationNfHom() {
            return "https://hom.svc.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfProd() {
            return "https://www.svc.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String returnAuthorizationNfHom() {
            return "https://hom.svc.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String eventNfAnProd() {
            return "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String eventNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String distributionNfAnProd() {
            return "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionNfAnHom() {
            return "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }
    };

    public static Collection<String> get(UF uf, Environment environment) throws NoProviderFound {
        Collection<NfeAuthorizer> serviceURL = Arrays.stream(NfeAuthorizer.values()).filter(it -> it.allow(uf, environment)).toList();

        if (serviceURL.isEmpty()) throw new NoProviderFound(uf);

        return environment.production() ? serviceURL.stream().map(it -> new ArrayList<>(it.prod())).flatMap(List::stream).collect(Collectors.toList()) : serviceURL.stream().map(it -> new ArrayList<>(it.hom())).flatMap(List::stream).collect(Collectors.toList());
    }

    public Collection<String> hom() {
        return Arrays.stream(this.getClass().getDeclaredMethods()).filter(it -> it.getName().toLowerCase().endsWith("hom")).map(it -> ClassUtils.get(it, this)).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.toSet());
    }

    public Collection<String> prod() {
        return Arrays.stream(this.getClass().getDeclaredMethods()).filter(it -> it.getName().toLowerCase().endsWith("prod")).map(it -> ClassUtils.get(it, this)).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.toSet());
    }

}
