//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:08 PM BRT 
//


package br.inf.portalfiscal.cte.send400;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Rodo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Rodo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RNTRC"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TRNTRC"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="occ" maxOccurs="10" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="serie" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="3"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="nOcc"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;pattern value="[1-9]{1}[0-9]{0,5}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
 *                   &lt;element name="emiOcc"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
 *                             &lt;element name="cInt" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="10"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe"/&gt;
 *                             &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *                             &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rodo", propOrder = {
        "rntrc",
        "occ"
})
public class Rodo
        implements XML {

    @XmlElement(name = "RNTRC", required = true)
    protected String rntrc;
    protected List<Occ> occ;

    /**
     * Gets the value of the rntrc property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRNTRC() {
        return rntrc;
    }

    /**
     * Sets the value of the rntrc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRNTRC(String value) {
        this.rntrc = value;
    }

    public boolean isSetRNTRC() {
        return (this.rntrc != null);
    }

    /**
     * Gets the value of the occ property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the occ property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOcc().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Occ }
     */
    public List<Occ> getOcc() {
        if (occ == null) {
            occ = new ArrayList<Occ>();
        }
        return this.occ;
    }

    public boolean isSetOcc() {
        return ((this.occ != null) && (!this.occ.isEmpty()));
    }

    public void unsetOcc() {
        this.occ = null;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="serie" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="3"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="nOcc"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;pattern value="[1-9]{1}[0-9]{0,5}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/cte}TData"/&gt;
     *         &lt;element name="emiOcc"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
     *                   &lt;element name="cInt" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="10"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe"/&gt;
     *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
     *                   &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "serie",
            "nOcc",
            "dEmi",
            "emiOcc"
    })
    public static class Occ
            implements XML {

        protected String serie;
        @XmlElement(required = true)
        protected String nOcc;
        @XmlElement(required = true)
        protected String dEmi;
        @XmlElement(required = true)
        protected EmiOcc emiOcc;

        /**
         * Gets the value of the serie property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getSerie() {
            return serie;
        }

        /**
         * Sets the value of the serie property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setSerie(String value) {
            this.serie = value;
        }

        public boolean isSetSerie() {
            return (this.serie != null);
        }

        /**
         * Gets the value of the nOcc property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNOcc() {
            return nOcc;
        }

        /**
         * Sets the value of the nOcc property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNOcc(String value) {
            this.nOcc = value;
        }

        public boolean isSetNOcc() {
            return (this.nOcc != null);
        }

        /**
         * Gets the value of the dEmi property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDEmi() {
            return dEmi;
        }

        /**
         * Sets the value of the dEmi property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDEmi(String value) {
            this.dEmi = value;
        }

        public boolean isSetDEmi() {
            return (this.dEmi != null);
        }

        /**
         * Gets the value of the emiOcc property.
         *
         * @return possible object is
         * {@link EmiOcc }
         */
        public EmiOcc getEmiOcc() {
            return emiOcc;
        }

        /**
         * Sets the value of the emiOcc property.
         *
         * @param value allowed object is
         *              {@link EmiOcc }
         */
        public void setEmiOcc(EmiOcc value) {
            this.emiOcc = value;
        }

        public boolean isSetEmiOcc() {
            return (this.emiOcc != null);
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
         *         &lt;element name="cInt" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="10"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIe"/&gt;
         *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
         *         &lt;element name="fone" type="{http://www.portalfiscal.inf.br/cte}TFone" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "cnpj",
                "cInt",
                "ie",
                "uf",
                "fone"
        })
        public static class EmiOcc
                implements XML {

            @XmlElement(name = "CNPJ", required = true)
            protected String cnpj;
            protected String cInt;
            @XmlElement(name = "IE", required = true)
            protected String ie;
            @XmlElement(name = "UF", required = true)
            @XmlSchemaType(name = "string")
            protected TUf uf;
            protected String fone;

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
             * Gets the value of the cInt property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getCInt() {
                return cInt;
            }

            /**
             * Sets the value of the cInt property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setCInt(String value) {
                this.cInt = value;
            }

            public boolean isSetCInt() {
                return (this.cInt != null);
            }

            /**
             * Gets the value of the ie property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getIE() {
                return ie;
            }

            /**
             * Sets the value of the ie property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setIE(String value) {
                this.ie = value;
            }

            public boolean isSetIE() {
                return (this.ie != null);
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

            /**
             * Gets the value of the fone property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getFone() {
                return fone;
            }

            /**
             * Sets the value of the fone property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setFone(String value) {
                this.fone = value;
            }

            public boolean isSetFone() {
                return (this.fone != null);
            }

        }

    }

}
