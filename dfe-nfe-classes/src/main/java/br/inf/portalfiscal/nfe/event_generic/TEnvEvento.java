//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.06 at 01:32:13 PM BRT 
//


package br.inf.portalfiscal.nfe.event_generic;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Tipo Lote de Envio
 *
 * <p>Java class for TEnvEvento complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TEnvEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idLote"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{1,15}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="evento" type="{http://www.portalfiscal.inf.br/nfe}TEvento" maxOccurs="20"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerEnvEvento" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEnvEvento", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = {
        "idLote",
        "evento"
})
public class TEnvEvento
        implements XML {

    @XmlElement(required = true)
    protected String idLote;
    @XmlElement(required = true)
    protected List<TEvento> evento;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Gets the value of the idLote property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIdLote() {
        return idLote;
    }

    /**
     * Sets the value of the idLote property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIdLote(String value) {
        this.idLote = value;
    }

    public boolean isSetIdLote() {
        return (this.idLote != null);
    }

    /**
     * Gets the value of the evento property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the evento property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvento().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TEvento }
     */
    public List<TEvento> getEvento() {
        if (evento == null) {
            evento = new ArrayList<TEvento>();
        }
        return this.evento;
    }

    public boolean isSetEvento() {
        return ((this.evento != null) && (!this.evento.isEmpty()));
    }

    public void unsetEvento() {
        this.evento = null;
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
