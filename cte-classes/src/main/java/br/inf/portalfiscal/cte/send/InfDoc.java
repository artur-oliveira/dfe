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
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de InfDoc complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="InfDoc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="infNF" type="{http://www.portalfiscal.inf.br/cte}InfNF" maxOccurs="unbounded"/&gt;
 *         &lt;element name="infNFe" type="{http://www.portalfiscal.inf.br/cte}InfNFe" maxOccurs="unbounded"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfDoc", propOrder = {
        "infNF",
        "infNFe"
})
public class InfDoc
        implements XML {

    protected List<InfNF> infNF;
    protected List<InfNFe> infNFe;

    /**
     * Gets the value of the infNF property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infNF property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfNF().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfNF }
     */
    public List<InfNF> getInfNF() {
        if (infNF == null) {
            infNF = new ArrayList<InfNF>();
        }
        return this.infNF;
    }

    /**
     * Gets the value of the infNFe property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infNFe property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfNFe().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfNFe }
     */
    public List<InfNFe> getInfNFe() {
        if (infNFe == null) {
            infNFe = new ArrayList<InfNFe>();
        }
        return this.infNFe;
    }

}
