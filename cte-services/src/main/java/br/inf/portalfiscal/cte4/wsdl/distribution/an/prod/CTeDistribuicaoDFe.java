package br.inf.portalfiscal.cte4.wsdl.distribution.an.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CTeDistribuicaoDFe", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", wsdlLocation = "https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx?wsdl")
public class CTeDistribuicaoDFe
        extends Service {

    private static final URL CTEDISTRIBUICAODFE_WSDL_LOCATION;
    private static final WebServiceException CTEDISTRIBUICAODFE_EXCEPTION;
    private static final QName CTEDISTRIBUICAODFE_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "CTeDistribuicaoDFe");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTEDISTRIBUICAODFE_WSDL_LOCATION = url;
        CTEDISTRIBUICAODFE_EXCEPTION = e;
    }

    public CTeDistribuicaoDFe() {
        super(__getWsdlLocation(), CTEDISTRIBUICAODFE_QNAME);
    }

    public CTeDistribuicaoDFe(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTEDISTRIBUICAODFE_QNAME, features);
    }

    public CTeDistribuicaoDFe(URL wsdlLocation) {
        super(wsdlLocation, CTEDISTRIBUICAODFE_QNAME);
    }

    public CTeDistribuicaoDFe(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTEDISTRIBUICAODFE_QNAME, features);
    }

    public CTeDistribuicaoDFe(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeDistribuicaoDFe(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns CTeDistribuicaoDFeSoap
     */
    @WebEndpoint(name = "CTeDistribuicaoDFeSoap")
    public CTeDistribuicaoDFeSoap getCTeDistribuicaoDFeSoap() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "CTeDistribuicaoDFeSoap"), CTeDistribuicaoDFeSoap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CTeDistribuicaoDFeSoap
     */
    @WebEndpoint(name = "CTeDistribuicaoDFeSoap")
    public CTeDistribuicaoDFeSoap getCTeDistribuicaoDFeSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "CTeDistribuicaoDFeSoap"), CTeDistribuicaoDFeSoap.class, features);
    }

    /**
     * @return returns CTeDistribuicaoDFeSoap
     */
    @WebEndpoint(name = "CTeDistribuicaoDFeSoap12")
    public CTeDistribuicaoDFeSoap getCTeDistribuicaoDFeSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "CTeDistribuicaoDFeSoap12"), CTeDistribuicaoDFeSoap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CTeDistribuicaoDFeSoap
     */
    @WebEndpoint(name = "CTeDistribuicaoDFeSoap12")
    public CTeDistribuicaoDFeSoap getCTeDistribuicaoDFeSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "CTeDistribuicaoDFeSoap12"), CTeDistribuicaoDFeSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CTEDISTRIBUICAODFE_EXCEPTION != null) {
            throw CTEDISTRIBUICAODFE_EXCEPTION;
        }
        return CTEDISTRIBUICAODFE_WSDL_LOCATION;
    }

}
