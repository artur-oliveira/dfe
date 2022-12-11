import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxMdfeConfigImpl;
import com.softart.dfe.components.security.signer.XmlSignerFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.city.CityPI;
import com.softart.dfe.enums.mdfe.event.MdfePaymentOperationShippingType;
import com.softart.dfe.enums.mdfe.event.MdfePaymentOperationTypeIndicator;
import com.softart.dfe.models.mdfe.event.MdfeDfeInclusion;
import com.softart.dfe.models.mdfe.event.MdfePaymentModification;
import com.softart.dfe.models.mdfe.event.MdfePaymentOperation;
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
import com.softart.dfe.services.mdfe.status_service.MdfeStatusServiceService;
import com.softart.dfe.services.mdfe.status_service.MdfeStatusServiceServiceImpl;

import java.util.Collections;

public class AppMdfe {
    public static void main(String[] args) throws Exception {
        System.setProperty("com.softart.certificate.path", "/home/artur/Documentos/Certificate/tartigrado.pfx");
        System.setProperty("com.softart.certificate.password", "22Rev");
        System.setProperty("com.softart.storage.mdfe.logxml", "false");
        System.setProperty("com.softart.handler.log.request", "false");
        System.setProperty("com.softart.handler.log.response", "false");

//        queryUnclosed();
//        statusService();
//        querySituation("22221211520224000140580010000005611194025753");
//        queryReceipt("222212115202240");
//        distribution();
//        transportConfirmation("22221211520224000140580010000005611194025753");
//        driverInclusion("22221211520224000140580010000005611194025753", "Artur Oliveira", "05213730345");
//        paymentOperation("22221211520224000140580010000005611194025753");
//        dfeInclusion("22221211520224000140580010000005611194025753");
//        paymentModification("22221211520224000140580010000005611194025753");
        close("22221211520224000140580010000005611194025753");
        cancel("22221211520224000140580010000005611194025753");
    }


    public static void queryUnclosed() throws Exception {
        MdfeQueryUnclosedService service = new MdfeQueryUnclosedServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());

        System.out.println(service.queryUnclosed());
        ;
    }

    public static void statusService() throws Exception {
        MdfeStatusServiceService service = new MdfeStatusServiceServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());

        System.out.println(service.statusService());
        ;
    }

    public static void querySituation(String accessKey) throws Exception {
        MdfeQuerySituationService service = new MdfeQuerySituationServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());

        System.out.println(service.querySituation(accessKey));
        ;
    }

    public static void transportConfirmation(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());

        System.out.println(service.transportConfirmation(accessKey));
        ;
    }

    public static void cancel(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());

        System.out.println(service.cancel(accessKey));
        ;
    }

    public static void close(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());

        System.out.println(service.close(accessKey, UF.PI.getCode(), CityPI.PI_TERESINA.getCode()));
        ;
    }

    public static void driverInclusion(String accessKey, String name, String cpf) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());
        System.out.println(service.driverInclusion(accessKey, name, cpf));
    }

    public static void dfeInclusion(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());
        System.out.println(service.dfeInclusion(accessKey, CityPI.PI_TERESINA.getCode(), CityPI.PI_TERESINA.getDescription(),
                Collections.singletonList(MdfeDfeInclusion.InfEvento.DetEvento.EvIncDFeMDFe.InfDoc
                        .builder()
                        .chNFe("22221211520224000140550010000036611779691887")
                        .cMunDescarga(CityPI.PI_TERESINA.getCode())
                        .xMunDescarga(CityPI.PI_TERESINA.getCode())
                        .build())));
    }

    public static void paymentOperation(String accessKey) throws Exception {
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());
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
        MdfeEventService service = new MdfeEventServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());
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
        MdfeQueryReceiptService service = new MdfeQueryReceiptServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());

        System.out.println(service.queryReceipt(receipt));
    }


    private static void distribution() throws Exception {
        MdfeDistributionService service = new MdfeDistributionServiceImpl(new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance()), XmlSignerFactory.getInstance());
        System.out.println(service.distributionUltNsu(0));
    }
}
