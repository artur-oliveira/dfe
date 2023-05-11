//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send400;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Ferrov complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Ferrov"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpTraf"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="trafMut" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="respFat"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                         &lt;enumeration value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ferrEmi"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                         &lt;enumeration value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="vFrete" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                   &lt;element name="chCTeFerroOrigem" type="{http://www.portalfiscal.inf.br/cte}TChDFe" minOccurs="0"/&gt;
 *                   &lt;element name="ferroEnv" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
 *                             &lt;element name="cInt" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="10"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe" minOccurs="0"/&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="enderFerro" type="{http://www.portalfiscal.inf.br/cte}TEnderFer"/&gt;
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
 *         &lt;element name="fluxo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="10"/&gt;
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
@XmlType(name = "Ferrov", propOrder = {
        "tpTraf",
        "trafMut",
        "fluxo"
})
public class Ferrov
        implements XML {

    @XmlElement(required = true)
    protected String tpTraf;
    protected TrafMut trafMut;
    @XmlElement(required = true)
    protected String fluxo;

    /**
     * Gets the value of the tpTraf property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpTraf() {
        return tpTraf;
    }

    /**
     * Sets the value of the tpTraf property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpTraf(String value) {
        this.tpTraf = value;
    }

    public boolean isSetTpTraf() {
        return (this.tpTraf != null);
    }

    /**
     * Gets the value of the trafMut property.
     *
     * @return possible object is
     * {@link TrafMut }
     */
    public TrafMut getTrafMut() {
        return trafMut;
    }

    /**
     * Sets the value of the trafMut property.
     *
     * @param value allowed object is
     *              {@link TrafMut }
     */
    public void setTrafMut(TrafMut value) {
        this.trafMut = value;
    }

    public boolean isSetTrafMut() {
        return (this.trafMut != null);
    }

    /**
     * Gets the value of the fluxo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFluxo() {
        return fluxo;
    }

    /**
     * Sets the value of the fluxo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFluxo(String value) {
        this.fluxo = value;
    }

    public boolean isSetFluxo() {
        return (this.fluxo != null);
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="respFat"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ferrEmi"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="vFrete" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *         &lt;element name="chCTeFerroOrigem" type="{http://www.portalfiscal.inf.br/cte}TChDFe" minOccurs="0"/&gt;
     *         &lt;element name="ferroEnv" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
     *                   &lt;element name="cInt" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="10"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe" minOccurs="0"/&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="enderFerro" type="{http://www.portalfiscal.inf.br/cte}TEnderFer"/&gt;
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
            "respFat",
            "ferrEmi",
            "vFrete",
            "chCTeFerroOrigem",
            "ferroEnv"
    })
    public static class TrafMut
            implements XML {

        @XmlElement(required = true)
        protected String respFat;
        @XmlElement(required = true)
        protected String ferrEmi;
        @XmlElement(required = true)
        protected String vFrete;
        protected String chCTeFerroOrigem;
        protected List<FerroEnv> ferroEnv;

        /**
         * Gets the value of the respFat property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getRespFat() {
            return respFat;
        }

        /**
         * Sets the value of the respFat property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setRespFat(String value) {
            this.respFat = value;
        }

        public boolean isSetRespFat() {
            return (this.respFat != null);
        }

        /**
         * Gets the value of the ferrEmi property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getFerrEmi() {
            return ferrEmi;
        }

        /**
         * Sets the value of the ferrEmi property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setFerrEmi(String value) {
            this.ferrEmi = value;
        }

        public boolean isSetFerrEmi() {
            return (this.ferrEmi != null);
        }

        /**
         * Gets the value of the vFrete property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVFrete() {
            return vFrete;
        }

        /**
         * Sets the value of the vFrete property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVFrete(String value) {
            this.vFrete = value;
        }

        public boolean isSetVFrete() {
            return (this.vFrete != null);
        }

        /**
         * Gets the value of the chCTeFerroOrigem property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getChCTeFerroOrigem() {
            return chCTeFerroOrigem;
        }

        /**
         * Sets the value of the chCTeFerroOrigem property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setChCTeFerroOrigem(String value) {
            this.chCTeFerroOrigem = value;
        }

        public boolean isSetChCTeFerroOrigem() {
            return (this.chCTeFerroOrigem != null);
        }

        /**
         * Gets the value of the ferroEnv property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the ferroEnv property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFerroEnv().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FerroEnv }
         */
        public List<FerroEnv> getFerroEnv() {
            if (ferroEnv == null) {
                ferroEnv = new ArrayList<>();
            }
            return this.ferroEnv;
        }

        public boolean isSetFerroEnv() {
            return ((this.ferroEnv != null) && (!this.ferroEnv.isEmpty()));
        }

        public void unsetFerroEnv() {
            this.ferroEnv = null;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
         *         &lt;element name="cInt" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="10"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe" minOccurs="0"/&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="enderFerro" type="{http://www.portalfiscal.inf.br/cte}TEnderFer"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "cnpj",
                "cInt",
                "ie",
                "xNome",
                "enderFerro"
        })
        public static class FerroEnv
                implements XML {

            @XmlElement(name = "CNPJ", required = true)
            protected String cnpj;
            protected String cInt;
            @XmlElement(name = "IE")
            protected String ie;
            @XmlElement(required = true)
            protected String xNome;
            @XmlElement(required = true)
            protected TEnderFer enderFerro;

            /**
             * Gets the value of the cnpj property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getCNPJ() {
                return cnpj;
            }

            /**
             * Sets the value of the cnpj property.
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
             * Gets the value of the cInt property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getCInt() {
                return cInt;
            }

            /**
             * Sets the value of the cInt property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setCInt(String value) {
                this.cInt = value;
            }

            public boolean isSetCInt() {
                return (this.cInt != null);
            }

            /**
             * Gets the value of the ie property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getIE() {
                return ie;
            }

            /**
             * Sets the value of the ie property.
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
             * Gets the value of the xNome property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getXNome() {
                return xNome;
            }

            /**
             * Sets the value of the xNome property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setXNome(String value) {
                this.xNome = value;
            }

            public boolean isSetXNome() {
                return (this.xNome != null);
            }

            /**
             * Gets the value of the enderFerro property.
             *
             * @return possible object is
             * {@link TEnderFer }
             */
            public TEnderFer getEnderFerro() {
                return enderFerro;
            }

            /**
             * Sets the value of the enderFerro property.
             *
             * @param value allowed object is
             *              {@link TEnderFer }
             */
            public void setEnderFerro(TEnderFer value) {
                this.enderFerro = value;
            }

            public boolean isSetEnderFerro() {
                return (this.enderFerro != null);
            }

        }

    }

}
