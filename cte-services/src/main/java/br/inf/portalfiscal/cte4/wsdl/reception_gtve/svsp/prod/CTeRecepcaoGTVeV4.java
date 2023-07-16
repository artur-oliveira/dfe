package br.inf.portalfiscal.cte4.wsdl.reception_gtve.svsp.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Serviço destinado à recepção de mensagens de GTVe (modelo 64).
 * <p>
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "CTeRecepcaoGTVeV4", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVeV4", wsdlLocation = "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx?wsdl")
public class CTeRecepcaoGTVeV4
        extends Service {

    private static final URL CTERECEPCAOGTVEV4_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAOGTVEV4_EXCEPTION;
    private static final QName CTERECEPCAOGTVEV4_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVeV4", "CTeRecepcaoGTVeV4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOGTVEV4_WSDL_LOCATION = url;
        CTERECEPCAOGTVEV4_EXCEPTION = e;
    }

    public CTeRecepcaoGTVeV4() {
        super(__getWsdlLocation(), CTERECEPCAOGTVEV4_QNAME);
    }

    public CTeRecepcaoGTVeV4(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOGTVEV4_QNAME, features);
    }

    public CTeRecepcaoGTVeV4(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOGTVEV4_QNAME);
    }

    public CTeRecepcaoGTVeV4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOGTVEV4_QNAME, features);
    }

    public CTeRecepcaoGTVeV4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeRecepcaoGTVeV4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOGTVEV4_EXCEPTION != null) {
            throw CTERECEPCAOGTVEV4_EXCEPTION;
        }
        return CTERECEPCAOGTVEV4_WSDL_LOCATION;
    }

    /**
     * @return returns CTeRecepcaoGTVeV4Soap12
     */
    @WebEndpoint(name = "CTeRecepcaoGTVeV4Soap12")
    public CTeRecepcaoGTVeV4Soap12 getCTeRecepcaoGTVeV4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVeV4", "CTeRecepcaoGTVeV4Soap12"), CTeRecepcaoGTVeV4Soap12.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CTeRecepcaoGTVeV4Soap12
     */
    @WebEndpoint(name = "CTeRecepcaoGTVeV4Soap12")
    public CTeRecepcaoGTVeV4Soap12 getCTeRecepcaoGTVeV4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVeV4", "CTeRecepcaoGTVeV4Soap12"), CTeRecepcaoGTVeV4Soap12.class, features);
    }

}
