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
 * <p>Classe Java de Peri complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Peri"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nONU"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{4}|ND"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="qTotEmb"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infTotAP" type="{http://www.portalfiscal.inf.br/cte}InfTotAP"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Peri", propOrder = {
        "nonu",
        "qTotEmb",
        "infTotAP"
})
public class Peri
        implements XML {

    @XmlElement(name = "nONU", required = true)
    protected String nonu;
    @XmlElement(required = true)
    protected String qTotEmb;
    @XmlElement(required = true)
    protected InfTotAP infTotAP;

    /**
     * Obtém o valor da propriedade nonu.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNONU() {
        return nonu;
    }

    /**
     * Define o valor da propriedade nonu.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNONU(String value) {
        this.nonu = value;
    }

    /**
     * Obtém o valor da propriedade qTotEmb.
     *
     * @return possible object is
     * {@link String }
     */
    public String getQTotEmb() {
        return qTotEmb;
    }

    /**
     * Define o valor da propriedade qTotEmb.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setQTotEmb(String value) {
        this.qTotEmb = value;
    }

    /**
     * Obtém o valor da propriedade infTotAP.
     *
     * @return possible object is
     * {@link InfTotAP }
     */
    public InfTotAP getInfTotAP() {
        return infTotAP;
    }

    /**
     * Define o valor da propriedade infTotAP.
     *
     * @param value allowed object is
     *              {@link InfTotAP }
     */
    public void setInfTotAP(InfTotAP value) {
        this.infTotAP = value;
    }

}
