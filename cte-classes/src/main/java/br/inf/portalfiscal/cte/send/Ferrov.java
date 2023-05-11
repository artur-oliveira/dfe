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
 * <p>Java class for Ferrov complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Ferrov"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpTraf"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="trafMut" type="{http://www.portalfiscal.inf.br/cte}TrafMut" minOccurs="0"/&gt;
 *         &lt;element name="fluxo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ferrov", propOrder = {
        "tpTraf",
        "trafMut",
        "fluxo"
})
public class Ferrov
        implements XML {

    @XmlElement(required = true)
    protected String tpTraf;
    protected TrafMut trafMut;
    @XmlElement(required = true)
    protected String fluxo;

    /**
     * Gets the value of the tpTraf property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpTraf() {
        return tpTraf;
    }

    /**
     * Sets the value of the tpTraf property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpTraf(String value) {
        this.tpTraf = value;
    }

    public boolean isSetTpTraf() {
        return (this.tpTraf != null);
    }

    /**
     * Gets the value of the trafMut property.
     *
     * @return possible object is
     * {@link TrafMut }
     */
    public TrafMut getTrafMut() {
        return trafMut;
    }

    /**
     * Sets the value of the trafMut property.
     *
     * @param value allowed object is
     *              {@link TrafMut }
     */
    public void setTrafMut(TrafMut value) {
        this.trafMut = value;
    }

    public boolean isSetTrafMut() {
        return (this.trafMut != null);
    }

    /**
     * Gets the value of the fluxo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFluxo() {
        return fluxo;
    }

    /**
     * Sets the value of the fluxo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFluxo(String value) {
        this.fluxo = value;
    }

    public boolean isSetFluxo() {
        return (this.fluxo != null);
    }

}
