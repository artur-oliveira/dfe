//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send400;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * Tipo Dados Unidade de Transporte
 *
 * <p>Java class for TUnidadeTransp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TUnidadeTransp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TtipoUnidTransp"/&gt;
 *         &lt;element name="idUnidTransp" type="{http://www.portalfiscal.inf.br/cte}TContainer"/&gt;
 *         &lt;element name="lacUnidTransp" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="nLacre"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="20"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infUnidCarga" type="{http://www.portalfiscal.inf.br/cte}TUnidCarga" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="qtdRat" type="{http://www.portalfiscal.inf.br/cte}TDec_0302_0303" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TUnidadeTransp", propOrder = {
        "tpUnidTransp",
        "idUnidTransp",
        "lacUnidTransp",
        "infUnidCarga",
        "qtdRat"
})
public class TUnidadeTransp
        implements XML {

    @XmlElement(required = true)
    protected String tpUnidTransp;
    @XmlElement(required = true)
    protected String idUnidTransp;
    protected List<LacUnidTransp> lacUnidTransp;
    protected List<TUnidCarga> infUnidCarga;
    protected String qtdRat;

    /**
     * Gets the value of the tpUnidTransp property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpUnidTransp() {
        return tpUnidTransp;
    }

    /**
     * Sets the value of the tpUnidTransp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpUnidTransp(String value) {
        this.tpUnidTransp = value;
    }

    public boolean isSetTpUnidTransp() {
        return (this.tpUnidTransp != null);
    }

    /**
     * Gets the value of the idUnidTransp property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIdUnidTransp() {
        return idUnidTransp;
    }

    /**
     * Sets the value of the idUnidTransp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIdUnidTransp(String value) {
        this.idUnidTransp = value;
    }

    public boolean isSetIdUnidTransp() {
        return (this.idUnidTransp != null);
    }

    /**
     * Gets the value of the lacUnidTransp property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the lacUnidTransp property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLacUnidTransp().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LacUnidTransp }
     */
    public List<LacUnidTransp> getLacUnidTransp() {
        if (lacUnidTransp == null) {
            lacUnidTransp = new ArrayList<>();
        }
        return this.lacUnidTransp;
    }

    public boolean isSetLacUnidTransp() {
        return ((this.lacUnidTransp != null) && (!this.lacUnidTransp.isEmpty()));
    }

    public void unsetLacUnidTransp() {
        this.lacUnidTransp = null;
    }

    /**
     * Gets the value of the infUnidCarga property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the infUnidCarga property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfUnidCarga().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TUnidCarga }
     */
    public List<TUnidCarga> getInfUnidCarga() {
        if (infUnidCarga == null) {
            infUnidCarga = new ArrayList<>();
        }
        return this.infUnidCarga;
    }

    public boolean isSetInfUnidCarga() {
        return ((this.infUnidCarga != null) && (!this.infUnidCarga.isEmpty()));
    }

    public void unsetInfUnidCarga() {
        this.infUnidCarga = null;
    }

    /**
     * Gets the value of the qtdRat property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getQtdRat() {
        return qtdRat;
    }

    /**
     * Sets the value of the qtdRat property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setQtdRat(String value) {
        this.qtdRat = value;
    }

    public boolean isSetQtdRat() {
        return (this.qtdRat != null);
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
     *         &lt;element name="nLacre"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="20"/&gt;
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
            "nLacre"
    })
    public static class LacUnidTransp
            implements XML {

        @XmlElement(required = true)
        protected String nLacre;

        /**
         * Gets the value of the nLacre property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNLacre() {
            return nLacre;
        }

        /**
         * Sets the value of the nLacre property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNLacre(String value) {
            this.nLacre = value;
        }

        public boolean isSetNLacre() {
            return (this.nLacre != null);
        }

    }

}
