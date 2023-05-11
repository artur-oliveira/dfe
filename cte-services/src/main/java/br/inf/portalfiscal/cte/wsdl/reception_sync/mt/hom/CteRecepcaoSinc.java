package br.inf.portalfiscal.cte.wsdl.reception_sync.mt.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CteRecepcaoSinc", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoSinc", wsdlLocation = "https://homologacao.sefaz.mt.gov.br/ctews2/services/CteRecepcaoSinc?wsdl")
public class CteRecepcaoSinc
        extends Service {

    private static final URL CTERECEPCAOSINC_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAOSINC_EXCEPTION;
    private static final QName CTERECEPCAOSINC_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoSinc", "CteRecepcaoSinc");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.sefaz.mt.gov.br/ctews2/services/CteRecepcaoSinc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOSINC_WSDL_LOCATION = url;
        CTERECEPCAOSINC_EXCEPTION = e;
    }

    public CteRecepcaoSinc() {
        super(__getWsdlLocation(), CTERECEPCAOSINC_QNAME);
    }

    public CteRecepcaoSinc(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOSINC_QNAME, features);
    }

    public CteRecepcaoSinc(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOSINC_QNAME);
    }

    public CteRecepcaoSinc(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOSINC_QNAME, features);
    }

    public CteRecepcaoSinc(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CteRecepcaoSinc(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns CteRecepcaoSincSoap12
     */
    @WebEndpoint(name = "CteRecepcaoSincSoap12")
    public CteRecepcaoSincSoap12 getCteRecepcaoSincSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoSinc", "CteRecepcaoSincSoap12"), CteRecepcaoSincSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CteRecepcaoSincSoap12
     */
    @WebEndpoint(name = "CteRecepcaoSincSoap12")
    public CteRecepcaoSincSoap12 getCteRecepcaoSincSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoSinc", "CteRecepcaoSincSoap12"), CteRecepcaoSincSoap12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOSINC_EXCEPTION != null) {
            throw CTERECEPCAOSINC_EXCEPTION;
        }
        return CTERECEPCAOSINC_WSDL_LOCATION;
    }

}
