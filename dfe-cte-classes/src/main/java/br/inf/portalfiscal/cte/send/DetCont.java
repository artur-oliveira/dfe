//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for DetCont complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DetCont"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nCont" type="{http://www.portalfiscal.inf.br/cte}TContainer"/&gt;
 *         &lt;element name="lacre" type="{http://www.portalfiscal.inf.br/cte}Lacre" maxOccurs="3" minOccurs="0"/&gt;
 *         &lt;element name="infDoc" type="{http://www.portalfiscal.inf.br/cte}InfDoc" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetCont", propOrder = {
        "nCont",
        "lacre",
        "infDoc"
})
public class DetCont
        implements XML {

    @XmlElement(required = true)
    protected String nCont;
    protected List<Lacre> lacre;
    protected InfDoc infDoc;

    /**
     * Gets the value of the nCont property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNCont() {
        return nCont;
    }

    /**
     * Sets the value of the nCont property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNCont(String value) {
        this.nCont = value;
    }

    public boolean isSetNCont() {
        return (this.nCont != null);
    }

    /**
     * Gets the value of the lacre property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the lacre property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLacre().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Lacre }
     */
    public List<Lacre> getLacre() {
        if (lacre == null) {
            lacre = new ArrayList<>();
        }
        return this.lacre;
    }

    public boolean isSetLacre() {
        return ((this.lacre != null) && (!this.lacre.isEmpty()));
    }

    public void unsetLacre() {
        this.lacre = null;
    }

    /**
     * Gets the value of the infDoc property.
     *
     * @return possible object is
     * {@link InfDoc }
     */
    public InfDoc getInfDoc() {
        return infDoc;
    }

    /**
     * Sets the value of the infDoc property.
     *
     * @param value allowed object is
     *              {@link InfDoc }
     */
    public void setInfDoc(InfDoc value) {
        this.infDoc = value;
    }

    public boolean isSetInfDoc() {
        return (this.infDoc != null);
    }

}
