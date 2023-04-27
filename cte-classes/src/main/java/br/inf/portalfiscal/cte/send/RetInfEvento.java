//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.12.08 às 12:12:45 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java de RetInfEvento complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="RetInfEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/cte}TAmb"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/cte}TVerAplic"/&gt;
 *         &lt;element name="cOrgao" type="{http://www.portalfiscal.inf.br/cte}TCOrgaoIBGE"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/cte}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/cte}TMotivo"/&gt;
 *         &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe" minOccurs="0"/&gt;
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
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="4"/&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nSeqEvento" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[1-9][0-9]|0?[1-9]"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dhRegEvento" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC" minOccurs="0"/&gt;
 *         &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/cte}TProt" minOccurs="0"/&gt;
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
        "chCTe",
        "tpEvento",
        "xEvento",
        "nSeqEvento",
        "dhRegEvento",
        "nProt"
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
    protected String chCTe;
    protected String tpEvento;
    protected String xEvento;
    protected String nSeqEvento;
    protected String dhRegEvento;
    protected String nProt;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

    /**
     * Obtém o valor da propriedade tpAmb.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * Define o valor da propriedade tpAmb.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpAmb(String value) {
        this.tpAmb = value;
    }

    /**
     * Obtém o valor da propriedade verAplic.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * Define o valor da propriedade verAplic.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVerAplic(String value) {
        this.verAplic = value;
    }

    /**
     * Obtém o valor da propriedade cOrgao.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCOrgao() {
        return cOrgao;
    }

    /**
     * Define o valor da propriedade cOrgao.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCOrgao(String value) {
        this.cOrgao = value;
    }

    /**
     * Obtém o valor da propriedade cStat.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCStat() {
        return cStat;
    }

    /**
     * Define o valor da propriedade cStat.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCStat(String value) {
        this.cStat = value;
    }

    /**
     * Obtém o valor da propriedade xMotivo.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXMotivo() {
        return xMotivo;
    }

    /**
     * Define o valor da propriedade xMotivo.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXMotivo(String value) {
        this.xMotivo = value;
    }

    /**
     * Obtém o valor da propriedade chCTe.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChCTe() {
        return chCTe;
    }

    /**
     * Define o valor da propriedade chCTe.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChCTe(String value) {
        this.chCTe = value;
    }

    /**
     * Obtém o valor da propriedade tpEvento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpEvento() {
        return tpEvento;
    }

    /**
     * Define o valor da propriedade tpEvento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpEvento(String value) {
        this.tpEvento = value;
    }

    /**
     * Obtém o valor da propriedade xEvento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXEvento() {
        return xEvento;
    }

    /**
     * Define o valor da propriedade xEvento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXEvento(String value) {
        this.xEvento = value;
    }

    /**
     * Obtém o valor da propriedade nSeqEvento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNSeqEvento() {
        return nSeqEvento;
    }

    /**
     * Define o valor da propriedade nSeqEvento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNSeqEvento(String value) {
        this.nSeqEvento = value;
    }

    /**
     * Obtém o valor da propriedade dhRegEvento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhRegEvento() {
        return dhRegEvento;
    }

    /**
     * Define o valor da propriedade dhRegEvento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhRegEvento(String value) {
        this.dhRegEvento = value;
    }

    /**
     * Obtém o valor da propriedade nProt.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNProt() {
        return nProt;
    }

    /**
     * Define o valor da propriedade nProt.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNProt(String value) {
        this.nProt = value;
    }

    /**
     * Obtém o valor da propriedade id.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

}
