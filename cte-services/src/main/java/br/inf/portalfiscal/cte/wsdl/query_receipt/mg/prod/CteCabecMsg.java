package br.inf.portalfiscal.cte.wsdl.query_receipt.mg.prod;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>Classe Java de cteCabecMsg complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="cteCabecMsg"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cUF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="versaoDados" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cteCabecMsg", propOrder = {
        "cuf",
        "versaoDados"
})
public class CteCabecMsg {

    @XmlAnyAttribute
    private final Map<QName, String> otherAttributes = new HashMap<QName, String>();
    @XmlElement(name = "cUF")
    protected String cuf;
    protected String versaoDados;

    /**
     * Obtém o valor da propriedade cuf.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCUF() {
        return cuf;
    }

    /**
     * Define o valor da propriedade cuf.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCUF(String value) {
        this.cuf = value;
    }

    /**
     * Obtém o valor da propriedade versaoDados.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersaoDados() {
        return versaoDados;
    }

    /**
     * Define o valor da propriedade versaoDados.
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
