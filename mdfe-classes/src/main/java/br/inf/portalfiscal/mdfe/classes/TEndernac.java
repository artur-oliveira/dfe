//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:09 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;


/**
 * Tipo Dados do Endereço
 *
 * <p>Java class for TEndernac complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TEndernac"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="xLgr"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;maxLength value="255"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nro"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xCpl" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xBairro"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cMun" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
 *         &lt;element name="xMun"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CEP" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{8}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEndernac", propOrder = {
        "xLgr",
        "nro",
        "xCpl",
        "xBairro",
        "cMun",
        "xMun",
        "cep",
        "uf"
})
public class TEndernac
        implements XML {

    @XmlElement(required = true)
    protected String xLgr;
    @XmlElement(required = true)
    protected String nro;
    protected String xCpl;
    @XmlElement(required = true)
    protected String xBairro;
    @XmlElement(required = true)
    protected String cMun;
    @XmlElement(required = true)
    protected String xMun;
    @XmlElement(name = "CEP")
    protected String cep;
    @XmlElement(name = "UF", required = true)
    @XmlSchemaType(name = "string")
    protected TUf uf;

    /**
     * Gets the value of the xLgr property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXLgr() {
        return xLgr;
    }

    /**
     * Sets the value of the xLgr property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXLgr(String value) {
        this.xLgr = value;
    }

    public boolean isSetXLgr() {
        return (this.xLgr != null);
    }

    /**
     * Gets the value of the nro property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNro() {
        return nro;
    }

    /**
     * Sets the value of the nro property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNro(String value) {
        this.nro = value;
    }

    public boolean isSetNro() {
        return (this.nro != null);
    }

    /**
     * Gets the value of the xCpl property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXCpl() {
        return xCpl;
    }

    /**
     * Sets the value of the xCpl property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXCpl(String value) {
        this.xCpl = value;
    }

    public boolean isSetXCpl() {
        return (this.xCpl != null);
    }

    /**
     * Gets the value of the xBairro property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXBairro() {
        return xBairro;
    }

    /**
     * Sets the value of the xBairro property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXBairro(String value) {
        this.xBairro = value;
    }

    public boolean isSetXBairro() {
        return (this.xBairro != null);
    }

    /**
     * Gets the value of the cMun property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCMun() {
        return cMun;
    }

    /**
     * Sets the value of the cMun property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCMun(String value) {
        this.cMun = value;
    }

    public boolean isSetCMun() {
        return (this.cMun != null);
    }

    /**
     * Gets the value of the xMun property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXMun() {
        return xMun;
    }

    /**
     * Sets the value of the xMun property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXMun(String value) {
        this.xMun = value;
    }

    public boolean isSetXMun() {
        return (this.xMun != null);
    }

    /**
     * Gets the value of the cep property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCEP() {
        return cep;
    }

    /**
     * Sets the value of the cep property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCEP(String value) {
        this.cep = value;
    }

    public boolean isSetCEP() {
        return (this.cep != null);
    }

    /**
     * Gets the value of the uf property.
     *
     * @return possible object is
     * {@link TUf }
     */
    public TUf getUF() {
        return uf;
    }

    /**
     * Sets the value of the uf property.
     *
     * @param value allowed object is
     *              {@link TUf }
     */
    public void setUF(TUf value) {
        this.uf = value;
    }

    public boolean isSetUF() {
        return (this.uf != null);
    }

}
