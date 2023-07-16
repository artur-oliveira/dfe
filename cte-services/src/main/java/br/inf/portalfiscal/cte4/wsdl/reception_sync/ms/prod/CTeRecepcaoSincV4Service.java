package br.inf.portalfiscal.cte4.wsdl.reception_sync.ms.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CTeRecepcaoSincV4Service", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSincV4", wsdlLocation = "https://producao.cte.ms.gov.br/ws/CTeRecepcaoSincV4?wsdl")
public class CTeRecepcaoSincV4Service
        extends Service {

    private static final URL CTERECEPCAOSINCV4SERVICE_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAOSINCV4SERVICE_EXCEPTION;
    private static final QName CTERECEPCAOSINCV4SERVICE_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSincV4", "CTeRecepcaoSincV4Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://producao.cte.ms.gov.br/ws/CTeRecepcaoSincV4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOSINCV4SERVICE_WSDL_LOCATION = url;
        CTERECEPCAOSINCV4SERVICE_EXCEPTION = e;
    }

    public CTeRecepcaoSincV4Service() {
        super(__getWsdlLocation(), CTERECEPCAOSINCV4SERVICE_QNAME);
    }

    public CTeRecepcaoSincV4Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOSINCV4SERVICE_QNAME, features);
    }

    public CTeRecepcaoSincV4Service(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOSINCV4SERVICE_QNAME);
    }

    public CTeRecepcaoSincV4Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOSINCV4SERVICE_QNAME, features);
    }

    public CTeRecepcaoSincV4Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeRecepcaoSincV4Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOSINCV4SERVICE_EXCEPTION != null) {
            throw CTERECEPCAOSINCV4SERVICE_EXCEPTION;
        }
        return CTERECEPCAOSINCV4SERVICE_WSDL_LOCATION;
    }

    /**
     * @return returns CTeRecepcaoSincV4Soap12
     */
    @WebEndpoint(name = "CTeRecepcaoSincV4Soap12")
    public CTeRecepcaoSincV4Soap12 getCTeRecepcaoSincV4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSincV4", "CTeRecepcaoSincV4Soap12"), CTeRecepcaoSincV4Soap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CTeRecepcaoSincV4Soap12
     */
    @WebEndpoint(name = "CTeRecepcaoSincV4Soap12")
    public CTeRecepcaoSincV4Soap12 getCTeRecepcaoSincV4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSincV4", "CTeRecepcaoSincV4Soap12"), CTeRecepcaoSincV4Soap12.class, features);
    }

}
