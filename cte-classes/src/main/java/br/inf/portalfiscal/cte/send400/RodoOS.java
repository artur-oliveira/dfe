//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.05.09 às 04:53:39 PM BRT 
//


package br.inf.portalfiscal.cte.send400;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.softart.dfe.interfaces.xml.generic.XML;


/**
 * <p>Classe Java de RodoOS complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RodoOS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="TAF" type="{http://www.portalfiscal.inf.br/cte}TTermoAutFreta"/&gt;
 *           &lt;element name="NroRegEstadual" type="{http://www.portalfiscal.inf.br/cte}TNroRegEstadual"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="veic" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="placa"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TPlaca"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="RENAVAM" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                         &lt;minLength value="9"/&gt;
 *                         &lt;maxLength value="11"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="prop" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="TAF" type="{http://www.portalfiscal.inf.br/cte}TTermoAutFreta"/&gt;
 *                               &lt;element name="NroRegEstadual" type="{http://www.portalfiscal.inf.br/cte}TNroRegEstadual"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;sequence minOccurs="0"&gt;
 *                               &lt;element name="IE"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;element name="tpProp"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="0"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infFretamento" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tpFretamento"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                         &lt;enumeration value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="dhViagem" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC" minOccurs="0"/&gt;
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
@XmlType(name = "RodoOS", propOrder = {
    "taf",
    "nroRegEstadual",
    "veic",
    "infFretamento"
})
public class RodoOS
    implements XML
{

    @XmlElement(name = "TAF")
    protected String taf;
    @XmlElement(name = "NroRegEstadual")
    protected String nroRegEstadual;
    protected RodoOS.Veic veic;
    protected RodoOS.InfFretamento infFretamento;

    /**
     * Obtém o valor da propriedade taf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTAF() {
        return taf;
    }

    /**
     * Define o valor da propriedade taf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTAF(String value) {
        this.taf = value;
    }

    /**
     * Obtém o valor da propriedade nroRegEstadual.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroRegEstadual() {
        return nroRegEstadual;
    }

    /**
     * Define o valor da propriedade nroRegEstadual.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroRegEstadual(String value) {
        this.nroRegEstadual = value;
    }

    /**
     * Obtém o valor da propriedade veic.
     * 
     * @return
     *     possible object is
     *     {@link RodoOS.Veic }
     *     
     */
    public RodoOS.Veic getVeic() {
        return veic;
    }

    /**
     * Define o valor da propriedade veic.
     * 
     * @param value
     *     allowed object is
     *     {@link RodoOS.Veic }
     *     
     */
    public void setVeic(RodoOS.Veic value) {
        this.veic = value;
    }

    /**
     * Obtém o valor da propriedade infFretamento.
     * 
     * @return
     *     possible object is
     *     {@link RodoOS.InfFretamento }
     *     
     */
    public RodoOS.InfFretamento getInfFretamento() {
        return infFretamento;
    }

    /**
     * Define o valor da propriedade infFretamento.
     * 
     * @param value
     *     allowed object is
     *     {@link RodoOS.InfFretamento }
     *     
     */
    public void setInfFretamento(RodoOS.InfFretamento value) {
        this.infFretamento = value;
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
     *         &lt;element name="tpFretamento"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="dhViagem" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC" minOccurs="0"/&gt;
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
        "tpFretamento",
        "dhViagem"
    })
    public static class InfFretamento
        implements XML
    {

        @XmlElement(required = true)
        protected String tpFretamento;
        protected String dhViagem;

        /**
         * Obtém o valor da propriedade tpFretamento.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTpFretamento() {
            return tpFretamento;
        }

        /**
         * Define o valor da propriedade tpFretamento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTpFretamento(String value) {
            this.tpFretamento = value;
        }

        /**
         * Obtém o valor da propriedade dhViagem.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDhViagem() {
            return dhViagem;
        }

        /**
         * Define o valor da propriedade dhViagem.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDhViagem(String value) {
            this.dhViagem = value;
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
     *         &lt;element name="placa"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TPlaca"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="RENAVAM" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *               &lt;minLength value="9"/&gt;
     *               &lt;maxLength value="11"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="prop" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="TAF" type="{http://www.portalfiscal.inf.br/cte}TTermoAutFreta"/&gt;
     *                     &lt;element name="NroRegEstadual" type="{http://www.portalfiscal.inf.br/cte}TNroRegEstadual"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;sequence minOccurs="0"&gt;
     *                     &lt;element name="IE"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
     *                   &lt;/sequence&gt;
     *                   &lt;element name="tpProp"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="0"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf" minOccurs="0"/&gt;
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
        "placa",
        "renavam",
        "prop",
        "uf"
    })
    public static class Veic
        implements XML
    {

        @XmlElement(required = true)
        protected String placa;
        @XmlElement(name = "RENAVAM")
        protected String renavam;
        protected RodoOS.Veic.Prop prop;
        @XmlElement(name = "UF")
        @XmlSchemaType(name = "string")
        protected TUf uf;

        /**
         * Obtém o valor da propriedade placa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlaca() {
            return placa;
        }

        /**
         * Define o valor da propriedade placa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlaca(String value) {
            this.placa = value;
        }

        /**
         * Obtém o valor da propriedade renavam.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRENAVAM() {
            return renavam;
        }

        /**
         * Define o valor da propriedade renavam.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRENAVAM(String value) {
            this.renavam = value;
        }

        /**
         * Obtém o valor da propriedade prop.
         * 
         * @return
         *     possible object is
         *     {@link RodoOS.Veic.Prop }
         *     
         */
        public RodoOS.Veic.Prop getProp() {
            return prop;
        }

        /**
         * Define o valor da propriedade prop.
         * 
         * @param value
         *     allowed object is
         *     {@link RodoOS.Veic.Prop }
         *     
         */
        public void setProp(RodoOS.Veic.Prop value) {
            this.prop = value;
        }

        /**
         * Obtém o valor da propriedade uf.
         * 
         * @return
         *     possible object is
         *     {@link TUf }
         *     
         */
        public TUf getUF() {
            return uf;
        }

        /**
         * Define o valor da propriedade uf.
         * 
         * @param value
         *     allowed object is
         *     {@link TUf }
         *     
         */
        public void setUF(TUf value) {
            this.uf = value;
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
         *         &lt;choice&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
         *         &lt;/choice&gt;
         *         &lt;choice&gt;
         *           &lt;element name="TAF" type="{http://www.portalfiscal.inf.br/cte}TTermoAutFreta"/&gt;
         *           &lt;element name="NroRegEstadual" type="{http://www.portalfiscal.inf.br/cte}TNroRegEstadual"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;sequence minOccurs="0"&gt;
         *           &lt;element name="IE"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TIeDest"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
         *         &lt;/sequence&gt;
         *         &lt;element name="tpProp"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="0"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
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
            "cpf",
            "cnpj",
            "taf",
            "nroRegEstadual",
            "xNome",
            "ie",
            "uf",
            "tpProp"
        })
        public static class Prop
            implements XML
        {

            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "TAF")
            protected String taf;
            @XmlElement(name = "NroRegEstadual")
            protected String nroRegEstadual;
            @XmlElement(required = true)
            protected String xNome;
            @XmlElement(name = "IE")
            protected String ie;
            @XmlElement(name = "UF")
            @XmlSchemaType(name = "string")
            protected TUf uf;
            @XmlElement(required = true)
            protected String tpProp;

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
             * Obtém o valor da propriedade taf.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTAF() {
                return taf;
            }

            /**
             * Define o valor da propriedade taf.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTAF(String value) {
                this.taf = value;
            }

            /**
             * Obtém o valor da propriedade nroRegEstadual.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNroRegEstadual() {
                return nroRegEstadual;
            }

            /**
             * Define o valor da propriedade nroRegEstadual.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNroRegEstadual(String value) {
                this.nroRegEstadual = value;
            }

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
             * Obtém o valor da propriedade ie.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIE() {
                return ie;
            }

            /**
             * Define o valor da propriedade ie.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIE(String value) {
                this.ie = value;
            }

            /**
             * Obtém o valor da propriedade uf.
             * 
             * @return
             *     possible object is
             *     {@link TUf }
             *     
             */
            public TUf getUF() {
                return uf;
            }

            /**
             * Define o valor da propriedade uf.
             * 
             * @param value
             *     allowed object is
             *     {@link TUf }
             *     
             */
            public void setUF(TUf value) {
                this.uf = value;
            }

            /**
             * Obtém o valor da propriedade tpProp.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTpProp() {
                return tpProp;
            }

            /**
             * Define o valor da propriedade tpProp.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTpProp(String value) {
                this.tpProp = value;
            }

        }

    }

}
