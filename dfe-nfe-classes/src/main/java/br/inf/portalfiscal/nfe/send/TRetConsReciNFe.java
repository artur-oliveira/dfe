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
 * Tipo Retorno do Pedido de  Consulta do Recido do Lote de Notas Fiscais Eletrônicas
 *
 * <p>Classe Java de TRetConsReciNFe complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TRetConsReciNFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/&gt;
 *         &lt;element name="nRec" type="{http://www.portalfiscal.inf.br/nfe}TRec"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/&gt;
 *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/&gt;
 *         &lt;element name="dhRecbto" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/&gt;
 *         &lt;sequence minOccurs="0"&gt;
 *           &lt;element name="cMsg"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                 &lt;whiteSpace value="preserve"/&gt;
 *                 &lt;pattern value="[0-9]{1,4}"/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="xMsg"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString"&gt;
 *                 &lt;minLength value="1"/&gt;
 *                 &lt;maxLength value="200"/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="protNFe" type="{http://www.portalfiscal.inf.br/nfe}TProtNFe" maxOccurs="50" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerNFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsReciNFe", propOrder = {
        "tpAmb",
        "verAplic",
        "nRec",
        "cStat",
        "xMotivo",
        "cuf",
        "dhRecbto",
        "cMsg",
        "xMsg",
        "protNFe"
})
public class TRetConsReciNFe
        implements XML {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String nRec;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    @XmlElement(name = "cUF", required = true)
    protected String cuf;
    @XmlElement(required = true)
    protected String dhRecbto;
    protected String cMsg;
    protected String xMsg;
    protected List<TProtNFe> protNFe;
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
     * Obtém o valor da propriedade nRec.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNRec() {
        return nRec;
    }

    /**
     * Define o valor da propriedade nRec.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNRec(String value) {
        this.nRec = value;
    }

    public boolean isSetNRec() {
        return (this.nRec != null);
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
     * Obtém o valor da propriedade cMsg.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCMsg() {
        return cMsg;
    }

    /**
     * Define o valor da propriedade cMsg.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCMsg(String value) {
        this.cMsg = value;
    }

    public boolean isSetCMsg() {
        return (this.cMsg != null);
    }

    /**
     * Obtém o valor da propriedade xMsg.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXMsg() {
        return xMsg;
    }

    /**
     * Define o valor da propriedade xMsg.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXMsg(String value) {
        this.xMsg = value;
    }

    public boolean isSetXMsg() {
        return (this.xMsg != null);
    }

    /**
     * Gets the value of the protNFe property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the protNFe property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProtNFe().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TProtNFe }
     */
    public List<TProtNFe> getProtNFe() {
        if (protNFe == null) {
            protNFe = new ArrayList<TProtNFe>();
        }
        return this.protNFe;
    }

    public boolean isSetProtNFe() {
        return ((this.protNFe != null) && (!this.protNFe.isEmpty()));
    }

    public void unsetProtNFe() {
        this.protNFe = null;
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
