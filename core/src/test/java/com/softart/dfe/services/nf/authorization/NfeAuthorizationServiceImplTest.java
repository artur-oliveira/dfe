package com.softart.dfe.services.nf.authorization;

import br.inf.portalfiscal.nfe.send.TUf;
import br.inf.portalfiscal.nfe.send.TUfEmi;
import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.components.internal.ProjectProperties;
import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFReturnCode;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.*;
import com.softart.dfe.enums.nf.payment.NFPaymentIndicative;
import com.softart.dfe.enums.nf.payment.NFPaymentType;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.models.nf.authorization.Nf;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.util.DateUtils;
import jakarta.xml.ws.WebServiceException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class NfeAuthorizationServiceImplTest {

    private static Nf getNf(NfConfig config, int number, Model model) {
        DFEnum.Codeable city = config.uf().getCities().stream().findAny().orElseThrow(RuntimeException::new);

        Nf nfe = Nf.builder().build();
        Nf.InfNFe infNFe = Nf.InfNFe.builder().build();

        Nf.InfNFe.Ide ide = Nf.InfNFe.Ide.builder().build();
        ide.setCuf(config.uf().getCode());
        ide.setNatOp("OPERACAO DE TESTE");
        ide.setSerie("2");
        ide.setNnf(String.valueOf(number));
        ide.setDhEmi(DateUtils.nowString());
        ide.setTpNF(NFType.OUTGOING.getCode());
        ide.setIdDest(NFOperationDestiny.INTERNAL.getCode());
        ide.setCMunFG(city.getCode());

        switch (model) {
            case NFE:
                ide.setTpImp(NFPrintType.PORTRAIT_DANFE.getCode());
                break;
            case NFCE:
                ide.setTpImp(NFPrintType.NFCE_DANFE.getCode());
            default:
                break;
        }

        ide.setTpEmis(config.emission().getCode());
        ide.setMod(model.getCode());

        if (!ide.getTpEmis().equals(NFEmissionType.NORMAL.getCode())) {
            ide.setDhCont(DateUtils.nowString());
            ide.setXJust("TESTE DE EMISSAO EM CONTIGENCIA");
        }

        ide.setTpAmb(config.environment().getCode());
        ide.setFinNFe(NFFinality.NORMAL.getCode());
        ide.setIndFinal(NFFinalConsumer.YES.getCode());
        ide.setVerProc(ProjectProperties.displayVersion());
        ide.setProcEmi(NFProcessEmission.APPLICATION.getCode());

        if (model.equals(Model.NFE)) {
            ide.setIndPres(NFPresenceIndicative.NOT_APPLY.getCode());
        } else {
            ide.setIndPres(NFPresenceIndicative.PRESENTIAL.getCode());
        }


        infNFe.setEmit(Nf.InfNFe.Emit.builder().cnpj(config.cnpj()).xNome("Teste Nome").xFant("Teste").ie("194739350").crt("1").enderEmit(Nf.InfNFe.Emit.EnderEmi.builder().cep("64014220").xBairro("Bairro Teste").xCpl("Complemento teste").cMun(city.getCode()).xMun(city.getDescription()).xLgr("Rua teste").nro("666").uf(TUfEmi.valueOf(config.uf().name())).build()).build());

        if (model.equals(Model.NFE)) {
            infNFe.setDest(Nf.InfNFe.Dest.builder().cnpj(config.cnpj()).ie("194739350").xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL").enderDest(Nf.InfNFe.Dest.Endereco.builder().cep("64014220").xBairro("Bairro Teste").xCpl("Complemento teste").cMun(city.getCode()).xMun(city.getDescription()).xLgr("Rua teste").nro("666").uf(TUf.valueOf(config.uf().name())).build()).indIEDest("9").build());
        }

        infNFe.setDet(Collections.singletonList(Nf.InfNFe.Det.builder().nItem("1").prod(Nf.InfNFe.Det.Prod.builder().cProd("1").xProd("NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL").cfop("5102").ncm("73110000").cest("0101900").vProd("70.00").qCom("1").vUnCom("70.0000000000").uCom("UNID").qTrib("1").vUnTrib("70.0000000000").uTrib("UNID").ceanTrib("SEM GTIN").cean("SEM GTIN").indTot("1").build()).imposto(Nf.InfNFe.Det.Imposto.builder().icms(Nf.InfNFe.Det.Imposto.ICMS.builder().icmssn102(Nf.InfNFe.Det.Imposto.ICMS.ICMSSN102.builder().csosn("400").orig("0").build()).build()).pis(Nf.InfNFe.Det.Imposto.PIS.builder().pisOutr(Nf.InfNFe.Det.Imposto.PIS.PISOutr.builder().cst("99").vpis("0.00").vbc("0.00").ppis("0.00").build()).build()).cofins(Nf.InfNFe.Det.Imposto.COFINS.builder().cofinsOutr(Nf.InfNFe.Det.Imposto.COFINS.COFINSOutr.builder().cst("99").vcofins("0.00").vbc("0.00").pcofins("0.00").build()).build()).build()).build()));
        infNFe.setTotal(Nf.InfNFe.Total.builder().icmsTot(Nf.InfNFe.Total.ICMSTot.builder().vbc("0.00").vicms("0.00").vicmsDeson("0.00").vfcp("0.00").vbcst("0.00").vst("0.00").vfcpst("0.00").vfcpstRet("0.00").vProd("70.00").vFrete("0.00").vSeg("0.00").vDesc("0.00").vii("0.00").vipi("0.00").vipiDevol("0.00").vpis("0.00").vcofins("0.00").vOutro("0.00").vnf("70.00").vTotTrib("0.00").build()).build());
        infNFe.setTransp(Nf.InfNFe.Transp.builder().modFrete("9").build());
        infNFe.setPag(Nf.InfNFe.Pag.builder().detPag(Collections.singletonList(Nf.InfNFe.Pag.DetPag.builder().indPag(NFPaymentIndicative.IN_CASH.getCode()).tPag(NFPaymentType.MONEY.getCode()).vPag("70.00").build())).build());
        infNFe.setIde(ide);
        infNFe.setInfRespTec(Nf.InfNFe.TInfRespTec.builder()
                .cnpj("11520224000140")
                .xContato("TARTIGRADO TECNOLOGIA TLDA")
                .email("falecom@tartigrado.com")
                .fone("86988033430")
                .build());
        nfe.setInfNFe(infNFe);

        return nfe;
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.AM.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.AM.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_203.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.AM.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_203.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.AM.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerBa() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.BA.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerBa() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.BA.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerBa() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_776.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.BA.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerBa() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_776.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.BA.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.GO.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.GO.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        try {
            ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

            assertNotNull(o);
            assertNull(o.getInfRec());
            assertNotNull(o.getProtNFe());
            assertEquals(NFReturnCode.CODE_233.getCode(), o.getProtNFe().getInfProt().getCStat());
            assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
            assertEquals(UF.GO.getCode(), o.getCuf());
        } catch (WebServiceException ignored) {
        }
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_233.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.GO.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MG.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MG.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MG.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_230.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MG.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_210.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_230.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerPe() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PE.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerPe() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PE.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerPe() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PE.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerPe() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PE.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PR.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PR.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PR.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PR.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.RS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.RS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_233.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.RS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_233.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.RS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.SP.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.SP.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.SP.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.SP.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerSvan() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MA.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerSvan() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MA.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerSvan() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MA.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerSvan() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MA.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerSvcan() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AC,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.AC.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerSvcan() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AC,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.AC.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerSvcan() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AC,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.AC.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerSvcan() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AC,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertEquals(UF.AC.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerSvcrs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerSvcrs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerSvcrs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_233.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerSvcrs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PI.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC
                )
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFE), getNf(service.getConfig(), 1, Model.NFE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PI.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_539.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PI.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfeAuthorizationService service = new NfeAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertEquals(NFReturnCode.CODE_539.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PI.getCode(), o.getCuf());
    }
}