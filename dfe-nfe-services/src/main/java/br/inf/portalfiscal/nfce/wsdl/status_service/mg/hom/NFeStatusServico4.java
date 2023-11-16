package br.inf.portalfiscal.nfce.wsdl.status_service.mg.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NFeStatusServico4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", wsdlLocation = "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeStatusServico4?wsdl")
public class NFeStatusServico4
        extends Service {

    private static final URL NFESTATUSSERVICO4_WSDL_LOCATION;
    private static final WebServiceException NFESTATUSSERVICO4_EXCEPTION;
    private static final QName NFESTATUSSERVICO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NFeStatusServico4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://hnfce.fazenda.mg.gov.br/nfce/services/NFeStatusServico4?wsdl");
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
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeStatusServico4Soap
     */
    @WebEndpoint(name = "NFeStatusServico4Soap")
    public NFeStatusServico4Soap getNFeStatusServico4Soap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "NFeStatusServico4Soap"), NFeStatusServico4Soap.class, features);
    }

}
