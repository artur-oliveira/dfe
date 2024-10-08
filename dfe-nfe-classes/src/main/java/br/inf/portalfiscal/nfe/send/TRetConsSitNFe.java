//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v3.0.0 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2024.08.02 às 08:46:12 AM BRT 
//


package br.inf.portalfiscal.nfe.send;

import jakarta.xml.bind.annotation.*;
import org.dfe.interfaces.xml.generic.XML;

import java.util.ArrayList;
import java.util.List;


/**
 * Tipo Retorno de Pedido de Consulta da Situação Atual da Nota Fiscal Eletrônica
 *
 * <p>Classe Java de TRetConsSitNFe complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TRetConsSitNFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/&gt;
 *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/&gt;
 *         &lt;element name="dhRecbto" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/&gt;
 *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/&gt;
 *         &lt;element name="protNFe" type="{http://www.portalfiscal.inf.br/nfe}TProtNFe" minOccurs="0"/&gt;
 *         &lt;element name="retCancNFe" type="{http://www.portalfiscal.inf.br/nfe}TRetCancNFe" minOccurs="0"/&gt;
 *         &lt;element name="procEventoNFe" type="{http://www.portalfiscal.inf.br/nfe}TProcEvento" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerConsSitNFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsSitNFe", propOrder = {
        "tpAmb",
        "verAplic",
        "cStat",
        "xMotivo",
        "cuf",
        "dhRecbto",
        "chNFe",
        "protNFe",
        "retCancNFe",
        "procEventoNFe"
})
public class TRetConsSitNFe
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
    @XmlElement(required = true)
    protected String dhRecbto;
    @XmlElement(required = true)
    protected String chNFe;
    protected TProtNFe protNFe;
    protected TRetCancNFe retCancNFe;
    protected List<TProcEvento> procEventoNFe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

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

    public boolean isSetTpAmb() {
        return (this.tpAmb != null);
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

    public boolean isSetVerAplic() {
        return (this.verAplic != null);
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

    public boolean isSetCStat() {
        return (this.cStat != null);
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

    public boolean isSetXMotivo() {
        return (this.xMotivo != null);
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

    public boolean isSetCUF() {
        return (this.cuf != null);
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

    public boolean isSetDhRecbto() {
        return (this.dhRecbto != null);
    }

    /**
     * Obtém o valor da propriedade chNFe.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChNFe() {
        return chNFe;
    }

    /**
     * Define o valor da propriedade chNFe.
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
     * Obtém o valor da propriedade protNFe.
     *
     * @return possible object is
     * {@link TProtNFe }
     */
    public TProtNFe getProtNFe() {
        return protNFe;
    }

    /**
     * Define o valor da propriedade protNFe.
     *
     * @param value allowed object is
     *              {@link TProtNFe }
     */
    public void setProtNFe(TProtNFe value) {
        this.protNFe = value;
    }

    public boolean isSetProtNFe() {
        return (this.protNFe != null);
    }

    /**
     * Obtém o valor da propriedade retCancNFe.
     *
     * @return possible object is
     * {@link TRetCancNFe }
     */
    public TRetCancNFe getRetCancNFe() {
        return retCancNFe;
    }

    /**
     * Define o valor da propriedade retCancNFe.
     *
     * @param value allowed object is
     *              {@link TRetCancNFe }
     */
    public void setRetCancNFe(TRetCancNFe value) {
        this.retCancNFe = value;
    }

    public boolean isSetRetCancNFe() {
        return (this.retCancNFe != null);
    }

    /**
     * Gets the value of the procEventoNFe property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the procEventoNFe property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcEventoNFe().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TProcEvento }
     */
    public List<TProcEvento> getProcEventoNFe() {
        if (procEventoNFe == null) {
            procEventoNFe = new ArrayList<TProcEvento>();
        }
        return this.procEventoNFe;
    }

    public boolean isSetProcEventoNFe() {
        return ((this.procEventoNFe != null) && (!this.procEventoNFe.isEmpty()));
    }

    public void unsetProcEventoNFe() {
        this.procEventoNFe = null;
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

    public boolean isSetVersao() {
        return (this.versao != null);
    }

}
