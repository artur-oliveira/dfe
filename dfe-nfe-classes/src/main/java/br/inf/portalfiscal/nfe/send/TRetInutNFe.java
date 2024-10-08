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
 * Tipo retorno do Pedido de Inutilização de Numeração da Nota Fiscal Eletrônica
 *
 * <p>Classe Java de TRetInutNFe complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TRetInutNFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infInut"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/&gt;
 *                   &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/&gt;
 *                   &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/&gt;
 *                   &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/&gt;
 *                   &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/&gt;
 *                   &lt;element name="ano" type="{http://www.portalfiscal.inf.br/nfe}Tano" minOccurs="0"/&gt;
 *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj" minOccurs="0"/&gt;
 *                   &lt;element name="mod" type="{http://www.portalfiscal.inf.br/nfe}TMod" minOccurs="0"/&gt;
 *                   &lt;element name="serie" type="{http://www.portalfiscal.inf.br/nfe}TSerie" minOccurs="0"/&gt;
 *                   &lt;element name="nNFIni" type="{http://www.portalfiscal.inf.br/nfe}TNF" minOccurs="0"/&gt;
 *                   &lt;element name="nNFFin" type="{http://www.portalfiscal.inf.br/nfe}TNF" minOccurs="0"/&gt;
 *                   &lt;element name="dhRecbto" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/&gt;
 *                   &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerInutNFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetInutNFe", propOrder = {
        "infInut",
        "signature"
})
public class TRetInutNFe
        implements XML {

    @XmlElement(required = true)
    protected InfInut infInut;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

    /**
     * Obtém o valor da propriedade infInut.
     *
     * @return possible object is
     * {@link InfInut }
     */
    public InfInut getInfInut() {
        return infInut;
    }

    /**
     * Define o valor da propriedade infInut.
     *
     * @param value allowed object is
     *              {@link InfInut }
     */
    public void setInfInut(InfInut value) {
        this.infInut = value;
    }

    public boolean isSetInfInut() {
        return (this.infInut != null);
    }

    /**
     * Obtém o valor da propriedade signature.
     *
     * @return possible object is
     * {@link SignatureType }
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Define o valor da propriedade signature.
     *
     * @param value allowed object is
     *              {@link SignatureType }
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

    public boolean isSetSignature() {
        return (this.signature != null);
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
     *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/&gt;
     *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/&gt;
     *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/&gt;
     *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/&gt;
     *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/&gt;
     *         &lt;element name="ano" type="{http://www.portalfiscal.inf.br/nfe}Tano" minOccurs="0"/&gt;
     *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj" minOccurs="0"/&gt;
     *         &lt;element name="mod" type="{http://www.portalfiscal.inf.br/nfe}TMod" minOccurs="0"/&gt;
     *         &lt;element name="serie" type="{http://www.portalfiscal.inf.br/nfe}TSerie" minOccurs="0"/&gt;
     *         &lt;element name="nNFIni" type="{http://www.portalfiscal.inf.br/nfe}TNF" minOccurs="0"/&gt;
     *         &lt;element name="nNFFin" type="{http://www.portalfiscal.inf.br/nfe}TNF" minOccurs="0"/&gt;
     *         &lt;element name="dhRecbto" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/&gt;
     *         &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "tpAmb",
            "verAplic",
            "cStat",
            "xMotivo",
            "cuf",
            "ano",
            "cnpj",
            "mod",
            "serie",
            "nnfIni",
            "nnfFin",
            "dhRecbto",
            "nProt"
    })
    public static class InfInut
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
        protected String ano;
        @XmlElement(name = "CNPJ")
        protected String cnpj;
        protected String mod;
        protected String serie;
        @XmlElement(name = "nNFIni")
        protected String nnfIni;
        @XmlElement(name = "nNFFin")
        protected String nnfFin;
        @XmlElement(required = true)
        protected String dhRecbto;
        protected String nProt;
        @XmlAttribute(name = "Id")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        protected String id;

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
         * Obtém o valor da propriedade ano.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAno() {
            return ano;
        }

        /**
         * Define o valor da propriedade ano.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAno(String value) {
            this.ano = value;
        }

        public boolean isSetAno() {
            return (this.ano != null);
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
         * Obtém o valor da propriedade mod.
         *
         * @return possible object is
         * {@link String }
         */
        public String getMod() {
            return mod;
        }

        /**
         * Define o valor da propriedade mod.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setMod(String value) {
            this.mod = value;
        }

        public boolean isSetMod() {
            return (this.mod != null);
        }

        /**
         * Obtém o valor da propriedade serie.
         *
         * @return possible object is
         * {@link String }
         */
        public String getSerie() {
            return serie;
        }

        /**
         * Define o valor da propriedade serie.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setSerie(String value) {
            this.serie = value;
        }

        public boolean isSetSerie() {
            return (this.serie != null);
        }

        /**
         * Obtém o valor da propriedade nnfIni.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNNFIni() {
            return nnfIni;
        }

        /**
         * Define o valor da propriedade nnfIni.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNNFIni(String value) {
            this.nnfIni = value;
        }

        public boolean isSetNNFIni() {
            return (this.nnfIni != null);
        }

        /**
         * Obtém o valor da propriedade nnfFin.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNNFFin() {
            return nnfFin;
        }

        /**
         * Define o valor da propriedade nnfFin.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNNFFin(String value) {
            this.nnfFin = value;
        }

        public boolean isSetNNFFin() {
            return (this.nnfFin != null);
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
         * Obtém o valor da propriedade nProt.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNProt() {
            return nProt;
        }

        /**
         * Define o valor da propriedade nProt.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNProt(String value) {
            this.nProt = value;
        }

        public boolean isSetNProt() {
            return (this.nProt != null);
        }

        /**
         * Obtém o valor da propriedade id.
         *
         * @return possible object is
         * {@link String }
         */
        public String getId() {
            return id;
        }

        /**
         * Define o valor da propriedade id.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setId(String value) {
            this.id = value;
        }

        public boolean isSetId() {
            return (this.id != null);
        }

    }

}
