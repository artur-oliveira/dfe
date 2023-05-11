package br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom;

import jakarta.xml.bind.annotation.*;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>Java class for CTeCabecMsg complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="CTeCabecMsg">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cUF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="versaoDados" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *       <anyAttribute/>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTeCabecMsg", propOrder = {
        "cuf",
        "versaoDados"
})
public class CTeCabecMsg {

    @XmlElement(name = "cUF")
    protected String cuf;
    protected String versaoDados;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<>();

    /**
     * Gets the value of the cuf property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCUF() {
        return cuf;
    }

    /**
     * Sets the value of the cuf property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCUF(String value) {
        this.cuf = value;
    }

    /**
     * Gets the value of the versaoDados property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersaoDados() {
        return versaoDados;
    }

    /**
     * Sets the value of the versaoDados property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersaoDados(String value) {
        this.versaoDados = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     *
     * <p>
     * the map is keyed by the name of the attribute and
     * the value is the string value of the attribute.
     * <p>
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     *
     * @return always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
