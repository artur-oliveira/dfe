
package br.inf.portalfiscal.cte4.wsdl.reception_sync.mg.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "CTeRecepcaoSincV4", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSinc", wsdlLocation = "https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoSincV4?wsdl")
public class CTeRecepcaoSincV4
    extends Service
{

    private static final URL CTERECEPCAOSINCV4_WSDL_LOCATION;
    private static final WebServiceException CTERECEPCAOSINCV4_EXCEPTION;
    private static final QName CTERECEPCAOSINCV4_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSinc", "CTeRecepcaoSincV4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoSincV4?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CTERECEPCAOSINCV4_WSDL_LOCATION = url;
        CTERECEPCAOSINCV4_EXCEPTION = e;
    }

    public CTeRecepcaoSincV4() {
        super(__getWsdlLocation(), CTERECEPCAOSINCV4_QNAME);
    }

    public CTeRecepcaoSincV4(WebServiceFeature... features) {
        super(__getWsdlLocation(), CTERECEPCAOSINCV4_QNAME, features);
    }

    public CTeRecepcaoSincV4(URL wsdlLocation) {
        super(wsdlLocation, CTERECEPCAOSINCV4_QNAME);
    }

    public CTeRecepcaoSincV4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CTERECEPCAOSINCV4_QNAME, features);
    }

    public CTeRecepcaoSincV4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CTeRecepcaoSincV4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CTeRecepcaoSincV4Soap12
     */
    @WebEndpoint(name = "CTeRecepcaoSincV4Soap12")
    public CTeRecepcaoSincV4Soap12 getCTeRecepcaoSincV4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSinc", "CTeRecepcaoSincV4Soap12"), CTeRecepcaoSincV4Soap12.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CTeRecepcaoSincV4Soap12
     */
    @WebEndpoint(name = "CTeRecepcaoSincV4Soap12")
    public CTeRecepcaoSincV4Soap12 getCTeRecepcaoSincV4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSinc", "CTeRecepcaoSincV4Soap12"), CTeRecepcaoSincV4Soap12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CTERECEPCAOSINCV4_EXCEPTION!= null) {
            throw CTERECEPCAOSINCV4_EXCEPTION;
        }
        return CTERECEPCAOSINCV4_WSDL_LOCATION;
    }

}
