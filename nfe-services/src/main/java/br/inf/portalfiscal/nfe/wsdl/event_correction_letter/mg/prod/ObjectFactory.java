package br.inf.portalfiscal.nfe.wsdl.event_correction_letter.mg.prod;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.nfe.wsdl.event_correction_letter.mg.prod package.
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

    private static final QName _NfeResultMsg_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "nfeResultMsg");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.nfe.wsdl.event_correction_letter.mg.prod
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
     * Create an instance of {@link NFeRecepcaoEvento4Result }
     *
     * @return the new instance of {@link NFeRecepcaoEvento4Result }
     */
    public NFeRecepcaoEvento4Result createNFeRecepcaoEvento4Result() {
        return new NFeRecepcaoEvento4Result();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NFeRecepcaoEvento4Result }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link NFeRecepcaoEvento4Result }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", name = "nfeResultMsg")
    public JAXBElement<NFeRecepcaoEvento4Result> createNfeResultMsg(NFeRecepcaoEvento4Result value) {
        return new JAXBElement<>(_NfeResultMsg_QNAME, NFeRecepcaoEvento4Result.class, null, value);
    }

}
