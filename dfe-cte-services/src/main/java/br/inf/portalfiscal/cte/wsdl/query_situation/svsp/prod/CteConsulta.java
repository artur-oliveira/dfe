package br.inf.portalfiscal.cte.wsdl.query_situation.svsp.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Serviço destinado ao atendimento de solicitações de consulta da situação atual do CT-e na Base de Dados do Portal da Secretaria de Fazenda Estadual.
 * <p>
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CteConsulta", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta", wsdlLocation = "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteConsulta.asmx?wsdl")
public class CteConsulta
        extends Service {

    private static final URL CTECONSULTA_WSDL_LOCATION;
    private static final WebServiceException CTECONSULTA_EXCEPTION;
    private static final QName CTECONSULTA_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta", "CteConsulta");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteConsulta.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTECONSULTA_WSDL_LOCATION = url;
        CTECONSULTA_EXCEPTION = e;
    }

    public CteConsulta() {
        super(__getWsdlLocation(), CTECONSULTA_QNAME);
    }

    public CteConsulta(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTECONSULTA_QNAME, features);
    }

    public CteConsulta(URL wsdlLocation) {
        super(wsdlLocation, CTECONSULTA_QNAME);
    }

    public CteConsulta(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTECONSULTA_QNAME, features);
    }

    public CteConsulta(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CteConsulta(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTECONSULTA_EXCEPTION != null) {
            throw CTECONSULTA_EXCEPTION;
        }
        return CTECONSULTA_WSDL_LOCATION;
    }

    /**
     * @return returns CteConsultaSoap12
     */
    @WebEndpoint(name = "CteConsultaSoap12")
    public CteConsultaSoap12 getCteConsultaSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta", "CteConsultaSoap12"), CteConsultaSoap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CteConsultaSoap12
     */
    @WebEndpoint(name = "CteConsultaSoap12")
    public CteConsultaSoap12 getCteConsultaSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta", "CteConsultaSoap12"), CteConsultaSoap12.class, features);
    }

}