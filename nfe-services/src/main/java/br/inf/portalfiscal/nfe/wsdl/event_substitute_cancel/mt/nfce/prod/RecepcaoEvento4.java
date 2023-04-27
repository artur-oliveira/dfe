package br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.mt.nfce.prod;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "RecepcaoEvento4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", wsdlLocation = "https://nfce.sefaz.mt.gov.br/nfcews/services/RecepcaoEvento4?wsdl")
public class RecepcaoEvento4
        extends Service {

    private final static URL RECEPCAOEVENTO4_WSDL_LOCATION;
    private final static WebServiceException RECEPCAOEVENTO4_EXCEPTION;
    private final static QName RECEPCAOEVENTO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "RecepcaoEvento4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfce.sefaz.mt.gov.br/nfcews/services/RecepcaoEvento4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RECEPCAOEVENTO4_WSDL_LOCATION = url;
        RECEPCAOEVENTO4_EXCEPTION = e;
    }

    public RecepcaoEvento4() {
        super(__getWsdlLocation(), RECEPCAOEVENTO4_QNAME);
    }

    public RecepcaoEvento4(WebServiceFeature... features) {
        super(__getWsdlLocation(), RECEPCAOEVENTO4_QNAME, features);
    }

    public RecepcaoEvento4(URL wsdlLocation) {
        super(wsdlLocation, RECEPCAOEVENTO4_QNAME);
    }

    public RecepcaoEvento4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RECEPCAOEVENTO4_QNAME, features);
    }

    public RecepcaoEvento4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RecepcaoEvento4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (RECEPCAOEVENTO4_EXCEPTION != null) {
            throw RECEPCAOEVENTO4_EXCEPTION;
        }
        return RECEPCAOEVENTO4_WSDL_LOCATION;
    }

    /**
     * @return returns RecepcaoEvento4Soap
     */
    @WebEndpoint(name = "RecepcaoEvento4Soap12")
    public RecepcaoEvento4Soap getRecepcaoEvento4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "RecepcaoEvento4Soap12"), RecepcaoEvento4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns RecepcaoEvento4Soap
     */
    @WebEndpoint(name = "RecepcaoEvento4Soap12")
    public RecepcaoEvento4Soap getRecepcaoEvento4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "RecepcaoEvento4Soap12"), RecepcaoEvento4Soap.class, features);
    }

    /**
     * @return returns RecepcaoEvento4Soap
     */
    @WebEndpoint(name = "RecepcaoEvento4Soap")
    public RecepcaoEvento4Soap getRecepcaoEvento4Soap() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "RecepcaoEvento4Soap"), RecepcaoEvento4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns RecepcaoEvento4Soap
     */
    @WebEndpoint(name = "RecepcaoEvento4Soap")
    public RecepcaoEvento4Soap getRecepcaoEvento4Soap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "RecepcaoEvento4Soap"), RecepcaoEvento4Soap.class, features);
    }

}
