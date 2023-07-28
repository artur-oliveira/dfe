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
 * Schema XML de validação do lote de retorno de documentos ficais eletronicos
 *
 *
 * <p>Java class for TRetDistDFe complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TRetDistDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/mdfe}TAmb"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/mdfe}TVerAplic"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/mdfe}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/mdfe}TMotivo"/&gt;
 *         &lt;element name="ultNSU" type="{http://www.portalfiscal.inf.br/mdfe}TNSU" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="loteDistMDFeComp" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *           &lt;element name="loteDistMDFe" type="{http://www.portalfiscal.inf.br/mdfe}TLoteDistDFe"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerDFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetDistDFe", propOrder = {
        "tpAmb",
        "verAplic",
        "cStat",
        "xMotivo",
        "ultNSU",
        "loteDistMDFeComp",
        "loteDistMDFe"
})
public class TRetDistDFe
        implements XML {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    protected String ultNSU;
    protected byte[] loteDistMDFeComp;
    protected TLoteDistDFe loteDistMDFe;
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
     * Gets the value of the ultNSU property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUltNSU() {
        return ultNSU;
    }

    /**
     * Sets the value of the ultNSU property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUltNSU(String value) {
        this.ultNSU = value;
    }

    public boolean isSetUltNSU() {
        return (this.ultNSU != null);
    }

    /**
     * Gets the value of the loteDistMDFeComp property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getLoteDistMDFeComp() {
        return loteDistMDFeComp;
    }

    /**
     * Sets the value of the loteDistMDFeComp property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setLoteDistMDFeComp(byte[] value) {
        this.loteDistMDFeComp = value;
    }

    public boolean isSetLoteDistMDFeComp() {
        return (this.loteDistMDFeComp != null);
    }

    /**
     * Gets the value of the loteDistMDFe property.
     *
     * @return possible object is
     * {@link TLoteDistDFe }
     */
    public TLoteDistDFe getLoteDistMDFe() {
        return loteDistMDFe;
    }

    /**
     * Sets the value of the loteDistMDFe property.
     *
     * @param value allowed object is
     *              {@link TLoteDistDFe }
     */
    public void setLoteDistMDFe(TLoteDistDFe value) {
        this.loteDistMDFe = value;
    }

    public boolean isSetLoteDistMDFe() {
        return (this.loteDistMDFe != null);
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
