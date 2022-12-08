package br.inf.portalfiscal.cte.wsdl.query_situation.ms.hom;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.cte.wsdl.query_situation.ms.hom package.
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

    private final static QName _CteCabecMsg_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta", "cteCabecMsg");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.cte.wsdl.query_situation.ms.hom
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CTeCabecMsg }
     */
    public CTeCabecMsg createCTeCabecMsg() {
        return new CTeCabecMsg();
    }

    /**
     * Create an instance of {@link CteConsultaCTResult }
     */
    public CteConsultaCTResult createCteConsultaCTResult() {
        return new CteConsultaCTResult();
    }

    /**
     * Create an instance of {@link CteDadosMsg }
     */
    public CteDadosMsg createCteDadosMsg() {
        return new CteDadosMsg();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CTeCabecMsg }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link CTeCabecMsg }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta", name = "cteCabecMsg")
    public JAXBElement<CTeCabecMsg> createCteCabecMsg(CTeCabecMsg value) {
        return new JAXBElement<CTeCabecMsg>(_CteCabecMsg_QNAME, CTeCabecMsg.class, null, value);
    }

}
