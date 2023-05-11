//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:07 PM BRT 
//


package br.inf.portalfiscal.nfe.event_epec;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for RetInfEvento complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RetInfEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/&gt;
 *         &lt;element name="cOrgao" type="{http://www.portalfiscal.inf.br/nfe}TCOrgaoIBGE"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/&gt;
 *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe" minOccurs="0"/&gt;
 *         &lt;element name="tpEvento" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{6}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xEvento" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString"&gt;
 *               &lt;minLength value="5"/&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nSeqEvento" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[1-9][0-9]{0,1}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}cOrgaoAutor"/&gt;
 *         &lt;element name="dhRegEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\d):[0-5]\d:[0-5]\d[\-,\+](0[0-9]|10|11|12):00"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt" minOccurs="0"/&gt;
 *         &lt;element name="chNFePend" type="{http://www.portalfiscal.inf.br/nfe}TChNFe" maxOccurs="50" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
 *             &lt;pattern value="ID[0-9]{15}"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetInfEvento", propOrder = {
        "tpAmb",
        "verAplic",
        "cOrgao",
        "cStat",
        "xMotivo",
        "chNFe",
        "tpEvento",
        "xEvento",
        "nSeqEvento",
        "cOrgaoAutor",
        "dhRegEvento",
        "nProt",
        "chNFePend"
})
public class RetInfEvento
        implements XML {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String cOrgao;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    protected String chNFe;
    protected String tpEvento;
    protected String xEvento;
    protected String nSeqEvento;
    @XmlElement(required = true)
    protected String cOrgaoAutor;
    @XmlElement(required = true)
    protected String dhRegEvento;
    protected String nProt;
    protected List<String> chNFePend;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

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
     * Gets the value of the cOrgao property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCOrgao() {
        return cOrgao;
    }

    /**
     * Sets the value of the cOrgao property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCOrgao(String value) {
        this.cOrgao = value;
    }

    public boolean isSetCOrgao() {
        return (this.cOrgao != null);
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
     * Gets the value of the chNFe property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChNFe() {
        return chNFe;
    }

    /**
     * Sets the value of the chNFe property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChNFe(String value) {
        this.chNFe = value;
    }

    public boolean isSetChNFe() {
        return (this.chNFe != null);
    }

    /**
     * Gets the value of the tpEvento property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpEvento() {
        return tpEvento;
    }

    /**
     * Sets the value of the tpEvento property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpEvento(String value) {
        this.tpEvento = value;
    }

    public boolean isSetTpEvento() {
        return (this.tpEvento != null);
    }

    /**
     * Gets the value of the xEvento property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXEvento() {
        return xEvento;
    }

    /**
     * Sets the value of the xEvento property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXEvento(String value) {
        this.xEvento = value;
    }

    public boolean isSetXEvento() {
        return (this.xEvento != null);
    }

    /**
     * Gets the value of the nSeqEvento property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNSeqEvento() {
        return nSeqEvento;
    }

    /**
     * Sets the value of the nSeqEvento property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNSeqEvento(String value) {
        this.nSeqEvento = value;
    }

    public boolean isSetNSeqEvento() {
        return (this.nSeqEvento != null);
    }

    /**
     * Gets the value of the cOrgaoAutor property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCOrgaoAutor() {
        return cOrgaoAutor;
    }

    /**
     * Sets the value of the cOrgaoAutor property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCOrgaoAutor(String value) {
        this.cOrgaoAutor = value;
    }

    public boolean isSetCOrgaoAutor() {
        return (this.cOrgaoAutor != null);
    }

    /**
     * Gets the value of the dhRegEvento property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhRegEvento() {
        return dhRegEvento;
    }

    /**
     * Sets the value of the dhRegEvento property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhRegEvento(String value) {
        this.dhRegEvento = value;
    }

    public boolean isSetDhRegEvento() {
        return (this.dhRegEvento != null);
    }

    /**
     * Gets the value of the nProt property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNProt() {
        return nProt;
    }

    /**
     * Sets the value of the nProt property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNProt(String value) {
        this.nProt = value;
    }

    public boolean isSetNProt() {
        return (this.nProt != null);
    }

    /**
     * Gets the value of the chNFePend property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the chNFePend property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChNFePend().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getChNFePend() {
        if (chNFePend == null) {
            chNFePend = new ArrayList<String>();
        }
        return this.chNFePend;
    }

    public boolean isSetChNFePend() {
        return ((this.chNFePend != null) && (!this.chNFePend.isEmpty()));
    }

    public void unsetChNFePend() {
        this.chNFePend = null;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id != null);
    }

}
