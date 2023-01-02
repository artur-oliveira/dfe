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
 * <p>Classe Java de InfNFe complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="InfNFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chave" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
 *         &lt;element name="unidRat" type="{http://www.portalfiscal.inf.br/cte}TDec_0302_0303" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfNFe", propOrder = {
        "chave",
        "unidRat"
})
public class InfNFe
        implements XML {

    @XmlElement(required = true)
    protected String chave;
    protected String unidRat;

    /**
     * Obtém o valor da propriedade chave.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChave() {
        return chave;
    }

    /**
     * Define o valor da propriedade chave.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChave(String value) {
        this.chave = value;
    }

    /**
     * Obtém o valor da propriedade unidRat.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUnidRat() {
        return unidRat;
    }

    /**
     * Define o valor da propriedade unidRat.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUnidRat(String value) {
        this.unidRat = value;
    }

}
