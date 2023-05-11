package br.inf.portalfiscal.cte.wsdl.reception_sync.svsp.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Serviço destinado à recepção de mensagens de
 * CTe síncrono (modelo 57).
 * <p>
 * <p>
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CTeRecepcaoSinc", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSinc", wsdlLocation = "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CTeRecepcaoSinc.asmx?wsdl")
public class CTeRecepcaoSinc
        extends Service {

    private static final URL CTERECEPCAOSINC_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAOSINC_EXCEPTION;
    private static final QName CTERECEPCAOSINC_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSinc", "CTeRecepcaoSinc");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CTeRecepcaoSinc.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOSINC_WSDL_LOCATION = url;
        CTERECEPCAOSINC_EXCEPTION = e;
    }

    public CTeRecepcaoSinc() {
        super(__getWsdlLocation(), CTERECEPCAOSINC_QNAME);
    }

    public CTeRecepcaoSinc(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOSINC_QNAME, features);
    }

    public CTeRecepcaoSinc(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOSINC_QNAME);
    }

    public CTeRecepcaoSinc(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOSINC_QNAME, features);
    }

    public CTeRecepcaoSinc(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeRecepcaoSinc(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns CTeRecepcaoSincSoap12
     */
    @WebEndpoint(name = "CTeRecepcaoSincSoap12")
    public CTeRecepcaoSincSoap12 getCTeRecepcaoSincSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSinc", "CTeRecepcaoSincSoap12"), CTeRecepcaoSincSoap12.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CTeRecepcaoSincSoap12
     */
    @WebEndpoint(name = "CTeRecepcaoSincSoap12")
    public CTeRecepcaoSincSoap12 getCTeRecepcaoSincSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSinc", "CTeRecepcaoSincSoap12"), CTeRecepcaoSincSoap12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOSINC_EXCEPTION != null) {
            throw CTERECEPCAOSINC_EXCEPTION;
        }
        return CTERECEPCAOSINC_WSDL_LOCATION;
    }

}
