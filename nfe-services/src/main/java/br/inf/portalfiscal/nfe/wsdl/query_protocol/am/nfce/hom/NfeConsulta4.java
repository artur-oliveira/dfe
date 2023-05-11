package br.inf.portalfiscal.nfe.wsdl.query_protocol.am.nfce.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NfeConsulta4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", wsdlLocation = "https://homnfce.sefaz.am.gov.br/nfce-services/services/NfeConsulta4?wsdl")
public class NfeConsulta4
        extends Service {

    private static final URL NFECONSULTA4_WSDL_LOCATION;
    private static final WebServiceException NFECONSULTA4_EXCEPTION;
    private static final QName NFECONSULTA4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "NfeConsulta4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homnfce.sefaz.am.gov.br/nfce-services/services/NfeConsulta4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFECONSULTA4_WSDL_LOCATION = url;
        NFECONSULTA4_EXCEPTION = e;
    }

    public NfeConsulta4() {
        super(__getWsdlLocation(), NFECONSULTA4_QNAME);
    }

    public NfeConsulta4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFECONSULTA4_QNAME, features);
    }

    public NfeConsulta4(URL wsdlLocation) {
        super(wsdlLocation, NFECONSULTA4_QNAME);
    }

    public NfeConsulta4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFECONSULTA4_QNAME, features);
    }

    public NfeConsulta4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NfeConsulta4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns NfeConsulta4Soap
     */
    @WebEndpoint(name = "NfeConsulta4Soap12")
    public NfeConsulta4Soap getNfeConsulta4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "NfeConsulta4Soap12"), NfeConsulta4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NfeConsulta4Soap
     */
    @WebEndpoint(name = "NfeConsulta4Soap12")
    public NfeConsulta4Soap getNfeConsulta4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "NfeConsulta4Soap12"), NfeConsulta4Soap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NFECONSULTA4_EXCEPTION != null) {
            throw NFECONSULTA4_EXCEPTION;
        }
        return NFECONSULTA4_WSDL_LOCATION;
    }

}
