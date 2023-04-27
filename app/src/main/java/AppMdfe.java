import br.inf.portalfiscal.mdfe.classes.TUf;
import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxMdfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.city.CityPI;
import com.softart.dfe.enums.mdfe.event.MdfePaymentOperationShippingType;
import com.softart.dfe.enums.mdfe.event.MdfePaymentOperationTypeIndicator;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;
import com.softart.dfe.enums.mdfe.identification.MdfeEmitterType;
import com.softart.dfe.enums.mdfe.identification.MdfeModal;
import com.softart.dfe.enums.mdfe.identification.MdfeProcessEmissionType;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.models.mdfe.event.MdfeDfeInclusion;
import com.softart.dfe.models.mdfe.event.MdfePaymentModification;
import com.softart.dfe.models.mdfe.event.MdfePaymentOperation;
import com.softart.dfe.models.mdfe.reception_sync.Mdfe;
import com.softart.dfe.services.mdfe.distribution.MdfeDistributionService;
import com.softart.dfe.services.mdfe.distribution.MdfeDistributionServiceImpl;
import com.softart.dfe.services.mdfe.event.MdfeEventService;
import com.softart.dfe.services.mdfe.event.MdfeEventServiceImpl;
import com.softart.dfe.services.mdfe.query_receipt.MdfeQueryReceiptService;
import com.softart.dfe.services.mdfe.query_receipt.MdfeQueryReceiptServiceImpl;
import com.softart.dfe.services.mdfe.query_situation.MdfeQuerySituationService;
import com.softart.dfe.services.mdfe.query_situation.MdfeQuerySituationServiceImpl;
import com.softart.dfe.services.mdfe.query_unclosed.MdfeQueryUnclosedService;
import com.softart.dfe.services.mdfe.query_unclosed.MdfeQueryUnclosedServiceImpl;
import com.softart.dfe.services.mdfe.reception_sync.MdfeReceptionSyncService;
import com.softart.dfe.services.mdfe.reception_sync.MdfeReceptionSyncServiceImpl;
import com.softart.dfe.services.mdfe.status_service.MdfeStatusServiceService;
import com.softart.dfe.services.mdfe.status_service.MdfeStatusServiceServiceImpl;

import java.util.Collections;

public final class AppMdfe {
    public static void main(String[] args) throws Exception {
        System.setProperty("com.softart.certificate.path", "path/to/certificate.pfx");
        System.setProperty("com.softart.certificate.password", "*");
        System.setProperty("com.softart.storage.mdfe.logxml", "false");
        System.setProperty("com.softart.handler.log.request", "false");
        System.setProperty("com.softart.handler.log.response", "false");

//        queryUnclosed();
//        statusService();
//        querySituation("22221211520224000140580010000005611194025753");
//        queryReceipt("222212115202240");
        distribution();
//        transportConfirmation("22221211520224000140580010000005611194025753");
//        driverInclusion("22221211520224000140580010000005611194025753", "Artur Oliveira", "05213730345");
//        paymentOperation("22221211520224000140580010000005611194025753");
//        dfeInclusion("22221211520224000140580010000005611194025753");
//        paymentModification("22221211520224000140580010000005611194025753");
//        close("22221211520224000140580010000005611194025753");
//        cancel("22221211520224000140580010000005611194025753");
//        receptionSync();
    }

    public static Mdfe getMdfe(int number, MdfeConfig config) {
        CityPI c = CityPI.PI_TERESINA;
        return Mdfe.builder().infMDFe(Mdfe.InfMDFe
                        .builder()
                        .ide(Mdfe.InfMDFe
                                .Ide
                                .builder()
                                .cuf(config.uf().getCode())
                                .mod(Model.MDFE.getCode())
                                .tpEmit(MdfeEmitterType.CODE_2.getCode())
                                .serie("1")
                                .nmdf(String.valueOf(number))
                                .tpAmb(config.environment().getCode())
                                .tpEmis(MdfeEmissionType.NORMAL.getCode())
                                .procEmi(MdfeProcessEmissionType.APPLICATION.getCode())
                                .tpEmis(config.emission().getCode())
                                .infMunCarrega(Collections.singletonList(Mdfe.InfMDFe.Ide.InfMunCarrega.builder().cMunCarrega(c.getCode()).xMunCarrega(c.getCode()).build()))
                                .modal(MdfeModal.RODOVIARIO.getCode())
                                .ufIni(TUf.valueOf(c.getUf().name()))
                                .ufFim(TUf.valueOf(c.getUf().name()))
                                .build())
                        .emit(Mdfe.InfMDFe.Emit
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .xFant("Teste")
                                .ie("194739350")
                                .enderEmit(Mdfe.InfMDFe.Emit.TEndeEmi
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
                        .infModal(Mdfe.InfMDFe.InfModal
                                .builder()
                                .rodo(Mdfe.InfMDFe.InfModal.Rodo
                                        .builder()
                                        .infANTT(Mdfe.InfMDFe.InfModal.Rodo.InfANTT.builder().rntrc("12345678").build())
                                        .veicTracao(Mdfe.InfMDFe.InfModal.Rodo.VeicTracao
                                                .builder()
                                                .tara("555")
                                                .condutor(Collections.singletonList(Mdfe.InfMDFe.InfModal.Rodo.VeicTracao.Condutor
                                                        .builder()
                                                        .xNome("Artur COndutor")
                                                        .cpf("05213730345")
                                                        .build()))
                                                .tpRod("06")
                                                .tpCar("01")
                                                .uf(TUf.PI)
                                                .placa("LVL5338")
                                                .build())
                                        .build())
                                .build())
                        .infDoc(Mdfe.InfMDFe.InfDoc
                                .builder()
                                .infMunDescarga(Collections.singletonList(Mdfe.InfMDFe.InfDoc.InfMunDescarga
                                        .builder()
                                        .cMunDescarga(c.getCode())
                                        .xMunDescarga(c.getDescription())
                                        .infNFe(Collections.singletonList(Mdfe.InfMDFe.InfDoc.InfMunDescarga.InfNFe.builder().chNFe("22221211520224000140550010000036611779691887").build()))
                                        .build()))

                                .build())
                        .tot(Mdfe.InfMDFe.Tot.builder().cUnid("01").qnFe("1").qcTe("0").qmdFe("0").qCarga("13.0000").vCarga("160.00").build())
                        .infRespTec(Mdfe.InfMDFe.TRespTec.builder()
                                .cnpj("11520224000140")
                                .xContato("TARTIGRADO TECNOLOGIA TLDA")
                                .email("falecom@tartigrado.com")
                                .fone("86988033430")
                                .build())
                        .build())
                .build();
    }

    public static void queryUnclosed() throws Exception {
        MdfeQueryUnclosedService service = new MdfeQueryUnclosedServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));

        System.out.println(service.queryUnclosed());
    }

