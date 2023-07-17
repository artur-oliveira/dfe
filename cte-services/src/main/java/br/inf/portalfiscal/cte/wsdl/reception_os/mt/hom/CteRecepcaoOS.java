package br.inf.portalfiscal.cte.wsdl.reception_os.mt.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CteRecepcaoOS", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", wsdlLocation = "https://homologacao.sefaz.mt.gov.br/ctews/services/CteRecepcaoOS?wsdl")
public class CteRecepcaoOS
        extends Service {

    private static final URL CTERECEPCAOOS_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAOOS_EXCEPTION;
    private static final QName CTERECEPCAOOS_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", "CteRecepcaoOS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.sefaz.mt.gov.br/ctews/services/CteRecepcaoOS?wsdl");
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
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CteRecepcaoOSSoap12
     */
    @WebEndpoint(name = "CteRecepcaoOSSoap12")
    public CteRecepcaoOSSoap12 getCteRecepcaoOSSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", "CteRecepcaoOSSoap12"), CteRecepcaoOSSoap12.class, features);
    }

}
