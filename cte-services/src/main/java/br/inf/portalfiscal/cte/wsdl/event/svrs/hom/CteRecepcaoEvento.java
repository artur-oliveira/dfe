package br.inf.portalfiscal.cte.wsdl.event.svrs.hom;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "CteRecepcaoEvento", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento", wsdlLocation = "https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx?wsdl")
public class CteRecepcaoEvento
        extends Service {

    private final static URL CTERECEPCAOEVENTO_WSDL_LOCATION;
    private final static WebServiceException CTERECEPCAOEVENTO_EXCEPTION;
    private final static QName CTERECEPCAOEVENTO_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento", "CteRecepcaoEvento");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOEVENTO_WSDL_LOCATION = url;
        CTERECEPCAOEVENTO_EXCEPTION = e;
    }

    public CteRecepcaoEvento() {
        super(__getWsdlLocation(), CTERECEPCAOEVENTO_QNAME);
    }

    public CteRecepcaoEvento(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOEVENTO_QNAME, features);
    }

    public CteRecepcaoEvento(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOEVENTO_QNAME);
    }

    public CteRecepcaoEvento(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOEVENTO_QNAME, features);
    }

    public CteRecepcaoEvento(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CteRecepcaoEvento(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOEVENTO_EXCEPTION != null) {
            throw CTERECEPCAOEVENTO_EXCEPTION;
        }
        return CTERECEPCAOEVENTO_WSDL_LOCATION;
    }

    /**
     * @return returns CteRecepcaoEventoSoap12
     */
    @WebEndpoint(name = "CteRecepcaoEventoSoap12")
    public CteRecepcaoEventoSoap12 getCteRecepcaoEventoSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento", "CteRecepcaoEventoSoap12"), CteRecepcaoEventoSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CteRecepcaoEventoSoap12
     */
    @WebEndpoint(name = "CteRecepcaoEventoSoap12")
    public CteRecepcaoEventoSoap12 getCteRecepcaoEventoSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento", "CteRecepcaoEventoSoap12"), CteRecepcaoEventoSoap12.class, features);
    }

}
