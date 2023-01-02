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
 * <p>Classe Java de EmiOcc complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="EmiOcc"&gt;
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
 *         &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe"/&gt;
 *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *         &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmiOcc", propOrder = {
        "cnpj",
        "cInt",
        "ie",
        "uf",
        "fone"
})
public class EmiOcc
        implements XML {

    @XmlElement(name = "CNPJ", required = true)
    protected String cnpj;
    protected String cInt;
    @XmlElement(name = "IE", required = true)
    protected String ie;
    @XmlElement(name = "UF", required = true)
    @XmlSchemaType(name = "string")
    protected TUf uf;
    protected String fone;

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

    /**
     * Obtém o valor da propriedade fone.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFone() {
        return fone;
    }

    /**
     * Define o valor da propriedade fone.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFone(String value) {
        this.fone = value;
    }

}
