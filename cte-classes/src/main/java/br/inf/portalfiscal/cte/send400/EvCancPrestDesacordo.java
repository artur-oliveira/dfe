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
 * <p>Classe Java de EvCancPrestDesacordo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="EvCancPrestDesacordo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="Cancelamento Prestação do Serviço em Desacordo"/&gt;
 *               &lt;enumeration value="Cancelamento Prestacao do Servico em Desacordo"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nProtEvPrestDes" type="{http://www.portalfiscal.inf.br/cte}TProt"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvCancPrestDesacordo", propOrder = {
    "descEvento",
    "nProtEvPrestDes"
})
public class EvCancPrestDesacordo
    implements XML
{

    @XmlElement(required = true)
    protected String descEvento;
    @XmlElement(required = true)
    protected String nProtEvPrestDes;

    /**
     * Obtém o valor da propriedade descEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEvento() {
        return descEvento;
    }

    /**
     * Define o valor da propriedade descEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEvento(String value) {
        this.descEvento = value;
    }

    /**
     * Obtém o valor da propriedade nProtEvPrestDes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNProtEvPrestDes() {
        return nProtEvPrestDes;
    }

    /**
     * Define o valor da propriedade nProtEvPrestDes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNProtEvPrestDes(String value) {
        this.nProtEvPrestDes = value;
    }

}
