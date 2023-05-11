//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for InfInut complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InfInut"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/cte}TAmb"/&gt;
 *         &lt;element name="xServ" type="{http://www.portalfiscal.inf.br/cte}TServ"/&gt;
 *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/cte}TCodUfIBGE"/&gt;
 *         &lt;element name="ano"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short"&gt;
 *               &lt;pattern value="[0-9]{1,2}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
 *         &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModCT_Carga_OS"/&gt;
 *         &lt;element name="serie" type="{http://www.portalfiscal.inf.br/cte}TSerie"/&gt;
 *         &lt;element name="nCTIni" type="{http://www.portalfiscal.inf.br/cte}TNF"/&gt;
 *         &lt;element name="nCTFin" type="{http://www.portalfiscal.inf.br/cte}TNF"/&gt;
 *         &lt;element name="xJust" type="{http://www.portalfiscal.inf.br/cte}TJust"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
 *             &lt;pattern value="ID[0-9]{39}"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfInut", propOrder = {
        "tpAmb",
        "xServ",
        "cuf",
        "ano",
        "cnpj",
        "mod",
        "serie",
        "nctIni",
        "nctFin",
        "xJust"
})
public class InfInut
        implements XML {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String xServ;
    @XmlElement(name = "cUF", required = true)
    protected String cuf;
    protected short ano;
    @XmlElement(name = "CNPJ", required = true)
    protected String cnpj;
    @XmlElement(required = true)
    protected String mod;
    @XmlElement(required = true)
    protected String serie;
    @XmlElement(name = "nCTIni", required = true)
    protected String nctIni;
    @XmlElement(name = "nCTFin", required = true)
    protected String nctFin;
    @XmlElement(required = true)
    protected String xJust;
    @XmlAttribute(name = "Id", required = true)
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
     * Gets the value of the xServ property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXServ() {
        return xServ;
    }

    /**
     * Sets the value of the xServ property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXServ(String value) {
        this.xServ = value;
    }

    public boolean isSetXServ() {
        return (this.xServ != null);
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
     * Gets the value of the ano property.
     */
    public short getAno() {
        return ano;
    }

    /**
     * Sets the value of the ano property.
     */
    public void setAno(short value) {
        this.ano = value;
    }

    public boolean isSetAno() {
        return true;
    }

    /**
     * Gets the value of the cnpj property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Sets the value of the cnpj property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    public boolean isSetCNPJ() {
        return (this.cnpj != null);
    }

    /**
     * Gets the value of the mod property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMod() {
        return mod;
    }

    /**
     * Sets the value of the mod property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMod(String value) {
        this.mod = value;
    }

    public boolean isSetMod() {
        return (this.mod != null);
    }

    /**
     * Gets the value of the serie property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Sets the value of the serie property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    public boolean isSetSerie() {
        return (this.serie != null);
    }

    /**
     * Gets the value of the nctIni property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNCTIni() {
        return nctIni;
    }

    /**
     * Sets the value of the nctIni property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNCTIni(String value) {
        this.nctIni = value;
    }

    public boolean isSetNCTIni() {
        return (this.nctIni != null);
    }

    /**
     * Gets the value of the nctFin property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNCTFin() {
        return nctFin;
    }

    /**
     * Sets the value of the nctFin property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNCTFin(String value) {
        this.nctFin = value;
    }

    public boolean isSetNCTFin() {
        return (this.nctFin != null);
    }

    /**
     * Gets the value of the xJust property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXJust() {
        return xJust;
    }

    /**
     * Sets the value of the xJust property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXJust(String value) {
        this.xJust = value;
    }

    public boolean isSetXJust() {
        return (this.xJust != null);
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
