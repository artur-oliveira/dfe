
package br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Serviço destinado ao atendimento de solicitações de consulta da situação atual do CT-e na Base de Dados do Portal da Secretaria de Fazenda Estadual.
 * 
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "CTeConsultaV4", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeConsultaV4", wsdlLocation = "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx?wsdl")
public class CTeConsultaV4
    extends Service
{

    private static final URL CTECONSULTAV4_WSDL_LOCATION;
    private static final WebServiceException CTECONSULTAV4_EXCEPTION;
    private static final QName CTECONSULTAV4_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeConsultaV4", "CTeConsultaV4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTECONSULTAV4_WSDL_LOCATION = url;
        CTECONSULTAV4_EXCEPTION = e;
    }

    public CTeConsultaV4() {
        super(__getWsdlLocation(), CTECONSULTAV4_QNAME);
    }

    public CTeConsultaV4(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTECONSULTAV4_QNAME, features);
    }

    public CTeConsultaV4(URL wsdlLocation) {
        super(wsdlLocation, CTECONSULTAV4_QNAME);
    }

    public CTeConsultaV4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTECONSULTAV4_QNAME, features);
    }

    public CTeConsultaV4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeConsultaV4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CTeConsultaV4Soap12
     */
    @WebEndpoint(name = "CTeConsultaV4Soap12")
    public CTeConsultaV4Soap12 getCTeConsultaV4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeConsultaV4", "CTeConsultaV4Soap12"), CTeConsultaV4Soap12.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CTeConsultaV4Soap12
     */
    @WebEndpoint(name = "CTeConsultaV4Soap12")
    public CTeConsultaV4Soap12 getCTeConsultaV4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeConsultaV4", "CTeConsultaV4Soap12"), CTeConsultaV4Soap12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CTECONSULTAV4_EXCEPTION!= null) {
            throw CTECONSULTAV4_EXCEPTION;
        }
        return CTECONSULTAV4_WSDL_LOCATION;
    }

}
