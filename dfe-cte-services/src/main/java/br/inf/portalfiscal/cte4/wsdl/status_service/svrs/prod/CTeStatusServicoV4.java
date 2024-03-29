package br.inf.portalfiscal.cte4.wsdl.status_service.svrs.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CTeStatusServicoV4", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeStatusServicoV4", wsdlLocation = "https://cte.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx?wsdl")
public class CTeStatusServicoV4
        extends Service {

    private static final URL CTESTATUSSERVICOV4_WSDL_LOCATION;
    private static final WebServiceException CTESTATUSSERVICOV4_EXCEPTION;
    private static final QName CTESTATUSSERVICOV4_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeStatusServicoV4", "CTeStatusServicoV4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://cte.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTESTATUSSERVICOV4_WSDL_LOCATION = url;
        CTESTATUSSERVICOV4_EXCEPTION = e;
    }

    public CTeStatusServicoV4() {
        super(__getWsdlLocation(), CTESTATUSSERVICOV4_QNAME);
    }

    public CTeStatusServicoV4(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTESTATUSSERVICOV4_QNAME, features);
    }

    public CTeStatusServicoV4(URL wsdlLocation) {
        super(wsdlLocation, CTESTATUSSERVICOV4_QNAME);
    }

    public CTeStatusServicoV4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTESTATUSSERVICOV4_QNAME, features);
    }

    public CTeStatusServicoV4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeStatusServicoV4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTESTATUSSERVICOV4_EXCEPTION != null) {
            throw CTESTATUSSERVICOV4_EXCEPTION;
        }
        return CTESTATUSSERVICOV4_WSDL_LOCATION;
    }

    /**
     * @return returns CTeStatusServicoV4Soap12
     */
    @WebEndpoint(name = "CTeStatusServicoV4Soap12")
    public CTeStatusServicoV4Soap12 getCTeStatusServicoV4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeStatusServicoV4", "CTeStatusServicoV4Soap12"), CTeStatusServicoV4Soap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CTeStatusServicoV4Soap12
     */
    @WebEndpoint(name = "CTeStatusServicoV4Soap12")
    public CTeStatusServicoV4Soap12 getCTeStatusServicoV4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeStatusServicoV4", "CTeStatusServicoV4Soap12"), CTeStatusServicoV4Soap12.class, features);
    }

}
