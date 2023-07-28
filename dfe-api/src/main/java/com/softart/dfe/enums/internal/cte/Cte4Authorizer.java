package com.softart.dfe.enums.internal.cte;

import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.allow.CteServiceAllow;
import com.softart.dfe.interfaces.internal.cte.Cte4URL;
import com.softart.dfe.util.ClassUtils;

import java.util.*;
import java.util.stream.Collectors;

public enum Cte4Authorizer implements Cte4URL, CteServiceAllow {

    AN {
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
        public String receptionOsProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoOSV4";
        }

        @Override
        public String receptionOsHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoOSV4";
        }

        @Override
        public String receptionSyncProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoSincV4";
        }

        @Override
        public String receptionSyncHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoSincV4";
        }

        @Override
        public String receptionGtveProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoGTVeV4";
        }

        @Override
        public String receptionGtveHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoGTVeV4";
        }

        @Override
        public String querySituationProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CTeConsultaV4";
        }

        @Override
        public String querySituationHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CTeConsultaV4";
        }

        @Override
        public String statusServiceProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CteStatusServicoV4";
        }

        @Override
        public String statusServiceHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CteStatusServicoV4";
        }

        @Override
        public String eventProd() {
            return "https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoEventoV4";
        }

        @Override
        public String eventHom() {
            return "https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoEventoV4";
        }

        @Override
        public String distributionAnProd() {
            return null;
        }

        @Override
        public String distributionAnHom() {
            return null;
        }
    },


    MS {
        @Override
        public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
            return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL);
        }

        @Override
        public String receptionOsProd() {
            return "https://producao.cte.ms.gov.br/ws/CTeRecepcaoOSV4";
        }

        @Override
        public String receptionOsHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoOSV4";
        }

        @Override
        public String receptionSyncProd() {
            return "https://producao.cte.ms.gov.br/ws/CTeRecepcaoSincV4";
        }

        @Override
        public String receptionSyncHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoSincV4";
        }

        @Override
        public String receptionGtveProd() {
            return "https://producao.cte.ms.gov.br/ws/CTeRecepcaoGTVeV4";
        }

        @Override
        public String receptionGtveHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoGTVeV4";
        }

        @Override
        public String querySituationProd() {
            return "https://producao.cte.ms.gov.br/ws/CTeConsultaV4";
        }

        @Override
        public String querySituationHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CTeConsultaV4";
        }

        @Override
        public String statusServiceProd() {
            return "https://producao.cte.ms.gov.br/ws/CTeStatusServicoV4";
        }

        @Override
        public String statusServiceHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CTeStatusServicoV4";
        }

        @Override
        public String eventProd() {
            return "https://producao.cte.ms.gov.br/ws/CTeRecepcaoEventoV4";
        }

        @Override
        public String eventHom() {
            return "https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoEventoV4";
        }

        @Override
        public String distributionAnProd() {
            return null;
        }

        @Override
        public String distributionAnHom() {
            return null;
        }
    },


    MT {
        @Override
        public String receptionOsProd() {
            return "https://cte.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4";
        }

        @Override
        public String receptionOsHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4";
        }

        @Override
        public String receptionSyncProd() {
            return "https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoSincV4";
        }

        @Override
        public String receptionSyncHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoSincV4";
        }

        @Override
        public String receptionGtveProd() {
            return "https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoGTVeV4";
        }

        @Override
        public String receptionGtveHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoGTVeV4";
        }

        @Override
        public String querySituationProd() {
            return "https://cte.sefaz.mt.gov.br/ctews2/services/CTeConsultaV4";
        }

        @Override
        public String querySituationHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeConsultaV4";
        }

        @Override
        public String statusServiceProd() {
            return "https://cte.sefaz.mt.gov.br/ctews2/services/CTeStatusServicoV4";
        }

        @Override
        public String statusServiceHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeStatusServicoV4";
        }

        @Override
        public String eventProd() {
            return "https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoEventoV4";
        }

        @Override
        public String eventHom() {
            return "https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoEventoV4";
        }

        @Override
        public String distributionAnProd() {
            return null;
        }

        @Override
        public String distributionAnHom() {
            return null;
        }

        @Override
        public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
            return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL);
        }
    },


    PR {
        @Override
        public String receptionOsProd() {
            return "https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoOSV4";
        }

        @Override
        public String receptionOsHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoOSV4";
        }

        @Override
        public String receptionSyncProd() {
            return "https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoSincV4";
        }

        @Override
        public String receptionSyncHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoSincV4";
        }

        @Override
        public String receptionGtveProd() {
            return "https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoGTVeV4";
        }

        @Override
        public String receptionGtveHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoGTVeV4";
        }

        @Override
        public String querySituationProd() {
            return "https://cte.fazenda.pr.gov.br/cte4/CTeConsultaV4";
        }

        @Override
        public String querySituationHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeConsultaV4";
        }

        @Override
        public String statusServiceProd() {
            return "https://cte.fazenda.pr.gov.br/cte4/CTeStatusServicoV4";
        }

        @Override
        public String statusServiceHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeStatusServicoV4";
        }

        @Override
        public String eventProd() {
            return "https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoEventoV4";
        }

        @Override
        public String eventHom() {
            return "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoEventoV4";
        }

        @Override
        public String distributionAnProd() {
            return null;
        }

        @Override
        public String distributionAnHom() {
            return null;
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
        public String receptionOsProd() {
            return "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoOsV4/CTeRecepcaoOsV4.asmx";
        }

        @Override
        public String receptionOsHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoOsV4/CTeRecepcaoOsV4.asmx";
        }

        @Override
        public String receptionSyncProd() {
            return "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx";
        }

        @Override
        public String receptionSyncHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaosincV4/CTeRecepcaosincV4.asmx";
        }

        @Override
        public String receptionGtveProd() {
            return "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx";
        }

        @Override
        public String receptionGtveHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx";
        }

        @Override
        public String querySituationProd() {
            return "https://cte.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx";
        }

        @Override
        public String querySituationHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx";
        }

        @Override
        public String statusServiceProd() {
            return "https://cte.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx";
        }

        @Override
        public String statusServiceHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx";
        }

        @Override
        public String eventProd() {
            return "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx";
        }

        @Override
        public String eventHom() {
            return "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx";
        }

        @Override
        public String distributionAnProd() {
            return null;
        }

        @Override
        public String distributionAnHom() {
            return null;
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
        public String receptionOsProd() {
            return "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx";
        }

        @Override
        public String receptionOsHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx";
        }

        @Override
        public String receptionSyncProd() {
            return "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx";
        }

        @Override
        public String receptionSyncHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx";
        }

        @Override
        public String receptionGtveProd() {
            return "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx";
        }

        @Override
        public String receptionGtveHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx";
        }

        @Override
        public String querySituationProd() {
            return "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx";
        }

        @Override
        public String querySituationHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx";
        }

        @Override
        public String statusServiceProd() {
            return "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx";
        }

        @Override
        public String statusServiceHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx";
        }

        @Override
        public String eventProd() {
            return "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx";
        }

        @Override
        public String eventHom() {
            return "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx";
        }

        @Override
        public String distributionAnProd() {
            return null;
        }

        @Override
        public String distributionAnHom() {
            return null;
        }
    };

    public static Collection<String> get(UF uf, Environment environment) throws NoProviderFound {
        Collection<Cte4Authorizer> serviceURL = Arrays.stream(values())
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
