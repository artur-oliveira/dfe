
package br.inf.portalfiscal.nfce.wsdl.authorization.ce.prod;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.inf.portalfiscal.nfce.wsdl.authorization.ce.prod package. 
 * <p>An ObjectFactory allows you to programmatically 
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

    private static final QName _NfeDadosMsgZIP_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", "nfeDadosMsgZIP");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.nfce.wsdl.authorization.ce.prod
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NfeDadosMsg }
     * 
     * @return
     *     the new instance of {@link NfeDadosMsg }
     */
    public NfeDadosMsg createNfeDadosMsg() {
        return new NfeDadosMsg();
    }

    /**
     * Create an instance of {@link NfeResultMsg }
     * 
     * @return
     *     the new instance of {@link NfeResultMsg }
     */
    public NfeResultMsg createNfeResultMsg() {
        return new NfeResultMsg();
    }

    /**
     * Create an instance of {@link NfeAutorizacaoLoteZipResult }
     * 
     * @return
     *     the new instance of {@link NfeAutorizacaoLoteZipResult }
     */
    public NfeAutorizacaoLoteZipResult createNfeAutorizacaoLoteZipResult() {
        return new NfeAutorizacaoLoteZipResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", name = "nfeDadosMsgZIP")
    public JAXBElement<String> createNfeDadosMsgZIP(String value) {
        return new JAXBElement<>(_NfeDadosMsgZIP_QNAME, String.class, null, value);
    }

}
