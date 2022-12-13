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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de TrafMut complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TrafMut"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="respFat"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ferrEmi"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="vFrete" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *         &lt;element name="chCTeFerroOrigem" type="{http://www.portalfiscal.inf.br/cte}TChNFe" minOccurs="0"/&gt;
 *         &lt;element name="ferroEnv" type="{http://www.portalfiscal.inf.br/cte}FerroEnv" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrafMut", propOrder = {
        "respFat",
        "ferrEmi",
        "vFrete",
        "chCTeFerroOrigem",
        "ferroEnv"
})
public class TrafMut
        implements XML {

    @XmlElement(required = true)
    protected String respFat;
    @XmlElement(required = true)
    protected String ferrEmi;
    @XmlElement(required = true)
    protected String vFrete;
    protected String chCTeFerroOrigem;
    protected List<FerroEnv> ferroEnv;

    /**
     * Obtém o valor da propriedade respFat.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRespFat() {
        return respFat;
    }

    /**
     * Define o valor da propriedade respFat.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRespFat(String value) {
        this.respFat = value;
    }

    /**
     * Obtém o valor da propriedade ferrEmi.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFerrEmi() {
        return ferrEmi;
    }

    /**
     * Define o valor da propriedade ferrEmi.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFerrEmi(String value) {
        this.ferrEmi = value;
    }

    /**
     * Obtém o valor da propriedade vFrete.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVFrete() {
        return vFrete;
    }

    /**
     * Define o valor da propriedade vFrete.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVFrete(String value) {
        this.vFrete = value;
    }

    /**
     * Obtém o valor da propriedade chCTeFerroOrigem.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChCTeFerroOrigem() {
        return chCTeFerroOrigem;
    }

    /**
     * Define o valor da propriedade chCTeFerroOrigem.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChCTeFerroOrigem(String value) {
        this.chCTeFerroOrigem = value;
    }

    /**
     * Gets the value of the ferroEnv property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ferroEnv property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFerroEnv().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FerroEnv }
     */
    public List<FerroEnv> getFerroEnv() {
        if (ferroEnv == null) {
            ferroEnv = new ArrayList<FerroEnv>();
        }
        return this.ferroEnv;
    }

}
