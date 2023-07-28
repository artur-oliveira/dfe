package br.inf.portalfiscal.nfe.wsdl.query_protocol.mg.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NFeConsultaProtocolo4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", wsdlLocation = "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeConsultaProtocolo4?wsdl")
public class NFeConsultaProtocolo4
        extends Service {

    private static final URL NFECONSULTAPROTOCOLO4_WSDL_LOCATION;
    private static final WebServiceException NFECONSULTAPROTOCOLO4_EXCEPTION;
    private static final QName NFECONSULTAPROTOCOLO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "NFeConsultaProtocolo4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeConsultaProtocolo4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFECONSULTAPROTOCOLO4_WSDL_LOCATION = url;
        NFECONSULTAPROTOCOLO4_EXCEPTION = e;
    }

    public NFeConsultaProtocolo4() {
        super(__getWsdlLocation(), NFECONSULTAPROTOCOLO4_QNAME);
    }

    public NFeConsultaProtocolo4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFECONSULTAPROTOCOLO4_QNAME, features);
    }

    public NFeConsultaProtocolo4(URL wsdlLocation) {
        super(wsdlLocation, NFECONSULTAPROTOCOLO4_QNAME);
    }

    public NFeConsultaProtocolo4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFECONSULTAPROTOCOLO4_QNAME, features);
    }

    public NFeConsultaProtocolo4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeConsultaProtocolo4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (NFECONSULTAPROTOCOLO4_EXCEPTION != null) {
            throw NFECONSULTAPROTOCOLO4_EXCEPTION;
        }
        return NFECONSULTAPROTOCOLO4_WSDL_LOCATION;
    }

    /**
     * @return returns NFeConsultaProtocolo4Soap
     */
    @WebEndpoint(name = "NFeConsultaProtocolo4Soap")
    public NFeConsultaProtocolo4Soap getNFeConsultaProtocolo4Soap() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "NFeConsultaProtocolo4Soap"), NFeConsultaProtocolo4Soap.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeConsultaProtocolo4Soap
     */
    @WebEndpoint(name = "NFeConsultaProtocolo4Soap")
    public NFeConsultaProtocolo4Soap getNFeConsultaProtocolo4Soap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "NFeConsultaProtocolo4Soap"), NFeConsultaProtocolo4Soap.class, features);
    }

}
