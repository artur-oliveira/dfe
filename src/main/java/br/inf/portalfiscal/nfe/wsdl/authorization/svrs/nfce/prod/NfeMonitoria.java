package br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.prod;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>Classe Java de nfeMonitoria complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="nfeMonitoria"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nomeServidor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dhServidor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nfeMonitoria", propOrder = {
        "nomeServidor",
        "dhServidor"
})
public class NfeMonitoria {

    @XmlAnyAttribute
    private final Map<QName, String> otherAttributes = new HashMap<QName, String>();
    protected String nomeServidor;
    protected String dhServidor;

    /**
     * Obtém o valor da propriedade nomeServidor.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNomeServidor() {
        return nomeServidor;
    }

    /**
     * Define o valor da propriedade nomeServidor.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNomeServidor(String value) {
        this.nomeServidor = value;
    }

    /**
     * Obtém o valor da propriedade dhServidor.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhServidor() {
        return dhServidor;
    }

    /**
     * Define o valor da propriedade dhServidor.
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
