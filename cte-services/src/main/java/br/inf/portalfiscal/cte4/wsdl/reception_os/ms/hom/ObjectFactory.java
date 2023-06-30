
package br.inf.portalfiscal.cte4.wsdl.reception_os.ms.hom;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.inf.portalfiscal.cte4.wsdl.reception_os.ms.hom package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _CteDadosMsg_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", "cteDadosMsg");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.cte4.wsdl.reception_os.ms.hom
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetCTeOS }
     * 
     * @return
     *     the new instance of {@link RetCTeOS }
     */
    public RetCTeOS createRetCTeOS() {
        return new RetCTeOS();
    }

    /**
     * Create an instance of {@link CteRecepcaoOSResult }
     * 
     * @return
     *     the new instance of {@link CteRecepcaoOSResult }
     */
    public CteRecepcaoOSResult createCteRecepcaoOSResult() {
        return new CteRecepcaoOSResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetCTeOS }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RetCTeOS }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", name = "cteDadosMsg")
    public JAXBElement<RetCTeOS> createCteDadosMsg(RetCTeOS value) {
        return new JAXBElement<>(_CteDadosMsg_QNAME, RetCTeOS.class, null, value);
    }

}