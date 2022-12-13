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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de Aquav complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Aquav"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="vPrest" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *         &lt;element name="vAFRMM" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *         &lt;element name="xNavio"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="balsa" type="{http://www.portalfiscal.inf.br/cte}Balsa" maxOccurs="3" minOccurs="0"/&gt;
 *         &lt;element name="nViag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[1-9]{1}[0-9]{0,9}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="direc"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="N"/&gt;
 *               &lt;enumeration value="S"/&gt;
 *               &lt;enumeration value="L"/&gt;
 *               &lt;enumeration value="O"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="irin"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;maxLength value="10"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="detCont" type="{http://www.portalfiscal.inf.br/cte}DetCont" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="tpNav" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
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
@XmlType(name = "Aquav", propOrder = {
        "vPrest",
        "vafrmm",
        "xNavio",
        "balsa",
        "nViag",
        "direc",
        "irin",
        "detCont",
        "tpNav"
})
public class Aquav
        implements XML {

    @XmlElement(required = true)
    protected String vPrest;
    @XmlElement(name = "vAFRMM", required = true)
    protected String vafrmm;
    @XmlElement(required = true)
    protected String xNavio;
    protected List<Balsa> balsa;
    protected String nViag;
    @XmlElement(required = true)
    protected String direc;
    @XmlElement(required = true)
    protected String irin;
    protected List<DetCont> detCont;
    protected String tpNav;

    /**
     * Obtém o valor da propriedade vPrest.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVPrest() {
        return vPrest;
    }

    /**
     * Define o valor da propriedade vPrest.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVPrest(String value) {
        this.vPrest = value;
    }

    /**
     * Obtém o valor da propriedade vafrmm.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVAFRMM() {
        return vafrmm;
    }

    /**
     * Define o valor da propriedade vafrmm.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVAFRMM(String value) {
        this.vafrmm = value;
    }

    /**
     * Obtém o valor da propriedade xNavio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXNavio() {
        return xNavio;
    }

    /**
     * Define o valor da propriedade xNavio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXNavio(String value) {
        this.xNavio = value;
    }

    /**
     * Gets the value of the balsa property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the balsa property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBalsa().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Balsa }
     */
    public List<Balsa> getBalsa() {
        if (balsa == null) {
            balsa = new ArrayList<Balsa>();
        }
        return this.balsa;
    }

    /**
     * Obtém o valor da propriedade nViag.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNViag() {
        return nViag;
    }

    /**
     * Define o valor da propriedade nViag.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNViag(String value) {
        this.nViag = value;
    }

    /**
     * Obtém o valor da propriedade direc.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDirec() {
        return direc;
    }

    /**
     * Define o valor da propriedade direc.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDirec(String value) {
        this.direc = value;
    }

    /**
     * Obtém o valor da propriedade irin.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIrin() {
        return irin;
    }

    /**
     * Define o valor da propriedade irin.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIrin(String value) {
        this.irin = value;
    }

    /**
     * Gets the value of the detCont property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detCont property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetCont().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetCont }
     */
    public List<DetCont> getDetCont() {
        if (detCont == null) {
            detCont = new ArrayList<DetCont>();
        }
        return this.detCont;
    }

    /**
     * Obtém o valor da propriedade tpNav.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpNav() {
        return tpNav;
    }

    /**
     * Define o valor da propriedade tpNav.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpNav(String value) {
        this.tpNav = value;
    }

}
