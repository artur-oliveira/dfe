package br.inf.portalfiscal.cte4.wsdl.reception_os.ms.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CTeRecepcaoOSV4Service", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", wsdlLocation = "https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoOSV4?wsdl")
public class CTeRecepcaoOSV4Service
        extends Service {

    private static final URL CTERECEPCAOOSV4SERVICE_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAOOSV4SERVICE_EXCEPTION;
    private static final QName CTERECEPCAOOSV4SERVICE_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", "CTeRecepcaoOSV4Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoOSV4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOOSV4SERVICE_WSDL_LOCATION = url;
        CTERECEPCAOOSV4SERVICE_EXCEPTION = e;
    }

    public CTeRecepcaoOSV4Service() {
        super(__getWsdlLocation(), CTERECEPCAOOSV4SERVICE_QNAME);
    }

    public CTeRecepcaoOSV4Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOOSV4SERVICE_QNAME, features);
    }

    public CTeRecepcaoOSV4Service(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOOSV4SERVICE_QNAME);
    }

    public CTeRecepcaoOSV4Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOOSV4SERVICE_QNAME, features);
    }

    public CTeRecepcaoOSV4Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeRecepcaoOSV4Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOOSV4SERVICE_EXCEPTION != null) {
            throw CTERECEPCAOOSV4SERVICE_EXCEPTION;
        }
        return CTERECEPCAOOSV4SERVICE_WSDL_LOCATION;
    }

    /**
     * @return returns CTeRecepcaoOSV4Soap12
     */
    @WebEndpoint(name = "CTeRecepcaoOSV4Soap12")
    public CTeRecepcaoOSV4Soap12 getCTeRecepcaoOSV4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", "CTeRecepcaoOSV4Soap12"), CTeRecepcaoOSV4Soap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CTeRecepcaoOSV4Soap12
     */
    @WebEndpoint(name = "CTeRecepcaoOSV4Soap12")
    public CTeRecepcaoOSV4Soap12 getCTeRecepcaoOSV4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", "CTeRecepcaoOSV4Soap12"), CTeRecepcaoOSV4Soap12.class, features);
    }

}
