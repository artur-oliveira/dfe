package br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Servico destinado ao atendimento de solicitacoes de consulta da situacao atual da NFe na Base de Dados do Portal da Secretaria de Fazenda Estadual
 * <p>
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NFeConsultaProtocolo4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", wsdlLocation = "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeConsultaProtocolo4?wsdl")
public class NFeConsultaProtocolo4
        extends Service {

    private static final URL NFECONSULTAPROTOCOLO4_WSDL_LOCATION;
    private static final WebServiceException NFECONSULTAPROTOCOLO4_EXCEPTION;
    private static final QName NFECONSULTAPROTOCOLO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "NFeConsultaProtocolo4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeConsultaProtocolo4?wsdl");
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
     * @return returns NFeConsultaProtocolo4Soap12
     */
    @WebEndpoint(name = "NFeConsultaProtocolo4ServicePort")
    public NFeConsultaProtocolo4Soap12 getNFeConsultaProtocolo4ServicePort() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "NFeConsultaProtocolo4ServicePort"), NFeConsultaProtocolo4Soap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeConsultaProtocolo4Soap12
     */
    @WebEndpoint(name = "NFeConsultaProtocolo4ServicePort")
    public NFeConsultaProtocolo4Soap12 getNFeConsultaProtocolo4ServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", "NFeConsultaProtocolo4ServicePort"), NFeConsultaProtocolo4Soap12.class, features);
    }

}
