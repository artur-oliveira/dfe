//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.nfe.event_interested_actor;

import br.inf.portalfiscal.nfe.event_correction_letter.X509DataType;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.dfe.interfaces.xml.generic.XML;


/**
 * <p>Java class for KeyInfoType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="KeyInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="X509Data" type="{http://www.w3.org/2000/09/xmldsig#}X509DataType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyInfoType", namespace = "http://www.w3.org/2000/09/xmldsig#", propOrder = {
        "x509Data"
})
public class KeyInfoType
        implements XML {

    @XmlElement(name = "X509Data", required = true)
    protected br.inf.portalfiscal.nfe.event_correction_letter.X509DataType x509Data;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the x509Data property.
     *
     * @return possible object is
     * {@link br.inf.portalfiscal.nfe.event_correction_letter.X509DataType }
     */
    public br.inf.portalfiscal.nfe.event_correction_letter.X509DataType getX509Data() {
        return x509Data;
    }

    /**
     * Sets the value of the x509Data property.
     *
     * @param value allowed object is
     *              {@link br.inf.portalfiscal.nfe.event_correction_letter.X509DataType }
     */
    public void setX509Data(X509DataType value) {
        this.x509Data = value;
    }

    public boolean isSetX509Data() {
        return (this.x509Data != null);
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id != null);
    }

}
