//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send400;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for EvCECTe complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EvCECTe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="Comprovante de Entrega do CT-e"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/cte}TProt"/&gt;
 *         &lt;element name="dhEntrega"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nDoc"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="2"/&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xNome"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="latitude" type="{http://www.portalfiscal.inf.br/cte}TLatitude" minOccurs="0"/&gt;
 *         &lt;element name="longitude" type="{http://www.portalfiscal.inf.br/cte}TLongitude" minOccurs="0"/&gt;
 *         &lt;element name="hashEntrega"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary"&gt;
 *               &lt;length value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dhHashEntrega"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infEntrega" maxOccurs="2000" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/cte}TChDFe"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvCECTe", propOrder = {
        "descEvento",
        "nProt",
        "dhEntrega",
        "nDoc",
        "xNome",
        "latitude",
        "longitude",
        "hashEntrega",
        "dhHashEntrega",
        "infEntrega"
})
public class EvCECTe
        implements XML {

    @XmlElement(required = true)
    protected String descEvento;
    @XmlElement(required = true)
    protected String nProt;
    @XmlElement(required = true)
    protected String dhEntrega;
    @XmlElement(required = true)
    protected String nDoc;
    @XmlElement(required = true)
    protected String xNome;
    protected String latitude;
    protected String longitude;
    @XmlElement(required = true)
    protected byte[] hashEntrega;
    @XmlElement(required = true)
    protected String dhHashEntrega;
    protected List<InfEntrega> infEntrega;

    /**
     * Gets the value of the descEvento property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescEvento() {
        return descEvento;
    }

    /**
     * Sets the value of the descEvento property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescEvento(String value) {
        this.descEvento = value;
    }

    public boolean isSetDescEvento() {
        return (this.descEvento != null);
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
     * Gets the value of the dhEntrega property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhEntrega() {
        return dhEntrega;
    }

    /**
     * Sets the value of the dhEntrega property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhEntrega(String value) {
        this.dhEntrega = value;
    }

    public boolean isSetDhEntrega() {
        return (this.dhEntrega != null);
    }

    /**
     * Gets the value of the nDoc property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNDoc() {
        return nDoc;
    }

    /**
     * Sets the value of the nDoc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNDoc(String value) {
        this.nDoc = value;
    }

    public boolean isSetNDoc() {
        return (this.nDoc != null);
    }

    /**
     * Gets the value of the xNome property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXNome() {
        return xNome;
    }

    /**
     * Sets the value of the xNome property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXNome(String value) {
        this.xNome = value;
    }

    public boolean isSetXNome() {
        return (this.xNome != null);
    }

    /**
     * Gets the value of the latitude property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    public boolean isSetLatitude() {
        return (this.latitude != null);
    }

    /**
     * Gets the value of the longitude property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    public boolean isSetLongitude() {
        return (this.longitude != null);
    }

    /**
     * Gets the value of the hashEntrega property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getHashEntrega() {
        return hashEntrega;
    }

    /**
     * Sets the value of the hashEntrega property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setHashEntrega(byte[] value) {
        this.hashEntrega = value;
    }

    public boolean isSetHashEntrega() {
        return (this.hashEntrega != null);
    }

    /**
     * Gets the value of the dhHashEntrega property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhHashEntrega() {
        return dhHashEntrega;
    }

    /**
     * Sets the value of the dhHashEntrega property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhHashEntrega(String value) {
        this.dhHashEntrega = value;
    }

    public boolean isSetDhHashEntrega() {
        return (this.dhHashEntrega != null);
    }

    /**
     * Gets the value of the infEntrega property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the infEntrega property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfEntrega().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfEntrega }
     */
    public List<InfEntrega> getInfEntrega() {
        if (infEntrega == null) {
            infEntrega = new ArrayList<>();
        }
        return this.infEntrega;
    }

    public boolean isSetInfEntrega() {
        return ((this.infEntrega != null) && (!this.infEntrega.isEmpty()));
    }

    public void unsetInfEntrega() {
        this.infEntrega = null;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/cte}TChDFe"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "chNFe"
    })
    public static class InfEntrega
            implements XML {

        @XmlElement(required = true)
        protected String chNFe;

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

    }

}
