//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v3.0.0 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2024.08.02 às 08:46:12 AM BRT 
//


package br.inf.portalfiscal.nfe.send;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.dfe.interfaces.xml.generic.XML;


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
    protected InfCons infCons;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

    /**
     * Obtém o valor da propriedade infCons.
     *
     * @return possible object is
     * {@link InfCons }
     */
    public InfCons getInfCons() {
        return infCons;
    }

    /**
     * Define o valor da propriedade infCons.
     *
     * @param value allowed object is
     *              {@link InfCons }
     */
    public void setInfCons(InfCons value) {
        this.infCons = value;
    }

    public boolean isSetInfCons() {
        return (this.infCons != null);
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

        public boolean isSetXServ() {
            return (this.xServ != null);
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

        public boolean isSetUF() {
            return (this.uf != null);
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

        public boolean isSetIE() {
            return (this.ie != null);
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

        public boolean isSetCNPJ() {
            return (this.cnpj != null);
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

        public boolean isSetCPF() {
            return (this.cpf != null);
        }

    }

}
