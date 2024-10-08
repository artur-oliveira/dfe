//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v3.0.0 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2024.08.02 às 08:46:12 AM BRT 
//


package br.inf.portalfiscal.nfe.send;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.dfe.interfaces.xml.generic.XML;


/**
 * <p>Classe Java de ReferenceType complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="ReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Transforms" type="{http://www.w3.org/2000/09/xmldsig#}TransformsType"/&gt;
 *         &lt;element name="DigestMethod"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/2000/09/xmldsig#sha1" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DigestValue" type="{http://www.w3.org/2000/09/xmldsig#}DigestValueType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;attribute name="URI" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyURI"&gt;
 *             &lt;minLength value="2"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferenceType", namespace = "http://www.w3.org/2000/09/xmldsig#", propOrder = {
        "transforms",
        "digestMethod",
        "digestValue"
})
public class ReferenceType
        implements XML {

    @XmlElement(name = "Transforms", required = true)
    protected TransformsType transforms;
    @XmlElement(name = "DigestMethod", required = true)
    protected DigestMethod digestMethod;
    @XmlElement(name = "DigestValue", required = true)
    protected byte[] digestValue;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "URI", required = true)
    protected String uri;
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anyURI")
    protected String type;

    /**
     * Obtém o valor da propriedade transforms.
     *
     * @return possible object is
     * {@link TransformsType }
     */
    public TransformsType getTransforms() {
        return transforms;
    }

    /**
     * Define o valor da propriedade transforms.
     *
     * @param value allowed object is
     *              {@link TransformsType }
     */
    public void setTransforms(TransformsType value) {
        this.transforms = value;
    }

    public boolean isSetTransforms() {
        return (this.transforms != null);
    }

    /**
     * Obtém o valor da propriedade digestMethod.
     *
     * @return possible object is
     * {@link DigestMethod }
     */
    public DigestMethod getDigestMethod() {
        return digestMethod;
    }

    /**
     * Define o valor da propriedade digestMethod.
     *
     * @param value allowed object is
     *              {@link DigestMethod }
     */
    public void setDigestMethod(DigestMethod value) {
        this.digestMethod = value;
    }

    public boolean isSetDigestMethod() {
        return (this.digestMethod != null);
    }

    /**
     * Obtém o valor da propriedade digestValue.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getDigestValue() {
        return digestValue;
    }

    /**
     * Define o valor da propriedade digestValue.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setDigestValue(byte[] value) {
        this.digestValue = value;
    }

    public boolean isSetDigestValue() {
        return (this.digestValue != null);
    }

    /**
     * Obtém o valor da propriedade id.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
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
     * Obtém o valor da propriedade uri.
     *
     * @return possible object is
     * {@link String }
     */
    public String getURI() {
        return uri;
    }

    /**
     * Define o valor da propriedade uri.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setURI(String value) {
        this.uri = value;
    }

    public boolean isSetURI() {
        return (this.uri != null);
    }

    /**
     * Obtém o valor da propriedade type.
     *
     * @return possible object is
     * {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type != null);
    }


    /**
     * <p>Classe Java de anonymous complex type.
     *
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/2000/09/xmldsig#sha1" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DigestMethod
            implements XML {

        @XmlAttribute(name = "Algorithm", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String algorithm;

        /**
         * Obtém o valor da propriedade algorithm.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAlgorithm() {
            if (algorithm == null) {
                return "http://www.w3.org/2000/09/xmldsig#sha1";
            } else {
                return algorithm;
            }
        }

        /**
         * Define o valor da propriedade algorithm.
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
