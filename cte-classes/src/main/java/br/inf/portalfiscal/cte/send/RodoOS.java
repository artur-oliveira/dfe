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
 * <p>Classe Java de RodoOS complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="RodoOS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="TAF" type="{http://www.portalfiscal.inf.br/cte}TTermoAutFreta"/&gt;
 *           &lt;element name="NroRegEstadual" type="{http://www.portalfiscal.inf.br/cte}TNroRegEstadual"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="veic" type="{http://www.portalfiscal.inf.br/cte}Veic" minOccurs="0"/&gt;
 *         &lt;element name="infFretamento" type="{http://www.portalfiscal.inf.br/cte}InfFretamento" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RodoOS", propOrder = {
        "taf",
        "nroRegEstadual",
        "veic",
        "infFretamento"
})
public class RodoOS
        implements XML {

    @XmlElement(name = "TAF")
    protected String taf;
    @XmlElement(name = "NroRegEstadual")
    protected String nroRegEstadual;
    protected Veic veic;
    protected InfFretamento infFretamento;

    /**
     * Obtém o valor da propriedade taf.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTAF() {
        return taf;
    }

    /**
     * Define o valor da propriedade taf.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTAF(String value) {
        this.taf = value;
    }

    /**
     * Obtém o valor da propriedade nroRegEstadual.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNroRegEstadual() {
        return nroRegEstadual;
    }

    /**
     * Define o valor da propriedade nroRegEstadual.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNroRegEstadual(String value) {
        this.nroRegEstadual = value;
    }

    /**
     * Obtém o valor da propriedade veic.
     *
     * @return possible object is
     * {@link Veic }
     */
    public Veic getVeic() {
        return veic;
    }

    /**
     * Define o valor da propriedade veic.
     *
     * @param value allowed object is
     *              {@link Veic }
     */
    public void setVeic(Veic value) {
        this.veic = value;
    }

    /**
     * Obtém o valor da propriedade infFretamento.
     *
     * @return possible object is
     * {@link InfFretamento }
     */
    public InfFretamento getInfFretamento() {
        return infFretamento;
    }

    /**
     * Define o valor da propriedade infFretamento.
     *
     * @param value allowed object is
     *              {@link InfFretamento }
     */
    public void setInfFretamento(InfFretamento value) {
        this.infFretamento = value;
    }

}
