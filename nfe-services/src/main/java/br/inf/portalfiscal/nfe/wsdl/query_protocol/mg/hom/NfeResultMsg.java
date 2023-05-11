package br.inf.portalfiscal.nfe.wsdl.query_protocol.mg.hom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for nfeResultMsg complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="nfeResultMsg">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="retConsSitNFe" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nfeResultMsg", propOrder = {
        "retConsSitNFe"
})
public class NfeResultMsg {

    protected List<Object> retConsSitNFe;

    /**
     * Gets the value of the retConsSitNFe property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the retConsSitNFe property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetConsSitNFe().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     *
     * @return The value of the retConsSitNFe property.
     */
    public List<Object> getRetConsSitNFe() {
        if (retConsSitNFe == null) {
            retConsSitNFe = new ArrayList<>();
        }
        return this.retConsSitNFe;
    }

}