    public static void statusService() throws Exception {
        MdfeStatusServiceService service = new MdfeStatusServiceServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));

        System.out.println(service.statusService());
    }

    public static void querySituation(String accessKey) throws Exception {
        MdfeQuerySituationService service = new MdfeQuerySituationServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));

        System.out.println(service.querySituation(accessKey));
    }

    public static void transportConfirmation(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));

        System.out.println(service.transportConfirmation(accessKey));
    }

    public static void cancel(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));

        System.out.println(service.cancel(accessKey));
    }


    public static void receptionSync() throws Exception {
        MdfeReceptionSyncService service = new MdfeReceptionSyncServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));

        System.out.println(service.receptionSync(getMdfe(1, service.getConfig())));
    }

    public static void close(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));

        System.out.println(service.close(accessKey, UF.PI.getCode(), CityPI.PI_TERESINA.getCode()));
    }

    public static void driverInclusion(String accessKey, String name, String cpf) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));
        System.out.println(service.driverInclusion(accessKey, name, cpf));
    }

    public static void dfeInclusion(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));
        System.out.println(service.dfeInclusion(accessKey, CityPI.PI_TERESINA.getCode(), CityPI.PI_TERESINA.getDescription(),
                Collections.singletonList(MdfeDfeInclusion.InfEvento.DetEvento.EvIncDFeMDFe.InfDoc
                        .builder()
                        .chNFe("22221211520224000140550010000036611779691887")
                        .cMunDescarga(CityPI.PI_TERESINA.getCode())
                        .xMunDescarga(CityPI.PI_TERESINA.getCode())
                        .build())));
    }

    public static void paymentOperation(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));
        System.out.println(service.paymentOperation(accessKey,
                MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfViagens
                        .builder()
                        .nroViagem("12345")
                        .qtdViagens("12345")
                        .build(),
                Collections.singletonList(MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag
                        .builder()
                        .xNome("Artur")
                        .comp(Collections.singletonList(MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag.Comp
                                .builder()
                                .tpComp(MdfePaymentOperationShippingType.CODE_99.getCode())
                                .vComp("1000")
                                .xComp("KEK")
                                .build()))
                        .indPag(MdfePaymentOperationTypeIndicator.IN_CASH.getCode())
                        .infBanc(MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag.InfBanc
                                .builder()
                                .codBanco("260")
                                .codAgencia("12345678")
                                .build())
                        .vContrato("1000")
                        .cpf("05213730345")
                        .build())));
    }

    public static void paymentModification(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));
        System.out.println(service.paymentModification(accessKey,
                Collections.singletonList(MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag
                        .builder()
                        .xNome("Artur")
                        .comp(Collections.singletonList(MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag.Comp
                                .builder()
                                .tpComp(MdfePaymentOperationShippingType.CODE_99.getCode())
                                .vComp("1000")
                                .xComp("KEK")
                                .build()))
                        .indPag(MdfePaymentOperationTypeIndicator.IN_CASH.getCode())
                        .infBanc(MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag.InfBanc
                                .builder()
                                .codBanco("260")
                                .codAgencia("12345678")
                                .build())
                        .vContrato("1000")
                        .cpf("05213730345")
                        .build())));
    }

    public static void queryReceipt(String receipt) throws Exception {
        MdfeQueryReceiptService service = new MdfeQueryReceiptServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));

        System.out.println(service.queryReceipt(receipt));
    }


    private static void distribution() throws Exception {
        MdfeDistributionService service = new MdfeDistributionServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()));
        System.out.println(service.distribution(0));
    }
}
