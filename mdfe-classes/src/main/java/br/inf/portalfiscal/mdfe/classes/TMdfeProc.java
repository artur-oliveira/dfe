//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.04.12 às 01:57:24 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.*;


/**
 * <p>Classe Java de TMdfeProc complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TMdfeProc", propOrder = {
    "mdFe",
    "protMDFe"
})
public class TMdfeProc
    implements XML
{

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
     * Obtém o valor da propriedade mdFe.
     * 
     * @return
     *     possible object is
     *     {@link TMDFe }
     *     
     */
    public TMDFe getMDFe() {
        return mdFe;
    }

    /**
     * Define o valor da propriedade mdFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TMDFe }
     *     
     */
    public void setMDFe(TMDFe value) {
        this.mdFe = value;
    }

    /**
     * Obtém o valor da propriedade protMDFe.
     * 
     * @return
     *     possible object is
     *     {@link TProtMDFe }
     *     
     */
    public TProtMDFe getProtMDFe() {
        return protMDFe;
    }

    /**
     * Define o valor da propriedade protMDFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TProtMDFe }
     *     
     */
    public void setProtMDFe(TProtMDFe value) {
        this.protMDFe = value;
    }

    /**
     * Obtém o valor da propriedade versao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersao(String value) {
        this.versao = value;
    }

    /**
     * Obtém o valor da propriedade ipTransmissor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpTransmissor() {
        return ipTransmissor;
    }

    /**
     * Define o valor da propriedade ipTransmissor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpTransmissor(String value) {
        this.ipTransmissor = value;
    }

    /**
     * Obtém o valor da propriedade nPortaCon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNPortaCon() {
        return nPortaCon;
    }

    /**
     * Define o valor da propriedade nPortaCon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNPortaCon(String value) {
        this.nPortaCon = value;
    }

    /**
     * Obtém o valor da propriedade dhConexao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhConexao() {
        return dhConexao;
    }

    /**
     * Define o valor da propriedade dhConexao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhConexao(String value) {
        this.dhConexao = value;
    }

}
