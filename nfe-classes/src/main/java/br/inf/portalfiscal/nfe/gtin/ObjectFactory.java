//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.nfe.gtin;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.nfe.gtin package.
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

    private final static QName _ConsGTIN_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "consGTIN");
    private final static QName _RetConsGTIN_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "retConsGTIN");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.nfe.gtin
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TConsGTIN }
     */
    public TConsGTIN createTConsGTIN() {
        return new TConsGTIN();
    }

    /**
     * Create an instance of {@link TRetConsGTIN }
     */
    public TRetConsGTIN createTRetConsGTIN() {
        return new TRetConsGTIN();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TConsGTIN }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link TConsGTIN }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "consGTIN")
    public JAXBElement<TConsGTIN> createConsGTIN(TConsGTIN value) {
        return new JAXBElement<>(_ConsGTIN_QNAME, TConsGTIN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRetConsGTIN }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link TRetConsGTIN }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "retConsGTIN")
    public JAXBElement<TRetConsGTIN> createRetConsGTIN(TRetConsGTIN value) {
        return new JAXBElement<>(_RetConsGTIN_QNAME, TRetConsGTIN.class, null, value);
    }

}
