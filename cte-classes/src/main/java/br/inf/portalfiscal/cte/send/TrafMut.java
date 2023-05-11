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

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for TrafMut complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TrafMut"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="respFat"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ferrEmi"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="vFrete" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *         &lt;element name="chCTeFerroOrigem" type="{http://www.portalfiscal.inf.br/cte}TChNFe" minOccurs="0"/&gt;
 *         &lt;element name="ferroEnv" type="{http://www.portalfiscal.inf.br/cte}FerroEnv" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrafMut", propOrder = {
        "respFat",
        "ferrEmi",
        "vFrete",
        "chCTeFerroOrigem",
        "ferroEnv"
})
public class TrafMut
        implements XML {

    @XmlElement(required = true)
    protected String respFat;
    @XmlElement(required = true)
    protected String ferrEmi;
    @XmlElement(required = true)
    protected String vFrete;
    protected String chCTeFerroOrigem;
    protected List<FerroEnv> ferroEnv;

    /**
     * Gets the value of the respFat property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRespFat() {
        return respFat;
    }

    /**
     * Sets the value of the respFat property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRespFat(String value) {
        this.respFat = value;
    }

    public boolean isSetRespFat() {
        return (this.respFat != null);
    }

    /**
     * Gets the value of the ferrEmi property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFerrEmi() {
        return ferrEmi;
    }

    /**
     * Sets the value of the ferrEmi property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFerrEmi(String value) {
        this.ferrEmi = value;
    }

    public boolean isSetFerrEmi() {
        return (this.ferrEmi != null);
    }

    /**
     * Gets the value of the vFrete property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVFrete() {
        return vFrete;
    }

    /**
     * Sets the value of the vFrete property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVFrete(String value) {
        this.vFrete = value;
    }

    public boolean isSetVFrete() {
        return (this.vFrete != null);
    }

    /**
     * Gets the value of the chCTeFerroOrigem property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChCTeFerroOrigem() {
        return chCTeFerroOrigem;
    }

    /**
     * Sets the value of the chCTeFerroOrigem property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChCTeFerroOrigem(String value) {
        this.chCTeFerroOrigem = value;
    }

    public boolean isSetChCTeFerroOrigem() {
        return (this.chCTeFerroOrigem != null);
    }

    /**
     * Gets the value of the ferroEnv property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the ferroEnv property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFerroEnv().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FerroEnv }
     */
    public List<FerroEnv> getFerroEnv() {
        if (ferroEnv == null) {
            ferroEnv = new ArrayList<>();
        }
        return this.ferroEnv;
    }

    public boolean isSetFerroEnv() {
        return ((this.ferroEnv != null) && (!this.ferroEnv.isEmpty()));
    }

    public void unsetFerroEnv() {
        this.ferroEnv = null;
    }

}
