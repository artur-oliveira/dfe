//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.distribution;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ConsNSU complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ConsNSU"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NSU" type="{http://www.portalfiscal.inf.br/cte}TNSU"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsNSU", namespace = "http://www.portalfiscal.inf.br/cte", propOrder = {
        "nsu"
})
public class ConsNSU
        implements XML {

    @XmlElement(name = "NSU", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String nsu;

    /**
     * Gets the value of the nsu property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNSU() {
        return nsu;
    }

    /**
     * Sets the value of the nsu property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNSU(String value) {
        this.nsu = value;
    }

    public boolean isSetNSU() {
        return (this.nsu != null);
    }

}