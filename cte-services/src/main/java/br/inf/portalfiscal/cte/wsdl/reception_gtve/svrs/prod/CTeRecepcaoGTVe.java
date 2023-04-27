package br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.prod;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "CTeRecepcaoGTVe", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe", wsdlLocation = "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoGTVe/CTeRecepcaoGTVe.asmx?wsdl")
public class CTeRecepcaoGTVe
        extends Service {

    private final static URL CTERECEPCAOGTVE_WSDL_LOCATION;
    private final static WebServiceException CTERECEPCAOGTVE_EXCEPTION;
    private final static QName CTERECEPCAOGTVE_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe", "CTeRecepcaoGTVe");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoGTVe/CTeRecepcaoGTVe.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOGTVE_WSDL_LOCATION = url;
        CTERECEPCAOGTVE_EXCEPTION = e;
    }

    public CTeRecepcaoGTVe() {
        super(__getWsdlLocation(), CTERECEPCAOGTVE_QNAME);
    }

    public CTeRecepcaoGTVe(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOGTVE_QNAME, features);
    }

    public CTeRecepcaoGTVe(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOGTVE_QNAME);
    }

    public CTeRecepcaoGTVe(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOGTVE_QNAME, features);
    }

    public CTeRecepcaoGTVe(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeRecepcaoGTVe(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOGTVE_EXCEPTION != null) {
            throw CTERECEPCAOGTVE_EXCEPTION;
        }
        return CTERECEPCAOGTVE_WSDL_LOCATION;
    }

    /**
     * @return returns CTeRecepcaoGTVeSoap12
     */
    @WebEndpoint(name = "CTeRecepcaoGTVeSoap12")
    public CTeRecepcaoGTVeSoap12 getCTeRecepcaoGTVeSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe", "CTeRecepcaoGTVeSoap12"), CTeRecepcaoGTVeSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CTeRecepcaoGTVeSoap12
     */
    @WebEndpoint(name = "CTeRecepcaoGTVeSoap12")
    public CTeRecepcaoGTVeSoap12 getCTeRecepcaoGTVeSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe", "CTeRecepcaoGTVeSoap12"), CTeRecepcaoGTVeSoap12.class, features);
    }

}
