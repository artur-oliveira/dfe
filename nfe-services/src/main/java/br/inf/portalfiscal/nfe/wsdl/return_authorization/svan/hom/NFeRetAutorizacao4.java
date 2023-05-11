package br.inf.portalfiscal.nfe.wsdl.return_authorization.svan.hom;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebServiceClient(name = "NFeRetAutorizacao4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", wsdlLocation = "https://hom.sefazvirtual.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx?wsdl")
public class NFeRetAutorizacao4
        extends Service {

    private static final URL NFERETAUTORIZACAO4_WSDL_LOCATION;
    private static final WebServiceException NFERETAUTORIZACAO4_EXCEPTION;
    private static final QName NFERETAUTORIZACAO4_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NFeRetAutorizacao4");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://hom.sefazvirtual.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFERETAUTORIZACAO4_WSDL_LOCATION = url;
        NFERETAUTORIZACAO4_EXCEPTION = e;
    }

    public NFeRetAutorizacao4() {
        super(__getWsdlLocation(), NFERETAUTORIZACAO4_QNAME);
    }

    public NFeRetAutorizacao4(WebServiceFeature... features) {
        super(__getWsdlLocation(), NFERETAUTORIZACAO4_QNAME, features);
    }

    public NFeRetAutorizacao4(URL wsdlLocation) {
        super(wsdlLocation, NFERETAUTORIZACAO4_QNAME);
    }

    public NFeRetAutorizacao4(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NFERETAUTORIZACAO4_QNAME, features);
    }

    public NFeRetAutorizacao4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NFeRetAutorizacao4(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns NFeRetAutorizacao4Soap
     */
    @WebEndpoint(name = "NFeRetAutorizacao4Soap")
    public NFeRetAutorizacao4Soap getNFeRetAutorizacao4Soap() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NFeRetAutorizacao4Soap"), NFeRetAutorizacao4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeRetAutorizacao4Soap
     */
    @WebEndpoint(name = "NFeRetAutorizacao4Soap")
    public NFeRetAutorizacao4Soap getNFeRetAutorizacao4Soap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NFeRetAutorizacao4Soap"), NFeRetAutorizacao4Soap.class, features);
    }

    /**
     * @return returns NFeRetAutorizacao4Soap
     */
    @WebEndpoint(name = "NFeRetAutorizacao4Soap12")
    public NFeRetAutorizacao4Soap getNFeRetAutorizacao4Soap12() {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NFeRetAutorizacao4Soap12"), NFeRetAutorizacao4Soap.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns NFeRetAutorizacao4Soap
     */
    @WebEndpoint(name = "NFeRetAutorizacao4Soap12")
    public NFeRetAutorizacao4Soap getNFeRetAutorizacao4Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", "NFeRetAutorizacao4Soap12"), NFeRetAutorizacao4Soap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NFERETAUTORIZACAO4_EXCEPTION != null) {
            throw NFERETAUTORIZACAO4_EXCEPTION;
        }
        return NFERETAUTORIZACAO4_WSDL_LOCATION;
    }

}
