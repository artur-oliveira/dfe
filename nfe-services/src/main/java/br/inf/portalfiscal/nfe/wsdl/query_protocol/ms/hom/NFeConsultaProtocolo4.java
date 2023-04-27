package br.inf.portalfiscal.nfe.wsdl.query_protocol.ms.hom;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "NFeConsultaProtocolo4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", wsdlLocation = "https://hom.nfe.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4?wsdl")
public class NFeConsultaProtocolo4
        extends Service {

    private final static URL NFECONSULTAPROTOCOLO4_WSDL_LOCATION;
    private final static WebServiceException NFECONSULTAPROTOCOLO4_EXCEPTION;
    private final static QName NFECONSULTAPROTOCOLO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "NFeConsultaProtocolo4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://hom.nfe.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4?wsdl");
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
     * @return returns NFeConsultaProtocoloSoap
     */
    @WebEndpoint(name = "nfeConsultaProtocolo4Soap12")
    public NFeConsultaProtocoloSoap getNfeConsultaProtocolo4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "nfeConsultaProtocolo4Soap12"), NFeConsultaProtocoloSoap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeConsultaProtocoloSoap
     */
    @WebEndpoint(name = "nfeConsultaProtocolo4Soap12")
    public NFeConsultaProtocoloSoap getNfeConsultaProtocolo4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "nfeConsultaProtocolo4Soap12"), NFeConsultaProtocoloSoap.class, features);
    }

}
