//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send400;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EvRegMultimodal complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EvRegMultimodal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="Registro Multimodal"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xRegistro"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="15"/&gt;
 *               &lt;maxLength value="1000"/&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[!-ÿ]{1}[ -ÿ]{0,}[!-ÿ]{1}|[!-ÿ]{1}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nDoc" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="44"/&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{1,44}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvRegMultimodal", propOrder = {
        "descEvento",
        "xRegistro",
        "nDoc"
})
public class EvRegMultimodal
        implements XML {

    @XmlElement(required = true)
    protected String descEvento;
    @XmlElement(required = true)
    protected String xRegistro;
    protected String nDoc;

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
     * Gets the value of the xRegistro property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXRegistro() {
        return xRegistro;
    }

    /**
     * Sets the value of the xRegistro property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXRegistro(String value) {
        this.xRegistro = value;
    }

    public boolean isSetXRegistro() {
        return (this.xRegistro != null);
    }

    /**
     * Gets the value of the nDoc property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNDoc() {
        return nDoc;
    }

    /**
     * Sets the value of the nDoc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNDoc(String value) {
        this.nDoc = value;
    }

    public boolean isSetNDoc() {
        return (this.nDoc != null);
    }

}
