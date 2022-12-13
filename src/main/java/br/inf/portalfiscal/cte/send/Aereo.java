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
 * <p>Classe Java de Aereo complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Aereo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nMinu" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{9}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nOCA" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{11}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dPrevAereo" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *         &lt;element name="natCarga" type="{http://www.portalfiscal.inf.br/cte}NatCarga"/&gt;
 *         &lt;element name="tarifa" type="{http://www.portalfiscal.inf.br/cte}Tarifa"/&gt;
 *         &lt;element name="peri" type="{http://www.portalfiscal.inf.br/cte}Peri" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Aereo", propOrder = {
        "nMinu",
        "noca",
        "dPrevAereo",
        "natCarga",
        "tarifa",
        "peri"
})
public class Aereo
        implements XML {

    protected String nMinu;
    @XmlElement(name = "nOCA")
    protected String noca;
    @XmlElement(required = true)
    protected String dPrevAereo;
    @XmlElement(required = true)
    protected NatCarga natCarga;
    @XmlElement(required = true)
    protected Tarifa tarifa;
    protected List<Peri> peri;

    /**
     * Obtém o valor da propriedade nMinu.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNMinu() {
        return nMinu;
    }

    /**
     * Define o valor da propriedade nMinu.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNMinu(String value) {
        this.nMinu = value;
    }

    /**
     * Obtém o valor da propriedade noca.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNOCA() {
        return noca;
    }

    /**
     * Define o valor da propriedade noca.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNOCA(String value) {
        this.noca = value;
    }

    /**
     * Obtém o valor da propriedade dPrevAereo.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDPrevAereo() {
        return dPrevAereo;
    }

    /**
     * Define o valor da propriedade dPrevAereo.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDPrevAereo(String value) {
        this.dPrevAereo = value;
    }

    /**
     * Obtém o valor da propriedade natCarga.
     *
     * @return possible object is
     * {@link NatCarga }
     */
    public NatCarga getNatCarga() {
        return natCarga;
    }

    /**
     * Define o valor da propriedade natCarga.
     *
     * @param value allowed object is
     *              {@link NatCarga }
     */
    public void setNatCarga(NatCarga value) {
        this.natCarga = value;
    }

    /**
     * Obtém o valor da propriedade tarifa.
     *
     * @return possible object is
     * {@link Tarifa }
     */
    public Tarifa getTarifa() {
        return tarifa;
    }

    /**
     * Define o valor da propriedade tarifa.
     *
     * @param value allowed object is
     *              {@link Tarifa }
     */
    public void setTarifa(Tarifa value) {
        this.tarifa = value;
    }

    /**
     * Gets the value of the peri property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the peri property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeri().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Peri }
     */
    public List<Peri> getPeri() {
        if (peri == null) {
            peri = new ArrayList<Peri>();
        }
        return this.peri;
    }

}
