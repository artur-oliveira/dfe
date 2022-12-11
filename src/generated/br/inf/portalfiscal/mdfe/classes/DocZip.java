//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.12.10 às 08:16:40 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import com.softart.dfe.interfaces.xml.XML;


/**
 * <p>Classe Java de DocZip complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DocZip"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
 *       &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TNSU" /&gt;
 *       &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocZip", propOrder = {
    "value"
})
public class DocZip
    implements XML
{

    @XmlValue
    protected byte[] value;
    @XmlAttribute(name = "NSU", required = true)
    protected String nsu;
    @XmlAttribute(name = "schema", required = true)
    protected String schema;

    /**
     * Obtém o valor da propriedade value.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getValue() {
        return value;
    }

    /**
     * Define o valor da propriedade value.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setValue(byte[] value) {
        this.value = value;
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

}
