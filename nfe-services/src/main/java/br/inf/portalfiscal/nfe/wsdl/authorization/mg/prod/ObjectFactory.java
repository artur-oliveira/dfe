package br.inf.portalfiscal.nfe.wsdl.authorization.mg.prod;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.nfe.wsdl.authorization.mg.prod package.
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

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.nfe.wsdl.authorization.mg.prod
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
     * Create an instance of {@link NfeDadosMsgZip }
     *
     * @return the new instance of {@link NfeDadosMsgZip }
     */
    public NfeDadosMsgZip createNfeDadosMsgZip() {
        return new NfeDadosMsgZip();
    }

    /**
     * Create an instance of {@link NFeAutorizacao4LoteResult }
     *
     * @return the new instance of {@link NFeAutorizacao4LoteResult }
     */
    public NFeAutorizacao4LoteResult createNFeAutorizacao4LoteResult() {
        return new NFeAutorizacao4LoteResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NFeAutorizacao4LoteResult }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link NFeAutorizacao4LoteResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", name = "nfeResultMsg")
    public JAXBElement<NFeAutorizacao4LoteResult> createNfeResultMsg(NFeAutorizacao4LoteResult value) {
        return new JAXBElement<>(_NfeResultMsg_QNAME, NFeAutorizacao4LoteResult.class, null, value);
    }

}
