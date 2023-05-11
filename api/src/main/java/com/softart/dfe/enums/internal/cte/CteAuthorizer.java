package com.softart.dfe.enums.internal.cte;

import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.allow.CteServiceAllow;
import com.softart.dfe.interfaces.internal.cte.CteURL;
import com.softart.dfe.util.ClassUtils;

import java.util.*;
import java.util.stream.Collectors;

public enum CteAuthorizer implements CteURL, CteServiceAllow {

    AN {
        @Override
        public String receptionProd() {
            return null;
        }

        @Override
        public String receptionHom() {
            return null;
        }

        @Override
        public String receptionOsProd() {
            return null;
        }

        @Override
        public String receptionOsHom() {
            return null;
        }

        @Override
        public String receptionSyncProd() {
            return null;
        }

        @Override
        public String receptionSyncHom() {
            return null;
        }

        @Override
        public String receptionGtveProd() {
            return null;
        }

        @Override
        public String receptionGtveHom() {
            return null;
        }

        @Override
        public String returnReceptionProd() {
            return null;
        }

        @Override
        public String returnReceptionHom() {
            return null;
        }

        @Override
        public String inutilizationProd() {
            return null;
        }

        @Override
        public String inutilizationHom() {
            return null;
        }

        @Override
        public String querySituationProd() {
            return null;
        }

        @Override
        public String querySituationHom() {
            return null;
        }

        @Override
        public String statusServiceProd() {
            return null;
        }

        @Override
        public String statusServiceHom() {
            return null;
        }

        @Override
        public String eventProd() {
            return null;
        }

        @Override
        public String eventHom() {
            return null;
        }


        @Override
        public String distributionAnProd() {
            return "https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionAnHom() {
            return "https://hom1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
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
        public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
            return true;
        }
    },

