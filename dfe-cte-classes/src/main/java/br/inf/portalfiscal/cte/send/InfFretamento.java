//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InfFretamento complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InfFretamento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpFretamento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dhViagem" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfFretamento", propOrder = {
        "tpFretamento",
        "dhViagem"
})
public class InfFretamento
        implements XML {

    @XmlElement(required = true)
    protected String tpFretamento;
    protected String dhViagem;

    /**
     * Gets the value of the tpFretamento property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpFretamento() {
        return tpFretamento;
    }

    /**
     * Sets the value of the tpFretamento property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpFretamento(String value) {
        this.tpFretamento = value;
    }

    public boolean isSetTpFretamento() {
        return (this.tpFretamento != null);
    }

    /**
     * Gets the value of the dhViagem property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhViagem() {
        return dhViagem;
    }

    /**
     * Sets the value of the dhViagem property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhViagem(String value) {
        this.dhViagem = value;
    }

    public boolean isSetDhViagem() {
        return (this.dhViagem != null);
    }

}
