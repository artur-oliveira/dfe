package br.inf.portalfiscal.mdfe.wsdl.reception.svrs.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "MDFeRecepcao", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcao", wsdlLocation = "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcao/MDFeRecepcao.asmx?wsdl")
public class MDFeRecepcao
        extends Service {

    private static final URL MDFERECEPCAO_WSDL_LOCATION;
    private static final WebServiceException MDFERECEPCAO_EXCEPTION;
    private static final QName MDFERECEPCAO_QNAME = new QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcao", "MDFeRecepcao");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcao/MDFeRecepcao.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MDFERECEPCAO_WSDL_LOCATION = url;
        MDFERECEPCAO_EXCEPTION = e;
    }

    public MDFeRecepcao() {
        super(__getWsdlLocation(), MDFERECEPCAO_QNAME);
    }

    public MDFeRecepcao(WebServiceFeature... features) {
        super(__getWsdlLocation(), MDFERECEPCAO_QNAME, features);
    }

    public MDFeRecepcao(URL wsdlLocation) {
        super(wsdlLocation, MDFERECEPCAO_QNAME);
    }

    public MDFeRecepcao(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MDFERECEPCAO_QNAME, features);
    }

    public MDFeRecepcao(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MDFeRecepcao(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns MDFeRecepcaoSoap12
     */
    @WebEndpoint(name = "MDFeRecepcaoSoap12")
    public MDFeRecepcaoSoap12 getMDFeRecepcaoSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcao", "MDFeRecepcaoSoap12"), MDFeRecepcaoSoap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns MDFeRecepcaoSoap12
     */
    @WebEndpoint(name = "MDFeRecepcaoSoap12")
    public MDFeRecepcaoSoap12 getMDFeRecepcaoSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcao", "MDFeRecepcaoSoap12"), MDFeRecepcaoSoap12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MDFERECEPCAO_EXCEPTION != null) {
            throw MDFERECEPCAO_EXCEPTION;
        }
        return MDFERECEPCAO_WSDL_LOCATION;
    }

}
