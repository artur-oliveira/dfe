package br.inf.portalfiscal.nfe.wsdl.status_service.mg.prod;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for nFeStatusServico4Result complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="nFeStatusServico4Result">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="retConsStatServ" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nFeStatusServico4Result", propOrder = {
        "retConsStatServ"
})
public class NFeStatusServico4Result {

    protected List<Object> retConsStatServ;

    /**
     * Gets the value of the retConsStatServ property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the retConsStatServ property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetConsStatServ().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     *
     * @return The value of the retConsStatServ property.
     */
    public List<Object> getRetConsStatServ() {
        if (retConsStatServ == null) {
            retConsStatServ = new ArrayList<>();
        }
        return this.retConsStatServ;
    }

}
