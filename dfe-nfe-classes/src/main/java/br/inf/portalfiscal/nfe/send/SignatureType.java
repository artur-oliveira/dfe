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
 * <p>Classe Java de SignatureType complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
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
@XmlType(name = "SignatureType", namespace = "http://www.w3.org/2000/09/xmldsig#", propOrder = {
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
     * Obtém o valor da propriedade signedInfo.
     *
     * @return possible object is
     * {@link SignedInfoType }
     */
    public SignedInfoType getSignedInfo() {
        return signedInfo;
    }

    /**
     * Define o valor da propriedade signedInfo.
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
     * Obtém o valor da propriedade signatureValue.
     *
     * @return possible object is
     * {@link SignatureValueType }
     */
    public SignatureValueType getSignatureValue() {
        return signatureValue;
    }

    /**
     * Define o valor da propriedade signatureValue.
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
     * Obtém o valor da propriedade keyInfo.
     *
     * @return possible object is
     * {@link KeyInfoType }
     */
    public KeyInfoType getKeyInfo() {
        return keyInfo;
    }

    /**
     * Define o valor da propriedade keyInfo.
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

}
