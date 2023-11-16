//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:09 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for TMdfeProc complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TMdfeProc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MDFe" type="{http://www.portalfiscal.inf.br/mdfe}TMDFe"/&gt;
 *         &lt;element name="protMDFe" type="{http://www.portalfiscal.inf.br/mdfe}TProtMDFe"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerMDe" /&gt;
 *       &lt;attribute name="ipTransmissor" type="{http://www.portalfiscal.inf.br/mdfe}TIPv4" /&gt;
 *       &lt;attribute name="nPortaCon"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="[0-9]{1,5}"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="dhConexao" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TMdfeProc", propOrder = {
        "mdFe",
        "protMDFe"
})
public class TMdfeProc
        implements XML {

    @XmlElement(name = "MDFe", required = true)
    protected TMDFe mdFe;
    @XmlElement(required = true)
    protected TProtMDFe protMDFe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;
    @XmlAttribute(name = "ipTransmissor")
    protected String ipTransmissor;
    @XmlAttribute(name = "nPortaCon")
    protected String nPortaCon;
    @XmlAttribute(name = "dhConexao")
    protected String dhConexao;

    /**
     * Gets the value of the mdFe property.
     *
     * @return possible object is
     * {@link TMDFe }
     */
    public TMDFe getMDFe() {
        return mdFe;
    }

    /**
     * Sets the value of the mdFe property.
     *
     * @param value allowed object is
     *              {@link TMDFe }
     */
    public void setMDFe(TMDFe value) {
        this.mdFe = value;
    }

    public boolean isSetMDFe() {
        return (this.mdFe != null);
    }

    /**
     * Gets the value of the protMDFe property.
     *
     * @return possible object is
     * {@link TProtMDFe }
     */
    public TProtMDFe getProtMDFe() {
        return protMDFe;
    }

    /**
     * Sets the value of the protMDFe property.
     *
     * @param value allowed object is
     *              {@link TProtMDFe }
     */
    public void setProtMDFe(TProtMDFe value) {
        this.protMDFe = value;
    }

    public boolean isSetProtMDFe() {
        return (this.protMDFe != null);
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

    /**
     * Gets the value of the ipTransmissor property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIpTransmissor() {
        return ipTransmissor;
    }

    /**
     * Sets the value of the ipTransmissor property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIpTransmissor(String value) {
        this.ipTransmissor = value;
    }

    public boolean isSetIpTransmissor() {
        return (this.ipTransmissor != null);
    }

    /**
     * Gets the value of the nPortaCon property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNPortaCon() {
        return nPortaCon;
    }

    /**
     * Sets the value of the nPortaCon property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNPortaCon(String value) {
        this.nPortaCon = value;
    }

    public boolean isSetNPortaCon() {
        return (this.nPortaCon != null);
    }

    /**
     * Gets the value of the dhConexao property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhConexao() {
        return dhConexao;
    }

    /**
     * Sets the value of the dhConexao property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhConexao(String value) {
        this.dhConexao = value;
    }

    public boolean isSetDhConexao() {
        return (this.dhConexao != null);
    }

}
