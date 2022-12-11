import br.inf.portalfiscal.nfe.send.TUf;
import br.inf.portalfiscal.nfe.send.TUfEmi;
import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.components.internal.certificate.PfxKeyStoreInfoImpl;
import com.softart.dfe.components.internal.ProjectProperties;
import com.softart.dfe.components.internal.config.PfxNfConfigImpl;
import com.softart.dfe.components.security.chain.CertificateChainFactory;
import com.softart.dfe.components.security.signer.DefaultXmlSigner;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.identification.*;
import com.softart.dfe.enums.nf.payment.NFPaymentIndicative;
import com.softart.dfe.enums.nf.payment.NFPaymentType;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.xml.XMLSigner;
import com.softart.dfe.models.internal.security.Certificate;
import com.softart.dfe.models.nf.authorization.Nf;
import com.softart.dfe.models.nf.authorization.ReturnNf;
import com.softart.dfe.models.nf.epec.ReturnNfeEpec;
import com.softart.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;
import com.softart.dfe.services.nf.authorization.NfAuthorizationService;
import com.softart.dfe.services.nf.authorization.NfceAuthorizationServiceImpl;
import com.softart.dfe.services.nf.authorization.NfeAuthorizationServiceImpl;
import com.softart.dfe.services.nf.cancel.NfCancelService;
import com.softart.dfe.services.nf.cancel.NfceCancelServiceImpl;
import com.softart.dfe.services.nf.cancel.NfeCancelServiceImpl;
import com.softart.dfe.services.nf.correction_letter.NfeCorrectionLetterService;
import com.softart.dfe.services.nf.correction_letter.NfeCorrectionLetterServiceImpl;
import com.softart.dfe.services.nf.distribution.NfeDistributionService;
import com.softart.dfe.services.nf.distribution.NfeDistributionServiceImpl;
import com.softart.dfe.services.nf.epec.NfeEpecService;
import com.softart.dfe.services.nf.epec.NfeEpecServiceImpl;
import com.softart.dfe.services.nf.interested_actor.NfeInterestedActorService;
import com.softart.dfe.services.nf.interested_actor.NfeInterestedActorServiceImpl;
import com.softart.dfe.services.nf.inutilization.NfInutilizationService;
import com.softart.dfe.services.nf.inutilization.NfceInutilizationServiceImpl;
import com.softart.dfe.services.nf.inutilization.NfeInutilizationServiceImpl;
import com.softart.dfe.services.nf.manifestation.NfeManifestationService;
import com.softart.dfe.services.nf.manifestation.NfeManifestationServiceImpl;
import com.softart.dfe.services.nf.query_gtin.NfQueryGtinService;
import com.softart.dfe.services.nf.query_gtin.NfQueryGtinServiceImpl;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;
import com.softart.dfe.services.nf.query_protocol.NfceQueryProtocolServiceImpl;
import com.softart.dfe.services.nf.query_protocol.NfeQueryProtocolServiceImpl;
import com.softart.dfe.services.nf.query_status_service.NfQueryStatusService;
import com.softart.dfe.services.nf.query_status_service.NfceQueryStatusServiceImpl;
import com.softart.dfe.services.nf.query_status_service.NfeQueryStatusServiceImpl;
import com.softart.dfe.services.nf.return_authorization.NfReturnAuthorizationService;
import com.softart.dfe.services.nf.return_authorization.NfceReturnAuthorizationServiceImpl;
import com.softart.dfe.services.nf.return_authorization.NfeReturnAuthorizationServiceImpl;
import com.softart.dfe.services.nf.substitute_cancel.NfSubstituteCancelService;
import com.softart.dfe.services.nf.substitute_cancel.NfceSubstituteCancelServiceImpl;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.InputStreamUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public final class App {

    public static void main(String[] args) throws Exception {
//        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
        cancelarNf("22221211520224000140550010000036481434788272", "322220000036984");
//        cancelarNfc("22220911520224000140650010000046781605558739");
//        substituteCancelNfc("22220911520224000140650010000046851087679555", "22220911520224000140650010000046869703887050");
//        queryGtin("7891249061166");
//        all();
//        autorizarNfc();
//        consultarLoteNfce("223065113228925");
//        consultarLote("291100011499320");
//        consultarProtocoloNfe("");
//        consultarProtocoloNfce("22220911520224000140650010000046621106595116");
//        inutilizarNf();
//        inutilizarNfce();
//        distributionNfAccessKey();
//        distributionNfUniqueNsu();
//        distributionNf();
//        operationScienceNf();
//        correctionLetterNf();
//        queryStatusServiceNf();
//        queryStatusServiceNfc();
//        epec();
//        interestedActor();
    }

    private static void all() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());
        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfAuthorizationService service = new NfeAuthorizationServiceImpl(config, signer);

        ReturnNf returnNf = service.authorization(Arrays.asList(getNfe(config, 3649), getNfe(config, 3650)));

        ReturnNf.InfRec rec = Objects.requireNonNull(returnNf.getInfRec());
        NfReturnAuthorizationService returnAuthorizationService = new NfeReturnAuthorizationServiceImpl(config, signer);
        ReturnQueryReceiptNfe returnQueryReceiptNfe;
        do {
            Thread.sleep(1000L * Integer.parseInt((Objects.nonNull(rec.getTMed()) ? rec.getTMed() : "5")));
            returnQueryReceiptNfe = returnAuthorizationService.queryReceipt(rec.getNRec());
        } while (returnQueryReceiptNfe.getProtNFe().isEmpty());

        NfeCorrectionLetterService correction = new NfeCorrectionLetterServiceImpl(config, signer);

        for (ReturnNf.ProtNFe protNFe : returnQueryReceiptNfe.getProtNFe()) {
            correction.correctionLetter(protNFe.getInfProt().getChNFe(), "TESTE CARTA CORREÇÃO");
        }

        NfeCancelServiceImpl cancelService = new NfeCancelServiceImpl(config, signer);

        for (ReturnNf.ProtNFe protNFe : returnQueryReceiptNfe.getProtNFe()) {
            cancelService.cancelar(protNFe.getInfProt().getChNFe(), protNFe.getInfProt().getNProt());
        }
    }

    private static void interestedActor() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());
