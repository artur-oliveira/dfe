//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.10 at 10:01:09 PM BRT 
//


package br.inf.portalfiscal.mdfe.classes;

import com.softart.dfe.interfaces.xml.generic.XML;
import jakarta.xml.bind.annotation.*;


/**
 * Tipo de Dados das Notas Fiscais Papel e Eletrônica
 *
 * <p>Java class for TNFeNF complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TNFeNF"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="infNFe"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
 *                   &lt;element name="PIN" type="{http://www.portalfiscal.inf.br/mdfe}TPIN" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infNF"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="emi"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="dest"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="xNome"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                                   &lt;maxLength value="60"/&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="serie"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="3"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="nNF"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="20"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/mdfe}TData"/&gt;
 *                   &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
 *                   &lt;element name="PIN" type="{http://www.portalfiscal.inf.br/mdfe}TPIN" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TNFeNF", propOrder = {
        "infNFe",
        "infNF"
})
public class TNFeNF
        implements XML {

    protected InfNFe infNFe;
    protected InfNF infNF;

    /**
     * Gets the value of the infNFe property.
     *
     * @return possible object is
     * {@link InfNFe }
     */
    public InfNFe getInfNFe() {
        return infNFe;
    }

    /**
     * Sets the value of the infNFe property.
     *
     * @param value allowed object is
     *              {@link InfNFe }
     */
    public void setInfNFe(InfNFe value) {
        this.infNFe = value;
    }

    public boolean isSetInfNFe() {
        return (this.infNFe != null);
    }

    /**
     * Gets the value of the infNF property.
     *
     * @return possible object is
     * {@link InfNF }
     */
    public InfNF getInfNF() {
        return infNF;
    }

    /**
     * Sets the value of the infNF property.
     *
     * @param value allowed object is
     *              {@link InfNF }
     */
    public void setInfNF(InfNF value) {
        this.infNF = value;
    }

    public boolean isSetInfNF() {
        return (this.infNF != null);
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
     *         &lt;element name="emi"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="dest"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
     *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="xNome"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *                         &lt;maxLength value="60"/&gt;
     *                         &lt;minLength value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="serie"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="3"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="nNF"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="20"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/mdfe}TData"/&gt;
     *         &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/mdfe}TDec_1302"/&gt;
     *         &lt;element name="PIN" type="{http://www.portalfiscal.inf.br/mdfe}TPIN" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "emi",
            "dest",
            "serie",
            "nnf",
            "dEmi",
            "vnf",
            "pin"
    })
    public static class InfNF
            implements XML {

        @XmlElement(required = true)
        protected Emi emi;
        @XmlElement(required = true)
        protected Dest dest;
        @XmlElement(required = true)
        protected String serie;
        @XmlElement(name = "nNF", required = true)
        protected String nnf;
        @XmlElement(required = true)
        protected String dEmi;
        @XmlElement(name = "vNF", required = true)
        protected String vnf;
        @XmlElement(name = "PIN")
        protected String pin;

        /**
         * Gets the value of the emi property.
         *
         * @return possible object is
         * {@link Emi }
         */
        public Emi getEmi() {
            return emi;
        }

        /**
         * Sets the value of the emi property.
         *
         * @param value allowed object is
         *              {@link Emi }
         */
        public void setEmi(Emi value) {
            this.emi = value;
        }

        public boolean isSetEmi() {
            return (this.emi != null);
        }

        /**
         * Gets the value of the dest property.
         *
         * @return possible object is
         * {@link Dest }
         */
        public Dest getDest() {
            return dest;
        }

        /**
         * Sets the value of the dest property.
         *
         * @param value allowed object is
         *              {@link Dest }
         */
        public void setDest(Dest value) {
            this.dest = value;
        }

        public boolean isSetDest() {
            return (this.dest != null);
        }

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
         * Gets the value of the nnf property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNNF() {
            return nnf;
        }

        /**
         * Sets the value of the nnf property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNNF(String value) {
            this.nnf = value;
        }

        public boolean isSetNNF() {
            return (this.nnf != null);
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
         * Gets the value of the vnf property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getVNF() {
            return vnf;
        }

        /**
         * Sets the value of the vnf property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setVNF(String value) {
            this.vnf = value;
        }

        public boolean isSetVNF() {
            return (this.vnf != null);
        }

        /**
         * Gets the value of the pin property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPIN() {
            return pin;
        }

        /**
         * Sets the value of the pin property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPIN(String value) {
            this.pin = value;
        }

        public boolean isSetPIN() {
            return (this.pin != null);
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
         *         &lt;choice&gt;
         *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpjOpc"/&gt;
         *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/mdfe}TCpf"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "cnpj",
                "cpf",
                "xNome",
                "uf"
        })
        public static class Dest
                implements XML {

            @XmlElement(name = "CNPJ")
            protected String cnpj;
            @XmlElement(name = "CPF")
            protected String cpf;
            @XmlElement(required = true)
            protected String xNome;
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
         *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/mdfe}TCnpj"/&gt;
         *         &lt;element name="xNome"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
         *               &lt;maxLength value="60"/&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/mdfe}TUf"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "cnpj",
                "xNome",
                "uf"
        })
        public static class Emi
                implements XML {

            @XmlElement(name = "CNPJ", required = true)
            protected String cnpj;
            @XmlElement(required = true)
            protected String xNome;
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
     *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/mdfe}TChNFe"/&gt;
     *         &lt;element name="PIN" type="{http://www.portalfiscal.inf.br/mdfe}TPIN" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "chNFe",
            "pin"
    })
    public static class InfNFe
            implements XML {

        @XmlElement(required = true)
        protected String chNFe;
        @XmlElement(name = "PIN")
        protected String pin;

        /**
         * Gets the value of the chNFe property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getChNFe() {
            return chNFe;
        }

        /**
         * Sets the value of the chNFe property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setChNFe(String value) {
            this.chNFe = value;
        }

        public boolean isSetChNFe() {
            return (this.chNFe != null);
        }

        /**
         * Gets the value of the pin property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPIN() {
            return pin;
        }

        /**
         * Sets the value of the pin property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPIN(String value) {
            this.pin = value;
        }

        public boolean isSetPIN() {
            return (this.pin != null);
        }

    }

}
