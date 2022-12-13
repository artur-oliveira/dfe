//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.12.08 às 12:12:45 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de Rodo complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Rodo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RNTRC"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TRNTRC"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="occ" type="{http://www.portalfiscal.inf.br/cte}Occ" maxOccurs="10" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rodo", propOrder = {
        "rntrc",
        "occ"
})
public class Rodo
        implements XML {

    @XmlElement(name = "RNTRC", required = true)
    protected String rntrc;
    protected List<Occ> occ;

    /**
     * Obtém o valor da propriedade rntrc.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRNTRC() {
        return rntrc;
    }

    /**
     * Define o valor da propriedade rntrc.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRNTRC(String value) {
        this.rntrc = value;
    }

    /**
     * Gets the value of the occ property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the occ property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOcc().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Occ }
     */
    public List<Occ> getOcc() {
        if (occ == null) {
            occ = new ArrayList<Occ>();
        }
        return this.occ;
    }

}
