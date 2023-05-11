package br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom package.
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

    private static final QName _CteCabecMsg_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", "cteCabecMsg");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CteDadosMsg }
     *
     * @return the new instance of {@link CteDadosMsg }
     */
    public CteDadosMsg createCteDadosMsg() {
        return new CteDadosMsg();
    }

    /**
     * Create an instance of {@link CteInutilizacaoCTResult }
     *
     * @return the new instance of {@link CteInutilizacaoCTResult }
     */
    public CteInutilizacaoCTResult createCteInutilizacaoCTResult() {
        return new CteInutilizacaoCTResult();
    }

    /**
     * Create an instance of {@link CTeCabecMsg }
     *
     * @return the new instance of {@link CTeCabecMsg }
     */
    public CTeCabecMsg createCTeCabecMsg() {
        return new CTeCabecMsg();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CTeCabecMsg }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link CTeCabecMsg }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", name = "cteCabecMsg")
    public JAXBElement<CTeCabecMsg> createCteCabecMsg(CTeCabecMsg value) {
        return new JAXBElement<>(_CteCabecMsg_QNAME, CTeCabecMsg.class, null, value);
    }

}
