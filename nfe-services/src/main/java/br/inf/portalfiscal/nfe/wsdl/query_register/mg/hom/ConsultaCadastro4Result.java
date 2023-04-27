
package br.inf.portalfiscal.nfe.wsdl.query_register.mg.hom;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de consultaCadastro4Result complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaCadastro4Result"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="retConsCad" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaCadastro4Result", propOrder = {
    "retConsCad"
})
public class ConsultaCadastro4Result {

    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<Object> retConsCad;

    /**
     * Gets the value of the retConsCad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retConsCad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetConsCad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getRetConsCad() {
        if (retConsCad == null) {
            retConsCad = new ArrayList<Object>();
        }
        return this.retConsCad;
    }

}
