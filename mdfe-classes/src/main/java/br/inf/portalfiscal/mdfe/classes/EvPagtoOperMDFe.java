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
 * <p>Classe Java de EvPagtoOperMDFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="EvPagtoOperMDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="Pagamento Operação MDF-e"/&gt;
 *               &lt;enumeration value="Pagamento Operacao MDF-e"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/mdfe}TProt"/&gt;
 *         &lt;element name="infViagens"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="qtdViagens"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;pattern value="[0-9]{5}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="nroViagem"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;pattern value="[0-9]{5}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infPag" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="xNome" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;maxLength value="60"/&gt;
 *                         &lt;minLength value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                     &lt;element name="idEstrangeiro"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;whiteSpace value="preserve"/&gt;
 *                           &lt;minLength value="2"/&gt;
 *                           &lt;maxLength value="20"/&gt;
 *                           &lt;pattern value="([!-ÿ]{0}|[!-ÿ]{5,20})?"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="Comp" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="tpComp"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="01"/&gt;
 *                                   &lt;enumeration value="02"/&gt;
 *                                   &lt;enumeration value="03"/&gt;
 *                                   &lt;enumeration value="99"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="vComp" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
 *                             &lt;element name="xComp" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="vContrato" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
 *                   &lt;element name="indPag"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="0"/&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="vAdiant" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302" minOccurs="0"/&gt;
 *                   &lt;element name="infPrazo" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="nParcela"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;pattern value="[0-9]{3}"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="dVenc" type="{http://www.portalfiscal.inf.br/mdfe}TData"/&gt;
 *                             &lt;element name="vParcela" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302Opc"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="infBanc"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="codBanco"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                     &lt;minLength value="3"/&gt;
 *                                     &lt;maxLength value="5"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="codAgencia"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                     &lt;minLength value="1"/&gt;
 *                                     &lt;maxLength value="10"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;element name="CNPJIPEF" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                             &lt;element name="PIX"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "EvPagtoOperMDFe", propOrder = {
    "descEvento",
    "nProt",
    "infViagens",
    "infPag"
})
public class EvPagtoOperMDFe
    implements XML
{

    @XmlElement(required = true)
    protected String descEvento;
    @XmlElement(required = true)
    protected String nProt;
    @XmlElement(required = true)
    protected InfViagens infViagens;
    @XmlElement(required = true)
    protected List<InfPag> infPag;

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
     * Obtém o valor da propriedade infViagens.
     * 
     * @return
     *     possible object is
     *     {@link InfViagens }
     *     
     */
    public InfViagens getInfViagens() {
        return infViagens;
    }

    /**
     * Define o valor da propriedade infViagens.
     * 
     * @param value
     *     allowed object is
     *     {@link InfViagens }
     *     
     */
    public void setInfViagens(InfViagens value) {
        this.infViagens = value;
    }

    /**
     * Gets the value of the infPag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infPag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfPag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfPag }
     * 
     * 
     */
    public List<InfPag> getInfPag() {
        if (infPag == null) {
            infPag = new ArrayList<InfPag>();
        }
        return this.infPag;
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
     *         &lt;element name="xNome" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;maxLength value="60"/&gt;
     *               &lt;minLength value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;choice&gt;
     *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *           &lt;element name="idEstrangeiro"&gt;
     *             &lt;simpleType&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                 &lt;whiteSpace value="preserve"/&gt;
     *                 &lt;minLength value="2"/&gt;
     *                 &lt;maxLength value="20"/&gt;
     *                 &lt;pattern value="([!-ÿ]{0}|[!-ÿ]{5,20})?"/&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleType&gt;
     *           &lt;/element&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="Comp" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="tpComp"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="01"/&gt;
     *                         &lt;enumeration value="02"/&gt;
     *                         &lt;enumeration value="03"/&gt;
     *                         &lt;enumeration value="99"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="vComp" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
     *                   &lt;element name="xComp" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="vContrato" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
     *         &lt;element name="indPag"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="0"/&gt;
     *               &lt;enumeration value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="vAdiant" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302" minOccurs="0"/&gt;
     *         &lt;element name="infPrazo" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="nParcela"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;pattern value="[0-9]{3}"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="dVenc" type="{http://www.portalfiscal.inf.br/mdfe}TData"/&gt;
     *                   &lt;element name="vParcela" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302Opc"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="infBanc"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="codBanco"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                           &lt;minLength value="3"/&gt;
     *                           &lt;maxLength value="5"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="codAgencia"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                           &lt;minLength value="1"/&gt;
     *                           &lt;maxLength value="10"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                   &lt;element name="CNPJIPEF" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *                   &lt;element name="PIX"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/choice&gt;
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
    @XmlType(name = "", propOrder = {
        "xNome",
        "cpf",
        "cnpj",
        "idEstrangeiro",
        "comp",
        "vContrato",
        "indPag",
        "vAdiant",
        "infPrazo",
        "infBanc"
    })
    public static class InfPag
        implements XML
    {

        protected String xNome;
        @XmlElement(name = "CPF")
        protected String cpf;
        @XmlElement(name = "CNPJ")
        protected String cnpj;
        protected String idEstrangeiro;
        @XmlElement(name = "Comp", required = true)
        protected List<Comp> comp;
        @XmlElement(required = true)
        protected String vContrato;
        @XmlElement(required = true)
        protected String indPag;
        protected String vAdiant;
        protected List<InfPrazo> infPrazo;
        @XmlElement(required = true)
        protected InfBanc infBanc;

        /**
         * Obtém o valor da propriedade xNome.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXNome() {
            return xNome;
        }

        /**
         * Define o valor da propriedade xNome.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXNome(String value) {
            this.xNome = value;
        }

        /**
         * Obtém o valor da propriedade cpf.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCPF() {
            return cpf;
        }

        /**
         * Define o valor da propriedade cpf.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCPF(String value) {
            this.cpf = value;
        }

        /**
         * Obtém o valor da propriedade cnpj.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCNPJ() {
            return cnpj;
        }

        /**
         * Define o valor da propriedade cnpj.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCNPJ(String value) {
            this.cnpj = value;
        }

        /**
         * Obtém o valor da propriedade idEstrangeiro.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdEstrangeiro() {
            return idEstrangeiro;
        }

        /**
         * Define o valor da propriedade idEstrangeiro.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdEstrangeiro(String value) {
            this.idEstrangeiro = value;
        }

        /**
         * Gets the value of the comp property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the comp property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getComp().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Comp }
         * 
         * 
         */
        public List<Comp> getComp() {
            if (comp == null) {
                comp = new ArrayList<Comp>();
            }
            return this.comp;
        }

        /**
         * Obtém o valor da propriedade vContrato.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVContrato() {
            return vContrato;
        }

        /**
         * Define o valor da propriedade vContrato.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVContrato(String value) {
            this.vContrato = value;
        }

        /**
         * Obtém o valor da propriedade indPag.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndPag() {
            return indPag;
        }

        /**
         * Define o valor da propriedade indPag.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndPag(String value) {
            this.indPag = value;
        }

        /**
         * Obtém o valor da propriedade vAdiant.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVAdiant() {
            return vAdiant;
        }

        /**
         * Define o valor da propriedade vAdiant.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVAdiant(String value) {
            this.vAdiant = value;
        }

        /**
         * Gets the value of the infPrazo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the infPrazo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInfPrazo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InfPrazo }
         * 
         * 
         */
        public List<InfPrazo> getInfPrazo() {
            if (infPrazo == null) {
                infPrazo = new ArrayList<InfPrazo>();
            }
            return this.infPrazo;
        }

        /**
         * Obtém o valor da propriedade infBanc.
         * 
         * @return
         *     possible object is
         *     {@link InfBanc }
         *     
         */
        public InfBanc getInfBanc() {
            return infBanc;
        }

        /**
         * Define o valor da propriedade infBanc.
         * 
         * @param value
         *     allowed object is
         *     {@link InfBanc }
         *     
         */
        public void setInfBanc(InfBanc value) {
            this.infBanc = value;
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
         *         &lt;element name="tpComp"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="01"/&gt;
         *               &lt;enumeration value="02"/&gt;
         *               &lt;enumeration value="03"/&gt;
         *               &lt;enumeration value="99"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="vComp" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
         *         &lt;element name="xComp" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
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
        @XmlType(name = "", propOrder = {
            "tpComp",
            "vComp",
            "xComp"
        })
        public static class Comp
            implements XML
        {

            @XmlElement(required = true)
            protected String tpComp;
            @XmlElement(required = true)
            protected String vComp;
            protected String xComp;

            /**
             * Obtém o valor da propriedade tpComp.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTpComp() {
                return tpComp;
            }

            /**
             * Define o valor da propriedade tpComp.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTpComp(String value) {
                this.tpComp = value;
            }

            /**
             * Obtém o valor da propriedade vComp.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVComp() {
                return vComp;
            }

            /**
             * Define o valor da propriedade vComp.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVComp(String value) {
                this.vComp = value;
            }

            /**
             * Obtém o valor da propriedade xComp.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXComp() {
                return xComp;
            }

            /**
             * Define o valor da propriedade xComp.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setXComp(String value) {
                this.xComp = value;
            }

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
         *       &lt;choice&gt;
         *         &lt;sequence&gt;
         *           &lt;element name="codBanco"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                 &lt;minLength value="3"/&gt;
         *                 &lt;maxLength value="5"/&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="codAgencia"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *                 &lt;minLength value="1"/&gt;
         *                 &lt;maxLength value="10"/&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *         &lt;/sequence&gt;
         *         &lt;element name="CNPJIPEF" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
         *         &lt;element name="PIX"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *       &lt;/choice&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "codBanco",
            "codAgencia",
            "cnpjipef",
            "pix"
        })
        public static class InfBanc
            implements XML
        {

            protected String codBanco;
            protected String codAgencia;
            @XmlElement(name = "CNPJIPEF")
            protected String cnpjipef;
            @XmlElement(name = "PIX")
            protected String pix;

            /**
             * Obtém o valor da propriedade codBanco.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodBanco() {
                return codBanco;
            }

            /**
             * Define o valor da propriedade codBanco.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodBanco(String value) {
                this.codBanco = value;
            }

            /**
             * Obtém o valor da propriedade codAgencia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodAgencia() {
                return codAgencia;
            }

            /**
             * Define o valor da propriedade codAgencia.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodAgencia(String value) {
                this.codAgencia = value;
            }

            /**
             * Obtém o valor da propriedade cnpjipef.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCNPJIPEF() {
                return cnpjipef;
            }

            /**
             * Define o valor da propriedade cnpjipef.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCNPJIPEF(String value) {
                this.cnpjipef = value;
            }

            /**
             * Obtém o valor da propriedade pix.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPIX() {
                return pix;
            }

            /**
             * Define o valor da propriedade pix.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPIX(String value) {
                this.pix = value;
            }

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
         *         &lt;element name="nParcela"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;pattern value="[0-9]{3}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="dVenc" type="{http://www.portalfiscal.inf.br/mdfe}TData"/&gt;
         *         &lt;element name="vParcela" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302Opc"/&gt;
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
            "nParcela",
            "dVenc",
            "vParcela"
        })
        public static class InfPrazo
            implements XML
        {

            @XmlElement(required = true)
            protected String nParcela;
            @XmlElement(required = true)
            protected String dVenc;
            @XmlElement(required = true)
            protected String vParcela;

            /**
             * Obtém o valor da propriedade nParcela.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNParcela() {
                return nParcela;
            }

            /**
             * Define o valor da propriedade nParcela.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNParcela(String value) {
                this.nParcela = value;
            }

            /**
             * Obtém o valor da propriedade dVenc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDVenc() {
                return dVenc;
            }

            /**
             * Define o valor da propriedade dVenc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDVenc(String value) {
                this.dVenc = value;
            }

            /**
             * Obtém o valor da propriedade vParcela.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVParcela() {
                return vParcela;
            }

            /**
             * Define o valor da propriedade vParcela.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVParcela(String value) {
                this.vParcela = value;
            }

        }

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
     *         &lt;element name="qtdViagens"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;pattern value="[0-9]{5}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="nroViagem"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;pattern value="[0-9]{5}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
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
    @XmlType(name = "", propOrder = {
        "qtdViagens",
        "nroViagem"
    })
    public static class InfViagens
        implements XML
    {

        @XmlElement(required = true)
        protected String qtdViagens;
        @XmlElement(required = true)
        protected String nroViagem;

        /**
         * Obtém o valor da propriedade qtdViagens.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQtdViagens() {
            return qtdViagens;
        }

        /**
         * Define o valor da propriedade qtdViagens.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQtdViagens(String value) {
            this.qtdViagens = value;
        }

        /**
         * Obtém o valor da propriedade nroViagem.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNroViagem() {
            return nroViagem;
        }

        /**
         * Define o valor da propriedade nroViagem.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNroViagem(String value) {
            this.nroViagem = value;
        }

    }

}
