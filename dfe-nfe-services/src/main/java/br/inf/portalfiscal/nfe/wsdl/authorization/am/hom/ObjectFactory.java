package br.inf.portalfiscal.nfe.wsdl.authorization.am.hom;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.nfe.wsdl.authorization.am.hom package.
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

    private static final QName _NfeResultMsg_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", "nfeResultMsg");
    private static final QName _NfeDadosMsgZip_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", "nfeDadosMsgZip");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.nfe.wsdl.authorization.am.hom
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NfeDadosMsg }
     *
     * @return the new instance of {@link NfeDadosMsg }
     */
    public NfeDadosMsg createNfeDadosMsg() {
        return new NfeDadosMsg();
    }

    /**
     * Create an instance of {@link NfeResultMsg }
     *
     * @return the new instance of {@link NfeResultMsg }
     */
    public NfeResultMsg createNfeResultMsg() {
        return new NfeResultMsg();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NfeResultMsg }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link NfeResultMsg }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", name = "nfeResultMsg")
    public JAXBElement<NfeResultMsg> createNfeResultMsg(NfeResultMsg value) {
        return new JAXBElement<>(_NfeResultMsg_QNAME, NfeResultMsg.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", name = "nfeDadosMsgZip")
    public JAXBElement<String> createNfeDadosMsgZip(String value) {
        return new JAXBElement<>(_NfeDadosMsgZip_QNAME, String.class, null, value);
    }

}
