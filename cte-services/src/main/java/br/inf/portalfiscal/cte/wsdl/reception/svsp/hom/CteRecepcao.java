package br.inf.portalfiscal.cte.wsdl.reception.svsp.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Serviço destinado à recepção de mensagens de
 * lote de CT-e.
 * <p>
 * <p>
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CteRecepcao", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", wsdlLocation = "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcao.asmx?wsdl")
public class CteRecepcao
        extends Service {

    private static final URL CTERECEPCAO_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAO_EXCEPTION;
    private static final QName CTERECEPCAO_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", "CteRecepcao");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcao.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAO_WSDL_LOCATION = url;
        CTERECEPCAO_EXCEPTION = e;
    }

    public CteRecepcao() {
        super(__getWsdlLocation(), CTERECEPCAO_QNAME);
    }

    public CteRecepcao(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAO_QNAME, features);
    }

    public CteRecepcao(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAO_QNAME);
    }

    public CteRecepcao(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAO_QNAME, features);
    }

    public CteRecepcao(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CteRecepcao(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns CteRecepcaoSoap12
     */
    @WebEndpoint(name = "CteRecepcaoSoap12")
    public CteRecepcaoSoap12 getCteRecepcaoSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", "CteRecepcaoSoap12"), CteRecepcaoSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CteRecepcaoSoap12
     */
    @WebEndpoint(name = "CteRecepcaoSoap12")
    public CteRecepcaoSoap12 getCteRecepcaoSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", "CteRecepcaoSoap12"), CteRecepcaoSoap12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAO_EXCEPTION != null) {
            throw CTERECEPCAO_EXCEPTION;
        }
        return CTERECEPCAO_WSDL_LOCATION;
    }

}
