//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.04.12 às 01:57:24 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import com.softart.dfe.interfaces.xml.generic.XML;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Schema XML de validação da área de dados descompactada
 * 
 * <p>Classe Java de TLoteDistDFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TLoteDistDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="50"&gt;
 *         &lt;element name="proc"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any processContents='skip'/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TNSU" /&gt;
 *                 &lt;attribute name="ipTransmissor" type="{http://www.portalfiscal.inf.br/mdfe}TIPv4" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerDFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TLoteDistDFe", propOrder = {
    "proc"
})
public class TLoteDistDFe
    implements XML
{

    @XmlElement(required = true)
    protected List<Proc> proc;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Gets the value of the proc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Proc }
     * 
     * 
     */
    public List<Proc> getProc() {
        if (proc == null) {
            proc = new ArrayList<Proc>();
        }
        return this.proc;
    }

    /**
     * Obtém o valor da propriedade versao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersao(String value) {
        this.versao = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;any processContents='skip'/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TNSU" /&gt;
     *       &lt;attribute name="ipTransmissor" type="{http://www.portalfiscal.inf.br/mdfe}TIPv4" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Proc
        implements XML
    {

        @XmlAnyElement
        protected Element any;
        @XmlAttribute(name = "schema", required = true)
        protected String schema;
        @XmlAttribute(name = "NSU", required = true)
        protected String nsu;
        @XmlAttribute(name = "ipTransmissor")
        protected String ipTransmissor;

        /**
         * Obtém o valor da propriedade any.
         * 
         * @return
         *     possible object is
         *     {@link Element }
         *     
         */
        public Element getAny() {
            return any;
        }

        /**
         * Define o valor da propriedade any.
         * 
         * @param value
         *     allowed object is
         *     {@link Element }
         *     
         */
        public void setAny(Element value) {
            this.any = value;
        }

        /**
         * Obtém o valor da propriedade schema.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSchema() {
            return schema;
        }

        /**
         * Define o valor da propriedade schema.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSchema(String value) {
            this.schema = value;
        }

        /**
         * Obtém o valor da propriedade nsu.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNSU() {
            return nsu;
        }

        /**
         * Define o valor da propriedade nsu.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNSU(String value) {
            this.nsu = value;
        }

        /**
         * Obtém o valor da propriedade ipTransmissor.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIpTransmissor() {
            return ipTransmissor;
        }

        /**
         * Define o valor da propriedade ipTransmissor.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIpTransmissor(String value) {
            this.ipTransmissor = value;
        }

    }

}
