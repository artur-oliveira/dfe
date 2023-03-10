package br.inf.portalfiscal.nfe.wsdl.return_authorization.am.nfce.prod;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "NfeRetAutorizacao4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", wsdlLocation = "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeRetAutorizacao4?wsdl")
public class NfeRetAutorizacao4
        extends Service {

    private final static URL NFERETAUTORIZACAO4_WSDL_LOCATION;
    private final static WebServiceException NFERETAUTORIZACAO4_EXCEPTION;
    private final static QName NFERETAUTORIZACAO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NfeRetAutorizacao4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfce.sefaz.am.gov.br/nfce-services/services/NfeRetAutorizacao4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFERETAUTORIZACAO4_WSDL_LOCATION = url;
        NFERETAUTORIZACAO4_EXCEPTION = e;
    }

    public NfeRetAutorizacao4() {
        super(__getWsdlLocation(), NFERETAUTORIZACAO4_QNAME);
    }

    public NfeRetAutorizacao4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFERETAUTORIZACAO4_QNAME, features);
    }

    public NfeRetAutorizacao4(URL wsdlLocation) {
        super(wsdlLocation, NFERETAUTORIZACAO4_QNAME);
    }

    public NfeRetAutorizacao4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFERETAUTORIZACAO4_QNAME, features);
    }

    public NfeRetAutorizacao4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NfeRetAutorizacao4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (NFERETAUTORIZACAO4_EXCEPTION != null) {
            throw NFERETAUTORIZACAO4_EXCEPTION;
        }
        return NFERETAUTORIZACAO4_WSDL_LOCATION;
    }

    /**
     * @return returns NfeRetAutorizacao4Soap
     */
    @WebEndpoint(name = "NfeRetAutorizacao4Soap12")
    public NfeRetAutorizacao4Soap getNfeRetAutorizacao4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NfeRetAutorizacao4Soap12"), NfeRetAutorizacao4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NfeRetAutorizacao4Soap
     */
    @WebEndpoint(name = "NfeRetAutorizacao4Soap12")
    public NfeRetAutorizacao4Soap getNfeRetAutorizacao4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NfeRetAutorizacao4Soap12"), NfeRetAutorizacao4Soap.class, features);
    }

}
