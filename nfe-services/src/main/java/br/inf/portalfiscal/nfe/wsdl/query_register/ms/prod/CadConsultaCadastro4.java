
package br.inf.portalfiscal.nfe.wsdl.query_register.ms.prod;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "CadConsultaCadastro4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", wsdlLocation = "https://nfe.sefaz.ms.gov.br/ws/CadConsultaCadastro4?wsdl")
public class CadConsultaCadastro4
        extends Service {

    private final static URL CADCONSULTACADASTRO4_WSDL_LOCATION;
    private final static WebServiceException CADCONSULTACADASTRO4_EXCEPTION;
    private final static QName CADCONSULTACADASTRO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "CadConsultaCadastro4");

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

    /**
     * @return returns CadConsultaCadastroSoap
     */
    @WebEndpoint(name = "cadConsultaCadastroSoap12")
    public CadConsultaCadastroSoap getCadConsultaCadastroSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "cadConsultaCadastroSoap12"), CadConsultaCadastroSoap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CadConsultaCadastroSoap
     */
    @WebEndpoint(name = "cadConsultaCadastroSoap12")
    public CadConsultaCadastroSoap getCadConsultaCadastroSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "cadConsultaCadastroSoap12"), CadConsultaCadastroSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CADCONSULTACADASTRO4_EXCEPTION != null) {
            throw CADCONSULTACADASTRO4_EXCEPTION;
        }
        return CADCONSULTACADASTRO4_WSDL_LOCATION;
    }

}
