//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v3.0.0 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2024.08.02 às 08:46:12 AM BRT 
//


package br.inf.portalfiscal.nfe.send;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.dfe.interfaces.xml.generic.XML;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de TransformsType complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TransformsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Transform" type="{http://www.w3.org/2000/09/xmldsig#}TransformType" maxOccurs="2" minOccurs="2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformsType", namespace = "http://www.w3.org/2000/09/xmldsig#", propOrder = {
        "transform"
})
public class TransformsType
        implements XML {

    @XmlElement(name = "Transform", required = true)
    protected List<TransformType> transform;

    /**
     * Gets the value of the transform property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the transform property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransform().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransformType }
     */
    public List<TransformType> getTransform() {
        if (transform == null) {
            transform = new ArrayList<TransformType>();
        }
        return this.transform;
    }

    public boolean isSetTransform() {
        return ((this.transform != null) && (!this.transform.isEmpty()));
    }

    public void unsetTransform() {
        this.transform = null;
    }

}
