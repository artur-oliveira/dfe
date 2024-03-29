package br.inf.portalfiscal.cte4.wsdl.event.pr.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CTeRecepcaoEventoV4", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoEventoV4", wsdlLocation = "https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoEventoV4?wsdl")
public class CTeRecepcaoEventoV4
        extends Service {

    private static final URL CTERECEPCAOEVENTOV4_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAOEVENTOV4_EXCEPTION;
    private static final QName CTERECEPCAOEVENTOV4_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoEventoV4", "CTeRecepcaoEventoV4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoEventoV4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOEVENTOV4_WSDL_LOCATION = url;
        CTERECEPCAOEVENTOV4_EXCEPTION = e;
    }

    public CTeRecepcaoEventoV4() {
        super(__getWsdlLocation(), CTERECEPCAOEVENTOV4_QNAME);
    }

    public CTeRecepcaoEventoV4(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOEVENTOV4_QNAME, features);
    }

    public CTeRecepcaoEventoV4(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOEVENTOV4_QNAME);
    }

    public CTeRecepcaoEventoV4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOEVENTOV4_QNAME, features);
    }

    public CTeRecepcaoEventoV4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeRecepcaoEventoV4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOEVENTOV4_EXCEPTION != null) {
            throw CTERECEPCAOEVENTOV4_EXCEPTION;
        }
        return CTERECEPCAOEVENTOV4_WSDL_LOCATION;
    }

    /**
     * @return returns CTeRecepcaoEventoV4Soap12
     */
    @WebEndpoint(name = "CTeRecepcaoEventoV4Soap12")
    public CTeRecepcaoEventoV4Soap12 getCTeRecepcaoEventoV4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoEventoV4", "CTeRecepcaoEventoV4Soap12"), CTeRecepcaoEventoV4Soap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CTeRecepcaoEventoV4Soap12
     */
    @WebEndpoint(name = "CTeRecepcaoEventoV4Soap12")
    public CTeRecepcaoEventoV4Soap12 getCTeRecepcaoEventoV4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoEventoV4", "CTeRecepcaoEventoV4Soap12"), CTeRecepcaoEventoV4Soap12.class, features);
    }

}