    MG {
        @Override
        public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
            return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL);
        }

        @Override
        public String receptionProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CteRecepcao";
        }

        @Override
        public String receptionHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CteRecepcao";
        }

        @Override
        public String receptionOsProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CteRecepcaoOS";
        }

        @Override
        public String receptionOsHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CteRecepcaoOS";
        }

        @Override
        public String receptionSyncProd() {
            return null;
        }

        @Override
        public String receptionSyncHom() {
            return null;
        }

        @Override
        public String receptionGtveProd() {
            return null;
        }

        @Override
        public String receptionGtveHom() {
            return null;
        }

        @Override
        public String returnReceptionProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CteRetRecepcao";
        }

        @Override
        public String returnReceptionHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CteRetRecepcao";
        }

        @Override
        public String inutilizationProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CteInutilizacao";
        }

        @Override
        public String inutilizationHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CteInutilizacao";
        }

        @Override
        public String querySituationProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CteConsulta";
        }

        @Override
        public String querySituationHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CteConsulta";
        }

        @Override
        public String statusServiceProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CteStatusServico";
        }

        @Override
        public String statusServiceHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CteStatusServico";
        }

        @Override
        public String eventProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/RecepcaoEvento";
        }

        @Override
        public String eventHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/RecepcaoEvento";
        }

        @Override
        public String distributionAnProd() {
            return "https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionAnHom() {
            return "https://hom1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }
    },


    MS {
        @Override
        public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
            return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL);
        }

        @Override
        public String receptionProd() {
            return "https://producao.cte.ms.gov.br/ws/CteRecepcao";
        }

        @Override
        public String receptionHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CteRecepcao";
        }

        @Override
        public String receptionOsProd() {
            return "https://producao.cte.ms.gov.br/ws/CteRecepcaoOS";
        }

        @Override
        public String receptionOsHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CteRecepcaoOS";
        }

        @Override
        public String receptionSyncProd() {
            return "https://producao.cte.ms.gov.br/ws/CteRecepcaoSinc";
        }

        @Override
        public String receptionSyncHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CteRecepcaoSinc";
        }

        @Override
        public String receptionGtveProd() {
            return null;
        }

        @Override
        public String receptionGtveHom() {
            return null;
        }

        @Override
        public String returnReceptionProd() {
            return "https://producao.cte.ms.gov.br/ws/CteRetRecepcao";
        }

        @Override
        public String returnReceptionHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CteRetRecepcao";
        }

        @Override
        public String inutilizationProd() {
            return "https://producao.cte.ms.gov.br/ws/CteInutilizacao";
        }

        @Override
        public String inutilizationHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CteInutilizacao";
        }

        @Override
        public String querySituationProd() {
            return "https://producao.cte.ms.gov.br/ws/CteConsulta";
        }

        @Override
        public String querySituationHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CteConsulta";
        }

        @Override
        public String statusServiceProd() {
            return "https://producao.cte.ms.gov.br/ws/CteStatusServico";
        }

        @Override
        public String statusServiceHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CteStatusServico";
        }

        @Override
        public String eventProd() {
            return "https://producao.cte.ms.gov.br/ws/CteRecepcaoEvento";
        }

        @Override
        public String eventHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CteRecepcaoEvento";
        }

        @Override
        public String distributionAnProd() {
            return "https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionAnHom() {
            return "https://hom1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }
    },


    MT {
        @Override
        public String receptionProd() {
            return "https://cte.sefaz.mt.gov.br/ctews/services/CteRecepcao";
        }

        @Override
        public String receptionHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews/services/CteRecepcao";
        }

        @Override
        public String receptionOsProd() {
            return "https://cte.sefaz.mt.gov.br/ctews/services/CteRecepcaoOS";
        }

        @Override
        public String receptionOsHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews/services/CteRecepcaoOS";
        }

        @Override
        public String receptionSyncProd() {
            return "https://cte.sefaz.mt.gov.br/ctews2/services/CteRecepcaoSinc";
        }

        @Override
        public String receptionSyncHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews2/services/CteRecepcaoSinc";
        }

        @Override
        public String receptionGtveProd() {
            return "https://cte.sefaz.mt.gov.br/ctews2/services/cteRecepcaoGTVe";
        }

        @Override
        public String receptionGtveHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews2/services/cteRecepcaoGTVe";
        }

        @Override
        public String returnReceptionProd() {
            return "https://cte.sefaz.mt.gov.br/ctews/services/CteRetRecepcao";
        }

        @Override
        public String returnReceptionHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews/services/CteRetRecepcao";
        }

        @Override
        public String inutilizationProd() {
            return "https://cte.sefaz.mt.gov.br/ctews/services/CteInutilizacao";
        }

        @Override
        public String inutilizationHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews/services/CteInutilizacao";
        }

        @Override
        public String querySituationProd() {
            return "https://cte.sefaz.mt.gov.br/ctews/services/CteConsulta";
        }

        @Override
        public String querySituationHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews/services/CteConsulta";
        }

        @Override
        public String statusServiceProd() {
            return "https://cte.sefaz.mt.gov.br/ctews/services/CteStatusServico";
        }

        @Override
        public String statusServiceHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews/services/CteStatusServico";
        }

        @Override
        public String eventProd() {
            return "https://cte.sefaz.mt.gov.br/ctews2/services/CteRecepcaoEvento";
        }

        @Override
        public String eventHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews2/services/CteRecepcaoEvento";
        }

        @Override
        public String distributionAnProd() {
            return "https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionAnHom() {
            return "https://hom1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }

        @Override
        public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
            return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL);
        }
    },


    PR {
        @Override
        public String receptionProd() {
            return "https://cte.fazenda.pr.gov.br/cte/CteRecepcao";
        }

        @Override
        public String receptionHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcao";
        }

        @Override
        public String receptionOsProd() {
            return "https://cte.fazenda.pr.gov.br/cte/CteRecepcaoOS";
        }

        @Override
        public String receptionOsHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcaoOS";
        }

        @Override
        public String receptionSyncProd() {
            return "https://cte.fazenda.pr.gov.br/cte/CteRecepcaoSinc";
        }

        @Override
        public String receptionSyncHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcaoSinc";
        }

        @Override
        public String receptionGtveProd() {
            return "https://cte.fazenda.pr.gov.br/cte/CteRecepcaoGTVe";
        }

        @Override
        public String receptionGtveHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcaoGTVe";
        }

        @Override
        public String returnReceptionProd() {
            return "https://cte.fazenda.pr.gov.br/cte/CteRetRecepcao";
        }

        @Override
        public String returnReceptionHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRetRecepcao";
        }

        @Override
        public String inutilizationProd() {
            return "https://cte.fazenda.pr.gov.br/cte/CteInutilizacao";
        }

        @Override
        public String inutilizationHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte/CteInutilizacao";
        }

        @Override
        public String querySituationProd() {
            return "https://cte.fazenda.pr.gov.br/cte/CteConsulta";
        }

        @Override
        public String querySituationHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte/CteConsulta";
        }

        @Override
        public String statusServiceProd() {
            return "https://cte.fazenda.pr.gov.br/cte/CteStatusServico";
        }

        @Override
        public String statusServiceHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte/CteStatusServico";
        }

        @Override
        public String eventProd() {
            return "https://cte.fazenda.pr.gov.br/cte/CteRecepcaoEvento";
        }

        @Override
        public String eventHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcaoEvento";
        }

        @Override
        public String distributionAnProd() {
            return "https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionAnHom() {
            return "https://hom1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }

        @Override
        public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
            return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL);
        }
    },


    SVRS {
        private Collection<UF> ufs() {
            return Arrays.asList(UF.AC, UF.AL, UF.AM, UF.BA, UF.CE, UF.DF, UF.ES, UF.GO, UF.MA, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RS, UF.RO, UF.SC, UF.SE, UF.TO);
        }

        private Collection<UF> ufsContigency() {
            return Arrays.asList(UF.MS, UF.MT, UF.SP, UF.AP, UF.PE, UF.RR);
        }

        @Override
        public Collection<UF> allowedUfsProduction() {
            return ufs();
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return ufs();
        }

        @Override
        public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
            return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL) || (Arrays.asList(CteEmissionType.EPEC, CteEmissionType.SVCRS).contains(emissionType) && ufsContigency().contains(uf));
        }

        @Override
        public String receptionProd() {
            return "https://cte.svrs.rs.gov.br/ws/cterecepcao/CteRecepcao.asmx";
        }

        @Override
        public String receptionHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcao/CteRecepcao.asmx";
        }

        @Override
        public String receptionOsProd() {
            return "https://cte.svrs.rs.gov.br/ws/cterecepcaoos/cterecepcaoos.asmx";
        }

        @Override
        public String receptionOsHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoos/cterecepcaoos.asmx";
        }

        @Override
        public String receptionSyncProd() {
            return "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoSinc/CTeRecepcaoSinc.asmx";
        }

        @Override
        public String receptionSyncHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoSinc/CTeRecepcaosinc.asmx";
        }

        @Override
        public String receptionGtveProd() {
            return "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoGTVe/CTeRecepcaoGTVe.asmx";
        }

        @Override
        public String receptionGtveHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoGTVe/CTeRecepcaoGTVe.asmx";
        }

        @Override
        public String returnReceptionProd() {
            return "https://cte.svrs.rs.gov.br/ws/cteretrecepcao/cteRetRecepcao.asmx";
        }

        @Override
        public String returnReceptionHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/cteretrecepcao/cteRetRecepcao.asmx";
        }

        @Override
        public String inutilizationProd() {
            return "https://cte.svrs.rs.gov.br/ws/cteinutilizacao/cteinutilizacao.asmx";
        }

        @Override
        public String inutilizationHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/cteinutilizacao/cteinutilizacao.asmx";
        }

        @Override
        public String querySituationProd() {
            return "https://cte.svrs.rs.gov.br/ws/cteconsulta/CteConsulta.asmx";
        }

        @Override
        public String querySituationHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/cteconsulta/CteConsulta.asmx";
        }

        @Override
        public String statusServiceProd() {
            return "https://cte.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx";
        }

        @Override
        public String statusServiceHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx";
        }

        @Override
        public String eventProd() {
            return "https://cte.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx";
        }

        @Override
        public String eventHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx";
        }

        @Override
        public String distributionAnProd() {
            return "https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionAnHom() {
            return "https://hom1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }
    },


    SVSP {
        Collection<UF> ufs() {
            return Arrays.asList(UF.AP, UF.PE, UF.RR, UF.SP);
        }

        Collection<UF> ufsContigency() {
            return Arrays.asList(UF.MG, UF.PR, UF.RS, UF.AC, UF.AL, UF.AM, UF.BA, UF.CE, UF.DF, UF.ES, UF.GO, UF.MA, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RO, UF.SC, UF.SE, UF.TO);
        }

        @Override
        public Collection<UF> allowedUfsProduction() {
            return ufs();
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return ufs();
        }

        @Override
        public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
            return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL) || (Arrays.asList(CteEmissionType.EPEC, CteEmissionType.SVCSP).contains(emissionType) && ufsContigency().contains(uf));
        }

        @Override
        public String receptionProd() {
            return "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcao.asmx";
        }

        @Override
        public String receptionHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcao.asmx";
        }

        @Override
        public String receptionOsProd() {
            return "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx";
        }

        @Override
        public String receptionOsHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx";
        }

        @Override
        public String receptionSyncProd() {
            return "https://nfe.fazenda.sp.gov.br/cteWEB/services/CTeRecepcaoSinc.asmx";
        }

        @Override
        public String receptionSyncHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CTeRecepcaoSinc.asmx";
        }

        @Override
        public String receptionGtveProd() {
            return "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoGTVe.asmx";
        }

        @Override
        public String receptionGtveHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoGTVe.asmx";
        }

        @Override
        public String returnReceptionProd() {
            return "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRetRecepcao.asmx";
        }

        @Override
        public String returnReceptionHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRetRecepcao.asmx";
        }

        @Override
        public String inutilizationProd() {
            return "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteInutilizacao.asmx";
        }

        @Override
        public String inutilizationHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteInutilizacao.asmx";
        }

        @Override
        public String querySituationProd() {
            return "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteConsulta.asmx";
        }

        @Override
        public String querySituationHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteConsulta.asmx";
        }

        @Override
        public String statusServiceProd() {
            return "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteStatusServico.asmx";
        }

        @Override
        public String statusServiceHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteStatusServico.asmx";
        }

        @Override
        public String eventProd() {
            return "https://nfe.fazenda.sp.gov.br/cteweb/services/cteRecepcaoEvento.asmx";
        }

        @Override
        public String eventHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/cteweb/services/cteRecepcaoEvento.asmx";
        }

        @Override
        public String distributionAnProd() {
            return "https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }

        @Override
        public String distributionAnHom() {
            return "https://hom1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }
    };

    public static Collection<String> get(UF uf, Environment environment) throws NoProviderFound {
        Collection<CteAuthorizer> serviceURL = Arrays.stream(values())
                .filter(it -> it.allow(uf, environment))
                .toList();

        if (serviceURL.isEmpty()) throw new NoProviderFound();

        return environment.production() ? serviceURL.stream().map(it -> new ArrayList<>(it.prod())).flatMap(List::stream).collect(Collectors.toList()) : serviceURL.stream().map(it -> new ArrayList<>(it.hom())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return Collections.singletonList(UF.valueOf(name()));
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return Collections.singletonList(UF.valueOf(name()));
    }

    public Collection<String> hom() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(it -> it.getName().toLowerCase().endsWith("hom"))
                .map(it -> ClassUtils.get(it, this))
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }

    public Collection<String> prod() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(it -> it.getName().toLowerCase().endsWith("prod"))
                .map(it -> ClassUtils.get(it, this))
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }
}
