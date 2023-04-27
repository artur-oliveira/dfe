package br.inf.portalfiscal.cte.wsdl.query_receipt.ms.hom;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Serviço destinado a devolver o resultado do processamento do lote de CT-e.
 * <p>
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "CteRetRecepcao", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRetRecepcao", wsdlLocation = "https://homologacao.cte.ms.gov.br/ws/CteRetRecepcao?wsdl")
public class CteRetRecepcao
        extends Service {

    private final static URL CTERETRECEPCAO_WSDL_LOCATION;
    private final static WebServiceException CTERETRECEPCAO_EXCEPTION;
    private final static QName CTERETRECEPCAO_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRetRecepcao", "CteRetRecepcao");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.cte.ms.gov.br/ws/CteRetRecepcao?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERETRECEPCAO_WSDL_LOCATION = url;
        CTERETRECEPCAO_EXCEPTION = e;
    }

    public CteRetRecepcao() {
        super(__getWsdlLocation(), CTERETRECEPCAO_QNAME);
    }

    public CteRetRecepcao(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERETRECEPCAO_QNAME, features);
    }

    public CteRetRecepcao(URL wsdlLocation) {
        super(wsdlLocation, CTERETRECEPCAO_QNAME);
    }

    public CteRetRecepcao(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERETRECEPCAO_QNAME, features);
    }

    public CteRetRecepcao(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CteRetRecepcao(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERETRECEPCAO_EXCEPTION != null) {
            throw CTERETRECEPCAO_EXCEPTION;
        }
        return CTERETRECEPCAO_WSDL_LOCATION;
    }

    /**
     * @return returns CteRetRecepcaoSoap12
     */
    @WebEndpoint(name = "CteRetRecepcaoSoap12")
    public CteRetRecepcaoSoap12 getCteRetRecepcaoSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRetRecepcao", "CteRetRecepcaoSoap12"), CteRetRecepcaoSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CteRetRecepcaoSoap12
     */
    @WebEndpoint(name = "CteRetRecepcaoSoap12")
    public CteRetRecepcaoSoap12 getCteRetRecepcaoSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRetRecepcao", "CteRetRecepcaoSoap12"), CteRetRecepcaoSoap12.class, features);
    }

}
