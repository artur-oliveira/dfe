package br.inf.portalfiscal.nfe.wsdl.event_correction_letter.mg.hom;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for nFeRecepcaoEvento4Result complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="nFeRecepcaoEvento4Result">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="retEnvEvento" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nFeRecepcaoEvento4Result", propOrder = {
        "retEnvEvento"
})
public class NFeRecepcaoEvento4Result {
    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<Object> retEnvEvento;

    /**
     * Gets the value of the retEnvEvento property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the retEnvEvento property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetEnvEvento().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     *
     * @return The value of the retEnvEvento property.
     */
    public List<Object> getRetEnvEvento() {
        if (retEnvEvento == null) {
            retEnvEvento = new ArrayList<>();
        }
        return this.retEnvEvento;
    }

}
