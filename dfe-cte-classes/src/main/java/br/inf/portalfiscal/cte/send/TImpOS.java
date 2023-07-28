//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Tipo Dados do Imposto para CT-e OS
 *
 * <p>Java class for TImpOS complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TImpOS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="ICMS00"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CST"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="00"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                   &lt;element name="pICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
 *                   &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ICMS20"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CST"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="20"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="pRedBC" type="{http://www.portalfiscal.inf.br/cte}TDec_0302Opc"/&gt;
 *                   &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                   &lt;element name="pICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
 *                   &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ICMS45"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CST"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="40"/&gt;
 *                         &lt;enumeration value="41"/&gt;
 *                         &lt;enumeration value="51"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ICMS90"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CST"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="90"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="pRedBC" type="{http://www.portalfiscal.inf.br/cte}TDec_0302Opc" minOccurs="0"/&gt;
 *                   &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                   &lt;element name="pICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
 *                   &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                   &lt;element name="vCred" type="{http://www.portalfiscal.inf.br/cte}TDec_1302" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ICMSOutraUF"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CST"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="90"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="pRedBCOutraUF" type="{http://www.portalfiscal.inf.br/cte}TDec_0302Opc" minOccurs="0"/&gt;
 *                   &lt;element name="vBCOutraUF" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                   &lt;element name="pICMSOutraUF" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
 *                   &lt;element name="vICMSOutraUF" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ICMSSN"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CST"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="90"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="indSN"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TImpOS", propOrder = {
        "icms00",
        "icms20",
        "icms45",
        "icms90",
        "icmsOutraUF",
        "icmssn"
})
public class TImpOS
        implements XML {

    @XmlElement(name = "ICMS00")
    protected ICMS00 icms00;
    @XmlElement(name = "ICMS20")
    protected ICMS20 icms20;
    @XmlElement(name = "ICMS45")
    protected ICMS45 icms45;
    @XmlElement(name = "ICMS90")
    protected ICMS90 icms90;
    @XmlElement(name = "ICMSOutraUF")
    protected ICMSOutraUF icmsOutraUF;
    @XmlElement(name = "ICMSSN")
    protected ICMSSN icmssn;

    /**
     * Gets the value of the icms00 property.
     *
     * @return possible object is
     * {@link ICMS00 }
     */
    public ICMS00 getICMS00() {
        return icms00;
    }

    /**
     * Sets the value of the icms00 property.
     *
     * @param value allowed object is
     *              {@link ICMS00 }
     */
    public void setICMS00(ICMS00 value) {
        this.icms00 = value;
    }

    public boolean isSetICMS00() {
        return (this.icms00 != null);
    }

    /**
     * Gets the value of the icms20 property.
     *
     * @return possible object is
     * {@link ICMS20 }
     */
    public ICMS20 getICMS20() {
        return icms20;
    }

    /**
     * Sets the value of the icms20 property.
     *
     * @param value allowed object is
     *              {@link ICMS20 }
     */
    public void setICMS20(ICMS20 value) {
        this.icms20 = value;
    }

    public boolean isSetICMS20() {
        return (this.icms20 != null);
    }

    /**
     * Gets the value of the icms45 property.
     *
     * @return possible object is
     * {@link ICMS45 }
     */
    public ICMS45 getICMS45() {
        return icms45;
    }

    /**
     * Sets the value of the icms45 property.
     *
     * @param value allowed object is
     *              {@link ICMS45 }
     */
    public void setICMS45(ICMS45 value) {
        this.icms45 = value;
    }

    public boolean isSetICMS45() {
        return (this.icms45 != null);
    }

    /**
     * Gets the value of the icms90 property.
     *
     * @return possible object is
     * {@link ICMS90 }
     */
    public ICMS90 getICMS90() {
        return icms90;
    }

    /**
     * Sets the value of the icms90 property.
     *
     * @param value allowed object is
     *              {@link ICMS90 }
     */
    public void setICMS90(ICMS90 value) {
        this.icms90 = value;
    }

    public boolean isSetICMS90() {
        return (this.icms90 != null);
    }

    /**
     * Gets the value of the icmsOutraUF property.
     *
     * @return possible object is
     * {@link ICMSOutraUF }
     */
    public ICMSOutraUF getICMSOutraUF() {
        return icmsOutraUF;
    }

    /**
     * Sets the value of the icmsOutraUF property.
     *
     * @param value allowed object is
     *              {@link ICMSOutraUF }
     */
    public void setICMSOutraUF(ICMSOutraUF value) {
        this.icmsOutraUF = value;
    }

    public boolean isSetICMSOutraUF() {
        return (this.icmsOutraUF != null);
    }

    /**
     * Gets the value of the icmssn property.
     *
     * @return possible object is
     * {@link ICMSSN }
     */
    public ICMSSN getICMSSN() {
        return icmssn;
    }

    /**
     * Sets the value of the icmssn property.
     *
     * @param value allowed object is
     *              {@link ICMSSN }
     */
    public void setICMSSN(ICMSSN value) {
        this.icmssn = value;
    }

    public boolean isSetICMSSN() {
        return (this.icmssn != null);
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
     *         &lt;element name="CST"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="00"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *         &lt;element name="pICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
     *         &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "cst",
            "vbc",
            "picms",
            "vicms"
    })
    public static class ICMS00
            implements XML {

        @XmlElement(name = "CST", required = true)
        protected String cst;
        @XmlElement(name = "vBC", required = true)
        protected String vbc;
        @XmlElement(name = "pICMS", required = true)
        protected String picms;
        @XmlElement(name = "vICMS", required = true)
        protected String vicms;

        /**
         * Gets the value of the cst property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCST() {
            return cst;
        }

        /**
         * Sets the value of the cst property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCST(String value) {
            this.cst = value;
        }

        public boolean isSetCST() {
            return (this.cst != null);
        }

        /**
         * Gets the value of the vbc property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVBC() {
            return vbc;
        }

        /**
         * Sets the value of the vbc property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVBC(String value) {
            this.vbc = value;
        }

        public boolean isSetVBC() {
            return (this.vbc != null);
        }

        /**
         * Gets the value of the picms property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPICMS() {
            return picms;
        }

        /**
         * Sets the value of the picms property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPICMS(String value) {
            this.picms = value;
        }

        public boolean isSetPICMS() {
            return (this.picms != null);
        }

        /**
         * Gets the value of the vicms property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVICMS() {
            return vicms;
        }

        /**
         * Sets the value of the vicms property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVICMS(String value) {
            this.vicms = value;
        }

        public boolean isSetVICMS() {
            return (this.vicms != null);
        }

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
     *         &lt;element name="CST"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="20"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="pRedBC" type="{http://www.portalfiscal.inf.br/cte}TDec_0302Opc"/&gt;
     *         &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *         &lt;element name="pICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
     *         &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "cst",
            "pRedBC",
            "vbc",
            "picms",
            "vicms"
    })
    public static class ICMS20
            implements XML {

        @XmlElement(name = "CST", required = true)
        protected String cst;
        @XmlElement(required = true)
        protected String pRedBC;
        @XmlElement(name = "vBC", required = true)
        protected String vbc;
        @XmlElement(name = "pICMS", required = true)
        protected String picms;
        @XmlElement(name = "vICMS", required = true)
        protected String vicms;

        /**
         * Gets the value of the cst property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCST() {
            return cst;
        }

        /**
         * Sets the value of the cst property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCST(String value) {
            this.cst = value;
        }

        public boolean isSetCST() {
            return (this.cst != null);
        }

        /**
         * Gets the value of the pRedBC property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPRedBC() {
            return pRedBC;
        }

        /**
         * Sets the value of the pRedBC property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPRedBC(String value) {
            this.pRedBC = value;
        }

        public boolean isSetPRedBC() {
            return (this.pRedBC != null);
        }

        /**
         * Gets the value of the vbc property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVBC() {
            return vbc;
        }

        /**
         * Sets the value of the vbc property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVBC(String value) {
            this.vbc = value;
        }

        public boolean isSetVBC() {
            return (this.vbc != null);
        }

        /**
         * Gets the value of the picms property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPICMS() {
            return picms;
        }

        /**
         * Sets the value of the picms property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPICMS(String value) {
            this.picms = value;
        }

        public boolean isSetPICMS() {
            return (this.picms != null);
        }

        /**
         * Gets the value of the vicms property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVICMS() {
            return vicms;
        }

        /**
         * Sets the value of the vicms property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVICMS(String value) {
            this.vicms = value;
        }

        public boolean isSetVICMS() {
            return (this.vicms != null);
        }

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
     *         &lt;element name="CST"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="40"/&gt;
     *               &lt;enumeration value="41"/&gt;
     *               &lt;enumeration value="51"/&gt;
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
            "cst"
    })
    public static class ICMS45
            implements XML {

        @XmlElement(name = "CST", required = true)
        protected String cst;

        /**
         * Gets the value of the cst property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCST() {
            return cst;
        }

        /**
         * Sets the value of the cst property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCST(String value) {
            this.cst = value;
        }

        public boolean isSetCST() {
            return (this.cst != null);
        }

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
     *         &lt;element name="CST"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="90"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="pRedBC" type="{http://www.portalfiscal.inf.br/cte}TDec_0302Opc" minOccurs="0"/&gt;
     *         &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *         &lt;element name="pICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
     *         &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *         &lt;element name="vCred" type="{http://www.portalfiscal.inf.br/cte}TDec_1302" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "cst",
            "pRedBC",
            "vbc",
            "picms",
            "vicms",
            "vCred"
    })
    public static class ICMS90
            implements XML {

        @XmlElement(name = "CST", required = true)
        protected String cst;
        protected String pRedBC;
        @XmlElement(name = "vBC", required = true)
        protected String vbc;
        @XmlElement(name = "pICMS", required = true)
        protected String picms;
        @XmlElement(name = "vICMS", required = true)
        protected String vicms;
        protected String vCred;

        /**
         * Gets the value of the cst property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCST() {
            return cst;
        }

        /**
         * Sets the value of the cst property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCST(String value) {
            this.cst = value;
        }

        public boolean isSetCST() {
            return (this.cst != null);
        }

        /**
         * Gets the value of the pRedBC property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPRedBC() {
            return pRedBC;
        }

        /**
         * Sets the value of the pRedBC property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPRedBC(String value) {
            this.pRedBC = value;
        }

        public boolean isSetPRedBC() {
            return (this.pRedBC != null);
        }

        /**
         * Gets the value of the vbc property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVBC() {
            return vbc;
        }

        /**
         * Sets the value of the vbc property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVBC(String value) {
            this.vbc = value;
        }

        public boolean isSetVBC() {
            return (this.vbc != null);
        }

        /**
         * Gets the value of the picms property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPICMS() {
            return picms;
        }

        /**
         * Sets the value of the picms property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPICMS(String value) {
            this.picms = value;
        }

        public boolean isSetPICMS() {
            return (this.picms != null);
        }

        /**
         * Gets the value of the vicms property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVICMS() {
            return vicms;
        }

        /**
         * Sets the value of the vicms property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVICMS(String value) {
            this.vicms = value;
        }

        public boolean isSetVICMS() {
            return (this.vicms != null);
        }

        /**
         * Gets the value of the vCred property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVCred() {
            return vCred;
        }

        /**
         * Sets the value of the vCred property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVCred(String value) {
            this.vCred = value;
        }

        public boolean isSetVCred() {
            return (this.vCred != null);
        }

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
     *         &lt;element name="CST"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="90"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="pRedBCOutraUF" type="{http://www.portalfiscal.inf.br/cte}TDec_0302Opc" minOccurs="0"/&gt;
     *         &lt;element name="vBCOutraUF" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *         &lt;element name="pICMSOutraUF" type="{http://www.portalfiscal.inf.br/cte}TDec_0302"/&gt;
     *         &lt;element name="vICMSOutraUF" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "cst",
            "pRedBCOutraUF",
            "vbcOutraUF",
            "picmsOutraUF",
            "vicmsOutraUF"
    })
    public static class ICMSOutraUF
            implements XML {

        @XmlElement(name = "CST", required = true)
        protected String cst;
        protected String pRedBCOutraUF;
        @XmlElement(name = "vBCOutraUF", required = true)
        protected String vbcOutraUF;
        @XmlElement(name = "pICMSOutraUF", required = true)
        protected String picmsOutraUF;
        @XmlElement(name = "vICMSOutraUF", required = true)
        protected String vicmsOutraUF;

        /**
         * Gets the value of the cst property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCST() {
            return cst;
        }

        /**
         * Sets the value of the cst property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCST(String value) {
            this.cst = value;
        }

        public boolean isSetCST() {
            return (this.cst != null);
        }

        /**
         * Gets the value of the pRedBCOutraUF property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPRedBCOutraUF() {
            return pRedBCOutraUF;
        }

        /**
         * Sets the value of the pRedBCOutraUF property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPRedBCOutraUF(String value) {
            this.pRedBCOutraUF = value;
        }

        public boolean isSetPRedBCOutraUF() {
            return (this.pRedBCOutraUF != null);
        }

        /**
         * Gets the value of the vbcOutraUF property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVBCOutraUF() {
            return vbcOutraUF;
        }

        /**
         * Sets the value of the vbcOutraUF property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVBCOutraUF(String value) {
            this.vbcOutraUF = value;
        }

        public boolean isSetVBCOutraUF() {
            return (this.vbcOutraUF != null);
        }

        /**
         * Gets the value of the picmsOutraUF property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPICMSOutraUF() {
            return picmsOutraUF;
        }

        /**
         * Sets the value of the picmsOutraUF property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPICMSOutraUF(String value) {
            this.picmsOutraUF = value;
        }

        public boolean isSetPICMSOutraUF() {
            return (this.picmsOutraUF != null);
        }

        /**
         * Gets the value of the vicmsOutraUF property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVICMSOutraUF() {
            return vicmsOutraUF;
        }

        /**
         * Sets the value of the vicmsOutraUF property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVICMSOutraUF(String value) {
            this.vicmsOutraUF = value;
        }

        public boolean isSetVICMSOutraUF() {
            return (this.vicmsOutraUF != null);
        }

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
     *         &lt;element name="CST"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="90"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="indSN"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="1"/&gt;
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
            "cst",
            "indSN"
    })
    public static class ICMSSN
            implements XML {

        @XmlElement(name = "CST", required = true)
        protected String cst;
        @XmlElement(required = true)
        protected String indSN;

        /**
         * Gets the value of the cst property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCST() {
            return cst;
        }

        /**
         * Sets the value of the cst property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCST(String value) {
            this.cst = value;
        }

        public boolean isSetCST() {
            return (this.cst != null);
        }

        /**
         * Gets the value of the indSN property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getIndSN() {
            return indSN;
        }

        /**
         * Sets the value of the indSN property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setIndSN(String value) {
            this.indSN = value;
        }

        public boolean isSetIndSN() {
            return (this.indSN != null);
        }

    }

}
