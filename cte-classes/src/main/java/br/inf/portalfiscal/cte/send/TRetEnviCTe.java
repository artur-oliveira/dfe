//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.12.08 às 12:12:45 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * Tipo Retorno do Pedido de Concessão de Autorização da CT-e
 *
 * <p>Classe Java de TRetEnviCTe complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TRetEnviCTe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/cte}TAmb"/&gt;
 *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/cte}TCodUfIBGE"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/cte}TVerAplic"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/cte}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/cte}TMotivo"/&gt;
 *         &lt;element name="infRec" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="nRec" type="{http://www.portalfiscal.inf.br/cte}TRec"/&gt;
 *                   &lt;element name="dhRecbto" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"/&gt;
 *                   &lt;element name="tMed"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                         &lt;pattern value="[0-9]{1,4}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/cte}TVerCTe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetEnviCTe", propOrder = {
        "tpAmb",
        "cuf",
        "verAplic",
        "cStat",
        "xMotivo",
        "infRec"
})
public class TRetEnviCTe
        implements XML {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(name = "cUF", required = true)
    protected String cuf;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    protected InfRec infRec;
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
     * Obtém o valor da propriedade infRec.
     *
     * @return possible object is
     * {@link InfRec }
     */
    public InfRec getInfRec() {
        return infRec;
    }

    /**
     * Define o valor da propriedade infRec.
     *
     * @param value allowed object is
     *              {@link InfRec }
     */
    public void setInfRec(InfRec value) {
        this.infRec = value;
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
     *         &lt;element name="nRec" type="{http://www.portalfiscal.inf.br/cte}TRec"/&gt;
     *         &lt;element name="dhRecbto" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC"/&gt;
     *         &lt;element name="tMed"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *               &lt;pattern value="[0-9]{1,4}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "nRec",
            "dhRecbto",
            "tMed"
    })
    public static class InfRec
            implements XML {

        @XmlElement(required = true)
        protected String nRec;
        @XmlElement(required = true)
        protected String dhRecbto;
        @XmlElement(required = true)
        protected BigInteger tMed;

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

        /**
         * Obtém o valor da propriedade tMed.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getTMed() {
            return tMed;
        }

        /**
         * Define o valor da propriedade tMed.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setTMed(BigInteger value) {
            this.tMed = value;
        }

    }

}
