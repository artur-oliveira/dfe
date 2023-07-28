package br.inf.portalfiscal.nfe.wsdl.query_register.ms.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CadConsultaCadastro4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", wsdlLocation = "https://nfe.sefaz.ms.gov.br/ws/CadConsultaCadastro4?wsdl")
public class CadConsultaCadastro4
        extends Service {

    private static final URL CADCONSULTACADASTRO4_WSDL_LOCATION;
    private static final WebServiceException CADCONSULTACADASTRO4_EXCEPTION;
    private static final QName CADCONSULTACADASTRO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "CadConsultaCadastro4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.sefaz.ms.gov.br/ws/CadConsultaCadastro4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CADCONSULTACADASTRO4_WSDL_LOCATION = url;
        CADCONSULTACADASTRO4_EXCEPTION = e;
    }

    public CadConsultaCadastro4() {
        super(__getWsdlLocation(), CADCONSULTACADASTRO4_QNAME);
    }

    public CadConsultaCadastro4(WebServiceFeature... features) {
        super(__getWsdlLocation(), CADCONSULTACADASTRO4_QNAME, features);
    }

    public CadConsultaCadastro4(URL wsdlLocation) {
        super(wsdlLocation, CADCONSULTACADASTRO4_QNAME);
    }

    public CadConsultaCadastro4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CADCONSULTACADASTRO4_QNAME, features);
    }

    public CadConsultaCadastro4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CadConsultaCadastro4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CADCONSULTACADASTRO4_EXCEPTION != null) {
            throw CADCONSULTACADASTRO4_EXCEPTION;
        }
        return CADCONSULTACADASTRO4_WSDL_LOCATION;
    }

    /**
     * @return returns CadConsultaCadastroSoap
     */
    @WebEndpoint(name = "cadConsultaCadastroSoap12")
    public CadConsultaCadastroSoap getCadConsultaCadastroSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "cadConsultaCadastroSoap12"), CadConsultaCadastroSoap.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CadConsultaCadastroSoap
     */
    @WebEndpoint(name = "cadConsultaCadastroSoap12")
    public CadConsultaCadastroSoap getCadConsultaCadastroSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "cadConsultaCadastroSoap12"), CadConsultaCadastroSoap.class, features);
    }

}
