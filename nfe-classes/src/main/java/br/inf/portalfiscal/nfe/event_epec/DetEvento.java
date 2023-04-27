//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.09.08 às 05:51:48 PM BRT 
//


package br.inf.portalfiscal.nfe.event_epec;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.*;


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
 *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}descEvento"/&gt;
 *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}cOrgaoAutor"/&gt;
 *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}tpAutor"/&gt;
 *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}verAplic"/&gt;
 *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}dhEmi"/&gt;
 *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}tpNF"/&gt;
 *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}IE"/&gt;
 *         &lt;element name="dest"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.portalfiscal.inf.br/nfe}UF"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj"/&gt;
 *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/&gt;
 *                     &lt;element name="idEstrangeiro"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;whiteSpace value="preserve"/&gt;
 *                           &lt;pattern value="([!-ÿ]{0}|[!-ÿ]{5,20})?"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element ref="{http://www.portalfiscal.inf.br/nfe}IE" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://www.portalfiscal.inf.br/nfe}vNF"/&gt;
 *                   &lt;element ref="{http://www.portalfiscal.inf.br/nfe}vICMS"/&gt;
 *                   &lt;element ref="{http://www.portalfiscal.inf.br/nfe}vST"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;whiteSpace value="preserve"/&gt;
 *             &lt;enumeration value="1.00"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "descEvento",
        "cOrgaoAutor",
        "tpAutor",
        "verAplic",
        "dhEmi",
        "tpNF",
        "ie",
        "dest"
})
@XmlRootElement(name = "detEvento", namespace = "http://www.portalfiscal.inf.br/nfe")
public class DetEvento
        implements XML {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String descEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String cOrgaoAutor;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String tpAutor;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String verAplic;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String dhEmi;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String tpNF;
    @XmlElement(name = "IE", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String ie;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected Dest dest;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obtém o valor da propriedade descEvento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescEvento() {
        return descEvento;
    }

    /**
     * Define o valor da propriedade descEvento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescEvento(String value) {
        this.descEvento = value;
    }

    /**
     * Obtém o valor da propriedade cOrgaoAutor.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCOrgaoAutor() {
        return cOrgaoAutor;
    }

    /**
     * Define o valor da propriedade cOrgaoAutor.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCOrgaoAutor(String value) {
        this.cOrgaoAutor = value;
    }

    /**
     * Obtém o valor da propriedade tpAutor.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpAutor() {
        return tpAutor;
    }

    /**
     * Define o valor da propriedade tpAutor.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpAutor(String value) {
        this.tpAutor = value;
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

    /**
     * Obtém o valor da propriedade dhEmi.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhEmi() {
        return dhEmi;
    }

    /**
     * Define o valor da propriedade dhEmi.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhEmi(String value) {
        this.dhEmi = value;
    }

    /**
     * Obtém o valor da propriedade tpNF.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpNF() {
        return tpNF;
    }

    /**
     * Define o valor da propriedade tpNF.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpNF(String value) {
        this.tpNF = value;
    }

    /**
     * Obtém o valor da propriedade ie.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIE() {
        return ie;
    }

    /**
     * Define o valor da propriedade ie.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIE(String value) {
        this.ie = value;
    }

    /**
     * Obtém o valor da propriedade dest.
     *
     * @return possible object is
     * {@link Dest }
     */
    public Dest getDest() {
        return dest;
    }

    /**
     * Define o valor da propriedade dest.
     *
     * @param value allowed object is
     *              {@link Dest }
     */
    public void setDest(Dest value) {
        this.dest = value;
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
     * <p>Classe Java de anonymous complex type.
     *
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}UF"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj"/&gt;
     *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/&gt;
     *           &lt;element name="idEstrangeiro"&gt;
     *             &lt;simpleType&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                 &lt;whiteSpace value="preserve"/&gt;
     *                 &lt;pattern value="([!-ÿ]{0}|[!-ÿ]{5,20})?"/&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleType&gt;
     *           &lt;/element&gt;
     *         &lt;/choice&gt;
     *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}IE" minOccurs="0"/&gt;
     *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}vNF"/&gt;
     *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}vICMS"/&gt;
     *         &lt;element ref="{http://www.portalfiscal.inf.br/nfe}vST"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "uf",
            "cnpj",
            "cpf",
            "idEstrangeiro",
            "ie",
            "vnf",
            "vicms",
            "vst"
    })
    public static class Dest
            implements XML {

        @XmlElement(name = "UF", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
        @XmlSchemaType(name = "string")
        protected TUf uf;
        @XmlElement(name = "CNPJ", namespace = "http://www.portalfiscal.inf.br/nfe")
        protected String cnpj;
        @XmlElement(name = "CPF", namespace = "http://www.portalfiscal.inf.br/nfe")
        protected String cpf;
        @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
        protected String idEstrangeiro;
        @XmlElement(name = "IE", namespace = "http://www.portalfiscal.inf.br/nfe")
        protected String ie;
        @XmlElement(name = "vNF", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
        protected String vnf;
        @XmlElement(name = "vICMS", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
        protected String vicms;
        @XmlElement(name = "vST", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
        protected String vst;

        /**
         * Obtém o valor da propriedade uf.
         *
         * @return possible object is
         * {@link TUf }
         */
        public TUf getUF() {
            return uf;
        }

        /**
         * Define o valor da propriedade uf.
         *
         * @param value allowed object is
         *              {@link TUf }
         */
        public void setUF(TUf value) {
            this.uf = value;
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
         * Obtém o valor da propriedade idEstrangeiro.
         *
         * @return possible object is
         * {@link String }
         */
        public String getIdEstrangeiro() {
            return idEstrangeiro;
        }

        /**
         * Define o valor da propriedade idEstrangeiro.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setIdEstrangeiro(String value) {
            this.idEstrangeiro = value;
        }

        /**
         * Obtém o valor da propriedade ie.
         *
         * @return possible object is
         * {@link String }
         */
        public String getIE() {
            return ie;
        }

        /**
         * Define o valor da propriedade ie.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setIE(String value) {
            this.ie = value;
        }

        /**
         * Obtém o valor da propriedade vnf.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVNF() {
            return vnf;
        }

        /**
         * Define o valor da propriedade vnf.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVNF(String value) {
            this.vnf = value;
        }

        /**
         * Obtém o valor da propriedade vicms.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVICMS() {
            return vicms;
        }

        /**
         * Define o valor da propriedade vicms.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVICMS(String value) {
            this.vicms = value;
        }

        /**
         * Obtém o valor da propriedade vst.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVST() {
            return vst;
        }

        /**
         * Define o valor da propriedade vst.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVST(String value) {
            this.vst = value;
        }

    }

}
