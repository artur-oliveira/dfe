package br.inf.portalfiscal.nfe.wsdl.status_service.mt.prod;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "NfeStatusServico4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", wsdlLocation = "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico4?wsdl")
public class NfeStatusServico4
        extends Service {

    private final static URL NFESTATUSSERVICO4_WSDL_LOCATION;
    private final static WebServiceException NFESTATUSSERVICO4_EXCEPTION;
    private final static QName NFESTATUSSERVICO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NfeStatusServico4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFESTATUSSERVICO4_WSDL_LOCATION = url;
        NFESTATUSSERVICO4_EXCEPTION = e;
    }

    public NfeStatusServico4() {
        super(__getWsdlLocation(), NFESTATUSSERVICO4_QNAME);
    }

    public NfeStatusServico4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFESTATUSSERVICO4_QNAME, features);
    }

    public NfeStatusServico4(URL wsdlLocation) {
        super(wsdlLocation, NFESTATUSSERVICO4_QNAME);
    }

    public NfeStatusServico4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFESTATUSSERVICO4_QNAME, features);
    }

    public NfeStatusServico4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NfeStatusServico4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (NFESTATUSSERVICO4_EXCEPTION != null) {
            throw NFESTATUSSERVICO4_EXCEPTION;
        }
        return NFESTATUSSERVICO4_WSDL_LOCATION;
    }

    /**
     * @return returns NfeStatusServico4Soap
     */
    @WebEndpoint(name = "NfeStatusServico4Soap")
    public NfeStatusServico4Soap getNfeStatusServico4Soap() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NfeStatusServico4Soap"), NfeStatusServico4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NfeStatusServico4Soap
     */
    @WebEndpoint(name = "NfeStatusServico4Soap")
    public NfeStatusServico4Soap getNfeStatusServico4Soap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NfeStatusServico4Soap"), NfeStatusServico4Soap.class, features);
    }

    /**
     * @return returns NfeStatusServico4Soap
     */
    @WebEndpoint(name = "NfeStatusServico4Soap12")
    public NfeStatusServico4Soap getNfeStatusServico4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NfeStatusServico4Soap12"), NfeStatusServico4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NfeStatusServico4Soap
     */
    @WebEndpoint(name = "NfeStatusServico4Soap12")
    public NfeStatusServico4Soap getNfeStatusServico4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NfeStatusServico4Soap12"), NfeStatusServico4Soap.class, features);
    }

}
