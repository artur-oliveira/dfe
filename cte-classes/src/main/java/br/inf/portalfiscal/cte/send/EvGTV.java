//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.12.08 às 12:12:45 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de EvGTV complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="EvGTV"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="Informações da GTV"/&gt;
 *               &lt;enumeration value="Informacoes da GTV"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infGTV" type="{http://www.portalfiscal.inf.br/cte}InfGTV" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvGTV", propOrder = {
        "descEvento",
        "infGTV"
})
public class EvGTV
        implements XML {

    @XmlElement(required = true)
    protected String descEvento;
    @XmlElement(required = true)
    protected List<InfGTV> infGTV;

    /**
     * Obtém o valor da propriedade descEvento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescEvento() {
        return descEvento;
    }

    /**
     * Define o valor da propriedade descEvento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescEvento(String value) {
        this.descEvento = value;
    }

    /**
     * Gets the value of the infGTV property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infGTV property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfGTV().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfGTV }
     */
    public List<InfGTV> getInfGTV() {
        if (infGTV == null) {
            infGTV = new ArrayList<InfGTV>();
        }
        return this.infGTV;
    }

}
