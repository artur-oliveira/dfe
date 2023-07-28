//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:09 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EvIncCondutorMDFe complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EvIncCondutorMDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="Inclusao Condutor"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="condutor"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="xNome"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;maxLength value="60"/&gt;
 *                         &lt;minLength value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvIncCondutorMDFe", propOrder = {
        "descEvento",
        "condutor"
})
public class EvIncCondutorMDFe
        implements XML {

    @XmlElement(required = true)
    protected String descEvento;
    @XmlElement(required = true)
    protected Condutor condutor;

    /**
     * Gets the value of the descEvento property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescEvento() {
        return descEvento;
    }

    /**
     * Sets the value of the descEvento property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescEvento(String value) {
        this.descEvento = value;
    }

    public boolean isSetDescEvento() {
        return (this.descEvento != null);
    }

    /**
     * Gets the value of the condutor property.
     *
     * @return possible object is
     * {@link Condutor }
     */
    public Condutor getCondutor() {
        return condutor;
    }

    /**
     * Sets the value of the condutor property.
     *
     * @param value allowed object is
     *              {@link Condutor }
     */
    public void setCondutor(Condutor value) {
        this.condutor = value;
    }

    public boolean isSetCondutor() {
        return (this.condutor != null);
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="xNome"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;maxLength value="60"/&gt;
     *               &lt;minLength value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "xNome",
            "cpf"
    })
    public static class Condutor
            implements XML {

        @XmlElement(required = true)
        protected String xNome;
        @XmlElement(name = "CPF", required = true)
        protected String cpf;

        /**
         * Gets the value of the xNome property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getXNome() {
            return xNome;
        }

        /**
         * Sets the value of the xNome property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setXNome(String value) {
            this.xNome = value;
        }

        public boolean isSetXNome() {
            return (this.xNome != null);
        }

        /**
         * Gets the value of the cpf property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCPF() {
            return cpf;
        }

        /**
         * Sets the value of the cpf property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCPF(String value) {
            this.cpf = value;
        }

        public boolean isSetCPF() {
            return (this.cpf != null);
        }

    }

}