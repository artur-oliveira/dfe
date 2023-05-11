package br.inf.portalfiscal.nfe.wsdl.query_register.svrs.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CadConsultaCadastro4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", wsdlLocation = "https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx?wsdl")
public class CadConsultaCadastro4
        extends Service {

    private static final URL CADCONSULTACADASTRO4_WSDL_LOCATION;
    private static final WebServiceException CADCONSULTACADASTRO4_EXCEPTION;
    private static final QName CADCONSULTACADASTRO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "CadConsultaCadastro4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx?wsdl");
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
     * @return returns CadConsultaCadastro4Soap
     */
    @WebEndpoint(name = "CadConsultaCadastro4Soap")
    public CadConsultaCadastro4Soap getCadConsultaCadastro4Soap() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "CadConsultaCadastro4Soap"), CadConsultaCadastro4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CadConsultaCadastro4Soap
     */
    @WebEndpoint(name = "CadConsultaCadastro4Soap")
    public CadConsultaCadastro4Soap getCadConsultaCadastro4Soap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "CadConsultaCadastro4Soap"), CadConsultaCadastro4Soap.class, features);
    }

    /**
     * @return returns CadConsultaCadastro4Soap
     */
    @WebEndpoint(name = "CadConsultaCadastro4Soap12")
    public CadConsultaCadastro4Soap getCadConsultaCadastro4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "CadConsultaCadastro4Soap12"), CadConsultaCadastro4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CadConsultaCadastro4Soap
     */
    @WebEndpoint(name = "CadConsultaCadastro4Soap12")
    public CadConsultaCadastro4Soap getCadConsultaCadastro4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "CadConsultaCadastro4Soap12"), CadConsultaCadastro4Soap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CADCONSULTACADASTRO4_EXCEPTION != null) {
            throw CADCONSULTACADASTRO4_EXCEPTION;
        }
        return CADCONSULTACADASTRO4_WSDL_LOCATION;
    }

}
