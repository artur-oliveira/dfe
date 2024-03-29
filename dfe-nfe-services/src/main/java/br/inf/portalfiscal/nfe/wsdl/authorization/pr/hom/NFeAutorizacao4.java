package br.inf.portalfiscal.nfe.wsdl.authorization.pr.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Servico destinado a recepcao de mensagens de lote de NFe
 * <p>
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NFeAutorizacao4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", wsdlLocation = "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeAutorizacao4?wsdl")
public class NFeAutorizacao4
        extends Service {

    private static final URL NFEAUTORIZACAO4_WSDL_LOCATION;
    private static final WebServiceException NFEAUTORIZACAO4_EXCEPTION;
    private static final QName NFEAUTORIZACAO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", "NFeAutorizacao4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeAutorizacao4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFEAUTORIZACAO4_WSDL_LOCATION = url;
        NFEAUTORIZACAO4_EXCEPTION = e;
    }

    public NFeAutorizacao4() {
        super(__getWsdlLocation(), NFEAUTORIZACAO4_QNAME);
    }

    public NFeAutorizacao4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFEAUTORIZACAO4_QNAME, features);
    }

    public NFeAutorizacao4(URL wsdlLocation) {
        super(wsdlLocation, NFEAUTORIZACAO4_QNAME);
    }

    public NFeAutorizacao4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFEAUTORIZACAO4_QNAME, features);
    }

    public NFeAutorizacao4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeAutorizacao4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (NFEAUTORIZACAO4_EXCEPTION != null) {
            throw NFEAUTORIZACAO4_EXCEPTION;
        }
        return NFEAUTORIZACAO4_WSDL_LOCATION;
    }

    /**
     * @return returns NFeAutorizacao4Soap12
     */
    @WebEndpoint(name = "NFeAutorizacao4ServicePort")
    public NFeAutorizacao4Soap12 getNFeAutorizacao4ServicePort() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", "NFeAutorizacao4ServicePort"), NFeAutorizacao4Soap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeAutorizacao4Soap12
     */
    @WebEndpoint(name = "NFeAutorizacao4ServicePort")
    public NFeAutorizacao4Soap12 getNFeAutorizacao4ServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", "NFeAutorizacao4ServicePort"), NFeAutorizacao4Soap12.class, features);
    }

}
