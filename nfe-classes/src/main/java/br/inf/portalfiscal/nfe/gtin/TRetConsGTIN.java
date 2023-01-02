//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.08.18 às 10:10:30 PM BRT 
//


package br.inf.portalfiscal.nfe.gtin;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * Tipo Retorno da Consulta pública Cadastro Centralizado de GTIN
 *
 * <p>Classe Java de TRetConsGTIN complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TRetConsGTIN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/&gt;
 *         &lt;element name="dhResp" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/&gt;
 *         &lt;element name="GTIN" type="{http://www.portalfiscal.inf.br/nfe}TCodGTIN" minOccurs="0"/&gt;
 *         &lt;element name="tpGTIN" type="{http://www.portalfiscal.inf.br/nfe}TTpGTIN" minOccurs="0"/&gt;
 *         &lt;element name="xProd" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString"&gt;
 *               &lt;minLength value="2"/&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="NCM" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString"&gt;
 *               &lt;pattern value="[0-9]{8}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CEST" maxOccurs="3" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString"&gt;
 *               &lt;pattern value="[0-9]{7}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerConsGTIN" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsGTIN", propOrder = {
        "verAplic",
        "cStat",
        "xMotivo",
        "dhResp",
        "gtin",
        "tpGTIN",
        "xProd",
        "ncm",
        "cest"
})
public class TRetConsGTIN
        implements XML {

    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    @XmlElement(required = true)
    protected String dhResp;
    @XmlElement(name = "GTIN")
    protected String gtin;
    protected String tpGTIN;
    protected String xProd;
    @XmlElement(name = "NCM")
    protected String ncm;
    @XmlElement(name = "CEST")
    protected List<String> cest;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

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
     * Obtém o valor da propriedade dhResp.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhResp() {
        return dhResp;
    }

    /**
     * Define o valor da propriedade dhResp.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhResp(String value) {
        this.dhResp = value;
    }

    /**
     * Obtém o valor da propriedade gtin.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGTIN() {
        return gtin;
    }

    /**
     * Define o valor da propriedade gtin.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGTIN(String value) {
        this.gtin = value;
    }

    /**
     * Obtém o valor da propriedade tpGTIN.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpGTIN() {
        return tpGTIN;
    }

    /**
     * Define o valor da propriedade tpGTIN.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpGTIN(String value) {
        this.tpGTIN = value;
    }

    /**
     * Obtém o valor da propriedade xProd.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXProd() {
        return xProd;
    }

    /**
     * Define o valor da propriedade xProd.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXProd(String value) {
        this.xProd = value;
    }

    /**
     * Obtém o valor da propriedade ncm.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNCM() {
        return ncm;
    }

    /**
     * Define o valor da propriedade ncm.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNCM(String value) {
        this.ncm = value;
    }

    /**
     * Gets the value of the cest property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cest property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCEST().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getCEST() {
        if (cest == null) {
            cest = new ArrayList<String>();
        }
        return this.cest;
    }

    /**
     * Obtém o valor da propriedade versao.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersao(String value) {
        this.versao = value;
    }

}
