//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:09 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Aquav complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Aquav"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="irin"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;maxLength value="10"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tpEmb"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{2}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cEmbar"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xEmbar"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nViag"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[1-9]{1}[0-9]{0,9}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cPrtEmb"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="5"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cPrtDest"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="5"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="prtTrans" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tpNav" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infTermCarreg" maxOccurs="5" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cTermCarreg"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="8"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="xTermCarreg"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="60"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infTermDescarreg" maxOccurs="5" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cTermDescarreg"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="8"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="xTermDescarreg"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="60"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infEmbComb" maxOccurs="30" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cEmbComb"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="10"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="xBalsa"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="60"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infUnidCargaVazia" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="idUnidCargaVazia" type="{http://www.portalfiscal.inf.br/mdfe}TContainer"/&gt;
 *                   &lt;element name="tpUnidCargaVazia"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                         &lt;enumeration value="2"/&gt;
 *                         &lt;enumeration value="3"/&gt;
 *                         &lt;enumeration value="4"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infUnidTranspVazia" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="idUnidTranspVazia" type="{http://www.portalfiscal.inf.br/mdfe}TContainer"/&gt;
 *                   &lt;element name="tpUnidTranspVazia"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
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
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Aquav", propOrder = {
        "irin",
        "tpEmb",
        "cEmbar",
        "xEmbar",
        "nViag",
        "cPrtEmb",
        "cPrtDest",
        "prtTrans",
        "tpNav",
        "infTermCarreg",
        "infTermDescarreg",
        "infEmbComb",
        "infUnidCargaVazia",
        "infUnidTranspVazia"
})
public class Aquav
        implements XML {

    @XmlElement(required = true)
    protected String irin;
    @XmlElement(required = true)
    protected String tpEmb;
    @XmlElement(required = true)
    protected String cEmbar;
    @XmlElement(required = true)
    protected String xEmbar;
    @XmlElement(required = true)
    protected String nViag;
    @XmlElement(required = true)
    protected String cPrtEmb;
    @XmlElement(required = true)
    protected String cPrtDest;
    protected String prtTrans;
    protected String tpNav;
    protected List<InfTermCarreg> infTermCarreg;
    protected List<InfTermDescarreg> infTermDescarreg;
    protected List<InfEmbComb> infEmbComb;
    protected List<InfUnidCargaVazia> infUnidCargaVazia;
    protected List<InfUnidTranspVazia> infUnidTranspVazia;

    /**
     * Gets the value of the irin property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIrin() {
        return irin;
    }

    /**
     * Sets the value of the irin property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIrin(String value) {
        this.irin = value;
    }

    public boolean isSetIrin() {
        return (this.irin != null);
    }

    /**
     * Gets the value of the tpEmb property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpEmb() {
        return tpEmb;
    }

    /**
     * Sets the value of the tpEmb property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpEmb(String value) {
        this.tpEmb = value;
    }

    public boolean isSetTpEmb() {
        return (this.tpEmb != null);
    }

    /**
     * Gets the value of the cEmbar property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCEmbar() {
        return cEmbar;
    }

    /**
     * Sets the value of the cEmbar property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCEmbar(String value) {
        this.cEmbar = value;
    }

    public boolean isSetCEmbar() {
        return (this.cEmbar != null);
    }

    /**
     * Gets the value of the xEmbar property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXEmbar() {
        return xEmbar;
    }

    /**
     * Sets the value of the xEmbar property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXEmbar(String value) {
        this.xEmbar = value;
    }

    public boolean isSetXEmbar() {
        return (this.xEmbar != null);
    }

    /**
     * Gets the value of the nViag property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNViag() {
        return nViag;
    }

    /**
     * Sets the value of the nViag property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNViag(String value) {
        this.nViag = value;
    }

    public boolean isSetNViag() {
        return (this.nViag != null);
    }

    /**
     * Gets the value of the cPrtEmb property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCPrtEmb() {
        return cPrtEmb;
    }

    /**
     * Sets the value of the cPrtEmb property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCPrtEmb(String value) {
        this.cPrtEmb = value;
    }

    public boolean isSetCPrtEmb() {
        return (this.cPrtEmb != null);
    }

    /**
     * Gets the value of the cPrtDest property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCPrtDest() {
        return cPrtDest;
    }

    /**
     * Sets the value of the cPrtDest property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCPrtDest(String value) {
        this.cPrtDest = value;
    }

    public boolean isSetCPrtDest() {
        return (this.cPrtDest != null);
    }

    /**
     * Gets the value of the prtTrans property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrtTrans() {
        return prtTrans;
    }

    /**
     * Sets the value of the prtTrans property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrtTrans(String value) {
        this.prtTrans = value;
    }

    public boolean isSetPrtTrans() {
        return (this.prtTrans != null);
    }

    /**
     * Gets the value of the tpNav property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpNav() {
        return tpNav;
    }

    /**
     * Sets the value of the tpNav property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpNav(String value) {
        this.tpNav = value;
    }

    public boolean isSetTpNav() {
        return (this.tpNav != null);
    }

    /**
     * Gets the value of the infTermCarreg property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the infTermCarreg property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfTermCarreg().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfTermCarreg }
     */
    public List<InfTermCarreg> getInfTermCarreg() {
        if (infTermCarreg == null) {
            infTermCarreg = new ArrayList<>();
        }
        return this.infTermCarreg;
    }

    public boolean isSetInfTermCarreg() {
        return ((this.infTermCarreg != null) && (!this.infTermCarreg.isEmpty()));
    }

    public void unsetInfTermCarreg() {
        this.infTermCarreg = null;
    }

    /**
     * Gets the value of the infTermDescarreg property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the infTermDescarreg property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfTermDescarreg().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfTermDescarreg }
     */
    public List<InfTermDescarreg> getInfTermDescarreg() {
        if (infTermDescarreg == null) {
            infTermDescarreg = new ArrayList<>();
        }
        return this.infTermDescarreg;
    }

    public boolean isSetInfTermDescarreg() {
        return ((this.infTermDescarreg != null) && (!this.infTermDescarreg.isEmpty()));
    }

    public void unsetInfTermDescarreg() {
        this.infTermDescarreg = null;
    }

    /**
     * Gets the value of the infEmbComb property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the infEmbComb property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfEmbComb().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfEmbComb }
     */
    public List<InfEmbComb> getInfEmbComb() {
        if (infEmbComb == null) {
            infEmbComb = new ArrayList<>();
        }
        return this.infEmbComb;
    }

    public boolean isSetInfEmbComb() {
        return ((this.infEmbComb != null) && (!this.infEmbComb.isEmpty()));
    }

    public void unsetInfEmbComb() {
        this.infEmbComb = null;
    }

    /**
     * Gets the value of the infUnidCargaVazia property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the infUnidCargaVazia property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfUnidCargaVazia().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfUnidCargaVazia }
     */
    public List<InfUnidCargaVazia> getInfUnidCargaVazia() {
        if (infUnidCargaVazia == null) {
            infUnidCargaVazia = new ArrayList<>();
        }
        return this.infUnidCargaVazia;
    }

    public boolean isSetInfUnidCargaVazia() {
        return ((this.infUnidCargaVazia != null) && (!this.infUnidCargaVazia.isEmpty()));
    }

    public void unsetInfUnidCargaVazia() {
        this.infUnidCargaVazia = null;
    }

    /**
     * Gets the value of the infUnidTranspVazia property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the infUnidTranspVazia property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfUnidTranspVazia().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfUnidTranspVazia }
     */
    public List<InfUnidTranspVazia> getInfUnidTranspVazia() {
        if (infUnidTranspVazia == null) {
            infUnidTranspVazia = new ArrayList<>();
        }
        return this.infUnidTranspVazia;
    }

    public boolean isSetInfUnidTranspVazia() {
        return ((this.infUnidTranspVazia != null) && (!this.infUnidTranspVazia.isEmpty()));
    }

    public void unsetInfUnidTranspVazia() {
        this.infUnidTranspVazia = null;
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
     *         &lt;element name="cEmbComb"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="10"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="xBalsa"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="60"/&gt;
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
            "cEmbComb",
            "xBalsa"
    })
    public static class InfEmbComb
            implements XML {

        @XmlElement(required = true)
        protected String cEmbComb;
        @XmlElement(required = true)
        protected String xBalsa;

        /**
         * Gets the value of the cEmbComb property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCEmbComb() {
            return cEmbComb;
        }

        /**
         * Sets the value of the cEmbComb property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCEmbComb(String value) {
            this.cEmbComb = value;
        }

        public boolean isSetCEmbComb() {
            return (this.cEmbComb != null);
        }

        /**
         * Gets the value of the xBalsa property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getXBalsa() {
            return xBalsa;
        }

        /**
         * Sets the value of the xBalsa property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setXBalsa(String value) {
            this.xBalsa = value;
        }

        public boolean isSetXBalsa() {
            return (this.xBalsa != null);
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
     *         &lt;element name="cTermCarreg"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="8"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="xTermCarreg"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="60"/&gt;
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
            "cTermCarreg",
            "xTermCarreg"
    })
    public static class InfTermCarreg
            implements XML {

        @XmlElement(required = true)
        protected String cTermCarreg;
        @XmlElement(required = true)
        protected String xTermCarreg;

        /**
         * Gets the value of the cTermCarreg property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCTermCarreg() {
            return cTermCarreg;
        }

        /**
         * Sets the value of the cTermCarreg property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCTermCarreg(String value) {
            this.cTermCarreg = value;
        }

        public boolean isSetCTermCarreg() {
            return (this.cTermCarreg != null);
        }

        /**
         * Gets the value of the xTermCarreg property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getXTermCarreg() {
            return xTermCarreg;
        }

        /**
         * Sets the value of the xTermCarreg property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setXTermCarreg(String value) {
            this.xTermCarreg = value;
        }

        public boolean isSetXTermCarreg() {
            return (this.xTermCarreg != null);
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
     *         &lt;element name="cTermDescarreg"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="8"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="xTermDescarreg"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="60"/&gt;
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
            "cTermDescarreg",
            "xTermDescarreg"
    })
    public static class InfTermDescarreg
            implements XML {

        @XmlElement(required = true)
        protected String cTermDescarreg;
        @XmlElement(required = true)
        protected String xTermDescarreg;

        /**
         * Gets the value of the cTermDescarreg property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCTermDescarreg() {
            return cTermDescarreg;
        }

        /**
         * Sets the value of the cTermDescarreg property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCTermDescarreg(String value) {
            this.cTermDescarreg = value;
        }

        public boolean isSetCTermDescarreg() {
            return (this.cTermDescarreg != null);
        }

        /**
         * Gets the value of the xTermDescarreg property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getXTermDescarreg() {
            return xTermDescarreg;
        }

        /**
         * Sets the value of the xTermDescarreg property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setXTermDescarreg(String value) {
            this.xTermDescarreg = value;
        }

        public boolean isSetXTermDescarreg() {
            return (this.xTermDescarreg != null);
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
     *         &lt;element name="idUnidCargaVazia" type="{http://www.portalfiscal.inf.br/mdfe}TContainer"/&gt;
     *         &lt;element name="tpUnidCargaVazia"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
     *               &lt;enumeration value="3"/&gt;
     *               &lt;enumeration value="4"/&gt;
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
            "idUnidCargaVazia",
            "tpUnidCargaVazia"
    })
    public static class InfUnidCargaVazia
            implements XML {

        @XmlElement(required = true)
        protected String idUnidCargaVazia;
        @XmlElement(required = true)
        protected String tpUnidCargaVazia;

        /**
         * Gets the value of the idUnidCargaVazia property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getIdUnidCargaVazia() {
            return idUnidCargaVazia;
        }

        /**
         * Sets the value of the idUnidCargaVazia property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setIdUnidCargaVazia(String value) {
            this.idUnidCargaVazia = value;
        }

        public boolean isSetIdUnidCargaVazia() {
            return (this.idUnidCargaVazia != null);
        }

        /**
         * Gets the value of the tpUnidCargaVazia property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getTpUnidCargaVazia() {
            return tpUnidCargaVazia;
        }

        /**
         * Sets the value of the tpUnidCargaVazia property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setTpUnidCargaVazia(String value) {
            this.tpUnidCargaVazia = value;
        }

        public boolean isSetTpUnidCargaVazia() {
            return (this.tpUnidCargaVazia != null);
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
     *         &lt;element name="idUnidTranspVazia" type="{http://www.portalfiscal.inf.br/mdfe}TContainer"/&gt;
     *         &lt;element name="tpUnidTranspVazia"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
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
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "idUnidTranspVazia",
            "tpUnidTranspVazia"
    })
    public static class InfUnidTranspVazia
            implements XML {

        @XmlElement(required = true)
        protected String idUnidTranspVazia;
        @XmlElement(required = true)
        protected String tpUnidTranspVazia;

        /**
         * Gets the value of the idUnidTranspVazia property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getIdUnidTranspVazia() {
            return idUnidTranspVazia;
        }

        /**
         * Sets the value of the idUnidTranspVazia property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setIdUnidTranspVazia(String value) {
            this.idUnidTranspVazia = value;
        }

        public boolean isSetIdUnidTranspVazia() {
            return (this.idUnidTranspVazia != null);
        }

        /**
         * Gets the value of the tpUnidTranspVazia property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getTpUnidTranspVazia() {
            return tpUnidTranspVazia;
        }

        /**
         * Sets the value of the tpUnidTranspVazia property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setTpUnidTranspVazia(String value) {
            this.tpUnidTranspVazia = value;
        }

        public boolean isSetTpUnidTranspVazia() {
            return (this.tpUnidTranspVazia != null);
        }

    }

}
