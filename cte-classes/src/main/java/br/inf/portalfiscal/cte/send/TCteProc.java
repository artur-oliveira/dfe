//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.12.08 às 12:12:45 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.*;


/**
 * <p>Classe Java de TCteProc complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TCteProc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CTe" type="{http://www.portalfiscal.inf.br/cte}TCTe"/&gt;
 *         &lt;element name="protCTe" type="{http://www.portalfiscal.inf.br/cte}TProtCTe"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/cte}TVerCTe" /&gt;
 *       &lt;attribute name="ipTransmissor" type="{http://www.portalfiscal.inf.br/cte}TIPv4" /&gt;
 *       &lt;attribute name="nPortaCon"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="[0-9]{1,5}"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="dhConexao" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCteProc", propOrder = {
        "cTe",
        "protCTe"
})
public class TCteProc
        implements XML {

    @XmlElement(name = "CTe", required = true)
    protected TCTe cTe;
    @XmlElement(required = true)
    protected TProtCTe protCTe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;
    @XmlAttribute(name = "ipTransmissor")
    protected String ipTransmissor;
    @XmlAttribute(name = "nPortaCon")
    protected String nPortaCon;
    @XmlAttribute(name = "dhConexao")
    protected String dhConexao;

    /**
     * Obtém o valor da propriedade cTe.
     *
     * @return possible object is
     * {@link TCTe }
     */
    public TCTe getCTe() {
        return cTe;
    }

    /**
     * Define o valor da propriedade cTe.
     *
     * @param value allowed object is
     *              {@link TCTe }
     */
    public void setCTe(TCTe value) {
        this.cTe = value;
    }

    /**
     * Obtém o valor da propriedade protCTe.
     *
     * @return possible object is
     * {@link TProtCTe }
     */
    public TProtCTe getProtCTe() {
        return protCTe;
    }

    /**
     * Define o valor da propriedade protCTe.
     *
     * @param value allowed object is
     *              {@link TProtCTe }
     */
    public void setProtCTe(TProtCTe value) {
        this.protCTe = value;
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

    /**
     * Obtém o valor da propriedade ipTransmissor.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIpTransmissor() {
        return ipTransmissor;
    }

    /**
     * Define o valor da propriedade ipTransmissor.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIpTransmissor(String value) {
        this.ipTransmissor = value;
    }

    /**
     * Obtém o valor da propriedade nPortaCon.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNPortaCon() {
        return nPortaCon;
    }

    /**
     * Define o valor da propriedade nPortaCon.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNPortaCon(String value) {
        this.nPortaCon = value;
    }

    /**
     * Obtém o valor da propriedade dhConexao.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhConexao() {
        return dhConexao;
    }

    /**
     * Define o valor da propriedade dhConexao.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhConexao(String value) {
        this.dhConexao = value;
    }

}
