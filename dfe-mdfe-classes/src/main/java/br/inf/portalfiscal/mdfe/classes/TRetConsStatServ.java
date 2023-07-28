//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:09 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;

import java.math.BigInteger;


/**
 * Tipo Resultado da Consulta do Status do Serviço MDFe
 *
 * <p>Java class for TRetConsStatServ complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TRetConsStatServ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/mdfe}TAmb"/&gt;
 *         &lt;element name="verAplic"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TVerAplic"&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/mdfe}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/mdfe}TMotivo"/&gt;
 *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/mdfe}TCodUfIBGE"/&gt;
 *         &lt;element name="dhRecbto" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC"/&gt;
 *         &lt;element name="tMed" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="[0-9]{1,4}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dhRetorno" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC" minOccurs="0"/&gt;
 *         &lt;element name="xObs" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="255"/&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerConsStat" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsStatServ", propOrder = {
        "tpAmb",
        "verAplic",
        "cStat",
        "xMotivo",
        "cuf",
        "dhRecbto",
        "tMed",
        "dhRetorno",
        "xObs"
})
public class TRetConsStatServ
        implements XML {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    @XmlElement(name = "cUF", required = true)
    protected String cuf;
    @XmlElement(required = true)
    protected String dhRecbto;
    protected BigInteger tMed;
    protected String dhRetorno;
    protected String xObs;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Gets the value of the tpAmb property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * Sets the value of the tpAmb property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpAmb(String value) {
        this.tpAmb = value;
    }

    public boolean isSetTpAmb() {
        return (this.tpAmb != null);
    }

    /**
     * Gets the value of the verAplic property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * Sets the value of the verAplic property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVerAplic(String value) {
        this.verAplic = value;
    }

    public boolean isSetVerAplic() {
        return (this.verAplic != null);
    }

    /**
     * Gets the value of the cStat property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCStat() {
        return cStat;
    }

    /**
     * Sets the value of the cStat property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCStat(String value) {
        this.cStat = value;
    }

    public boolean isSetCStat() {
        return (this.cStat != null);
    }

    /**
     * Gets the value of the xMotivo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXMotivo() {
        return xMotivo;
    }

    /**
     * Sets the value of the xMotivo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXMotivo(String value) {
        this.xMotivo = value;
    }

    public boolean isSetXMotivo() {
        return (this.xMotivo != null);
    }

    /**
     * Gets the value of the cuf property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCUF() {
        return cuf;
    }

    /**
     * Sets the value of the cuf property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCUF(String value) {
        this.cuf = value;
    }

    public boolean isSetCUF() {
        return (this.cuf != null);
    }

    /**
     * Gets the value of the dhRecbto property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhRecbto() {
        return dhRecbto;
    }

    /**
     * Sets the value of the dhRecbto property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhRecbto(String value) {
        this.dhRecbto = value;
    }

    public boolean isSetDhRecbto() {
        return (this.dhRecbto != null);
    }

    /**
     * Gets the value of the tMed property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getTMed() {
        return tMed;
    }

    /**
     * Sets the value of the tMed property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setTMed(BigInteger value) {
        this.tMed = value;
    }

    public boolean isSetTMed() {
        return (this.tMed != null);
    }

    /**
     * Gets the value of the dhRetorno property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhRetorno() {
        return dhRetorno;
    }

    /**
     * Sets the value of the dhRetorno property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhRetorno(String value) {
        this.dhRetorno = value;
    }

    public boolean isSetDhRetorno() {
        return (this.dhRetorno != null);
    }

    /**
     * Gets the value of the xObs property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXObs() {
        return xObs;
    }

    /**
     * Sets the value of the xObs property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXObs(String value) {
        this.xObs = value;
    }

    public boolean isSetXObs() {
        return (this.xObs != null);
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
