package br.inf.portalfiscal.nfe.wsdl.status_service.mt.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NfeStatusServico4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", wsdlLocation = "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico4?wsdl")
public class NfeStatusServico4
        extends Service {

    private static final URL NFESTATUSSERVICO4_WSDL_LOCATION;
    private static final WebServiceException NFESTATUSSERVICO4_EXCEPTION;
    private static final QName NFESTATUSSERVICO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NfeStatusServico4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico4?wsdl");
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
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
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
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NfeStatusServico4Soap
     */
    @WebEndpoint(name = "NfeStatusServico4Soap12")
    public NfeStatusServico4Soap getNfeStatusServico4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NfeStatusServico4Soap12"), NfeStatusServico4Soap.class, features);
    }

}
