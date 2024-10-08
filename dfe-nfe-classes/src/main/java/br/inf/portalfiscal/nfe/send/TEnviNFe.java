//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v3.0.0 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2024.08.02 às 08:46:12 AM BRT 
//


package br.inf.portalfiscal.nfe.send;

import jakarta.xml.bind.annotation.*;
import org.dfe.interfaces.xml.generic.XML;

import java.util.ArrayList;
import java.util.List;


/**
 * Tipo Pedido de Concessão de Autorização da Nota Fiscal Eletrônica
 *
 * <p>Classe Java de TEnviNFe complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="TEnviNFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idLote" type="{http://www.portalfiscal.inf.br/nfe}TIdLote"/&gt;
 *         &lt;element name="indSinc"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="NFe" type="{http://www.portalfiscal.inf.br/nfe}TNFe" maxOccurs="50"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerNFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEnviNFe", propOrder = {
        "idLote",
        "indSinc",
        "nFe"
})
public class TEnviNFe
        implements XML {

    @XmlElement(required = true)
    protected String idLote;
    @XmlElement(required = true)
    protected String indSinc;
    @XmlElement(name = "NFe", required = true)
    protected List<TNFe> nFe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obtém o valor da propriedade idLote.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIdLote() {
        return idLote;
    }

    /**
     * Define o valor da propriedade idLote.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIdLote(String value) {
        this.idLote = value;
    }

    public boolean isSetIdLote() {
        return (this.idLote != null);
    }

    /**
     * Obtém o valor da propriedade indSinc.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIndSinc() {
        return indSinc;
    }

    /**
     * Define o valor da propriedade indSinc.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIndSinc(String value) {
        this.indSinc = value;
    }

    public boolean isSetIndSinc() {
        return (this.indSinc != null);
    }

    /**
     * Gets the value of the nFe property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the nFe property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNFe().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TNFe }
     */
    public List<TNFe> getNFe() {
        if (nFe == null) {
            nFe = new ArrayList<TNFe>();
        }
        return this.nFe;
    }

    public boolean isSetNFe() {
        return ((this.nFe != null) && (!this.nFe.isEmpty()));
    }

    public void unsetNFe() {
        this.nFe = null;
    }

    /**
     * Obtém o valor da propriedade versao.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersao(String value) {
        this.versao = value;
    }

    public boolean isSetVersao() {
        return (this.versao != null);
    }

}
