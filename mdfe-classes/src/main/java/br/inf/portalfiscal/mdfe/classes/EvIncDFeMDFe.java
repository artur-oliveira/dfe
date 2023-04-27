//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.04.12 às 01:57:24 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de EvIncDFeMDFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="EvIncDFeMDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="Inclusão DF-e"/&gt;
 *               &lt;enumeration value="Inclusao DF-e"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/mdfe}TProt"/&gt;
 *         &lt;element name="cMunCarrega" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
 *         &lt;element name="xMunCarrega"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="2"/&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infDoc" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cMunDescarga" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
 *                   &lt;element name="xMunDescarga"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="2"/&gt;
 *                         &lt;maxLength value="60"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvIncDFeMDFe", propOrder = {
    "descEvento",
    "nProt",
    "cMunCarrega",
    "xMunCarrega",
    "infDoc"
})
public class EvIncDFeMDFe
    implements XML
{

    @XmlElement(required = true)
    protected String descEvento;
    @XmlElement(required = true)
    protected String nProt;
    @XmlElement(required = true)
    protected String cMunCarrega;
    @XmlElement(required = true)
    protected String xMunCarrega;
    @XmlElement(required = true)
    protected List<InfDoc> infDoc;

    /**
     * Obtém o valor da propriedade descEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEvento() {
        return descEvento;
    }

    /**
     * Define o valor da propriedade descEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEvento(String value) {
        this.descEvento = value;
    }

    /**
     * Obtém o valor da propriedade nProt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNProt() {
        return nProt;
    }

    /**
     * Define o valor da propriedade nProt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNProt(String value) {
        this.nProt = value;
    }

    /**
     * Obtém o valor da propriedade cMunCarrega.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCMunCarrega() {
        return cMunCarrega;
    }

    /**
     * Define o valor da propriedade cMunCarrega.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCMunCarrega(String value) {
        this.cMunCarrega = value;
    }

    /**
     * Obtém o valor da propriedade xMunCarrega.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXMunCarrega() {
        return xMunCarrega;
    }

    /**
     * Define o valor da propriedade xMunCarrega.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXMunCarrega(String value) {
        this.xMunCarrega = value;
    }

    /**
     * Gets the value of the infDoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infDoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfDoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfDoc }
     * 
     * 
     */
    public List<InfDoc> getInfDoc() {
        if (infDoc == null) {
            infDoc = new ArrayList<InfDoc>();
        }
        return this.infDoc;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="cMunDescarga" type="{http://www.portalfiscal.inf.br/mdfe}TCodMunIBGE"/&gt;
     *         &lt;element name="xMunDescarga"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="2"/&gt;
     *               &lt;maxLength value="60"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cMunDescarga",
        "xMunDescarga",
        "chNFe"
    })
    public static class InfDoc
        implements XML
    {

        @XmlElement(required = true)
        protected String cMunDescarga;
        @XmlElement(required = true)
        protected String xMunDescarga;
        @XmlElement(required = true)
        protected String chNFe;

        /**
         * Obtém o valor da propriedade cMunDescarga.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCMunDescarga() {
            return cMunDescarga;
        }

        /**
         * Define o valor da propriedade cMunDescarga.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCMunDescarga(String value) {
            this.cMunDescarga = value;
        }

        /**
         * Obtém o valor da propriedade xMunDescarga.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXMunDescarga() {
            return xMunDescarga;
        }

        /**
         * Define o valor da propriedade xMunDescarga.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXMunDescarga(String value) {
            this.xMunDescarga = value;
        }

        /**
         * Obtém o valor da propriedade chNFe.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChNFe() {
            return chNFe;
        }

        /**
         * Define o valor da propriedade chNFe.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChNFe(String value) {
            this.chNFe = value;
        }

    }

}
