//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EvCancCECTe complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EvCancCECTe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="Cancelamento do Comprovante de Entrega do CT-e"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/cte}TProt"/&gt;
 *         &lt;element name="nProtCE" type="{http://www.portalfiscal.inf.br/cte}TProt"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvCancCECTe", propOrder = {
        "descEvento",
        "nProt",
        "nProtCE"
})
public class EvCancCECTe
        implements XML {

    @XmlElement(required = true)
    protected String descEvento;
    @XmlElement(required = true)
    protected String nProt;
    @XmlElement(required = true)
    protected String nProtCE;

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
     * Gets the value of the nProt property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNProt() {
        return nProt;
    }

    /**
     * Sets the value of the nProt property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNProt(String value) {
        this.nProt = value;
    }

    public boolean isSetNProt() {
        return (this.nProt != null);
    }

    /**
     * Gets the value of the nProtCE property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNProtCE() {
        return nProtCE;
    }

    /**
     * Sets the value of the nProtCE property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNProtCE(String value) {
        this.nProtCE = value;
    }

    public boolean isSetNProtCE() {
        return (this.nProtCE != null);
    }

}