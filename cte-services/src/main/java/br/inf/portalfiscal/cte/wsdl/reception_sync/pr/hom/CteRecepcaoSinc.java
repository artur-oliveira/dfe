package br.inf.portalfiscal.cte.wsdl.reception_sync.pr.hom;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "CteRecepcaoSinc", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoSinc", wsdlLocation = "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcaoSinc?wsdl")
public class CteRecepcaoSinc
        extends Service {

    private final static URL CTERECEPCAOSINC_WSDL_LOCATION;
    private final static WebServiceException CTERECEPCAOSINC_EXCEPTION;
    private final static QName CTERECEPCAOSINC_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoSinc", "CteRecepcaoSinc");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcaoSinc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOSINC_WSDL_LOCATION = url;
        CTERECEPCAOSINC_EXCEPTION = e;
    }

    public CteRecepcaoSinc() {
        super(__getWsdlLocation(), CTERECEPCAOSINC_QNAME);
    }

    public CteRecepcaoSinc(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOSINC_QNAME, features);
    }

    public CteRecepcaoSinc(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOSINC_QNAME);
    }

    public CteRecepcaoSinc(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOSINC_QNAME, features);
    }

    public CteRecepcaoSinc(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CteRecepcaoSinc(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOSINC_EXCEPTION != null) {
            throw CTERECEPCAOSINC_EXCEPTION;
        }
        return CTERECEPCAOSINC_WSDL_LOCATION;
    }

    /**
     * @return returns CteRecepcaoSincSoap12
     */
    @WebEndpoint(name = "CteRecepcaoSincServicePort")
    public CteRecepcaoSincSoap12 getCteRecepcaoSincServicePort() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoSinc", "CteRecepcaoSincServicePort"), CteRecepcaoSincSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CteRecepcaoSincSoap12
     */
    @WebEndpoint(name = "CteRecepcaoSincServicePort")
    public CteRecepcaoSincSoap12 getCteRecepcaoSincServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoSinc", "CteRecepcaoSincServicePort"), CteRecepcaoSincSoap12.class, features);
    }

}
