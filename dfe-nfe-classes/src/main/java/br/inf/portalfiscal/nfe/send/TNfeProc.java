//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.nfe.send;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;


/**
 * Tipo da NF-e processada
 *
 * <p>Java class for TNfeProc complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TNfeProc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NFe" type="{http://www.portalfiscal.inf.br/nfe}TNFe"/&gt;
 *         &lt;element name="protNFe" type="{http://www.portalfiscal.inf.br/nfe}TProtNFe"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerNFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TNfeProc", propOrder = {
        "nFe",
        "protNFe"
})
public class TNfeProc
        implements XML {

    @XmlElement(name = "NFe", required = true)
    protected TNFe nFe;
    @XmlElement(required = true)
    protected TProtNFe protNFe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Gets the value of the nFe property.
     *
     * @return possible object is
     * {@link TNFe }
     */
    public TNFe getNFe() {
        return nFe;
    }

    /**
     * Sets the value of the nFe property.
     *
     * @param value allowed object is
     *              {@link TNFe }
     */
    public void setNFe(TNFe value) {
        this.nFe = value;
    }

    public boolean isSetNFe() {
        return (this.nFe != null);
    }

    /**
     * Gets the value of the protNFe property.
     *
     * @return possible object is
     * {@link TProtNFe }
     */
    public TProtNFe getProtNFe() {
        return protNFe;
    }

    /**
     * Sets the value of the protNFe property.
     *
     * @param value allowed object is
     *              {@link TProtNFe }
     */
    public void setProtNFe(TProtNFe value) {
        this.protNFe = value;
    }

    public boolean isSetProtNFe() {
        return (this.protNFe != null);
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