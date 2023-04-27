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
 * <p>Classe Java de InfTotAP complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="InfTotAP"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="qTotProd" type="{http://www.portalfiscal.inf.br/cte}TDec_1104"/&gt;
 *         &lt;element name="uniAP"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="1"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *               &lt;enumeration value="4"/&gt;
 *               &lt;enumeration value="5"/&gt;
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
@XmlType(name = "InfTotAP", propOrder = {
        "qTotProd",
        "uniAP"
})
public class InfTotAP
        implements XML {

    @XmlElement(required = true)
    protected String qTotProd;
    @XmlElement(required = true)
    protected String uniAP;

    /**
     * Obtém o valor da propriedade qTotProd.
     *
     * @return possible object is
     * {@link String }
     */
    public String getQTotProd() {
        return qTotProd;
    }

    /**
     * Define o valor da propriedade qTotProd.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setQTotProd(String value) {
        this.qTotProd = value;
    }

    /**
     * Obtém o valor da propriedade uniAP.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUniAP() {
        return uniAP;
    }

    /**
     * Define o valor da propriedade uniAP.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUniAP(String value) {
        this.uniAP = value;
    }

}
