package br.inf.portalfiscal.nfe.wsdl.status_service.am.hom;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "NFeStatusServico4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", wsdlLocation = "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx?wsdl")
public class NFeStatusServico4
        extends Service {

    private final static URL NFESTATUSSERVICO4_WSDL_LOCATION;
    private final static WebServiceException NFESTATUSSERVICO4_EXCEPTION;
    private final static QName NFESTATUSSERVICO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NFeStatusServico4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFESTATUSSERVICO4_WSDL_LOCATION = url;
        NFESTATUSSERVICO4_EXCEPTION = e;
    }

    public NFeStatusServico4() {
        super(__getWsdlLocation(), NFESTATUSSERVICO4_QNAME);
    }

    public NFeStatusServico4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFESTATUSSERVICO4_QNAME, features);
    }

    public NFeStatusServico4(URL wsdlLocation) {
        super(wsdlLocation, NFESTATUSSERVICO4_QNAME);
    }

    public NFeStatusServico4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFESTATUSSERVICO4_QNAME, features);
    }

    public NFeStatusServico4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeStatusServico4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (NFESTATUSSERVICO4_EXCEPTION != null) {
            throw NFESTATUSSERVICO4_EXCEPTION;
        }
        return NFESTATUSSERVICO4_WSDL_LOCATION;
    }

    /**
     * @return returns NFeStatusServico4Soap
     */
    @WebEndpoint(name = "NFeStatusServico4Soap")
    public NFeStatusServico4Soap getNFeStatusServico4Soap() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NFeStatusServico4Soap"), NFeStatusServico4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeStatusServico4Soap
     */
    @WebEndpoint(name = "NFeStatusServico4Soap")
    public NFeStatusServico4Soap getNFeStatusServico4Soap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NFeStatusServico4Soap"), NFeStatusServico4Soap.class, features);
    }

    /**
     * @return returns NFeStatusServico4Soap
     */
    @WebEndpoint(name = "NFeStatusServico4Soap12")
    public NFeStatusServico4Soap getNFeStatusServico4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NFeStatusServico4Soap12"), NFeStatusServico4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeStatusServico4Soap
     */
    @WebEndpoint(name = "NFeStatusServico4Soap12")
    public NFeStatusServico4Soap getNFeStatusServico4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NFeStatusServico4Soap12"), NFeStatusServico4Soap.class, features);
    }

}
