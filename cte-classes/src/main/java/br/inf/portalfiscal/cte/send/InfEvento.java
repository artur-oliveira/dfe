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
 * <p>Classe Java de InfEvento complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="InfEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cOrgao" type="{http://www.portalfiscal.inf.br/cte}TCOrgaoIBGE"/&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/cte}TAmb"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
 *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="chCTe" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
 *         &lt;element name="dhEvento" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"/&gt;
 *         &lt;element name="tpEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{6}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nSeqEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[1-9][0-9]|0?[1-9]"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="detEvento" type="{http://www.portalfiscal.inf.br/cte}DetEvento"/&gt;
 *         &lt;element name="infSolicNFF" type="{http://www.portalfiscal.inf.br/cte}InfSolicNFF" minOccurs="0"/&gt;
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
        "chCTe",
        "dhEvento",
        "tpEvento",
        "nSeqEvento",
        "detEvento",
        "infSolicNFF"
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
    protected String chCTe;
    @XmlElement(required = true)
    protected String dhEvento;
    @XmlElement(required = true)
    protected String tpEvento;
    @XmlElement(required = true)
    protected String nSeqEvento;
    @XmlElement(required = true)
    protected DetEvento detEvento;
    protected InfSolicNFF infSolicNFF;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

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
     * Obtém o valor da propriedade cpf.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * Define o valor da propriedade cpf.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCPF(String value) {
        this.cpf = value;
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
     * Obtém o valor da propriedade dhEvento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhEvento() {
        return dhEvento;
    }

    /**
     * Define o valor da propriedade dhEvento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhEvento(String value) {
        this.dhEvento = value;
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
     * Obtém o valor da propriedade detEvento.
     *
     * @return possible object is
     * {@link DetEvento }
     */
    public DetEvento getDetEvento() {
        return detEvento;
    }

    /**
     * Define o valor da propriedade detEvento.
     *
     * @param value allowed object is
     *              {@link DetEvento }
     */
    public void setDetEvento(DetEvento value) {
        this.detEvento = value;
    }

    /**
     * Obtém o valor da propriedade infSolicNFF.
     *
     * @return possible object is
     * {@link InfSolicNFF }
     */
    public InfSolicNFF getInfSolicNFF() {
        return infSolicNFF;
    }

    /**
     * Define o valor da propriedade infSolicNFF.
     *
     * @param value allowed object is
     *              {@link InfSolicNFF }
     */
    public void setInfSolicNFF(InfSolicNFF value) {
        this.infSolicNFF = value;
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
