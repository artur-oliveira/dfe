package br.inf.portalfiscal.mdfe.wsdl.event.svrs.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "MDFeRecepcaoEvento", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento", wsdlLocation = "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx?wsdl")
public class MDFeRecepcaoEvento
        extends Service {

    private static final URL MDFERECEPCAOEVENTO_WSDL_LOCATION;
    private static final WebServiceException MDFERECEPCAOEVENTO_EXCEPTION;
    private static final QName MDFERECEPCAOEVENTO_QNAME = new QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento", "MDFeRecepcaoEvento");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MDFERECEPCAOEVENTO_WSDL_LOCATION = url;
        MDFERECEPCAOEVENTO_EXCEPTION = e;
    }

    public MDFeRecepcaoEvento() {
        super(__getWsdlLocation(), MDFERECEPCAOEVENTO_QNAME);
    }

    public MDFeRecepcaoEvento(WebServiceFeature... features) {
        super(__getWsdlLocation(), MDFERECEPCAOEVENTO_QNAME, features);
    }

    public MDFeRecepcaoEvento(URL wsdlLocation) {
        super(wsdlLocation, MDFERECEPCAOEVENTO_QNAME);
    }

    public MDFeRecepcaoEvento(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MDFERECEPCAOEVENTO_QNAME, features);
    }

    public MDFeRecepcaoEvento(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MDFeRecepcaoEvento(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns MDFeRecepcaoEventoSoap12
     */
    @WebEndpoint(name = "MDFeRecepcaoEventoSoap12")
    public MDFeRecepcaoEventoSoap12 getMDFeRecepcaoEventoSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento", "MDFeRecepcaoEventoSoap12"), MDFeRecepcaoEventoSoap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns MDFeRecepcaoEventoSoap12
     */
    @WebEndpoint(name = "MDFeRecepcaoEventoSoap12")
    public MDFeRecepcaoEventoSoap12 getMDFeRecepcaoEventoSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento", "MDFeRecepcaoEventoSoap12"), MDFeRecepcaoEventoSoap12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MDFERECEPCAOEVENTO_EXCEPTION != null) {
            throw MDFERECEPCAOEVENTO_EXCEPTION;
        }
        return MDFERECEPCAOEVENTO_WSDL_LOCATION;
    }

}
