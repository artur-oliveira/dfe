//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.09.08 às 10:05:07 AM BRT 
//


package br.inf.portalfiscal.nfe.distribution;

import com.softart.dfe.interfaces.xml.generic.XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de X509DataType complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="X509DataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="X509Certificate" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "X509DataType", propOrder = {
        "x509Certificate"
})
public class X509DataType
        implements XML {

    @XmlElement(name = "X509Certificate", required = true)
    protected byte[] x509Certificate;

    /**
     * Obtém o valor da propriedade x509Certificate.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getX509Certificate() {
        return x509Certificate;
    }

    /**
     * Define o valor da propriedade x509Certificate.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setX509Certificate(byte[] value) {
        this.x509Certificate = value;
    }

}
