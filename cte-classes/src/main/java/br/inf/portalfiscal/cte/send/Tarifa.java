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
 * <p>Classe Java de Tarifa complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Tarifa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CL"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="1"/&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="M"/&gt;
 *               &lt;pattern value="G"/&gt;
 *               &lt;pattern value="E"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cTar" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="vTar" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tarifa", propOrder = {
        "cl",
        "cTar",
        "vTar"
})
public class Tarifa
        implements XML {

    @XmlElement(name = "CL", required = true)
    protected String cl;
    protected String cTar;
    @XmlElement(required = true)
    protected String vTar;

    /**
     * Obtém o valor da propriedade cl.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCL() {
        return cl;
    }

    /**
     * Define o valor da propriedade cl.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCL(String value) {
        this.cl = value;
    }

    /**
     * Obtém o valor da propriedade cTar.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCTar() {
        return cTar;
    }

    /**
     * Define o valor da propriedade cTar.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCTar(String value) {
        this.cTar = value;
    }

    /**
     * Obtém o valor da propriedade vTar.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVTar() {
        return vTar;
    }

    /**
     * Define o valor da propriedade vTar.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVTar(String value) {
        this.vTar = value;
    }

}
