//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.nfe.gtin;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Tipo Consulta pública Cadastro Centralizado de GTIN
 *
 * <p>Java class for TConsGTIN complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TConsGTIN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GTIN" type="{http://www.portalfiscal.inf.br/nfe}TCodGTIN"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerConsGTIN" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TConsGTIN", propOrder = {
        "gtin"
})
public class TConsGTIN
        implements XML {

    @XmlElement(name = "GTIN", required = true)
    protected String gtin;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

    /**
     * Gets the value of the gtin property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGTIN() {
        return gtin;
    }

    /**
     * Sets the value of the gtin property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGTIN(String value) {
        this.gtin = value;
    }

    public boolean isSetGTIN() {
        return (this.gtin != null);
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
