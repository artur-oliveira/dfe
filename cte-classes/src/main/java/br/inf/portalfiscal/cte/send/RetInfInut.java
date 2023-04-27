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
 * <p>Classe Java de RetInfInut complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="RetInfInut"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/cte}TAmb"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/cte}TVerAplic"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/cte}TStat"/&gt;
 *         &lt;element name="xMotivo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="255"/&gt;
 *               &lt;whiteSpace value="collapse"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/cte}TCodUfIBGE"/&gt;
 *         &lt;element name="ano" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short"&gt;
 *               &lt;pattern value="[0-9]{1,2}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj" minOccurs="0"/&gt;
 *         &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModCT_Carga_OS" minOccurs="0"/&gt;
 *         &lt;element name="serie" type="{http://www.portalfiscal.inf.br/cte}TSerie" minOccurs="0"/&gt;
 *         &lt;element name="nCTIni" type="{http://www.portalfiscal.inf.br/cte}TNF" minOccurs="0"/&gt;
 *         &lt;element name="nCTFin" type="{http://www.portalfiscal.inf.br/cte}TNF" minOccurs="0"/&gt;
 *         &lt;element name="dhRecbto" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC" minOccurs="0"/&gt;
 *         &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/cte}TProt" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetInfInut", propOrder = {
        "tpAmb",
        "verAplic",
        "cStat",
        "xMotivo",
        "cuf",
        "ano",
        "cnpj",
        "mod",
        "serie",
        "nctIni",
        "nctFin",
        "dhRecbto",
        "nProt"
})
public class RetInfInut
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
    protected Short ano;
    @XmlElement(name = "CNPJ")
    protected String cnpj;
    protected String mod;
    protected String serie;
    @XmlElement(name = "nCTIni")
    protected String nctIni;
    @XmlElement(name = "nCTFin")
    protected String nctFin;
    protected String dhRecbto;
    protected String nProt;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
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
     * Obtém o valor da propriedade cuf.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCUF() {
        return cuf;
    }

    /**
     * Define o valor da propriedade cuf.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCUF(String value) {
        this.cuf = value;
    }

    /**
     * Obtém o valor da propriedade ano.
     *
     * @return possible object is
     * {@link Short }
     */
    public Short getAno() {
        return ano;
    }

    /**
     * Define o valor da propriedade ano.
     *
     * @param value allowed object is
     *              {@link Short }
     */
    public void setAno(Short value) {
        this.ano = value;
    }

    /**
     * Obtém o valor da propriedade cnpj.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Define o valor da propriedade cnpj.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    /**
     * Obtém o valor da propriedade mod.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMod() {
        return mod;
    }

    /**
     * Define o valor da propriedade mod.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMod(String value) {
        this.mod = value;
    }

    /**
     * Obtém o valor da propriedade serie.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Define o valor da propriedade serie.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Obtém o valor da propriedade nctIni.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNCTIni() {
        return nctIni;
    }

    /**
     * Define o valor da propriedade nctIni.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNCTIni(String value) {
        this.nctIni = value;
    }

    /**
     * Obtém o valor da propriedade nctFin.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNCTFin() {
        return nctFin;
    }

    /**
     * Define o valor da propriedade nctFin.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNCTFin(String value) {
        this.nctFin = value;
    }

    /**
     * Obtém o valor da propriedade dhRecbto.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhRecbto() {
        return dhRecbto;
    }

    /**
     * Define o valor da propriedade dhRecbto.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhRecbto(String value) {
        this.dhRecbto = value;
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
