package br.inf.portalfiscal.cte.wsdl.event.mg.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * ServiÃ§o destinado Ã  recepÃ§Ã£o de mensagem
 * de Evento do CT-e.
 * <p>
 * <p>
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "RecepcaoEvento", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento", wsdlLocation = "https://cte.fazenda.mg.gov.br/cte/services/RecepcaoEvento?wsdl")
public class RecepcaoEvento
        extends Service {

    private static final URL RECEPCAOEVENTO_WSDL_LOCATION;
    private static final WebServiceException RECEPCAOEVENTO_EXCEPTION;
    private static final QName RECEPCAOEVENTO_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento", "RecepcaoEvento");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://cte.fazenda.mg.gov.br/cte/services/RecepcaoEvento?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RECEPCAOEVENTO_WSDL_LOCATION = url;
        RECEPCAOEVENTO_EXCEPTION = e;
    }

    public RecepcaoEvento() {
        super(__getWsdlLocation(), RECEPCAOEVENTO_QNAME);
    }

    public RecepcaoEvento(WebServiceFeature... features) {
        super(__getWsdlLocation(), RECEPCAOEVENTO_QNAME, features);
    }

    public RecepcaoEvento(URL wsdlLocation) {
        super(wsdlLocation, RECEPCAOEVENTO_QNAME);
    }

    public RecepcaoEvento(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RECEPCAOEVENTO_QNAME, features);
    }

    public RecepcaoEvento(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RecepcaoEvento(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
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

    private static URL __getWsdlLocation() {
        if (RECEPCAOEVENTO_EXCEPTION != null) {
            throw RECEPCAOEVENTO_EXCEPTION;
        }
        return RECEPCAOEVENTO_WSDL_LOCATION;
    }

}
