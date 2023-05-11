package br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.am.nfce.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "RecepcaoEvento4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", wsdlLocation = "https://homnfce.sefaz.am.gov.br/nfce-services/services/RecepcaoEvento4?wsdl")
public class RecepcaoEvento4
        extends Service {

    private static final URL RECEPCAOEVENTO4_WSDL_LOCATION;
    private static final WebServiceException RECEPCAOEVENTO4_EXCEPTION;
    private static final QName RECEPCAOEVENTO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "RecepcaoEvento4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homnfce.sefaz.am.gov.br/nfce-services/services/RecepcaoEvento4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RECEPCAOEVENTO4_WSDL_LOCATION = url;
        RECEPCAOEVENTO4_EXCEPTION = e;
    }

    public RecepcaoEvento4() {
        super(__getWsdlLocation(), RECEPCAOEVENTO4_QNAME);
    }

    public RecepcaoEvento4(WebServiceFeature... features) {
        super(__getWsdlLocation(), RECEPCAOEVENTO4_QNAME, features);
    }

    public RecepcaoEvento4(URL wsdlLocation) {
        super(wsdlLocation, RECEPCAOEVENTO4_QNAME);
    }

    public RecepcaoEvento4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RECEPCAOEVENTO4_QNAME, features);
    }

    public RecepcaoEvento4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RecepcaoEvento4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns RecepcaoEvento4Soap
     */
    @WebEndpoint(name = "RecepcaoEvento4Soap12")
    public RecepcaoEvento4Soap getRecepcaoEvento4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "RecepcaoEvento4Soap12"), RecepcaoEvento4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns RecepcaoEvento4Soap
     */
    @WebEndpoint(name = "RecepcaoEvento4Soap12")
    public RecepcaoEvento4Soap getRecepcaoEvento4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "RecepcaoEvento4Soap12"), RecepcaoEvento4Soap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RECEPCAOEVENTO4_EXCEPTION != null) {
            throw RECEPCAOEVENTO4_EXCEPTION;
        }
        return RECEPCAOEVENTO4_WSDL_LOCATION;
    }

}
