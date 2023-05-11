package br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.prod;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlType;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>Java class for nfeMonitoria complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="nfeMonitoria">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="nomeServidor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="dhServidor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *       <anyAttribute/>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nfeMonitoria", propOrder = {
        "nomeServidor",
        "dhServidor"
})
public class NfeMonitoria {

    protected String nomeServidor;
    protected String dhServidor;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<>();

    /**
     * Gets the value of the nomeServidor property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNomeServidor() {
        return nomeServidor;
    }

    /**
     * Sets the value of the nomeServidor property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNomeServidor(String value) {
        this.nomeServidor = value;
    }

    /**
     * Gets the value of the dhServidor property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhServidor() {
        return dhServidor;
    }

    /**
     * Sets the value of the dhServidor property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhServidor(String value) {
        this.dhServidor = value;
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
