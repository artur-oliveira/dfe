//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.08.18 às 10:10:30 PM BRT 
//


package br.inf.portalfiscal.nfe.gtin;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TConsGTIN }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "consGTIN")
    public JAXBElement<TConsGTIN> createConsGTIN(TConsGTIN value) {
        return new JAXBElement<TConsGTIN>(_ConsGTIN_QNAME, TConsGTIN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRetConsGTIN }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "retConsGTIN")
    public JAXBElement<TRetConsGTIN> createRetConsGTIN(TRetConsGTIN value) {
        return new JAXBElement<TRetConsGTIN>(_RetConsGTIN_QNAME, TRetConsGTIN.class, null, value);
    }

}
