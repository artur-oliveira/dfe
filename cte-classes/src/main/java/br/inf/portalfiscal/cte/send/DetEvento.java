//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.12.08 às 12:12:45 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;


/**
 * <p>Classe Java de DetEvento complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="DetEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;any processContents='skip'/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versaoEvento" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;whiteSpace value="preserve"/&gt;
 *             &lt;pattern value="3\.(0[0-9]|[1-9][0-9])"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetEvento", propOrder = {
        "any"
})
public class DetEvento
        implements XML {

    @XmlAnyElement
    protected Element any;
    @XmlAttribute(name = "versaoEvento", required = true)
    protected String versaoEvento;

    /**
     * Obtém o valor da propriedade any.
     *
     * @return possible object is
     * {@link Element }
     */
    public Element getAny() {
        return any;
    }

    /**
     * Define o valor da propriedade any.
     *
     * @param value allowed object is
     *              {@link Element }
     */
    public void setAny(Element value) {
        this.any = value;
    }

    /**
     * Obtém o valor da propriedade versaoEvento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersaoEvento() {
        return versaoEvento;
    }

    /**
     * Define o valor da propriedade versaoEvento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersaoEvento(String value) {
        this.versaoEvento = value;
    }

}
