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
 * <p>Java class for InfTotAP complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InfTotAP"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="qTotProd" type="{http://www.portalfiscal.inf.br/cte}TDec_1104"/&gt;
 *         &lt;element name="uniAP"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="1"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *               &lt;enumeration value="4"/&gt;
 *               &lt;enumeration value="5"/&gt;
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
@XmlType(name = "InfTotAP", propOrder = {
        "qTotProd",
        "uniAP"
})
public class InfTotAP
        implements XML {

    @XmlElement(required = true)
    protected String qTotProd;
    @XmlElement(required = true)
    protected String uniAP;

    /**
     * Gets the value of the qTotProd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getQTotProd() {
        return qTotProd;
    }

    /**
     * Sets the value of the qTotProd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setQTotProd(String value) {
        this.qTotProd = value;
    }

    public boolean isSetQTotProd() {
        return (this.qTotProd != null);
    }

    /**
     * Gets the value of the uniAP property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUniAP() {
        return uniAP;
    }

    /**
     * Sets the value of the uniAP property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUniAP(String value) {
        this.uniAP = value;
    }

    public boolean isSetUniAP() {
        return (this.uniAP != null);
    }

}
