package br.inf.portalfiscal.cte.wsdl.inutilization.mg.prod;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * ServiÃ§o destinado ao atendimento de solicitaÃ§Ãµes de inutilizaÃ§Ã£o de numeraÃ§Ã£o de CT-e.
 * <p>
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebServiceClient(name = "CteInutilizacao", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", wsdlLocation = "https://cte.fazenda.mg.gov.br/cte/services/CteInutilizacao?wsdl")
public class CteInutilizacao
        extends Service {

    private final static URL CTEINUTILIZACAO_WSDL_LOCATION;
    private final static WebServiceException CTEINUTILIZACAO_EXCEPTION;
    private final static QName CTEINUTILIZACAO_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", "CteInutilizacao");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://cte.fazenda.mg.gov.br/cte/services/CteInutilizacao?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTEINUTILIZACAO_WSDL_LOCATION = url;
        CTEINUTILIZACAO_EXCEPTION = e;
    }

    public CteInutilizacao() {
        super(__getWsdlLocation(), CTEINUTILIZACAO_QNAME);
    }

    public CteInutilizacao(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTEINUTILIZACAO_QNAME, features);
    }

    public CteInutilizacao(URL wsdlLocation) {
        super(wsdlLocation, CTEINUTILIZACAO_QNAME);
    }

    public CteInutilizacao(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTEINUTILIZACAO_QNAME, features);
    }

    public CteInutilizacao(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CteInutilizacao(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTEINUTILIZACAO_EXCEPTION != null) {
            throw CTEINUTILIZACAO_EXCEPTION;
        }
        return CTEINUTILIZACAO_WSDL_LOCATION;
    }

    /**
     * @return returns CteInutilizacaoSoap12
     */
    @WebEndpoint(name = "CteInutilizacaoSoap12")
    public CteInutilizacaoSoap12 getCteInutilizacaoSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", "CteInutilizacaoSoap12"), CteInutilizacaoSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CteInutilizacaoSoap12
     */
    @WebEndpoint(name = "CteInutilizacaoSoap12")
    public CteInutilizacaoSoap12 getCteInutilizacaoSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", "CteInutilizacaoSoap12"), CteInutilizacaoSoap12.class, features);
    }

}
