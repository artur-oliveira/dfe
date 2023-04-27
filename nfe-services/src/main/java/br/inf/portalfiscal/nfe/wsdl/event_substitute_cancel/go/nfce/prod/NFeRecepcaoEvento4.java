package br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.go.nfce.prod;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "NFeRecepcaoEvento4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", wsdlLocation = "https://nfe.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4?wsdl")
public class NFeRecepcaoEvento4
        extends Service {

    private final static URL NFERECEPCAOEVENTO4_WSDL_LOCATION;
    private final static WebServiceException NFERECEPCAOEVENTO4_EXCEPTION;
    private final static QName NFERECEPCAOEVENTO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "NFeRecepcaoEvento4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFERECEPCAOEVENTO4_WSDL_LOCATION = url;
        NFERECEPCAOEVENTO4_EXCEPTION = e;
    }

    public NFeRecepcaoEvento4() {
        super(__getWsdlLocation(), NFERECEPCAOEVENTO4_QNAME);
    }

    public NFeRecepcaoEvento4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFERECEPCAOEVENTO4_QNAME, features);
    }

    public NFeRecepcaoEvento4(URL wsdlLocation) {
        super(wsdlLocation, NFERECEPCAOEVENTO4_QNAME);
    }

    public NFeRecepcaoEvento4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFERECEPCAOEVENTO4_QNAME, features);
    }

    public NFeRecepcaoEvento4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeRecepcaoEvento4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (NFERECEPCAOEVENTO4_EXCEPTION != null) {
            throw NFERECEPCAOEVENTO4_EXCEPTION;
        }
        return NFERECEPCAOEVENTO4_WSDL_LOCATION;
    }

    /**
     * @return returns NFeRecepcaoEvento4Service
     */
    @WebEndpoint(name = "NFeRecepcaoEvento4ServicePort")
    public NFeRecepcaoEvento4Service getNFeRecepcaoEvento4ServicePort() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "NFeRecepcaoEvento4ServicePort"), NFeRecepcaoEvento4Service.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeRecepcaoEvento4Service
     */
    @WebEndpoint(name = "NFeRecepcaoEvento4ServicePort")
    public NFeRecepcaoEvento4Service getNFeRecepcaoEvento4ServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "NFeRecepcaoEvento4ServicePort"), NFeRecepcaoEvento4Service.class, features);
    }

}
