//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.12.10 às 08:16:40 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.softart.dfe.interfaces.xml.XML;


/**
 * <p>Classe Java de LoteDistDFeInt complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
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
@XmlType(name = "LoteDistDFeInt", propOrder = {
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
     * returned list will be present inside the JAXB object.
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

}
