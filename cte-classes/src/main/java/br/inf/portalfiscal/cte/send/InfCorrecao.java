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
 * <p>Classe Java de InfCorrecao complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="InfCorrecao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="grupoAlterado"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="campoAlterado"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valorAlterado"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="500"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nroItemAlterado" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[1-9][0-9]|0?[1-9]"/&gt;
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
@XmlType(name = "InfCorrecao", propOrder = {
        "grupoAlterado",
        "campoAlterado",
        "valorAlterado",
        "nroItemAlterado"
})
public class InfCorrecao
        implements XML {

    @XmlElement(required = true)
    protected String grupoAlterado;
    @XmlElement(required = true)
    protected String campoAlterado;
    @XmlElement(required = true)
    protected String valorAlterado;
    protected String nroItemAlterado;

    /**
     * Obtém o valor da propriedade grupoAlterado.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGrupoAlterado() {
        return grupoAlterado;
    }

    /**
     * Define o valor da propriedade grupoAlterado.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGrupoAlterado(String value) {
        this.grupoAlterado = value;
    }

    /**
     * Obtém o valor da propriedade campoAlterado.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCampoAlterado() {
        return campoAlterado;
    }

    /**
     * Define o valor da propriedade campoAlterado.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCampoAlterado(String value) {
        this.campoAlterado = value;
    }

    /**
     * Obtém o valor da propriedade valorAlterado.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValorAlterado() {
        return valorAlterado;
    }

    /**
     * Define o valor da propriedade valorAlterado.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValorAlterado(String value) {
        this.valorAlterado = value;
    }

    /**
     * Obtém o valor da propriedade nroItemAlterado.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNroItemAlterado() {
        return nroItemAlterado;
    }

    /**
     * Define o valor da propriedade nroItemAlterado.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNroItemAlterado(String value) {
        this.nroItemAlterado = value;
    }

}
