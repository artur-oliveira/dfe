package br.inf.portalfiscal.mdfe.wsdl.event.svrs.prod;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.mdfe.wsdl.event.svrs.prod package.
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

    private static final QName _MdfeCabecMsg_QNAME = new QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento", "mdfeCabecMsg");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.mdfe.wsdl.event.svrs.prod
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MdfeDadosMsg }
     *
     * @return the new instance of {@link MdfeDadosMsg }
     */
    public MdfeDadosMsg createMdfeDadosMsg() {
        return new MdfeDadosMsg();
    }

    /**
     * Create an instance of {@link MdfeRecepcaoEventoResult }
     *
     * @return the new instance of {@link MdfeRecepcaoEventoResult }
     */
    public MdfeRecepcaoEventoResult createMdfeRecepcaoEventoResult() {
        return new MdfeRecepcaoEventoResult();
    }

    /**
     * Create an instance of {@link MdfeCabecMsg }
     *
     * @return the new instance of {@link MdfeCabecMsg }
     */
    public MdfeCabecMsg createMdfeCabecMsg() {
        return new MdfeCabecMsg();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MdfeCabecMsg }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link MdfeCabecMsg }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento", name = "mdfeCabecMsg")
    public JAXBElement<MdfeCabecMsg> createMdfeCabecMsg(MdfeCabecMsg value) {
        return new JAXBElement<>(_MdfeCabecMsg_QNAME, MdfeCabecMsg.class, null, value);
    }

}
