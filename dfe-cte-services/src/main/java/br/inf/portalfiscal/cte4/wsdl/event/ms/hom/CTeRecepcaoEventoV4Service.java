package br.inf.portalfiscal.cte4.wsdl.event.ms.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CTeRecepcaoEventoV4Service", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoEventoV4", wsdlLocation = "https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoEventoV4?wsdl")
public class CTeRecepcaoEventoV4Service
        extends Service {

    private static final URL CTERECEPCAOEVENTOV4SERVICE_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAOEVENTOV4SERVICE_EXCEPTION;
    private static final QName CTERECEPCAOEVENTOV4SERVICE_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoEventoV4", "CTeRecepcaoEventoV4Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoEventoV4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOEVENTOV4SERVICE_WSDL_LOCATION = url;
        CTERECEPCAOEVENTOV4SERVICE_EXCEPTION = e;
    }

    public CTeRecepcaoEventoV4Service() {
        super(__getWsdlLocation(), CTERECEPCAOEVENTOV4SERVICE_QNAME);
    }

    public CTeRecepcaoEventoV4Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOEVENTOV4SERVICE_QNAME, features);
    }

    public CTeRecepcaoEventoV4Service(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOEVENTOV4SERVICE_QNAME);
    }

    public CTeRecepcaoEventoV4Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOEVENTOV4SERVICE_QNAME, features);
    }

    public CTeRecepcaoEventoV4Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeRecepcaoEventoV4Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOEVENTOV4SERVICE_EXCEPTION != null) {
            throw CTERECEPCAOEVENTOV4SERVICE_EXCEPTION;
        }
        return CTERECEPCAOEVENTOV4SERVICE_WSDL_LOCATION;
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
