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
 * <p>Classe Java de TGTVeProc complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TGTVeProc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GTVe" type="{http://www.portalfiscal.inf.br/cte}TGTVe"/&gt;
 *         &lt;element name="protCTe" type="{http://www.portalfiscal.inf.br/cte}TProtGTVe"/&gt;
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
@XmlType(name = "TGTVeProc", propOrder = {
        "gtVe",
        "protCTe"
})
public class TGTVeProc
        implements XML {

    @XmlElement(name = "GTVe", required = true)
    protected TGTVe gtVe;
    @XmlElement(required = true)
    protected TProtGTVe protCTe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;
    @XmlAttribute(name = "ipTransmissor")
    protected String ipTransmissor;
    @XmlAttribute(name = "nPortaCon")
    protected String nPortaCon;
    @XmlAttribute(name = "dhConexao")
    protected String dhConexao;

    /**
     * Obtém o valor da propriedade gtVe.
     *
     * @return possible object is
     * {@link TGTVe }
     */
    public TGTVe getGTVe() {
        return gtVe;
    }

    /**
     * Define o valor da propriedade gtVe.
     *
     * @param value allowed object is
     *              {@link TGTVe }
     */
    public void setGTVe(TGTVe value) {
        this.gtVe = value;
    }

    /**
     * Obtém o valor da propriedade protCTe.
     *
     * @return possible object is
     * {@link TProtGTVe }
     */
    public TProtGTVe getProtCTe() {
        return protCTe;
    }

    /**
     * Define o valor da propriedade protCTe.
     *
     * @param value allowed object is
     *              {@link TProtGTVe }
     */
    public void setProtCTe(TProtGTVe value) {
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
