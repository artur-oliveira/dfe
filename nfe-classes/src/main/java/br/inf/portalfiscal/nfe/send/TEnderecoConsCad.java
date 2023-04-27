//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.03.16 às 01:10:23 PM BRT 
//


package br.inf.portalfiscal.nfe.send;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Tipo Dados do Endereço
 *
 * <p>Classe Java de TEnderecoConsCad complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TEnderecoConsCad"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="xLgr" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nro" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xCpl" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xBairro" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cMun" type="{http://www.portalfiscal.inf.br/nfe}TCodMunIBGEConsCad" minOccurs="0"/&gt;
 *         &lt;element name="xMun" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TStringConsCad"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CEP" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *               &lt;pattern value="[0-9]{7,8}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEnderecoConsCad", propOrder = {
        "xLgr",
        "nro",
        "xCpl",
        "xBairro",
        "cMun",
        "xMun",
        "cep"
})
public class TEnderecoConsCad
        implements XML {

    protected String xLgr;
    protected String nro;
    protected String xCpl;
    protected String xBairro;
    protected String cMun;
    protected String xMun;
    @XmlElement(name = "CEP")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cep;

    /**
     * Obtém o valor da propriedade xLgr.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXLgr() {
        return xLgr;
    }

    /**
     * Define o valor da propriedade xLgr.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXLgr(String value) {
        this.xLgr = value;
    }

    /**
     * Obtém o valor da propriedade nro.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNro() {
        return nro;
    }

    /**
     * Define o valor da propriedade nro.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNro(String value) {
        this.nro = value;
    }

    /**
     * Obtém o valor da propriedade xCpl.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXCpl() {
        return xCpl;
    }

    /**
     * Define o valor da propriedade xCpl.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXCpl(String value) {
        this.xCpl = value;
    }

    /**
     * Obtém o valor da propriedade xBairro.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXBairro() {
        return xBairro;
    }

    /**
     * Define o valor da propriedade xBairro.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXBairro(String value) {
        this.xBairro = value;
    }

    /**
     * Obtém o valor da propriedade cMun.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCMun() {
        return cMun;
    }

    /**
     * Define o valor da propriedade cMun.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCMun(String value) {
        this.cMun = value;
    }

    /**
     * Obtém o valor da propriedade xMun.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXMun() {
        return xMun;
    }

    /**
     * Define o valor da propriedade xMun.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXMun(String value) {
        this.xMun = value;
    }

    /**
     * Obtém o valor da propriedade cep.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCEP() {
        return cep;
    }

    /**
     * Define o valor da propriedade cep.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCEP(String value) {
        this.cep = value;
    }

}
