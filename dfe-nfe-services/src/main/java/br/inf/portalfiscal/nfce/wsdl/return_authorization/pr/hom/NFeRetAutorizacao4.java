package br.inf.portalfiscal.nfce.wsdl.return_authorization.pr.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Servico destinado a retornar o resultado do processamento do lote de NFCe
 * <p>
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NFeRetAutorizacao4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", wsdlLocation = "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeRetAutorizacao4?wsdl")
public class NFeRetAutorizacao4
        extends Service {

    private static final URL NFERETAUTORIZACAO4_WSDL_LOCATION;
    private static final WebServiceException NFERETAUTORIZACAO4_EXCEPTION;
    private static final QName NFERETAUTORIZACAO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NFeRetAutorizacao4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeRetAutorizacao4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFERETAUTORIZACAO4_WSDL_LOCATION = url;
        NFERETAUTORIZACAO4_EXCEPTION = e;
    }

    public NFeRetAutorizacao4() {
        super(__getWsdlLocation(), NFERETAUTORIZACAO4_QNAME);
    }

    public NFeRetAutorizacao4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFERETAUTORIZACAO4_QNAME, features);
    }

    public NFeRetAutorizacao4(URL wsdlLocation) {
        super(wsdlLocation, NFERETAUTORIZACAO4_QNAME);
    }

    public NFeRetAutorizacao4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFERETAUTORIZACAO4_QNAME, features);
    }

    public NFeRetAutorizacao4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeRetAutorizacao4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (NFERETAUTORIZACAO4_EXCEPTION != null) {
            throw NFERETAUTORIZACAO4_EXCEPTION;
        }
        return NFERETAUTORIZACAO4_WSDL_LOCATION;
    }

    /**
     * @return returns NFeRetAutorizacao4Soap12
     */
    @WebEndpoint(name = "NFeRetAutorizacao4ServicePort")
    public NFeRetAutorizacao4Soap12 getNFeRetAutorizacao4ServicePort() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NFeRetAutorizacao4ServicePort"), NFeRetAutorizacao4Soap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeRetAutorizacao4Soap12
     */
    @WebEndpoint(name = "NFeRetAutorizacao4ServicePort")
    public NFeRetAutorizacao4Soap12 getNFeRetAutorizacao4ServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NFeRetAutorizacao4ServicePort"), NFeRetAutorizacao4Soap12.class, features);
    }

}
