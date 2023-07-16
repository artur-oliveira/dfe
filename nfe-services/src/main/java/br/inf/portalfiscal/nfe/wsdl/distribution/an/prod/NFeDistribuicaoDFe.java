package br.inf.portalfiscal.nfe.wsdl.distribution.an.prod;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NFeDistribuicaoDFe", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe", wsdlLocation = "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx?wsdl")
public class NFeDistribuicaoDFe
        extends Service {

    private static final URL NFEDISTRIBUICAODFE_WSDL_LOCATION;
    private static final WebServiceException NFEDISTRIBUICAODFE_EXCEPTION;
    private static final QName NFEDISTRIBUICAODFE_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe", "NFeDistribuicaoDFe");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFEDISTRIBUICAODFE_WSDL_LOCATION = url;
        NFEDISTRIBUICAODFE_EXCEPTION = e;
    }

    public NFeDistribuicaoDFe() {
        super(__getWsdlLocation(), NFEDISTRIBUICAODFE_QNAME);
    }

    public NFeDistribuicaoDFe(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFEDISTRIBUICAODFE_QNAME, features);
    }

    public NFeDistribuicaoDFe(URL wsdlLocation) {
        super(wsdlLocation, NFEDISTRIBUICAODFE_QNAME);
    }

    public NFeDistribuicaoDFe(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFEDISTRIBUICAODFE_QNAME, features);
    }

    public NFeDistribuicaoDFe(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeDistribuicaoDFe(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (NFEDISTRIBUICAODFE_EXCEPTION != null) {
            throw NFEDISTRIBUICAODFE_EXCEPTION;
        }
        return NFEDISTRIBUICAODFE_WSDL_LOCATION;
    }

    /**
     * @return returns NFeDistribuicaoDFeSoap
     */
    @WebEndpoint(name = "NFeDistribuicaoDFeSoap")
    public NFeDistribuicaoDFeSoap getNFeDistribuicaoDFeSoap() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe", "NFeDistribuicaoDFeSoap"), NFeDistribuicaoDFeSoap.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeDistribuicaoDFeSoap
     */
    @WebEndpoint(name = "NFeDistribuicaoDFeSoap")
    public NFeDistribuicaoDFeSoap getNFeDistribuicaoDFeSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe", "NFeDistribuicaoDFeSoap"), NFeDistribuicaoDFeSoap.class, features);
    }

    /**
     * @return returns NFeDistribuicaoDFeSoap
     */
    @WebEndpoint(name = "NFeDistribuicaoDFeSoap12")
    public NFeDistribuicaoDFeSoap getNFeDistribuicaoDFeSoap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe", "NFeDistribuicaoDFeSoap12"), NFeDistribuicaoDFeSoap.class);
    }

    /**
     * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeDistribuicaoDFeSoap
     */
    @WebEndpoint(name = "NFeDistribuicaoDFeSoap12")
    public NFeDistribuicaoDFeSoap getNFeDistribuicaoDFeSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe", "NFeDistribuicaoDFeSoap12"), NFeDistribuicaoDFeSoap.class, features);
    }

}
