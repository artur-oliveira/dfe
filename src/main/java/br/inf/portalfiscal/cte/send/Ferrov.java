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
 * <p>Classe Java de Ferrov complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Ferrov"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpTraf"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="trafMut" type="{http://www.portalfiscal.inf.br/cte}TrafMut" minOccurs="0"/&gt;
 *         &lt;element name="fluxo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="10"/&gt;
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
@XmlType(name = "Ferrov", propOrder = {
        "tpTraf",
        "trafMut",
        "fluxo"
})
public class Ferrov
        implements XML {

    @XmlElement(required = true)
    protected String tpTraf;
    protected TrafMut trafMut;
    @XmlElement(required = true)
    protected String fluxo;

    /**
     * Obtém o valor da propriedade tpTraf.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpTraf() {
        return tpTraf;
    }

    /**
     * Define o valor da propriedade tpTraf.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpTraf(String value) {
        this.tpTraf = value;
    }

    /**
     * Obtém o valor da propriedade trafMut.
     *
     * @return possible object is
     * {@link TrafMut }
     */
    public TrafMut getTrafMut() {
        return trafMut;
    }

    /**
     * Define o valor da propriedade trafMut.
     *
     * @param value allowed object is
     *              {@link TrafMut }
     */
    public void setTrafMut(TrafMut value) {
        this.trafMut = value;
    }

    /**
     * Obtém o valor da propriedade fluxo.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFluxo() {
        return fluxo;
    }

    /**
     * Define o valor da propriedade fluxo.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFluxo(String value) {
        this.fluxo = value;
    }

}
