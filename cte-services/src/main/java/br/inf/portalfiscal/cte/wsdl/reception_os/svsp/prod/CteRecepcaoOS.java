package br.inf.portalfiscal.cte.wsdl.reception_os.svsp.prod;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Serviço destinado à recepção de mensagens de CT-e (Outros Serviços).
 * <p>
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "CteRecepcaoOS", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", wsdlLocation = "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx?wsdl")
public class CteRecepcaoOS
        extends Service {

    private final static URL CTERECEPCAOOS_WSDL_LOCATION;
    private final static WebServiceException CTERECEPCAOOS_EXCEPTION;
    private final static QName CTERECEPCAOOS_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", "CteRecepcaoOS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOOS_WSDL_LOCATION = url;
        CTERECEPCAOOS_EXCEPTION = e;
    }

    public CteRecepcaoOS() {
        super(__getWsdlLocation(), CTERECEPCAOOS_QNAME);
    }

    public CteRecepcaoOS(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOOS_QNAME, features);
    }

    public CteRecepcaoOS(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOOS_QNAME);
    }

    public CteRecepcaoOS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOOS_QNAME, features);
    }

    public CteRecepcaoOS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CteRecepcaoOS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOOS_EXCEPTION != null) {
            throw CTERECEPCAOOS_EXCEPTION;
        }
        return CTERECEPCAOOS_WSDL_LOCATION;
    }

    /**
     * @return returns CteRecepcaoOSSoap12
     */
    @WebEndpoint(name = "CteRecepcaoOSSoap12")
    public CteRecepcaoOSSoap12 getCteRecepcaoOSSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", "CteRecepcaoOSSoap12"), CteRecepcaoOSSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CteRecepcaoOSSoap12
     */
    @WebEndpoint(name = "CteRecepcaoOSSoap12")
    public CteRecepcaoOSSoap12 getCteRecepcaoOSSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", "CteRecepcaoOSSoap12"), CteRecepcaoOSSoap12.class, features);
    }

}
