//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.13 at 10:48:41 AM BRT 
//


package br.inf.portalfiscal.mdfe.distribution;

import java.util.ArrayList;
import java.util.List;
import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoteDistDFeInt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoteDistDFeInt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="50"&gt;
 *         &lt;element name="docZip" type="{http://www.portalfiscal.inf.br/mdfe}DocZip"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoteDistDFeInt", namespace = "http://www.portalfiscal.inf.br/mdfe", propOrder = {
    "docZip"
})
public class LoteDistDFeInt
    implements XML
{

    @XmlElement(required = true)
    protected List<DocZip> docZip;

    /**
     * Gets the value of the docZip property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the docZip property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocZip().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocZip }
     * 
     * 
     */
    public List<DocZip> getDocZip() {
        if (docZip == null) {
            docZip = new ArrayList<DocZip>();
        }
        return this.docZip;
    }

    public boolean isSetDocZip() {
        return ((this.docZip!= null)&&(!this.docZip.isEmpty()));
    }

    public void unsetDocZip() {
        this.docZip = null;
    }

}
