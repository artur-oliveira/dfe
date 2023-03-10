package br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.prod;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "MDFeRetRecepcao", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRetRecepcao", wsdlLocation = "https://mdfe.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx?wsdl")
public class MDFeRetRecepcao
        extends Service {

    private final static URL MDFERETRECEPCAO_WSDL_LOCATION;
    private final static WebServiceException MDFERETRECEPCAO_EXCEPTION;
    private final static QName MDFERETRECEPCAO_QNAME = new QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRetRecepcao", "MDFeRetRecepcao");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://mdfe.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MDFERETRECEPCAO_WSDL_LOCATION = url;
        MDFERETRECEPCAO_EXCEPTION = e;
    }

    public MDFeRetRecepcao() {
        super(__getWsdlLocation(), MDFERETRECEPCAO_QNAME);
    }

    public MDFeRetRecepcao(WebServiceFeature... features) {
        super(__getWsdlLocation(), MDFERETRECEPCAO_QNAME, features);
    }

    public MDFeRetRecepcao(URL wsdlLocation) {
        super(wsdlLocation, MDFERETRECEPCAO_QNAME);
    }

    public MDFeRetRecepcao(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MDFERETRECEPCAO_QNAME, features);
    }

    public MDFeRetRecepcao(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MDFeRetRecepcao(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (MDFERETRECEPCAO_EXCEPTION != null) {
            throw MDFERETRECEPCAO_EXCEPTION;
        }
        return MDFERETRECEPCAO_WSDL_LOCATION;
    }

    /**
     * @return returns MDFeRetRecepcaoSoap12
     */
    @WebEndpoint(name = "MDFeRetRecepcaoSoap12")
    public MDFeRetRecepcaoSoap12 getMDFeRetRecepcaoSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRetRecepcao", "MDFeRetRecepcaoSoap12"), MDFeRetRecepcaoSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns MDFeRetRecepcaoSoap12
     */
    @WebEndpoint(name = "MDFeRetRecepcaoSoap12")
    public MDFeRetRecepcaoSoap12 getMDFeRetRecepcaoSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRetRecepcao", "MDFeRetRecepcaoSoap12"), MDFeRetRecepcaoSoap12.class, features);
    }

}