//
        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfeInterestedActorService service = new NfeInterestedActorServiceImpl(config, signer);

        System.out.println(service.interestedActor("22220911520224000140550010000035361187602778", "05213730345", null));
    }

    private static void queryGtin(String gtin) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());
//
        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfQueryGtinService service = new NfQueryGtinServiceImpl(config, signer);

        System.out.println(service.queryGtin(gtin));
    }

    private static void epec() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());
//
        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfeEpecService epecService = new NfeEpecServiceImpl(config, signer);

        Nf n = getNfe(config, 3532);
        ReturnNfeEpec returnepec = epecService.epec(n);

        System.out.println(returnepec);
    }

    private static void operationScienceNf() throws Exception {
        Collection<String> aks = Collections.singletonList("22220911520224000140550010000035361187602778");
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfeManifestationService service = new NfeManifestationServiceImpl(config, signer);
        for (String ak : aks) {
            System.out.println(service.science(ak));
        }
    }

    private static void correctionLetterNf() throws Exception {
        Collection<String> aks = Collections.singletonList("22220911520224000140550010000035101745364806");
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(config, signer);
        for (String ak : aks) {
            System.out.println(service.correctionLetter(ak, "LOREM IPSUM DOLOR SIT AMET"));
        }
    }

    private static void inutilizarNf() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfInutilizationService service = new NfeInutilizationServiceImpl(config, signer);
        System.out.println(service.inutilizar(1, 1, 1).getInfInut().getXMotivo());
    }

    private static void inutilizarNfce() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfInutilizationService service = new NfceInutilizationServiceImpl(config, signer);

        for (int i = 1; i <= 4664; i++) {
            System.out.println(service.inutilizar(1, i, i).getInfInut());
        }

    }

    private static void distributionNf() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfeDistributionService service = new NfeDistributionServiceImpl(config, signer);
        System.out.println(service.distributionUltNsu(0L));
    }

    private static void distributionNfAccessKey() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfeDistributionService service = new NfeDistributionServiceImpl(config, signer);
        System.out.println(service.distributionAccessKey("22220111520224000140550010000017131070903776"));
    }

    private static void distributionNfUniqueNsu() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfeDistributionService service = new NfeDistributionServiceImpl(config, signer);
        System.out.println(service.distributionUniqueNsu(78L));
    }

    private static void autorizarNf() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSigner signer = new DefaultXmlSigner();
        NfAuthorizationService service = new NfeAuthorizationServiceImpl(config, signer);

        System.out.println(service.authorization(Collections.singletonList(getNfe(config, 1))));
    }

    private static void autorizarNfc() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, "1", "115202241607220426225340");
        XMLSigner signer = new DefaultXmlSigner();
        NfAuthorizationService service = new NfceAuthorizationServiceImpl(config, signer);

        System.out.println(service.authorization(Collections.singletonList(getNfe(config, 4681, Model.NFCE))));
        System.out.println(service.authorization(Collections.singletonList(getNfe(config, 4682, Model.NFCE))));
        System.out.println(service.authorization(Collections.singletonList(getNfe(config, 4683, Model.NFCE))));
    }

    private static void consultarLote(String lote) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        NfReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(config, null);

        System.out.println(service.queryReceipt(lote));
    }

    private static void consultarLoteNfce(String lote) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        NfReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(config, null);

        System.out.println(service.queryReceipt(lote));
    }

    private static void queryStatusServiceNf() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        NfQueryStatusService service = new NfeQueryStatusServiceImpl(config, null);

        System.out.println(service.queryStatusService());
    }

    private static void queryStatusServiceNfc() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        NfQueryStatusService service = new NfceQueryStatusServiceImpl(config, null);

        System.out.println(service.queryStatusService());
    }

    private static void consultarProtocoloNfe(String accessKey) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        NfQueryProtocolService service = new NfeQueryProtocolServiceImpl(config, null);

        System.out.println(service.queryProtocol(accessKey));
    }

    private static void consultarProtocoloNfce(String accessKey) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        NfQueryProtocolService service = new NfceQueryProtocolServiceImpl(config, null);

        System.out.println(service.queryProtocol(accessKey));
    }

    private static Nf getNfe(NfConfig config, int number, Model model) {
        DFEnum.Codeable city = config.uf().getCities().stream().findAny().orElseThrow(RuntimeException::new);

        Nf nfe = Nf.builder().build();
        Nf.InfNFe infNFe = Nf.InfNFe.builder().build();

        Nf.InfNFe.Ide ide = Nf.InfNFe.Ide.builder().build();
        ide.setCuf(config.uf().getCode());
        ide.setNatOp("OPERACAO DE TESTE");
        ide.setSerie("1");
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
        nfe.setInfNFe(infNFe);

        return nfe;
    }

    private static Nf getNfe(NfConfig config, int number) {
        return getNfe(config, number, Model.NFE);
    }

    private static void cancelarNf(String accessKey, String protocol) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);

        XMLSigner signer = new DefaultXmlSigner();
        NfCancelService service = new NfeCancelServiceImpl(config, signer);
        System.out.println(service.cancelar(accessKey, protocol, "Quero Cancelar essa nota", "1").getRetEvento().get(0).getInfEvento().getXMotivo());
    }

    private static void cancelarNfc(final String accessKey) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);

        XMLSigner signer = new DefaultXmlSigner();
        NfCancelService service = new NfceCancelServiceImpl(config, signer);
        System.out.println(service.cancelar(accessKey));
    }

    private static void substituteCancelNfc(final String accessKey, final String accessKeyRef) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreamUtils.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        NfConfig config = new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);

        XMLSigner signer = new DefaultXmlSigner();
        NfSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(config, signer);
        System.out.println(service.substituteCancel(accessKey, accessKeyRef));
    }
}
