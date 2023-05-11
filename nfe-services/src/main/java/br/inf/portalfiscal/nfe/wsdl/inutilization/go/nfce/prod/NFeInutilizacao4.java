package br.inf.portalfiscal.nfe.wsdl.inutilization.go.nfce.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NFeInutilizacao4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", wsdlLocation = "https://nfe.sefaz.go.gov.br/nfe/services/NFeInutilizacao4?wsdl")
public class NFeInutilizacao4
        extends Service {

    private static final URL NFEINUTILIZACAO4_WSDL_LOCATION;
    private static final WebServiceException NFEINUTILIZACAO4_EXCEPTION;
    private static final QName NFEINUTILIZACAO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", "NFeInutilizacao4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.sefaz.go.gov.br/nfe/services/NFeInutilizacao4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFEINUTILIZACAO4_WSDL_LOCATION = url;
        NFEINUTILIZACAO4_EXCEPTION = e;
    }

    public NFeInutilizacao4() {
        super(__getWsdlLocation(), NFEINUTILIZACAO4_QNAME);
    }

    public NFeInutilizacao4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFEINUTILIZACAO4_QNAME, features);
    }

    public NFeInutilizacao4(URL wsdlLocation) {
        super(wsdlLocation, NFEINUTILIZACAO4_QNAME);
    }

    public NFeInutilizacao4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFEINUTILIZACAO4_QNAME, features);
    }

    public NFeInutilizacao4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeInutilizacao4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns NFeInutilizacao4Service
     */
    @WebEndpoint(name = "NFeInutilizacao4ServicePort")
    public NFeInutilizacao4Service getNFeInutilizacao4ServicePort() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", "NFeInutilizacao4ServicePort"), NFeInutilizacao4Service.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeInutilizacao4Service
     */
    @WebEndpoint(name = "NFeInutilizacao4ServicePort")
    public NFeInutilizacao4Service getNFeInutilizacao4ServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", "NFeInutilizacao4ServicePort"), NFeInutilizacao4Service.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NFEINUTILIZACAO4_EXCEPTION != null) {
            throw NFEINUTILIZACAO4_EXCEPTION;
        }
        return NFEINUTILIZACAO4_WSDL_LOCATION;
    }

}
