//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:09 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;


/**
 * Tipo Retorno de Pedido de Consulta da Situação Atual do MDF-e
 *
 * <p>Java class for TRetConsSitMDFe complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TRetConsSitMDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/mdfe}TAmb"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/mdfe}TVerAplic"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/mdfe}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/mdfe}TMotivo"/&gt;
 *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/mdfe}TCodUfIBGE"/&gt;
 *         &lt;element name="protMDFe" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any processContents='skip'/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="versao" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;whiteSpace value="preserve"/&gt;
 *                       &lt;enumeration value="1.00"/&gt;
 *                       &lt;enumeration value="3.00"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="procEventoMDFe" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any processContents='skip'/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="versao" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;whiteSpace value="preserve"/&gt;
 *                       &lt;enumeration value="1.00"/&gt;
 *                       &lt;enumeration value="3.00"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerConsSitMDFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsSitMDFe", propOrder = {
        "tpAmb",
        "verAplic",
        "cStat",
        "xMotivo",
        "cuf",
        "protMDFe",
        "procEventoMDFe"
})
public class TRetConsSitMDFe
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
    protected ProtMDFe protMDFe;
    protected List<ProcEventoMDFe> procEventoMDFe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Gets the value of the tpAmb property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * Sets the value of the tpAmb property.
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
     * Gets the value of the verAplic property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * Sets the value of the verAplic property.
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
     * Gets the value of the cStat property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCStat() {
        return cStat;
    }

    /**
     * Sets the value of the cStat property.
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
     * Gets the value of the xMotivo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXMotivo() {
        return xMotivo;
    }

    /**
     * Sets the value of the xMotivo property.
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
     * Gets the value of the cuf property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCUF() {
        return cuf;
    }

    /**
     * Sets the value of the cuf property.
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
     * Gets the value of the protMDFe property.
     *
     * @return possible object is
     * {@link ProtMDFe }
     */
    public ProtMDFe getProtMDFe() {
        return protMDFe;
    }

    /**
     * Sets the value of the protMDFe property.
     *
     * @param value allowed object is
     *              {@link ProtMDFe }
     */
    public void setProtMDFe(ProtMDFe value) {
        this.protMDFe = value;
    }

    public boolean isSetProtMDFe() {
        return (this.protMDFe != null);
    }

    /**
     * Gets the value of the procEventoMDFe property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the procEventoMDFe property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcEventoMDFe().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcEventoMDFe }
     */
    public List<ProcEventoMDFe> getProcEventoMDFe() {
        if (procEventoMDFe == null) {
            procEventoMDFe = new ArrayList<>();
        }
        return this.procEventoMDFe;
    }

    public boolean isSetProcEventoMDFe() {
        return ((this.procEventoMDFe != null) && (!this.procEventoMDFe.isEmpty()));
    }

    public void unsetProcEventoMDFe() {
        this.procEventoMDFe = null;
    }

    /**
     * Gets the value of the versao property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Sets the value of the versao property.
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
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;any processContents='skip'/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="versao" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;whiteSpace value="preserve"/&gt;
     *             &lt;enumeration value="1.00"/&gt;
     *             &lt;enumeration value="3.00"/&gt;
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
            "any"
    })
    public static class ProcEventoMDFe
            implements XML {

        @XmlAnyElement
        protected Element any;
        @XmlAttribute(name = "versao", required = true)
        protected String versao;

        /**
         * Gets the value of the any property.
         *
         * @return possible object is
         * {@link Element }
         */
        public Element getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         *
         * @param value allowed object is
         *              {@link Element }
         */
        public void setAny(Element value) {
            this.any = value;
        }

        public boolean isSetAny() {
            return (this.any != null);
        }

        /**
         * Gets the value of the versao property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVersao() {
            return versao;
        }

        /**
         * Sets the value of the versao property.
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
     *         &lt;any processContents='skip'/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="versao" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;whiteSpace value="preserve"/&gt;
     *             &lt;enumeration value="1.00"/&gt;
     *             &lt;enumeration value="3.00"/&gt;
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
            "any"
    })
    public static class ProtMDFe
            implements XML {

        @XmlAnyElement
        protected Element any;
        @XmlAttribute(name = "versao", required = true)
        protected String versao;

        /**
         * Gets the value of the any property.
         *
         * @return possible object is
         * {@link Element }
         */
        public Element getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         *
         * @param value allowed object is
         *              {@link Element }
         */
        public void setAny(Element value) {
            this.any = value;
        }

        public boolean isSetAny() {
            return (this.any != null);
        }

        /**
         * Gets the value of the versao property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVersao() {
            return versao;
        }

        /**
         * Sets the value of the versao property.
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

    }

}
