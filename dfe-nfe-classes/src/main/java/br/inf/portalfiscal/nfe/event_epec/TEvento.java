//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:07 PM BRT 
//


package br.inf.portalfiscal.nfe.event_epec;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;


/**
 * Tipo Evento
 *
 * <p>Java class for TEvento complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infEvento" type="{http://www.portalfiscal.inf.br/nfe}InfEvento"/&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerEvento" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEvento", propOrder = {
        "infEvento",
        "signature"
})
public class TEvento
        implements XML {

    @XmlElement(required = true)
    protected InfEvento infEvento;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Gets the value of the infEvento property.
     *
     * @return possible object is
     * {@link InfEvento }
     */
    public InfEvento getInfEvento() {
        return infEvento;
    }

    /**
     * Sets the value of the infEvento property.
     *
     * @param value allowed object is
     *              {@link InfEvento }
     */
    public void setInfEvento(InfEvento value) {
        this.infEvento = value;
    }

    public boolean isSetInfEvento() {
        return (this.infEvento != null);
    }

    /**
     * Gets the value of the signature property.
     *
     * @return possible object is
     * {@link SignatureType }
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     *
     * @param value allowed object is
     *              {@link SignatureType }
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

    public boolean isSetSignature() {
        return (this.signature != null);
    }

    /**
     * Gets the value of the versao property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Sets the value of the versao property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersao(String value) {
        this.versao = value;
    }

    public boolean isSetVersao() {
        return (this.versao != null);
    }

}
