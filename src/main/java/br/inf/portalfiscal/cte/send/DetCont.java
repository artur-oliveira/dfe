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
 * <p>Classe Java de DetCont complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="DetCont"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nCont" type="{http://www.portalfiscal.inf.br/cte}TContainer"/&gt;
 *         &lt;element name="lacre" type="{http://www.portalfiscal.inf.br/cte}Lacre" maxOccurs="3" minOccurs="0"/&gt;
 *         &lt;element name="infDoc" type="{http://www.portalfiscal.inf.br/cte}InfDoc" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetCont", propOrder = {
        "nCont",
        "lacre",
        "infDoc"
})
public class DetCont
        implements XML {

    @XmlElement(required = true)
    protected String nCont;
    protected List<Lacre> lacre;
    protected InfDoc infDoc;

    /**
     * Obtém o valor da propriedade nCont.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNCont() {
        return nCont;
    }

    /**
     * Define o valor da propriedade nCont.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNCont(String value) {
        this.nCont = value;
    }

    /**
     * Gets the value of the lacre property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lacre property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLacre().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Lacre }
     */
    public List<Lacre> getLacre() {
        if (lacre == null) {
            lacre = new ArrayList<Lacre>();
        }
        return this.lacre;
    }

    /**
     * Obtém o valor da propriedade infDoc.
     *
     * @return possible object is
     * {@link InfDoc }
     */
    public InfDoc getInfDoc() {
        return infDoc;
    }

    /**
     * Define o valor da propriedade infDoc.
     *
     * @param value allowed object is
     *              {@link InfDoc }
     */
    public void setInfDoc(InfDoc value) {
        this.infDoc = value;
    }

}
