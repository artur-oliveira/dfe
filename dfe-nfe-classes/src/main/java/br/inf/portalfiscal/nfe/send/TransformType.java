//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v3.0.0 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2024.08.02 às 08:46:12 AM BRT 
//


package br.inf.portalfiscal.nfe.send;

import jakarta.xml.bind.annotation.*;
import org.dfe.interfaces.xml.generic.XML;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de TransformType complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TransformType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="XPath" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2000/09/xmldsig#}TTransformURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformType", namespace = "http://www.w3.org/2000/09/xmldsig#", propOrder = {
        "xPath"
})
public class TransformType
        implements XML {

    @XmlElement(name = "XPath")
    protected List<String> xPath;
    @XmlAttribute(name = "Algorithm", required = true)
    protected String algorithm;

    /**
     * Gets the value of the xPath property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the xPath property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXPath().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getXPath() {
        if (xPath == null) {
            xPath = new ArrayList<String>();
        }
        return this.xPath;
    }

    public boolean isSetXPath() {
        return ((this.xPath != null) && (!this.xPath.isEmpty()));
    }

    public void unsetXPath() {
        this.xPath = null;
    }

    /**
     * Obtém o valor da propriedade algorithm.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Define o valor da propriedade algorithm.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAlgorithm(String value) {
        this.algorithm = value;
    }

    public boolean isSetAlgorithm() {
        return (this.algorithm != null);
    }

}
