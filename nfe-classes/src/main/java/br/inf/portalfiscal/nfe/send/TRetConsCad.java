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
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Tipo Retorno Pedido de Consulta de cadastro de contribuintes
 *
 * <p>Classe Java de TRetConsCad complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TRetConsCad"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infCons"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplicConsCad"/&gt;
 *                   &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStatConsCad"/&gt;
 *                   &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivoConsCad"/&gt;
 *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/nfe}TUfCons"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad"/&gt;
 *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjVarConsCad"/&gt;
 *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpfVarConsCad"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="dhCons" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                   &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGEConsCad"/&gt;
 *                   &lt;element name="infCad" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad"/&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjVarConsCad"/&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpfVarConsCad"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="UF" type="{http://www.portalfiscal.inf.br/nfe}TUfConsCad"/&gt;
 *                             &lt;element name="cSit"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *                                   &lt;enumeration value="0"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="indCredNFe"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="0"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                   &lt;enumeration value="3"/&gt;
 *                                   &lt;enumeration value="4"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="indCredCTe"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;whiteSpace value="preserve"/&gt;
 *                                   &lt;enumeration value="0"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                   &lt;enumeration value="3"/&gt;
 *                                   &lt;enumeration value="4"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xFant" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="xRegApur" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="CNAE" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *                                   &lt;pattern value="[0-9]{6,7}"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="dIniAtiv" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="dUltSit" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="dBaixa" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="IEUnica" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad" minOccurs="0"/&gt;
 *                             &lt;element name="IEAtual" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad" minOccurs="0"/&gt;
 *                             &lt;element name="ender" type="{http://www.portalfiscal.inf.br/nfe}TEnderecoConsCad" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
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
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerConsCad" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsCad", propOrder = {
        "infCons"
})
public class TRetConsCad
        implements XML {

    @XmlElement(required = true)
    protected TRetConsCad.InfCons infCons;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

    /**
     * Obtém o valor da propriedade infCons.
     *
     * @return possible object is
     * {@link TRetConsCad.InfCons }
     */
    public TRetConsCad.InfCons getInfCons() {
        return infCons;
    }

    /**
     * Define o valor da propriedade infCons.
     *
     * @param value allowed object is
     *              {@link TRetConsCad.InfCons }
     */
    public void setInfCons(TRetConsCad.InfCons value) {
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
     *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplicConsCad"/&gt;
     *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStatConsCad"/&gt;
     *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivoConsCad"/&gt;
     *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/nfe}TUfCons"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad"/&gt;
     *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjVarConsCad"/&gt;
     *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpfVarConsCad"/&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="dhCons" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGEConsCad"/&gt;
     *         &lt;element name="infCad" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad"/&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjVarConsCad"/&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpfVarConsCad"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/nfe}TUfConsCad"/&gt;
     *                   &lt;element name="cSit"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
     *                         &lt;enumeration value="0"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="indCredNFe"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="0"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                         &lt;enumeration value="3"/&gt;
     *                         &lt;enumeration value="4"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="indCredCTe"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;whiteSpace value="preserve"/&gt;
     *                         &lt;enumeration value="0"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                         &lt;enumeration value="3"/&gt;
     *                         &lt;enumeration value="4"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xFant" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="xRegApur" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="CNAE" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
     *                         &lt;pattern value="[0-9]{6,7}"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="dIniAtiv" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="dUltSit" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="dBaixa" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="IEUnica" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad" minOccurs="0"/&gt;
     *                   &lt;element name="IEAtual" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad" minOccurs="0"/&gt;
     *                   &lt;element name="ender" type="{http://www.portalfiscal.inf.br/nfe}TEnderecoConsCad" minOccurs="0"/&gt;
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
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "verAplic",
            "cStat",
            "xMotivo",
            "uf",
            "ie",
            "cnpj",
            "cpf",
            "dhCons",
            "cuf",
            "infCad"
    })
    public static class InfCons
            implements XML {

        @XmlElement(required = true)
        protected String verAplic;
        @XmlElement(required = true)
        protected String cStat;
        @XmlElement(required = true)
        protected String xMotivo;
        @XmlElement(name = "UF", required = true)
        @XmlSchemaType(name = "token")
        protected TUfCons uf;
        @XmlElement(name = "IE")
        protected String ie;
        @XmlElement(name = "CNPJ")
        protected String cnpj;
        @XmlElement(name = "CPF")
        protected String cpf;
        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dhCons;
        @XmlElement(name = "cUF", required = true)
        protected String cuf;
        protected List<TRetConsCad.InfCons.InfCad> infCad;

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

        /**
         * Obtém o valor da propriedade uf.
         *
         * @return possible object is
         * {@link TUfCons }
         */
        public TUfCons getUF() {
            return uf;
        }

        /**
         * Define o valor da propriedade uf.
         *
         * @param value allowed object is
         *              {@link TUfCons }
         */
        public void setUF(TUfCons value) {
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

        /**
         * Obtém o valor da propriedade dhCons.
         *
         * @return possible object is
         * {@link XMLGregorianCalendar }
         */
        public XMLGregorianCalendar getDhCons() {
            return dhCons;
        }

        /**
         * Define o valor da propriedade dhCons.
         *
         * @param value allowed object is
         *              {@link XMLGregorianCalendar }
         */
        public void setDhCons(XMLGregorianCalendar value) {
            this.dhCons = value;
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

        /**
         * Gets the value of the infCad property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the infCad property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInfCad().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TRetConsCad.InfCons.InfCad }
         */
        public List<TRetConsCad.InfCons.InfCad> getInfCad() {
            if (infCad == null) {
                infCad = new ArrayList<TRetConsCad.InfCons.InfCad>();
            }
            return this.infCad;
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
         *         &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad"/&gt;
         *         &lt;choice&gt;
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjVarConsCad"/&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpfVarConsCad"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/nfe}TUfConsCad"/&gt;
         *         &lt;element name="cSit"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
         *               &lt;enumeration value="0"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="indCredNFe"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="0"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *               &lt;enumeration value="3"/&gt;
         *               &lt;enumeration value="4"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="indCredCTe"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;whiteSpace value="preserve"/&gt;
         *               &lt;enumeration value="0"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *               &lt;enumeration value="3"/&gt;
         *               &lt;enumeration value="4"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="60"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xFant" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="60"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="xRegApur" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="60"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="CNAE" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
         *               &lt;pattern value="[0-9]{6,7}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="dIniAtiv" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="dUltSit" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="dBaixa" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="IEUnica" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad" minOccurs="0"/&gt;
         *         &lt;element name="IEAtual" type="{http://www.portalfiscal.inf.br/nfe}TIeConsCad" minOccurs="0"/&gt;
         *         &lt;element name="ender" type="{http://www.portalfiscal.inf.br/nfe}TEnderecoConsCad" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "ie",
                "cnpj",
                "cpf",
                "uf",
                "cSit",
                "indCredNFe",
                "indCredCTe",
                "xNome",
                "xFant",
                "xRegApur",
                "cnae",
                "dIniAtiv",
                "dUltSit",
                "dBaixa",
                "ieUnica",
                "ieAtual",
                "ender"
        })
        public static class InfCad
                implements XML {

            @XmlElement(name = "IE", required = true)
            protected String ie;
            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(name = "UF", required = true)
            @XmlSchemaType(name = "string")
            protected TUfConsCad uf;
            @XmlElement(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String cSit;
            @XmlElement(required = true)
            protected String indCredNFe;
            @XmlElement(required = true)
            protected String indCredCTe;
            @XmlElement(required = true)
            protected String xNome;
            protected String xFant;
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String xRegApur;
            @XmlElement(name = "CNAE")
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String cnae;
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar dIniAtiv;
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar dUltSit;
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar dBaixa;
            @XmlElement(name = "IEUnica")
            protected String ieUnica;
            @XmlElement(name = "IEAtual")
            protected String ieAtual;
            protected TEnderecoConsCad ender;

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
             * Obtém o valor da propriedade cSit.
             *
             * @return possible object is
             * {@link String }
             */
            public String getCSit() {
                return cSit;
            }

            /**
             * Define o valor da propriedade cSit.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setCSit(String value) {
                this.cSit = value;
            }

            /**
             * Obtém o valor da propriedade indCredNFe.
             *
             * @return possible object is
             * {@link String }
             */
            public String getIndCredNFe() {
                return indCredNFe;
            }

            /**
             * Define o valor da propriedade indCredNFe.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setIndCredNFe(String value) {
                this.indCredNFe = value;
            }

            /**
             * Obtém o valor da propriedade indCredCTe.
             *
             * @return possible object is
             * {@link String }
             */
            public String getIndCredCTe() {
                return indCredCTe;
            }

            /**
             * Define o valor da propriedade indCredCTe.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setIndCredCTe(String value) {
                this.indCredCTe = value;
            }

            /**
             * Obtém o valor da propriedade xNome.
             *
             * @return possible object is
             * {@link String }
             */
            public String getXNome() {
                return xNome;
            }

            /**
             * Define o valor da propriedade xNome.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setXNome(String value) {
                this.xNome = value;
            }

            /**
             * Obtém o valor da propriedade xFant.
             *
             * @return possible object is
             * {@link String }
             */
            public String getXFant() {
                return xFant;
            }

            /**
             * Define o valor da propriedade xFant.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setXFant(String value) {
                this.xFant = value;
            }

            /**
             * Obtém o valor da propriedade xRegApur.
             *
             * @return possible object is
             * {@link String }
             */
            public String getXRegApur() {
                return xRegApur;
            }

            /**
             * Define o valor da propriedade xRegApur.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setXRegApur(String value) {
                this.xRegApur = value;
            }

            /**
             * Obtém o valor da propriedade cnae.
             *
             * @return possible object is
             * {@link String }
             */
            public String getCNAE() {
                return cnae;
            }

            /**
             * Define o valor da propriedade cnae.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setCNAE(String value) {
                this.cnae = value;
            }

            /**
             * Obtém o valor da propriedade dIniAtiv.
             *
             * @return possible object is
             * {@link XMLGregorianCalendar }
             */
            public XMLGregorianCalendar getDIniAtiv() {
                return dIniAtiv;
            }

            /**
             * Define o valor da propriedade dIniAtiv.
             *
             * @param value allowed object is
             *              {@link XMLGregorianCalendar }
             */
            public void setDIniAtiv(XMLGregorianCalendar value) {
                this.dIniAtiv = value;
            }

            /**
             * Obtém o valor da propriedade dUltSit.
             *
             * @return possible object is
             * {@link XMLGregorianCalendar }
             */
            public XMLGregorianCalendar getDUltSit() {
                return dUltSit;
            }

            /**
             * Define o valor da propriedade dUltSit.
             *
             * @param value allowed object is
             *              {@link XMLGregorianCalendar }
             */
            public void setDUltSit(XMLGregorianCalendar value) {
                this.dUltSit = value;
            }

            /**
             * Obtém o valor da propriedade dBaixa.
             *
             * @return possible object is
             * {@link XMLGregorianCalendar }
             */
            public XMLGregorianCalendar getDBaixa() {
                return dBaixa;
            }

            /**
             * Define o valor da propriedade dBaixa.
             *
             * @param value allowed object is
             *              {@link XMLGregorianCalendar }
             */
            public void setDBaixa(XMLGregorianCalendar value) {
                this.dBaixa = value;
            }

            /**
             * Obtém o valor da propriedade ieUnica.
             *
             * @return possible object is
             * {@link String }
             */
            public String getIEUnica() {
                return ieUnica;
            }

            /**
             * Define o valor da propriedade ieUnica.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setIEUnica(String value) {
                this.ieUnica = value;
            }

            /**
             * Obtém o valor da propriedade ieAtual.
             *
             * @return possible object is
             * {@link String }
             */
            public String getIEAtual() {
                return ieAtual;
            }

            /**
             * Define o valor da propriedade ieAtual.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setIEAtual(String value) {
                this.ieAtual = value;
            }

            /**
             * Obtém o valor da propriedade ender.
             *
             * @return possible object is
             * {@link TEnderecoConsCad }
             */
            public TEnderecoConsCad getEnder() {
                return ender;
            }

            /**
             * Define o valor da propriedade ender.
             *
             * @param value allowed object is
             *              {@link TEnderecoConsCad }
             */
            public void setEnder(TEnderecoConsCad value) {
                this.ender = value;
            }

        }

    }

}
