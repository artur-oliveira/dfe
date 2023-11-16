//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tarifa complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tarifa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CL"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="1"/&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="M"/&gt;
 *               &lt;pattern value="G"/&gt;
 *               &lt;pattern value="E"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cTar" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="vTar" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tarifa", propOrder = {
        "cl",
        "cTar",
        "vTar"
})
public class Tarifa
        implements XML {

    @XmlElement(name = "CL", required = true)
    protected String cl;
    protected String cTar;
    @XmlElement(required = true)
    protected String vTar;

    /**
     * Gets the value of the cl property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCL() {
        return cl;
    }

    /**
     * Sets the value of the cl property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCL(String value) {
        this.cl = value;
    }

    public boolean isSetCL() {
        return (this.cl != null);
    }

    /**
     * Gets the value of the cTar property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCTar() {
        return cTar;
    }

    /**
     * Sets the value of the cTar property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCTar(String value) {
        this.cTar = value;
    }

    public boolean isSetCTar() {
        return (this.cTar != null);
    }

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

}
