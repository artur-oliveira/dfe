//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.05.09 às 04:53:39 PM BRT 
//


package br.inf.portalfiscal.cte.send400;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.softart.dfe.interfaces.xml.generic.XML;


/**
 * <p>Classe Java de Duto complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Duto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="vTar" type="{http://www.portalfiscal.inf.br/cte}TDec_0906Opc" minOccurs="0"/&gt;
 *         &lt;element name="dIni" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *         &lt;element name="dFim" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Duto", propOrder = {
    "vTar",
    "dIni",
    "dFim"
})
public class Duto
    implements XML
{

    protected String vTar;
    @XmlElement(required = true)
    protected String dIni;
    @XmlElement(required = true)
    protected String dFim;

    /**
     * Obtém o valor da propriedade vTar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTar() {
        return vTar;
    }

    /**
     * Define o valor da propriedade vTar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTar(String value) {
        this.vTar = value;
    }

    /**
     * Obtém o valor da propriedade dIni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDIni() {
        return dIni;
    }

    /**
     * Define o valor da propriedade dIni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDIni(String value) {
        this.dIni = value;
    }

    /**
     * Obtém o valor da propriedade dFim.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDFim() {
        return dFim;
    }

    /**
     * Define o valor da propriedade dFim.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDFim(String value) {
        this.dFim = value;
    }

}
