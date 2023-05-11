package br.inf.portalfiscal.nfe.wsdl.event_interested_actor.pe.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Servico destinado a recepcao de mensagens de evento de NFe
 * <p>
 * <p>
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NFeRecepcaoEvento4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", wsdlLocation = "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeRecepcaoEvento4?wsdl")
public class NFeRecepcaoEvento4
        extends Service {

    private static final URL NFERECEPCAOEVENTO4_WSDL_LOCATION;
    private static final WebServiceException NFERECEPCAOEVENTO4_EXCEPTION;
    private static final QName NFERECEPCAOEVENTO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "NFeRecepcaoEvento4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeRecepcaoEvento4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFERECEPCAOEVENTO4_WSDL_LOCATION = url;
        NFERECEPCAOEVENTO4_EXCEPTION = e;
    }

    public NFeRecepcaoEvento4() {
        super(__getWsdlLocation(), NFERECEPCAOEVENTO4_QNAME);
    }

    public NFeRecepcaoEvento4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFERECEPCAOEVENTO4_QNAME, features);
    }

    public NFeRecepcaoEvento4(URL wsdlLocation) {
        super(wsdlLocation, NFERECEPCAOEVENTO4_QNAME);
    }

    public NFeRecepcaoEvento4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFERECEPCAOEVENTO4_QNAME, features);
    }

    public NFeRecepcaoEvento4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeRecepcaoEvento4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns NFeRecepcaoEvento4Soap12
     */
    @WebEndpoint(name = "NFeRecepcaoEvento4ServicePort")
    public NFeRecepcaoEvento4Soap12 getNFeRecepcaoEvento4ServicePort() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "NFeRecepcaoEvento4ServicePort"), NFeRecepcaoEvento4Soap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeRecepcaoEvento4Soap12
     */
    @WebEndpoint(name = "NFeRecepcaoEvento4ServicePort")
    public NFeRecepcaoEvento4Soap12 getNFeRecepcaoEvento4ServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "NFeRecepcaoEvento4ServicePort"), NFeRecepcaoEvento4Soap12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NFERECEPCAOEVENTO4_EXCEPTION != null) {
            throw NFERECEPCAOEVENTO4_EXCEPTION;
        }
        return NFERECEPCAOEVENTO4_WSDL_LOCATION;
    }

}
