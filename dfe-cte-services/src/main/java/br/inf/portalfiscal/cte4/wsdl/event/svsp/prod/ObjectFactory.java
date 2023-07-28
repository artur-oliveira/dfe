package br.inf.portalfiscal.cte4.wsdl.event.svsp.prod;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.cte4.wsdl.event.svsp.prod package.
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.cte4.wsdl.event.svsp.prod
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
     * Create an instance of {@link CteRecepcaoEventoResult }
     *
     * @return the new instance of {@link CteRecepcaoEventoResult }
     */
    public CteRecepcaoEventoResult createCteRecepcaoEventoResult() {
        return new CteRecepcaoEventoResult();
    }

}