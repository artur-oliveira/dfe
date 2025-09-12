package br.inf.portalfiscal.nfe.wsdl.query_register.mg.prod;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for consultaCadastro4Result complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="consultaCadastro4Result">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="retConsCad" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaCadastro4Result", propOrder = {
        "retConsCad"
})
public class ConsultaCadastro4Result {

    @XmlElement(nillable = true)
    protected List<Object> retConsCad;

    /**
     * Gets the value of the retConsCad property.
     *
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retConsCad property.</p>
     *
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getRetConsCad().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * </p>
     *
     * @return The value of the retConsCad property.
     */
    public List<Object> getRetConsCad() {
        if (retConsCad == null) {
            retConsCad = new ArrayList<>();
        }
        return this.retConsCad;
    }

}
