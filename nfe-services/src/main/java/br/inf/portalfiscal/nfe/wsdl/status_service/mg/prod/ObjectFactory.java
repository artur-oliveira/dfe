package br.inf.portalfiscal.nfe.wsdl.status_service.mg.prod;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.nfe.wsdl.status_service.mg.prod package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NfeResultMsg_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "nfeResultMsg");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.nfe.wsdl.status_service.mg.prod
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NfeDadosMsg }
     */
    public NfeDadosMsg createNfeDadosMsg() {
        return new NfeDadosMsg();
    }

    /**
     * Create an instance of {@link NFeStatusServico4Result }
     */
    public NFeStatusServico4Result createNFeStatusServico4Result() {
        return new NFeStatusServico4Result();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NFeStatusServico4Result }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link NFeStatusServico4Result }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", name = "nfeResultMsg")
    public JAXBElement<NFeStatusServico4Result> createNfeResultMsg(NFeStatusServico4Result value) {
        return new JAXBElement<NFeStatusServico4Result>(_NfeResultMsg_QNAME, NFeStatusServico4Result.class, null, value);
    }

}
