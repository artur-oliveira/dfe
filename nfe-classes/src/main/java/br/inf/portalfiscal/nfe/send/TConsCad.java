//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.03.16 às 01:10:23 PM BRT 
//


package br.inf.portalfiscal.nfe.send;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Tipo Pedido de Consulta de cadastro de contribuintes
 *
 * <p>Classe Java de TConsCad complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TConsCad"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infCons"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="xServ"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TServConsCad"&gt;
 *                         &lt;enumeration value="CONS-CAD"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/nfe}TUfConsCad"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad"/&gt;
 *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjVarConsCad"/&gt;
 *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpfVarConsCad"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerConsCad" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TConsCad", propOrder = {
        "infCons"
})
public class TConsCad
        implements XML {

    @XmlElement(required = true)
    protected TConsCad.InfCons infCons;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

    /**
     * Obtém o valor da propriedade infCons.
     *
     * @return possible object is
     * {@link TConsCad.InfCons }
     */
    public TConsCad.InfCons getInfCons() {
        return infCons;
    }

    /**
     * Define o valor da propriedade infCons.
     *
     * @param value allowed object is
     *              {@link TConsCad.InfCons }
     */
    public void setInfCons(TConsCad.InfCons value) {
        this.infCons = value;
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
     *         &lt;element name="xServ"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TServConsCad"&gt;
     *               &lt;enumeration value="CONS-CAD"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/nfe}TUfConsCad"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad"/&gt;
     *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjVarConsCad"/&gt;
     *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpfVarConsCad"/&gt;
     *         &lt;/choice&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "xServ",
            "uf",
            "ie",
            "cnpj",
            "cpf"
    })
    public static class InfCons
            implements XML {

        @XmlElement(required = true)
        protected String xServ;
        @XmlElement(name = "UF", required = true)
        @XmlSchemaType(name = "string")
        protected TUfConsCad uf;
        @XmlElement(name = "IE")
        protected String ie;
        @XmlElement(name = "CNPJ")
        protected String cnpj;
        @XmlElement(name = "CPF")
        protected String cpf;

        /**
         * Obtém o valor da propriedade xServ.
         *
         * @return possible object is
         * {@link String }
         */
        public String getXServ() {
            return xServ;
        }

        /**
         * Define o valor da propriedade xServ.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setXServ(String value) {
            this.xServ = value;
        }

        /**
         * Obtém o valor da propriedade uf.
         *
         * @return possible object is
         * {@link TUfConsCad }
         */
        public TUfConsCad getUF() {
            return uf;
        }

        /**
         * Define o valor da propriedade uf.
         *
         * @param value allowed object is
         *              {@link TUfConsCad }
         */
        public void setUF(TUfConsCad value) {
            this.uf = value;
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

    }

}
