package br.inf.portalfiscal.nfe.wsdl.inutilization.mt.prod;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "NfeInutilizacao4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", wsdlLocation = "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao4?wsdl")
public class NfeInutilizacao4
        extends Service {

    private final static URL NFEINUTILIZACAO4_WSDL_LOCATION;
    private final static WebServiceException NFEINUTILIZACAO4_EXCEPTION;
    private final static QName NFEINUTILIZACAO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", "NfeInutilizacao4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao4?wsdl");
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
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NfeInutilizacao4Soap
     */
    @WebEndpoint(name = "NfeInutilizacao4Soap12")
    public NfeInutilizacao4Soap getNfeInutilizacao4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", "NfeInutilizacao4Soap12"), NfeInutilizacao4Soap.class, features);
    }

    /**
     * @return returns NfeInutilizacao4Soap
     */
    @WebEndpoint(name = "NfeInutilizacao4Soap")
    public NfeInutilizacao4Soap getNfeInutilizacao4Soap() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", "NfeInutilizacao4Soap"), NfeInutilizacao4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NfeInutilizacao4Soap
     */
    @WebEndpoint(name = "NfeInutilizacao4Soap")
    public NfeInutilizacao4Soap getNfeInutilizacao4Soap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", "NfeInutilizacao4Soap"), NfeInutilizacao4Soap.class, features);
    }

}
