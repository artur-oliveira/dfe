package br.inf.portalfiscal.nfe.wsdl.inutilization.am.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NfeInutilizacao4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", wsdlLocation = "https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao4?wsdl")
public class NfeInutilizacao4
        extends Service {

    private static final URL NFEINUTILIZACAO4_WSDL_LOCATION;
    private static final WebServiceException NFEINUTILIZACAO4_EXCEPTION;
    private static final QName NFEINUTILIZACAO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", "NfeInutilizacao4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFEINUTILIZACAO4_WSDL_LOCATION = url;
        NFEINUTILIZACAO4_EXCEPTION = e;
    }

    public NfeInutilizacao4() {
        super(__getWsdlLocation(), NFEINUTILIZACAO4_QNAME);
    }

    public NfeInutilizacao4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFEINUTILIZACAO4_QNAME, features);
    }

    public NfeInutilizacao4(URL wsdlLocation) {
        super(wsdlLocation, NFEINUTILIZACAO4_QNAME);
    }

    public NfeInutilizacao4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFEINUTILIZACAO4_QNAME, features);
    }

    public NfeInutilizacao4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NfeInutilizacao4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (NFEINUTILIZACAO4_EXCEPTION != null) {
            throw NFEINUTILIZACAO4_EXCEPTION;
        }
        return NFEINUTILIZACAO4_WSDL_LOCATION;
    }

    /**
     * @return returns NfeInutilizacao4Soap
     */
    @WebEndpoint(name = "NfeInutilizacao4Soap12")
    public NfeInutilizacao4Soap getNfeInutilizacao4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", "NfeInutilizacao4Soap12"), NfeInutilizacao4Soap.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NfeInutilizacao4Soap
     */
    @WebEndpoint(name = "NfeInutilizacao4Soap12")
    public NfeInutilizacao4Soap getNfeInutilizacao4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", "NfeInutilizacao4Soap12"), NfeInutilizacao4Soap.class, features);
    }

}
