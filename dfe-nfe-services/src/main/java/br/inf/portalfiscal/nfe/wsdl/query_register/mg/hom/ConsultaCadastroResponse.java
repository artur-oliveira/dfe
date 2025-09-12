package br.inf.portalfiscal.nfe.wsdl.query_register.mg.hom;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element ref="{http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4}consultaCadastro4Result"/>
 *         <element ref="{http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4}nfeCabecMsg"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "consultaCadastro4Result",
        "nfeCabecMsg"
})
@XmlRootElement(name = "consultaCadastroResponse", namespace = "")
public class ConsultaCadastroResponse {

    @XmlElement(required = true)
    protected ConsultaCadastro4Result consultaCadastro4Result;
    @XmlElement(required = true)
    protected NfeCabecMsg nfeCabecMsg;

    /**
     * Gets the value of the consultaCadastro4Result property.
     *
     * @return possible object is
     * {@link ConsultaCadastro4Result }
     *
     */
    public ConsultaCadastro4Result getConsultaCadastro4Result() {
        return consultaCadastro4Result;
    }

    /**
     * Sets the value of the consultaCadastro4Result property.
     *
     * @param value allowed object is
     *              {@link ConsultaCadastro4Result }
     *
     */
    public void setConsultaCadastro4Result(ConsultaCadastro4Result value) {
        this.consultaCadastro4Result = value;
    }

    /**
     * Gets the value of the nfeCabecMsg property.
     *
     * @return possible object is
     * {@link NfeCabecMsg }
     *
     */
    public NfeCabecMsg getNfeCabecMsg() {
        return nfeCabecMsg;
    }

    /**
     * Sets the value of the nfeCabecMsg property.
     *
     * @param value allowed object is
     *              {@link NfeCabecMsg }
     *
     */
    public void setNfeCabecMsg(NfeCabecMsg value) {
        this.nfeCabecMsg = value;
    }

}
