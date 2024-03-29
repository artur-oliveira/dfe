//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.13 at 10:48:41 AM BRT 
//


package br.inf.portalfiscal.mdfe.distribution;

import org.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for DistDFeInt complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DistDFeInt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/mdfe}TAmb"/&gt;
 *         &lt;element name="cUFAutor" type="{http://www.portalfiscal.inf.br/mdfe}TCodUfIBGE"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
 *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="distNSU" type="{http://www.portalfiscal.inf.br/mdfe}DistNSU"/&gt;
 *           &lt;element name="consNSU" type="{http://www.portalfiscal.inf.br/mdfe}ConsNSU"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerDistDFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistDFeInt", namespace = "http://www.portalfiscal.inf.br/mdfe", propOrder = {
        "tpAmb",
        "cufAutor",
        "cnpj",
        "cpf",
        "distNSU",
        "consNSU"
})
public class DistDFeInt
        implements XML {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(name = "cUFAutor", required = true)
    protected String cufAutor;
    @XmlElement(name = "CNPJ")
    protected String cnpj;
    @XmlElement(name = "CPF")
    protected String cpf;
    protected DistNSU distNSU;
    protected ConsNSU consNSU;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Gets the value of the tpAmb property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * Sets the value of the tpAmb property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTpAmb(String value) {
        this.tpAmb = value;
    }

    public boolean isSetTpAmb() {
        return (this.tpAmb != null);
    }

    /**
     * Gets the value of the cufAutor property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCUFAutor() {
        return cufAutor;
    }

    /**
     * Sets the value of the cufAutor property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCUFAutor(String value) {
        this.cufAutor = value;
    }

    public boolean isSetCUFAutor() {
        return (this.cufAutor != null);
    }

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
     * Gets the value of the distNSU property.
     *
     * @return possible object is
     * {@link DistNSU }
     */
    public DistNSU getDistNSU() {
        return distNSU;
    }

    /**
     * Sets the value of the distNSU property.
     *
     * @param value allowed object is
     *              {@link DistNSU }
     */
    public void setDistNSU(DistNSU value) {
        this.distNSU = value;
    }

    public boolean isSetDistNSU() {
        return (this.distNSU != null);
    }

    /**
     * Gets the value of the consNSU property.
     *
     * @return possible object is
     * {@link ConsNSU }
     */
    public ConsNSU getConsNSU() {
        return consNSU;
    }

    /**
     * Sets the value of the consNSU property.
     *
     * @param value allowed object is
     *              {@link ConsNSU }
     */
    public void setConsNSU(ConsNSU value) {
        this.consNSU = value;
    }

    public boolean isSetConsNSU() {
        return (this.consNSU != null);
    }

    /**
     * Gets the value of the versao property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Sets the value of the versao property.
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
