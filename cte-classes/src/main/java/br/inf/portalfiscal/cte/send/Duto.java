//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Duto complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Duto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="vTar" type="{http://www.portalfiscal.inf.br/cte}TDec_0906Opc" minOccurs="0"/&gt;
 *         &lt;element name="dIni" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *         &lt;element name="dFim" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Duto", propOrder = {
        "vTar",
        "dIni",
        "dFim"
})
public class Duto
        implements XML {

    protected String vTar;
    @XmlElement(required = true)
    protected String dIni;
    @XmlElement(required = true)
    protected String dFim;

    /**
     * Gets the value of the vTar property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVTar() {
        return vTar;
    }

    /**
     * Sets the value of the vTar property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVTar(String value) {
        this.vTar = value;
    }

    public boolean isSetVTar() {
        return (this.vTar != null);
    }

    /**
     * Gets the value of the dIni property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDIni() {
        return dIni;
    }

    /**
     * Sets the value of the dIni property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDIni(String value) {
        this.dIni = value;
    }

    public boolean isSetDIni() {
        return (this.dIni != null);
    }

    /**
     * Gets the value of the dFim property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDFim() {
        return dFim;
    }

    /**
     * Sets the value of the dFim property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDFim(String value) {
        this.dFim = value;
    }

    public boolean isSetDFim() {
        return (this.dFim != null);
    }

}
