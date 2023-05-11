package br.inf.portalfiscal.nfe.wsdl.authorization.mg.hom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for nFeAutorizacao4LoteResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="nFeAutorizacao4LoteResult">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="retEnviNFe" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nFeAutorizacao4LoteResult", propOrder = {
        "retEnviNFe"
})
public class NFeAutorizacao4LoteResult {

    protected List<Object> retEnviNFe;

    /**
     * Gets the value of the retEnviNFe property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the retEnviNFe property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetEnviNFe().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     *
     * @return The value of the retEnviNFe property.
     */
    public List<Object> getRetEnviNFe() {
        if (retEnviNFe == null) {
            retEnviNFe = new ArrayList<>();
        }
        return this.retEnviNFe;
    }

}
