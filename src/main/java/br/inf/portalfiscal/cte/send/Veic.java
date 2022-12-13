//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.12.08 às 12:12:45 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.*;


/**
 * <p>Classe Java de Veic complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Veic"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="placa"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TPlaca"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RENAVAM" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="9"/&gt;
 *               &lt;maxLength value="11"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="prop" type="{http://www.portalfiscal.inf.br/cte}Prop" minOccurs="0"/&gt;
 *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Veic", propOrder = {
        "placa",
        "renavam",
        "prop",
        "uf"
})
public class Veic
        implements XML {

    @XmlElement(required = true)
    protected String placa;
    @XmlElement(name = "RENAVAM")
    protected String renavam;
    protected Prop prop;
    @XmlElement(name = "UF")
    @XmlSchemaType(name = "string")
    protected TUf uf;

    /**
     * Obtém o valor da propriedade placa.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Define o valor da propriedade placa.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPlaca(String value) {
        this.placa = value;
    }

    /**
     * Obtém o valor da propriedade renavam.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRENAVAM() {
        return renavam;
    }

    /**
     * Define o valor da propriedade renavam.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRENAVAM(String value) {
        this.renavam = value;
    }

    /**
     * Obtém o valor da propriedade prop.
     *
     * @return possible object is
     * {@link Prop }
     */
    public Prop getProp() {
        return prop;
    }

    /**
     * Define o valor da propriedade prop.
     *
     * @param value allowed object is
     *              {@link Prop }
     */
    public void setProp(Prop value) {
        this.prop = value;
    }

    /**
     * Obtém o valor da propriedade uf.
     *
     * @return possible object is
     * {@link TUf }
     */
    public TUf getUF() {
        return uf;
    }

    /**
     * Define o valor da propriedade uf.
     *
     * @param value allowed object is
     *              {@link TUf }
     */
    public void setUF(TUf value) {
        this.uf = value;
    }

}
