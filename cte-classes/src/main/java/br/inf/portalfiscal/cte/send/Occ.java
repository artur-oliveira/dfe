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
 * <p>Classe Java de Occ complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Occ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serie" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nOcc"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[1-9]{1}[0-9]{0,5}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *         &lt;element name="emiOcc" type="{http://www.portalfiscal.inf.br/cte}EmiOcc"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Occ", propOrder = {
        "serie",
        "nOcc",
        "dEmi",
        "emiOcc"
})
public class Occ
        implements XML {

    protected String serie;
    @XmlElement(required = true)
    protected String nOcc;
    @XmlElement(required = true)
    protected String dEmi;
    @XmlElement(required = true)
    protected EmiOcc emiOcc;

    /**
     * Obtém o valor da propriedade serie.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Define o valor da propriedade serie.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Obtém o valor da propriedade nOcc.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNOcc() {
        return nOcc;
    }

    /**
     * Define o valor da propriedade nOcc.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNOcc(String value) {
        this.nOcc = value;
    }

    /**
     * Obtém o valor da propriedade dEmi.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDEmi() {
        return dEmi;
    }

    /**
     * Define o valor da propriedade dEmi.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDEmi(String value) {
        this.dEmi = value;
    }

    /**
     * Obtém o valor da propriedade emiOcc.
     *
     * @return possible object is
     * {@link EmiOcc }
     */
    public EmiOcc getEmiOcc() {
        return emiOcc;
    }

    /**
     * Define o valor da propriedade emiOcc.
     *
     * @param value allowed object is
     *              {@link EmiOcc }
     */
    public void setEmiOcc(EmiOcc value) {
        this.emiOcc = value;
    }

}
