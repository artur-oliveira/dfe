
package br.inf.portalfiscal.cte4.wsdl.reception_os.mt.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "CTeRecepcaoOSV4", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", wsdlLocation = "https://cte.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4?wsdl")
public class CTeRecepcaoOSV4
    extends Service
{

    private static final URL CTERECEPCAOOSV4_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAOOSV4_EXCEPTION;
    private static final QName CTERECEPCAOOSV4_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", "CTeRecepcaoOSV4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://cte.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOOSV4_WSDL_LOCATION = url;
        CTERECEPCAOOSV4_EXCEPTION = e;
    }

    public CTeRecepcaoOSV4() {
        super(__getWsdlLocation(), CTERECEPCAOOSV4_QNAME);
    }

    public CTeRecepcaoOSV4(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOOSV4_QNAME, features);
    }

    public CTeRecepcaoOSV4(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOOSV4_QNAME);
    }

    public CTeRecepcaoOSV4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOOSV4_QNAME, features);
    }

    public CTeRecepcaoOSV4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeRecepcaoOSV4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CteRecepcaoOSSoap12
     */
    @WebEndpoint(name = "CteRecepcaoOSSoap12")
    public CteRecepcaoOSSoap12 getCteRecepcaoOSSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", "CteRecepcaoOSSoap12"), CteRecepcaoOSSoap12.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CteRecepcaoOSSoap12
     */
    @WebEndpoint(name = "CteRecepcaoOSSoap12")
    public CteRecepcaoOSSoap12 getCteRecepcaoOSSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", "CteRecepcaoOSSoap12"), CteRecepcaoOSSoap12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOOSV4_EXCEPTION!= null) {
            throw CTERECEPCAOOSV4_EXCEPTION;
        }
        return CTERECEPCAOOSV4_WSDL_LOCATION;
    }

}
