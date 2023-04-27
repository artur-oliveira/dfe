//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.03.16 às 01:10:23 PM BRT 
//


package br.inf.portalfiscal.nfe.send;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.*;


/**
 * Tipo da NF-e processada
 *
 * <p>Classe Java de TNfeProc complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TNfeProc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NFe" type="{http://www.portalfiscal.inf.br/nfe}TNFe"/&gt;
 *         &lt;element name="protNFe" type="{http://www.portalfiscal.inf.br/nfe}TProtNFe"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerNFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TNfeProc", propOrder = {
        "nFe",
        "protNFe"
})
public class TNfeProc
        implements XML {

    @XmlElement(name = "NFe", required = true)
    protected TNFe nFe;
    @XmlElement(required = true)
    protected TProtNFe protNFe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obtém o valor da propriedade nFe.
     *
     * @return possible object is
     * {@link TNFe }
     */
    public TNFe getNFe() {
        return nFe;
    }

    /**
     * Define o valor da propriedade nFe.
     *
     * @param value allowed object is
     *              {@link TNFe }
     */
    public void setNFe(TNFe value) {
        this.nFe = value;
    }

    /**
     * Obtém o valor da propriedade protNFe.
     *
     * @return possible object is
     * {@link TProtNFe }
     */
    public TProtNFe getProtNFe() {
        return protNFe;
    }

    /**
     * Define o valor da propriedade protNFe.
     *
     * @param value allowed object is
     *              {@link TProtNFe }
     */
    public void setProtNFe(TProtNFe value) {
        this.protNFe = value;
    }

    /**
     * Obtém o valor da propriedade versao.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersao(String value) {
        this.versao = value;
    }

}
