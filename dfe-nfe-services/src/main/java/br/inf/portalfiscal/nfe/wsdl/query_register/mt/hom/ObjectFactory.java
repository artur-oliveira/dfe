package br.inf.portalfiscal.nfe.wsdl.query_register.mt.hom;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.nfe.wsdl.query_register.mt.hom package.
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.nfe.wsdl.query_register.mt.hom
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaCadastro }
     *
     * @return the new instance of {@link ConsultaCadastro }
     */
    public ConsultaCadastro createConsultaCadastro() {
        return new ConsultaCadastro();
    }

    /**
     * Create an instance of {@link NfeResultMsg }
     *
     * @return the new instance of {@link NfeResultMsg }
     */
    public NfeResultMsg createNfeResultMsg() {
        return new NfeResultMsg();
    }

    /**
     * Create an instance of {@link ConsultaCadastro.NfeDadosMsg }
     *
     * @return the new instance of {@link ConsultaCadastro.NfeDadosMsg }
     */
    public ConsultaCadastro.NfeDadosMsg createConsultaCadastroNfeDadosMsg() {
        return new ConsultaCadastro.NfeDadosMsg();
    }

    /**
     * Create an instance of {@link NfeResultMsg.ConsultaCadastroResult }
     *
     * @return the new instance of {@link NfeResultMsg.ConsultaCadastroResult }
     */
    public NfeResultMsg.ConsultaCadastroResult createNfeResultMsgConsultaCadastroResult() {
        return new NfeResultMsg.ConsultaCadastroResult();
    }

}
