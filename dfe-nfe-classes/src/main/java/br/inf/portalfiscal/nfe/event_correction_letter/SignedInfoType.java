//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.nfe.event_correction_letter;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.dfe.interfaces.xml.generic.XML;

import java.util.Objects;


/**
 * <p>Java class for SignedInfoType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SignedInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CanonicalizationMethod"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/TR/2001/REC-xml-c14n-20010315" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SignatureMethod"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/2000/09/xmldsig#rsa-sha1" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Reference" type="{http://www.w3.org/2000/09/xmldsig#}ReferenceType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignedInfoType", namespace = "http://www.w3.org/2000/09/xmldsig#", propOrder = {
        "canonicalizationMethod",
        "signatureMethod",
        "reference"
})
public class SignedInfoType
        implements XML {

    @XmlElement(name = "CanonicalizationMethod", required = true)
    protected CanonicalizationMethod canonicalizationMethod;
    @XmlElement(name = "SignatureMethod", required = true)
    protected SignatureMethod signatureMethod;
    @XmlElement(name = "Reference", required = true)
    protected ReferenceType reference;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the canonicalizationMethod property.
     *
     * @return possible object is
     * {@link CanonicalizationMethod }
     */
    public CanonicalizationMethod getCanonicalizationMethod() {
        return canonicalizationMethod;
    }

    /**
     * Sets the value of the canonicalizationMethod property.
     *
     * @param value allowed object is
     *              {@link CanonicalizationMethod }
     */
    public void setCanonicalizationMethod(CanonicalizationMethod value) {
        this.canonicalizationMethod = value;
    }

    public boolean isSetCanonicalizationMethod() {
        return (this.canonicalizationMethod != null);
    }

    /**
     * Gets the value of the signatureMethod property.
     *
     * @return possible object is
     * {@link SignatureMethod }
     */
    public SignatureMethod getSignatureMethod() {
        return signatureMethod;
    }

    /**
     * Sets the value of the signatureMethod property.
     *
     * @param value allowed object is
     *              {@link SignatureMethod }
     */
    public void setSignatureMethod(SignatureMethod value) {
        this.signatureMethod = value;
    }

    public boolean isSetSignatureMethod() {
        return (this.signatureMethod != null);
    }

    /**
     * Gets the value of the reference property.
     *
     * @return possible object is
     * {@link ReferenceType }
     */
    public ReferenceType getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     *
     * @param value allowed object is
     *              {@link ReferenceType }
     */
    public void setReference(ReferenceType value) {
        this.reference = value;
    }

    public boolean isSetReference() {
        return (this.reference != null);
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


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/TR/2001/REC-xml-c14n-20010315" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CanonicalizationMethod
            implements XML {

        @XmlAttribute(name = "Algorithm", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String algorithm;

        /**
         * Gets the value of the algorithm property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAlgorithm() {
            return Objects.requireNonNullElse(algorithm, "http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
        }

        /**
         * Sets the value of the algorithm property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAlgorithm(String value) {
            this.algorithm = value;
        }

        public boolean isSetAlgorithm() {
            return (this.algorithm != null);
        }

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
     *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/2000/09/xmldsig#rsa-sha1" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SignatureMethod
            implements XML {

        @XmlAttribute(name = "Algorithm", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String algorithm;

        /**
         * Gets the value of the algorithm property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAlgorithm() {
            return Objects.requireNonNullElse(algorithm, "http://www.w3.org/2000/09/xmldsig#rsa-sha1");
        }

        /**
         * Sets the value of the algorithm property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAlgorithm(String value) {
            this.algorithm = value;
        }

        public boolean isSetAlgorithm() {
            return (this.algorithm != null);
        }

    }

}
