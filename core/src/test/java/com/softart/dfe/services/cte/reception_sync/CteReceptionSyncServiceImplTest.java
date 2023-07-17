package com.softart.dfe.services.cte.reception_sync;

import br.inf.portalfiscal.cte.send.TUFSemEX;
import br.inf.portalfiscal.cte.send.TUf;
import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.enums.cte.CteReturnCode;
import com.softart.dfe.enums.cte.identification.*;
import com.softart.dfe.enums.cte.info.charge.CteChargeUnid;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.city.CityPI;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.models.cte.reception.Cte;
import com.softart.dfe.models.cte.reception_sync.CteReturn;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CteReceptionSyncServiceImplTest {


    private static Cte getCte(CteConfig config, int number, Model model) {
        CityPI c = CityPI.PI_TERESINA;

        return Cte
                .builder()
                .infCte(Cte.InfCte
                        .builder()
                        .ide(Cte.InfCte
                                .Ide
                                .builder()
                                .cuf(config.uf().getCode())
                                .cfop("5353")
                                .natOp("TESTE")
                                .mod(model.getCode())
                                .serie("1")
                                .nct(String.valueOf(number))
                                .tpAmb(config.environment().getCode())
                                .tpCTe(CteType.NORMAL.getCode())
                                .procEmi(CteProcessEmission.APPLICATION.getCode())
                                .tpImp(CtePrintType.PORTRAIT.getCode())
                                .tpEmis(config.emission().getCode())
                                .cMunEnv(c.getCode())
                                .ufEnv(TUf.valueOf(c.getUf().name()))
                                .xMunEnv(c.getDescription())
                                .modal(CteModal.RODOVIARIO.getCode())
                                .tpServ(CteServiceType.NORMAL.getCode())
                                .cMunIni(c.getCode())
                                .xMunIni(c.getDescription())
                                .ufIni(TUf.valueOf(c.getUf().name()))
                                .cMunFim(c.getCode())
                                .xMunFim(c.getDescription())
                                .ufFim(TUf.valueOf(c.getUf().name()))
                                .indIEToma("1")
                                .retira("1")
                                .toma3(Cte.InfCte.Ide.Toma3.builder().toma(CteToma.REMITTEE.getCode()).build())
                                .build())
                        .compl(Cte.InfCte.Compl.builder().entrega(Cte.InfCte.Compl.Entrega
                                        .builder()
                                        .semData(Cte.InfCte.Compl.Entrega.SemData.builder().build())
                                        .semHora(Cte.InfCte.Compl.Entrega.SemHora.builder().build())
                                        .build())
                                .build())
                        .emit(Cte.InfCte.Emit
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .xFant("Teste")
                                .ie("194739350")
                                .crt("1")
                                .enderEmit(Cte.InfCte.TEndeEmi
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUFSemEX.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .rem(Cte.InfCte.Rem
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .xFant("Teste")
                                .ie("194739350")
                                .enderReme(Cte.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .exped(Cte.InfCte.Exped
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .ie("194739350")
                                .enderExped(Cte.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .receb(Cte.InfCte.Receb
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .ie("194739350")
                                .enderReceb(Cte.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .dest(Cte.InfCte.Dest
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .ie("194739350")
                                .enderDest(Cte.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .vPrest(Cte.InfCte.VPrest.builder()
                                .vtPrest("1110.00")
                                .vRec("1110.00")
                                .build())
                        .imp(Cte.InfCte.Imp
                                .builder()
                                .icms(Cte.InfCte.Imp.TImp
                                        .builder()
                                        .icms00(Cte.InfCte.Imp.TImp.ICMS00.builder()
                                                .vbc("1110.00")
                                                .picms("17.00")
                                                .vicms("188.70")
                                                .build())
                                        .build())
                                .vTotTrib("188.70")
                                .build())
                        .infCTeNorm(Cte.InfCte.InfCTeNorm
                                .builder()
                                .infCarga(Cte.InfCte.InfCTeNorm.InfCarga
                                        .builder()
                                        .vCarga("1600.00")
                                        .proPred("VASILHAME 13KG - ONU 1075 GLP 2.1")
                                        .xOutCat("VASILHAME")
                                        .infQ(Collections.singletonList(
                                                Cte.InfCte.InfCTeNorm.InfCarga.InfQ
                                                        .builder()
                                                        .cUnid(CteChargeUnid.KG.getCode())
                                                        .tpMed("PESO BRUTO")
                                                        .qCarga("130.0000")
                                                        .build()
                                        ))
                                        .build())
                                .infDoc(Cte.InfCte.InfCTeNorm.InfDoc
                                        .builder()
                                        .infNFe(Collections.singletonList(Cte.InfCte.InfCTeNorm.InfDoc.InfNFe
                                                .builder()
                                                .chave("22220911520224000140550010000035391879129974")
                                                .build()))
                                        .build())
                                .infModal(Cte.InfCte.InfCTeNorm.InfModal
                                        .builder()
                                        .rodo(Cte.InfCte.InfCTeNorm.InfModal.Rodo
                                                .builder()
                                                .rntrc("12345678")
                                                .build())
                                        .build())
                                .build())
                        .infRespTec(Cte.InfCte.TRespTec.builder()
                                .cnpj("11520224000140")
                                .xContato("TARTIGRADO TECNOLOGIA TLDA")
                                .email("falecom@tartigrado.com")
                                .fone("86988033430")
                                .build())
                        .build())
                .build();
    }

    @Test
    void testReceptionEnvironmentHomologationAndAuthorizerSvrs() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertNotNull(o);
        assertEquals(CteReturnCode.CODE_539.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PI.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentProductionAndAuthorizerSvrs() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertEquals(CteReturnCode.CODE_661.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PI.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentHomologationAndAuthorizerSvsp() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertNotNull(o);
        assertEquals(CteReturnCode.CODE_524.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.SP.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentProductionAndAuthorizerSvsp() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertEquals(CteReturnCode.CODE_524.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.SP.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentHomologationAndAuthorizerMg() throws Exception {
         CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                 new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
         );
         CteReturn o = service.receptionSync(
                 getCte(service.getConfig(), 1, Model.CTE)
         );
         assertNotNull(o);
         assertEquals(CteReturnCode.CODE_524.getCode(), o.getCStat());
         assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
         assertEquals(UF.MG.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentProductionAndAuthorizerMg() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertEquals(CteReturnCode.CODE_524.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MG.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentHomologationAndAuthorizerMt() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertNotNull(o);
        assertEquals(CteReturnCode.CODE_524.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentProductionAndAuthorizerMt() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertEquals(CteReturnCode.CODE_524.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentHomologationAndAuthorizerMs() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertNotNull(o);
        assertEquals(CteReturnCode.CODE_712.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MS.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentProductionAndAuthorizerMs() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertEquals(CteReturnCode.CODE_712.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MS.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentHomologationAndAuthorizerPr() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertNotNull(o);
        assertEquals(CteReturnCode.CODE_524.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PR.getCode(), o.getCuf());
    }

    @Test
    void testReceptionEnvironmentProductionAndAuthorizerPr() throws Exception {
        CteReceptionSyncService service = new CteReceptionSyncServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturn o = service.receptionSync(
                getCte(service.getConfig(), 1, Model.CTE)
        );
        assertEquals(CteReturnCode.CODE_524.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PR.getCode(), o.getCuf());
    }


}