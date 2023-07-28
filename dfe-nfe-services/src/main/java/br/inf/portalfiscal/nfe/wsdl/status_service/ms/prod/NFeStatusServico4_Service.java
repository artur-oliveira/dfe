package br.inf.portalfiscal.nfe.wsdl.status_service.ms.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NFeStatusServico4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", wsdlLocation = "https://nfe.sefaz.ms.gov.br/ws/NFeStatusServico4?wsdl")
public class NFeStatusServico4_Service
        extends Service {

    private static final URL NFESTATUSSERVICO4_WSDL_LOCATION;
    private static final WebServiceException NFESTATUSSERVICO4_EXCEPTION;
    private static final QName NFESTATUSSERVICO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NFeStatusServico4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.sefaz.ms.gov.br/ws/NFeStatusServico4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFESTATUSSERVICO4_WSDL_LOCATION = url;
        NFESTATUSSERVICO4_EXCEPTION = e;
    }

    public NFeStatusServico4_Service() {
        super(__getWsdlLocation(), NFESTATUSSERVICO4_QNAME);
    }

    public NFeStatusServico4_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFESTATUSSERVICO4_QNAME, features);
    }

    public NFeStatusServico4_Service(URL wsdlLocation) {
        super(wsdlLocation, NFESTATUSSERVICO4_QNAME);
    }

    public NFeStatusServico4_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFESTATUSSERVICO4_QNAME, features);
    }

    public NFeStatusServico4_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeStatusServico4_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (NFESTATUSSERVICO4_EXCEPTION != null) {
            throw NFESTATUSSERVICO4_EXCEPTION;
        }
        return NFESTATUSSERVICO4_WSDL_LOCATION;
    }

    /**
     * @return returns NFeStatusServico4
     */
    @WebEndpoint(name = "nfeStatusServico4Soap12")
    public NFeStatusServico4 getNfeStatusServico4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "nfeStatusServico4Soap12"), NFeStatusServico4.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeStatusServico4
     */
    @WebEndpoint(name = "nfeStatusServico4Soap12")
    public NFeStatusServico4 getNfeStatusServico4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "nfeStatusServico4Soap12"), NFeStatusServico4.class, features);
    }

}
