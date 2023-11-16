//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:07 PM BRT 
//


package br.inf.portalfiscal.nfe.event_manifestation;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for SignatureType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SignatureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SignedInfo" type="{http://www.w3.org/2000/09/xmldsig#}SignedInfoType"/&gt;
 *         &lt;element name="SignatureValue" type="{http://www.w3.org/2000/09/xmldsig#}SignatureValueType"/&gt;
 *         &lt;element name="KeyInfo" type="{http://www.w3.org/2000/09/xmldsig#}KeyInfoType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatureType", propOrder = {
        "signedInfo",
        "signatureValue",
        "keyInfo"
})
public class SignatureType
        implements XML {

    @XmlElement(name = "SignedInfo", required = true)
    protected SignedInfoType signedInfo;
    @XmlElement(name = "SignatureValue", required = true)
    protected SignatureValueType signatureValue;
    @XmlElement(name = "KeyInfo", required = true)
    protected KeyInfoType keyInfo;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the signedInfo property.
     *
     * @return possible object is
     * {@link SignedInfoType }
     */
    public SignedInfoType getSignedInfo() {
        return signedInfo;
    }

    /**
     * Sets the value of the signedInfo property.
     *
     * @param value allowed object is
     *              {@link SignedInfoType }
     */
    public void setSignedInfo(SignedInfoType value) {
        this.signedInfo = value;
    }

    public boolean isSetSignedInfo() {
        return (this.signedInfo != null);
    }

    /**
     * Gets the value of the signatureValue property.
     *
     * @return possible object is
     * {@link SignatureValueType }
     */
    public SignatureValueType getSignatureValue() {
        return signatureValue;
    }

    /**
     * Sets the value of the signatureValue property.
     *
     * @param value allowed object is
     *              {@link SignatureValueType }
     */
    public void setSignatureValue(SignatureValueType value) {
        this.signatureValue = value;
    }

    public boolean isSetSignatureValue() {
        return (this.signatureValue != null);
    }

    /**
     * Gets the value of the keyInfo property.
     *
     * @return possible object is
     * {@link KeyInfoType }
     */
    public KeyInfoType getKeyInfo() {
        return keyInfo;
    }

    /**
     * Sets the value of the keyInfo property.
     *
     * @param value allowed object is
     *              {@link KeyInfoType }
     */
    public void setKeyInfo(KeyInfoType value) {
        this.keyInfo = value;
    }

    public boolean isSetKeyInfo() {
        return (this.keyInfo != null);
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
