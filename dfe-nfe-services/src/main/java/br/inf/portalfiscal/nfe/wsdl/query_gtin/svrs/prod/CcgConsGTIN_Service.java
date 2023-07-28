package br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "ccgConsGTIN", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/ccgConsGtin", wsdlLocation = "https://dfe-servico.svrs.rs.gov.br/ws/ccgConsGTIN/ccgConsGTIN.asmx?wsdl")
public class CcgConsGTIN_Service
        extends Service {

    private static final URL CCGCONSGTIN_WSDL_LOCATION;
    private static final WebServiceException CCGCONSGTIN_EXCEPTION;
    private static final QName CCGCONSGTIN_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/ccgConsGtin", "ccgConsGTIN");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://dfe-servico.svrs.rs.gov.br/ws/ccgConsGTIN/ccgConsGTIN.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CCGCONSGTIN_WSDL_LOCATION = url;
        CCGCONSGTIN_EXCEPTION = e;
    }

    public CcgConsGTIN_Service() {
        super(__getWsdlLocation(), CCGCONSGTIN_QNAME);
    }

    public CcgConsGTIN_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CCGCONSGTIN_QNAME, features);
    }

    public CcgConsGTIN_Service(URL wsdlLocation) {
        super(wsdlLocation, CCGCONSGTIN_QNAME);
    }

    public CcgConsGTIN_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CCGCONSGTIN_QNAME, features);
    }

    public CcgConsGTIN_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CcgConsGTIN_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CCGCONSGTIN_EXCEPTION != null) {
            throw CCGCONSGTIN_EXCEPTION;
        }
        return CCGCONSGTIN_WSDL_LOCATION;
    }

    /**
     * @return returns CcgConsGTINSoap
     */
    @WebEndpoint(name = "ccgConsGTINSoap")
    public CcgConsGTINSoap getCcgConsGTINSoap() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/ccgConsGtin", "ccgConsGTINSoap"), CcgConsGTINSoap.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CcgConsGTINSoap
     */
    @WebEndpoint(name = "ccgConsGTINSoap")
    public CcgConsGTINSoap getCcgConsGTINSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/ccgConsGtin", "ccgConsGTINSoap"), CcgConsGTINSoap.class, features);
    }

    /**
     * @return returns CcgConsGTINSoap
     */
    @WebEndpoint(name = "ccgConsGTINSoap12")
    public CcgConsGTINSoap getCcgConsGTINSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/ccgConsGtin", "ccgConsGTINSoap12"), CcgConsGTINSoap.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CcgConsGTINSoap
     */
    @WebEndpoint(name = "ccgConsGTINSoap12")
    public CcgConsGTINSoap getCcgConsGTINSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/ccgConsGtin", "ccgConsGTINSoap12"), CcgConsGTINSoap.class, features);
    }

}