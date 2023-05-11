package br.inf.portalfiscal.cte.wsdl.reception.pr.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CteRecepcao", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", wsdlLocation = "https://cte.fazenda.pr.gov.br/cte/CteRecepcao?wsdl")
public class CteRecepcao
        extends Service {

    private static final URL CTERECEPCAO_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAO_EXCEPTION;
    private static final QName CTERECEPCAO_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", "CteRecepcao");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://cte.fazenda.pr.gov.br/cte/CteRecepcao?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAO_WSDL_LOCATION = url;
        CTERECEPCAO_EXCEPTION = e;
    }

    public CteRecepcao() {
        super(__getWsdlLocation(), CTERECEPCAO_QNAME);
    }

    public CteRecepcao(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAO_QNAME, features);
    }

    public CteRecepcao(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAO_QNAME);
    }

    public CteRecepcao(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAO_QNAME, features);
    }

    public CteRecepcao(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CteRecepcao(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns CteRecepcaoSoap12
     */
    @WebEndpoint(name = "CteRecepcaoServicePort")
    public CteRecepcaoSoap12 getCteRecepcaoServicePort() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", "CteRecepcaoServicePort"), CteRecepcaoSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CteRecepcaoSoap12
     */
    @WebEndpoint(name = "CteRecepcaoServicePort")
    public CteRecepcaoSoap12 getCteRecepcaoServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", "CteRecepcaoServicePort"), CteRecepcaoSoap12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAO_EXCEPTION != null) {
            throw CTERECEPCAO_EXCEPTION;
        }
        return CTERECEPCAO_WSDL_LOCATION;
    }

}
