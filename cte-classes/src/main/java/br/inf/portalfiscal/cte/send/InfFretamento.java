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
 * <p>Classe Java de InfFretamento complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="InfFretamento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpFretamento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dhViagem" type="{http://www.portalfiscal.inf.br/cte}TDateTimeUTC" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfFretamento", propOrder = {
        "tpFretamento",
        "dhViagem"
})
public class InfFretamento
        implements XML {

    @XmlElement(required = true)
    protected String tpFretamento;
    protected String dhViagem;

    /**
     * Obtém o valor da propriedade tpFretamento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpFretamento() {
        return tpFretamento;
    }

    /**
     * Define o valor da propriedade tpFretamento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpFretamento(String value) {
        this.tpFretamento = value;
    }

    /**
     * Obtém o valor da propriedade dhViagem.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDhViagem() {
        return dhViagem;
    }

    /**
     * Define o valor da propriedade dhViagem.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDhViagem(String value) {
        this.dhViagem = value;
    }

}
