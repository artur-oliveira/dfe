import br.inf.portalfiscal.cte.send.TUf;
import com.softart.dfe.components.internal.PfxKeyStoreInfoImpl;
import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.components.security.CertificateChainFactory;
import com.softart.dfe.components.security.DefaultXmlSigner;
import com.softart.dfe.enums.cte.CteGtvKind;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.xml.XMLSigner;
import com.softart.dfe.models.cte.event.CteCorrectionLetter;
import com.softart.dfe.models.cte.event.CteGtv;
import com.softart.dfe.models.cte.inutilization.CteReturnInutilization;
import com.softart.dfe.models.internal.security.Certificate;
import com.softart.dfe.services.cte.distribution.CteDistributionServiceImpl;
import com.softart.dfe.services.cte.event.CteEventService;
import com.softart.dfe.services.cte.event.CteEventServiceImpl;
import com.softart.dfe.services.cte.inutilization.CteInutilizationServiceImpl;
import com.softart.dfe.services.cte.inutilization.CteOsInutilizationServiceImpl;
import com.softart.dfe.services.cte.inutilization.InutilizationService;
import com.softart.dfe.services.cte.query_situation.CteQuerySituationServiceImpl;
import com.softart.dfe.services.cte.status_service.CteStatusServiceServiceImpl;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.InputStreams;

import java.util.Collection;
import java.util.Collections;

public final class AppCte {

    public static void main(String[] args) throws Exception {
//        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
//        statusServico(Arrays.asList(UF.PI, UF.BA, UF.RS));
//        distribution();
//        querySituation("22221011520224000140570010000002881903321274");
//        cancelar("22221011520224000140570010000002881903321274");
//        cartaCorrecao("22221011520224000140570010000002881903321274");
//        comprovanteEntrega("22221011520224000140570010000002881903321274");
//        cancelarComprovanteEntrega("22221011520224000140570010000002881903321274", "322220000001422");
//        gtv("22221011520224000140570010000002881903321274");
//        provisionInDisagreement("22221211520224000140570010000003191604007441", "QUERO TESTAR ISSO AQUI");
        multimodal("22221211520224000140570010000003191604007441", "QUERO TESTAR ISSO AQUI", "1");
//        inutilizarCte();
//        inutilizarCteOs();
    }

    private static void cancelar(String accessKey) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        System.out.println(new CteEventServiceImpl(new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info), new DefaultXmlSigner()).cancel(accessKey));

    }

    private static void cartaCorrecao(String accessKey) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao correction = CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                .builder()
                .campoAlterado("xNome")
                .grupoAlterado("emit")
                .valorAlterado("TESTE")
                .build();

        System.out.println(new CteEventServiceImpl(new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info), new DefaultXmlSigner()).correctionLetter(accessKey, correction));

    }

    private static void comprovanteEntrega(String accessKey) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());


        System.out.println(new CteEventServiceImpl(new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info), new DefaultXmlSigner()).deliveryReceipt(accessKey, "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=", "05213730345", "Artur", "-5.076913", "-42.801835", Collections.singletonList("22220911520224000140550010000035391879129974")));

    }

    private static void cancelarComprovanteEntrega(String accessKey, String deliveryReceipt) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        CteEventService service = new CteEventServiceImpl(new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info), new DefaultXmlSigner());

        System.out.println(service.cancelDeliveryReceipt(accessKey, deliveryReceipt));

    }

    private static void provisionInDisagreement(String ak, String obs) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        CteEventService service = new CteEventServiceImpl(new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info), new DefaultXmlSigner());

        System.out.println(service.provisionDisagreement(ak, obs));
    }

    private static void multimodal(String ak, String reg, String doc) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        CteEventService service = new CteEventServiceImpl(new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info), new DefaultXmlSigner());

        System.out.println(service.multimodal(ak, reg, doc));
    }


    private static void gtv(String accessKey) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        CteEventService service = new CteEventServiceImpl(new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info), new DefaultXmlSigner());
        System.out.println(service.gtv(accessKey,
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKind.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build()));

    }

    private static void distribution() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        System.out.println(new CteDistributionServiceImpl(new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info), null).distributionUltNsu(0L));

    }

    private static void querySituation(String accessKey) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        CteConfig config = new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info);
        XMLSigner signer = new DefaultXmlSigner();
        System.out.println(new CteQuerySituationServiceImpl(config, signer).querySituation(accessKey));
    }


    private static void statusServico(Collection<UF> states) throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        for (UF state : states) {
            try {
                System.out.println(new CteStatusServiceServiceImpl(new PfxCteConfigImpl(state, "11520224000140", Environment.HOMOLOGATION, info), null).statusService());
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                System.out.println(new CteStatusServiceServiceImpl(new PfxCteConfigImpl(state, "11520224000140", Environment.PRODUCTION, info), null).statusService());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void inutilizarCte() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());
        XMLSigner signer = new DefaultXmlSigner();

        for (UF state : UF.states()) {
            try {
                System.out.println(new CteInutilizationServiceImpl(new PfxCteConfigImpl(state, "11520224000140", Environment.HOMOLOGATION, info), signer).inutilizar(1, 1, 1));
            } catch (Exception ignored) {
            }
        }

    }

    private static void inutilizarCteOs() throws Exception {
        KeyStoreInfo info = new PfxKeyStoreInfoImpl(InputStreams.newFileInputStream("/home/artur/Documentos/Certificate/tartigrado.pfx"), "22Rev", InputStreams.newByteArrayInputStream(CertificateChainFactory.getInstance().generate(Certificate.builder().build())), CertificateChainFactory.getInstance().getPassword());

        CteConfig config = new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, info);
        XMLSigner signer = new DefaultXmlSigner();
        InutilizationService service = new CteOsInutilizationServiceImpl(config, signer);

        CteReturnInutilization ret = service.inutilizar(1, 1, 2);
        System.out.println(ret);
    }

}

