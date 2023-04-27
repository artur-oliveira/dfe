//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.09.08 às 05:51:47 PM BRT 
//


package br.inf.portalfiscal.nfe.event_cancel;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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

}
