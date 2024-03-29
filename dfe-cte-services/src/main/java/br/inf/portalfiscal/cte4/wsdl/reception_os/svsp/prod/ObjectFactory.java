package br.inf.portalfiscal.cte4.wsdl.reception_os.svsp.prod;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.cte4.wsdl.reception_os.svsp.prod package.
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

    private static final QName _CteDadosMsg_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", "cteDadosMsg");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.cte4.wsdl.reception_os.svsp.prod
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CteRecepcaoOSResult }
     *
     * @return the new instance of {@link CteRecepcaoOSResult }
     */
    public CteRecepcaoOSResult createCteRecepcaoOSResult() {
        return new CteRecepcaoOSResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", name = "cteDadosMsg")
    public JAXBElement<String> createCteDadosMsg(String value) {
        return new JAXBElement<>(_CteDadosMsg_QNAME, String.class, null, value);
    }

}
