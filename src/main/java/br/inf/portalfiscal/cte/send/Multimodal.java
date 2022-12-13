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


/**
 * <p>Classe Java de Multimodal complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Multimodal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="COTM"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="20"/&gt;
 *               &lt;pattern value="[!-ÿ]{1}[ -ÿ]{0,}[!-ÿ]{1}|[!-ÿ]{1}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="indNegociavel"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="seg" type="{http://www.portalfiscal.inf.br/cte}Seg" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Multimodal", propOrder = {
        "cotm",
        "indNegociavel",
        "seg"
})
public class Multimodal
        implements XML {

    @XmlElement(name = "COTM", required = true)
    protected String cotm;
    @XmlElement(required = true)
    protected String indNegociavel;
    protected Seg seg;

    /**
     * Obtém o valor da propriedade cotm.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCOTM() {
        return cotm;
    }

    /**
     * Define o valor da propriedade cotm.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCOTM(String value) {
        this.cotm = value;
    }

    /**
     * Obtém o valor da propriedade indNegociavel.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIndNegociavel() {
        return indNegociavel;
    }

    /**
     * Define o valor da propriedade indNegociavel.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIndNegociavel(String value) {
        this.indNegociavel = value;
    }

    /**
     * Obtém o valor da propriedade seg.
     *
     * @return possible object is
     * {@link Seg }
     */
    public Seg getSeg() {
        return seg;
    }

    /**
     * Define o valor da propriedade seg.
     *
     * @param value allowed object is
     *              {@link Seg }
     */
    public void setSeg(Seg value) {
        this.seg = value;
    }

}
