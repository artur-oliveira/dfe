package org.dfe.services.nf.authorization;

import br.inf.portalfiscal.nfe.send.TUf;
import br.inf.portalfiscal.nfe.send.TUfEmi;
import org.dfe.components.internal.DFEnum;
import org.dfe.components.internal.ProjectProperties;
import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfceConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFReturnCode;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.*;
import org.dfe.enums.nf.payment.NFPaymentIndicative;
import org.dfe.enums.nf.payment.NFPaymentType;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.models.nf.authorization.Nf;
import org.dfe.models.nf.authorization.ReturnSendNf;
import org.dfe.util.DateUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class NfceAuthorizationServiceImplTest {

    private static Nf getNf(NfConfig config, int number, Model model) {
        DFEnum.Codeable city = config.uf().getCities().stream().findAny().orElseThrow(RuntimeException::new);

        Nf nfe = Nf.builder().build();
        Nf.InfNFe infNFe = Nf.InfNFe.builder().build();

        Nf.InfNFe.Ide ide = Nf.InfNFe.Ide.builder().build();
        ide.setCuf(config.uf().getCode());
        ide.setNatOp("OPERAÇÃO DE TESTE");
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
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.AM.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.AM.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_464.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.AM.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_462.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.AM.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {

        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.GO.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.GO.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_384.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.GO.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_384.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.GO.getCode(), o.getCuf());
    }


    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {

        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MG.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MG.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MG.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MG.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {

        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {

        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_126.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
        assertEquals(NFReturnCode.CODE_230.getCode(), o.getProtNFe().getInfProt().getCStat());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_230.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.MT.getCode(), o.getCuf());
        assertEquals(NFReturnCode.CODE_230.getCode(), o.getProtNFe().getInfProt().getCStat());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {

        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PR.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PR.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PR.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PR.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {

        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_126.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.RS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.RS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_462.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.RS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_462.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.RS.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {

        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_126.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.SP.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.SP.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.SP.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_209.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.SP.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_126.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PI.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationAsyncWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.ASYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(Arrays.asList(getNf(service.getConfig(), 1, Model.NFCE), getNf(service.getConfig(), 1, Model.NFCE)));

        assertNotNull(o);
        assertNotNull(o.getInfRec());
        assertEquals(NFReturnCode.CODE_103.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PI.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_539.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        assertEquals(UF.PI.getCode(), o.getCuf());
    }

    @Test
    void testAuthorizationSyncWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfceAuthorizationService service = new NfceAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );

        ReturnSendNf o = service.authorization(getNf(service.getConfig(), 1, Model.NFCE));

        assertNotNull(o);
        assertNull(o.getInfRec());
        assertNotNull(o.getProtNFe());
        assertNotNull(o.getProtNFe().getInfProt());
        assertEquals(NFReturnCode.CODE_539.getCode(), o.getProtNFe().getInfProt().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        assertEquals(UF.PI.getCode(), o.getCuf());
    }
}