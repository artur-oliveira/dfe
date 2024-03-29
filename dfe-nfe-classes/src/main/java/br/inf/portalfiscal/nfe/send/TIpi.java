//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.nfe.send;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Tipo: Dados do IPI
 *
 * <p>Java class for TIpi complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TIpi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CNPJProd" type="{http://www.portalfiscal.inf.br/nfe}TCnpj" minOccurs="0"/&gt;
 *         &lt;element name="cSelo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="qSelo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{1,12}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cEnq"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;choice&gt;
 *           &lt;element name="IPITrib"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="CST"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;whiteSpace value="preserve"/&gt;
 *                           &lt;enumeration value="00"/&gt;
 *                           &lt;enumeration value="49"/&gt;
 *                           &lt;enumeration value="50"/&gt;
 *                           &lt;enumeration value="99"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;choice&gt;
 *                       &lt;sequence&gt;
 *                         &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/&gt;
 *                         &lt;element name="pIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_0302a04"/&gt;
 *                       &lt;/sequence&gt;
 *                       &lt;sequence&gt;
 *                         &lt;element name="qUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1204v"/&gt;
 *                         &lt;element name="vUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1104"/&gt;
 *                       &lt;/sequence&gt;
 *                     &lt;/choice&gt;
 *                     &lt;element name="vIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="IPINT"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="CST"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;whiteSpace value="preserve"/&gt;
 *                           &lt;enumeration value="01"/&gt;
 *                           &lt;enumeration value="02"/&gt;
 *                           &lt;enumeration value="03"/&gt;
 *                           &lt;enumeration value="04"/&gt;
 *                           &lt;enumeration value="05"/&gt;
 *                           &lt;enumeration value="51"/&gt;
 *                           &lt;enumeration value="52"/&gt;
 *                           &lt;enumeration value="53"/&gt;
 *                           &lt;enumeration value="54"/&gt;
 *                           &lt;enumeration value="55"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIpi", propOrder = {
        "cnpjProd",
        "cSelo",
        "qSelo",
        "cEnq",
        "ipiTrib",
        "ipint"
})
public class TIpi implements XML {

    @XmlElement(name = "CNPJProd")
    protected String cnpjProd;
    protected String cSelo;
    protected String qSelo;
    @XmlElement(required = true)
    protected String cEnq;
    @XmlElement(name = "IPITrib")
    protected IPITrib ipiTrib;
    @XmlElement(name = "IPINT")
    protected IPINT ipint;

    /**
     * Gets the value of the cnpjProd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCNPJProd() {
        return cnpjProd;
    }

    /**
     * Sets the value of the cnpjProd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCNPJProd(String value) {
        this.cnpjProd = value;
    }

    public boolean isSetCNPJProd() {
        return (this.cnpjProd != null);
    }

    /**
     * Gets the value of the cSelo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCSelo() {
        return cSelo;
    }

    /**
     * Sets the value of the cSelo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCSelo(String value) {
        this.cSelo = value;
    }

    public boolean isSetCSelo() {
        return (this.cSelo != null);
    }

    /**
     * Gets the value of the qSelo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getQSelo() {
        return qSelo;
    }

    /**
     * Sets the value of the qSelo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setQSelo(String value) {
        this.qSelo = value;
    }

    public boolean isSetQSelo() {
        return (this.qSelo != null);
    }

    /**
     * Gets the value of the cEnq property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCEnq() {
        return cEnq;
    }

    /**
     * Sets the value of the cEnq property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCEnq(String value) {
        this.cEnq = value;
    }

    public boolean isSetCEnq() {
        return (this.cEnq != null);
    }

    /**
     * Gets the value of the ipiTrib property.
     *
     * @return possible object is
     * {@link IPITrib }
     */
    public IPITrib getIPITrib() {
        return ipiTrib;
    }

    /**
     * Sets the value of the ipiTrib property.
     *
     * @param value allowed object is
     *              {@link IPITrib }
     */
    public void setIPITrib(IPITrib value) {
        this.ipiTrib = value;
    }

    public boolean isSetIPITrib() {
        return (this.ipiTrib != null);
    }

    /**
     * Gets the value of the ipint property.
     *
     * @return possible object is
     * {@link IPINT }
     */
    public IPINT getIPINT() {
        return ipint;
    }

    /**
     * Sets the value of the ipint property.
     *
     * @param value allowed object is
     *              {@link IPINT }
     */
    public void setIPINT(IPINT value) {
        this.ipint = value;
    }

    public boolean isSetIPINT() {
        return (this.ipint != null);
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
     *               &lt;enumeration value="01"/&gt;
     *               &lt;enumeration value="02"/&gt;
     *               &lt;enumeration value="03"/&gt;
     *               &lt;enumeration value="04"/&gt;
     *               &lt;enumeration value="05"/&gt;
     *               &lt;enumeration value="51"/&gt;
     *               &lt;enumeration value="52"/&gt;
     *               &lt;enumeration value="53"/&gt;
     *               &lt;enumeration value="54"/&gt;
     *               &lt;enumeration value="55"/&gt;
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
    public static class IPINT
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
     *               &lt;enumeration value="00"/&gt;
     *               &lt;enumeration value="49"/&gt;
     *               &lt;enumeration value="50"/&gt;
     *               &lt;enumeration value="99"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;choice&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/&gt;
     *             &lt;element name="pIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_0302a04"/&gt;
     *           &lt;/sequence&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="qUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1204v"/&gt;
     *             &lt;element name="vUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1104"/&gt;
     *           &lt;/sequence&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="vIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/&gt;
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
            "pipi",
            "qUnid",
            "vUnid",
            "vipi"
    })
    public static class IPITrib
            implements XML {

        @XmlElement(name = "CST", required = true)
        protected String cst;
        @XmlElement(name = "vBC")
        protected String vbc;
        @XmlElement(name = "pIPI")
        protected String pipi;
        protected String qUnid;
        protected String vUnid;
        @XmlElement(name = "vIPI", required = true)
        protected String vipi;

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
         * Gets the value of the pipi property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPIPI() {
            return pipi;
        }

        /**
         * Sets the value of the pipi property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPIPI(String value) {
            this.pipi = value;
        }

        public boolean isSetPIPI() {
            return (this.pipi != null);
        }

        /**
         * Gets the value of the qUnid property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getQUnid() {
            return qUnid;
        }

        /**
         * Sets the value of the qUnid property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setQUnid(String value) {
            this.qUnid = value;
        }

        public boolean isSetQUnid() {
            return (this.qUnid != null);
        }

        /**
         * Gets the value of the vUnid property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVUnid() {
            return vUnid;
        }

        /**
         * Sets the value of the vUnid property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVUnid(String value) {
            this.vUnid = value;
        }

        public boolean isSetVUnid() {
            return (this.vUnid != null);
        }

        /**
         * Gets the value of the vipi property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVIPI() {
            return vipi;
        }

        /**
         * Sets the value of the vipi property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVIPI(String value) {
            this.vipi = value;
        }

        public boolean isSetVIPI() {
            return (this.vipi != null);
        }

    }

}
