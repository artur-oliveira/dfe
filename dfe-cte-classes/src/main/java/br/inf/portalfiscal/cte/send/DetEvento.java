//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;
import org.w3c.dom.Element;


/**
 * <p>Java class for DetEvento complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DetEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;any processContents='skip'/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versaoEvento" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;whiteSpace value="preserve"/&gt;
 *             &lt;pattern value="3\.(0[0-9]|[1-9][0-9])"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetEvento", propOrder = {
        "any"
})
public class DetEvento
        implements XML {

    @XmlAnyElement
    protected Element any;
    @XmlAttribute(name = "versaoEvento", required = true)
    protected String versaoEvento;

    /**
     * Gets the value of the any property.
     *
     * @return possible object is
     * {@link Element }
     */
    public Element getAny() {
        return any;
    }

    /**
     * Sets the value of the any property.
     *
     * @param value allowed object is
     *              {@link Element }
     */
    public void setAny(Element value) {
        this.any = value;
    }

    public boolean isSetAny() {
        return (this.any != null);
    }

    /**
     * Gets the value of the versaoEvento property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersaoEvento() {
        return versaoEvento;
    }

    /**
     * Sets the value of the versaoEvento property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersaoEvento(String value) {
        this.versaoEvento = value;
    }

    public boolean isSetVersaoEvento() {
        return (this.versaoEvento != null);
    }

}