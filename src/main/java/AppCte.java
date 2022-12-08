import com.softart.dfe.components.internal.PfxKeyStoreInfoImpl;
import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.components.security.CertificateChainFactory;
import com.softart.dfe.components.security.DefaultXmlSigner;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.xml.XMLSigner;
import com.softart.dfe.models.cte.event.CteCorrectionLetter;
import com.softart.dfe.models.cte.inutilization.CteReturnInutilization;
import com.softart.dfe.models.internal.security.Certificate;
import com.softart.dfe.services.cte.distribution.CteDistributionServiceImpl;
import com.softart.dfe.services.cte.event.CteEventServiceImpl;
import com.softart.dfe.services.cte.inutilization.CteInutilizationServiceImpl;
import com.softart.dfe.services.cte.inutilization.CteOsInutilizationServiceImpl;
import com.softart.dfe.services.cte.inutilization.InutilizationService;
import com.softart.dfe.services.cte.query_situation.CteQuerySituationServiceImpl;
import com.softart.dfe.services.cte.status_service.CteStatusServiceServiceImpl;
import com.softart.dfe.util.InputStreams;

import java.util.Collection;

public final class AppCte {

    public static void main(String[] args) throws Exception {
//        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
//        statusServico(Arrays.asList(UF.PI, UF.BA, UF.RS));
//        distribution();
        querySituation("22221011520224000140570010000002881903321274");
//        cancelar("22221011520224000140570010000002881903321274");
//        cartaCorrecao("22221011520224000140570010000002881903321274");
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

