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
 * <p>Classe Java de FerroEnv complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="FerroEnv"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
 *         &lt;element name="cInt" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe" minOccurs="0"/&gt;
 *         &lt;element name="xNome"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="enderFerro" type="{http://www.portalfiscal.inf.br/cte}TEnderFer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FerroEnv", propOrder = {
        "cnpj",
        "cInt",
        "ie",
        "xNome",
        "enderFerro"
})
public class FerroEnv
        implements XML {

    @XmlElement(name = "CNPJ", required = true)
    protected String cnpj;
    protected String cInt;
    @XmlElement(name = "IE")
    protected String ie;
    @XmlElement(required = true)
    protected String xNome;
    @XmlElement(required = true)
    protected TEnderFer enderFerro;

    /**
     * Obtém o valor da propriedade cnpj.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Define o valor da propriedade cnpj.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    /**
     * Obtém o valor da propriedade cInt.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCInt() {
        return cInt;
    }

    /**
     * Define o valor da propriedade cInt.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCInt(String value) {
        this.cInt = value;
    }

    /**
     * Obtém o valor da propriedade ie.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIE() {
        return ie;
    }

    /**
     * Define o valor da propriedade ie.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIE(String value) {
        this.ie = value;
    }

    /**
     * Obtém o valor da propriedade xNome.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXNome() {
        return xNome;
    }

    /**
     * Define o valor da propriedade xNome.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXNome(String value) {
        this.xNome = value;
    }

    /**
     * Obtém o valor da propriedade enderFerro.
     *
     * @return possible object is
     * {@link TEnderFer }
     */
    public TEnderFer getEnderFerro() {
        return enderFerro;
    }

    /**
     * Define o valor da propriedade enderFerro.
     *
     * @param value allowed object is
     *              {@link TEnderFer }
     */
    public void setEnderFerro(TEnderFer value) {
        this.enderFerro = value;
    }

}
