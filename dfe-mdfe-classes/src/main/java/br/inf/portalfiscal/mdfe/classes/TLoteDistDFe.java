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
 * Schema XML de validação da área de dados descompactada
 *
 * <p>Java class for TLoteDistDFe complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TLoteDistDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="50"&gt;
 *         &lt;element name="proc"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any processContents='skip'/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TNSU" /&gt;
 *                 &lt;attribute name="ipTransmissor" type="{http://www.portalfiscal.inf.br/mdfe}TIPv4" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerDFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TLoteDistDFe", propOrder = {
        "proc"
})
public class TLoteDistDFe
        implements XML {

    @XmlElement(required = true)
    protected List<Proc> proc;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Gets the value of the proc property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the proc property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProc().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Proc }
     */
    public List<Proc> getProc() {
        if (proc == null) {
            proc = new ArrayList<>();
        }
        return this.proc;
    }

    public boolean isSetProc() {
        return ((this.proc != null) && (!this.proc.isEmpty()));
    }

    public void unsetProc() {
        this.proc = null;
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
     *       &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TNSU" /&gt;
     *       &lt;attribute name="ipTransmissor" type="{http://www.portalfiscal.inf.br/mdfe}TIPv4" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "any"
    })
    public static class Proc
            implements XML {

        @XmlAnyElement
        protected Element any;
        @XmlAttribute(name = "schema", required = true)
        protected String schema;
        @XmlAttribute(name = "NSU", required = true)
        protected String nsu;
        @XmlAttribute(name = "ipTransmissor")
        protected String ipTransmissor;

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
         * Gets the value of the schema property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getSchema() {
            return schema;
        }

        /**
         * Sets the value of the schema property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setSchema(String value) {
            this.schema = value;
        }

        public boolean isSetSchema() {
            return (this.schema != null);
        }

        /**
         * Gets the value of the nsu property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNSU() {
            return nsu;
        }

        /**
         * Sets the value of the nsu property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNSU(String value) {
            this.nsu = value;
        }

        public boolean isSetNSU() {
            return (this.nsu != null);
        }

        /**
         * Gets the value of the ipTransmissor property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getIpTransmissor() {
            return ipTransmissor;
        }

        /**
         * Sets the value of the ipTransmissor property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setIpTransmissor(String value) {
            this.ipTransmissor = value;
        }

        public boolean isSetIpTransmissor() {
            return (this.ipTransmissor != null);
        }

    }

}
