//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:07 PM BRT 
//


package br.inf.portalfiscal.nfe.event_epec;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for InfEvento complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InfEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cOrgao" type="{http://www.portalfiscal.inf.br/nfe}TCOrgaoIBGE"/&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjOpc"/&gt;
 *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/&gt;
 *         &lt;element name="dhEvento" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/&gt;
 *         &lt;element name="tpEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{6}"/&gt;
 *               &lt;enumeration value="110140"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nSeqEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[1-9]|[1][0-9]{0,1}|20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="verEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="1.00"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="detEvento" type="{http://www.portalfiscal.inf.br/nfe}DetEvento"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
 *             &lt;pattern value="ID[0-9]{52}"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfEvento", propOrder = {
        "cOrgao",
        "tpAmb",
        "cnpj",
        "cpf",
        "chNFe",
        "dhEvento",
        "tpEvento",
        "nSeqEvento",
        "verEvento",
        "detEvento"
})
public class InfEvento
        implements XML {

    @XmlElement(required = true)
    protected String cOrgao;
    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(name = "CNPJ")
    protected String cnpj;
    @XmlElement(name = "CPF")
    protected String cpf;
    @XmlElement(required = true)
    protected String chNFe;
    @XmlElement(required = true)
    protected String dhEvento;
    @XmlElement(required = true)
    protected String tpEvento;
    @XmlElement(required = true)
    protected String nSeqEvento;
    @XmlElement(required = true)
    protected String verEvento;
    @XmlElement(required = true)
    protected DetEvento detEvento;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

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
     * Gets the value of the cpf property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * Sets the value of the cpf property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCPF(String value) {
        this.cpf = value;
    }

    public boolean isSetCPF() {
        return (this.cpf != null);
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
     * Gets the value of the dhEvento property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhEvento() {
        return dhEvento;
    }

    /**
     * Sets the value of the dhEvento property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhEvento(String value) {
        this.dhEvento = value;
    }

    public boolean isSetDhEvento() {
        return (this.dhEvento != null);
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
     * Gets the value of the verEvento property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVerEvento() {
        return verEvento;
    }

    /**
     * Sets the value of the verEvento property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVerEvento(String value) {
        this.verEvento = value;
    }

    public boolean isSetVerEvento() {
        return (this.verEvento != null);
    }

    /**
     * Gets the value of the detEvento property.
     *
     * @return possible object is
     * {@link DetEvento }
     */
    public DetEvento getDetEvento() {
        return detEvento;
    }

    /**
     * Sets the value of the detEvento property.
     *
     * @param value allowed object is
     *              {@link DetEvento }
     */
    public void setDetEvento(DetEvento value) {
        this.detEvento = value;
    }

    public boolean isSetDetEvento() {
        return (this.detEvento != null);
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
