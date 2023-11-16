//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;


/**
 * Tipo Dados do Local de Retirada ou Entrega
 *
 * <p>Java class for TEndReEnt complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TEndReEnt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
 *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="xNome"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xLgr"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;maxLength value="255"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nro"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xCpl" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xBairro"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cMun" type="{http://www.portalfiscal.inf.br/cte}TCodMunIBGE"/&gt;
 *         &lt;element name="xMun"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEndReEnt", propOrder = {
        "cnpj",
        "cpf",
        "xNome",
        "xLgr",
        "nro",
        "xCpl",
        "xBairro",
        "cMun",
        "xMun",
        "uf"
})
public class TEndReEnt
        implements XML {

    @XmlElement(name = "CNPJ")
    protected String cnpj;
    @XmlElement(name = "CPF")
    protected String cpf;
    @XmlElement(required = true)
    protected String xNome;
    @XmlElement(required = true)
    protected String xLgr;
    @XmlElement(required = true)
    protected String nro;
    protected String xCpl;
    @XmlElement(required = true)
    protected String xBairro;
    @XmlElement(required = true)
    protected String cMun;
    @XmlElement(required = true)
    protected String xMun;
    @XmlElement(name = "UF", required = true)
    @XmlSchemaType(name = "string")
    protected TUf uf;

    /**
     * Gets the value of the cnpj property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Sets the value of the cnpj property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    public boolean isSetCNPJ() {
        return (this.cnpj != null);
    }

    /**
     * Gets the value of the cpf property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * Sets the value of the cpf property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCPF(String value) {
        this.cpf = value;
    }

    public boolean isSetCPF() {
        return (this.cpf != null);
    }

    /**
     * Gets the value of the xNome property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXNome() {
        return xNome;
    }

    /**
     * Sets the value of the xNome property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXNome(String value) {
        this.xNome = value;
    }

    public boolean isSetXNome() {
        return (this.xNome != null);
    }

    /**
     * Gets the value of the xLgr property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXLgr() {
        return xLgr;
    }

    /**
     * Sets the value of the xLgr property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXLgr(String value) {
        this.xLgr = value;
    }

    public boolean isSetXLgr() {
        return (this.xLgr != null);
    }

    /**
     * Gets the value of the nro property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNro() {
        return nro;
    }

    /**
     * Sets the value of the nro property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNro(String value) {
        this.nro = value;
    }

    public boolean isSetNro() {
        return (this.nro != null);
    }

    /**
     * Gets the value of the xCpl property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXCpl() {
        return xCpl;
    }

    /**
     * Sets the value of the xCpl property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXCpl(String value) {
        this.xCpl = value;
    }

    public boolean isSetXCpl() {
        return (this.xCpl != null);
    }

    /**
     * Gets the value of the xBairro property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXBairro() {
        return xBairro;
    }

    /**
     * Sets the value of the xBairro property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXBairro(String value) {
        this.xBairro = value;
    }

    public boolean isSetXBairro() {
        return (this.xBairro != null);
    }

    /**
     * Gets the value of the cMun property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCMun() {
        return cMun;
    }

    /**
     * Sets the value of the cMun property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCMun(String value) {
        this.cMun = value;
    }

    public boolean isSetCMun() {
        return (this.cMun != null);
    }

    /**
     * Gets the value of the xMun property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getXMun() {
        return xMun;
    }

    /**
     * Sets the value of the xMun property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setXMun(String value) {
        this.xMun = value;
    }

    public boolean isSetXMun() {
        return (this.xMun != null);
    }

    /**
     * Gets the value of the uf property.
     *
     * @return possible object is
     * {@link TUf }
     */
    public TUf getUF() {
        return uf;
    }

    /**
     * Sets the value of the uf property.
     *
     * @param value allowed object is
     *              {@link TUf }
     */
    public void setUF(TUf value) {
        this.uf = value;
    }

    public boolean isSetUF() {
        return (this.uf != null);
    }

}
