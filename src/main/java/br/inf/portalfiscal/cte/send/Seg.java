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
 * <p>Classe Java de Seg complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Seg"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infSeg" type="{http://www.portalfiscal.inf.br/cte}InfSeg"/&gt;
 *         &lt;element name="nApol"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nAver"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Seg", propOrder = {
        "infSeg",
        "nApol",
        "nAver"
})
public class Seg
        implements XML {

    @XmlElement(required = true)
    protected InfSeg infSeg;
    @XmlElement(required = true)
    protected String nApol;
    @XmlElement(required = true)
    protected String nAver;

    /**
     * Obtém o valor da propriedade infSeg.
     *
     * @return possible object is
     * {@link InfSeg }
     */
    public InfSeg getInfSeg() {
        return infSeg;
    }

    /**
     * Define o valor da propriedade infSeg.
     *
     * @param value allowed object is
     *              {@link InfSeg }
     */
    public void setInfSeg(InfSeg value) {
        this.infSeg = value;
    }

    /**
     * Obtém o valor da propriedade nApol.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNApol() {
        return nApol;
    }

    /**
     * Define o valor da propriedade nApol.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNApol(String value) {
        this.nApol = value;
    }

    /**
     * Obtém o valor da propriedade nAver.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNAver() {
        return nAver;
    }

    /**
     * Define o valor da propriedade nAver.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNAver(String value) {
        this.nAver = value;
    }

}
