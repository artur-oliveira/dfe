package br.inf.portalfiscal.nfe.wsdl.distribution.an.hom;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="nfeDadosMsg" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <any/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "nfeDadosMsg"
})
@XmlRootElement(name = "nfeDistDFeInteresse")
public class NfeDistDFeInteresse {

    protected NfeDistDFeInteresse.NfeDadosMsg nfeDadosMsg;

    /**
     * Gets the value of the nfeDadosMsg property.
     *
     * @return possible object is
     * {@link NfeDistDFeInteresse.NfeDadosMsg }
     */
    public NfeDistDFeInteresse.NfeDadosMsg getNfeDadosMsg() {
        return nfeDadosMsg;
    }

    /**
     * Sets the value of the nfeDadosMsg property.
     *
     * @param value allowed object is
     *              {@link NfeDistDFeInteresse.NfeDadosMsg }
     */
    public void setNfeDadosMsg(NfeDistDFeInteresse.NfeDadosMsg value) {
        this.nfeDadosMsg = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <any/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "content"
    })
    public static class NfeDadosMsg {

        @XmlMixed
        @XmlAnyElement(lax = true)
        protected List<Object> content;

        /**
         * Gets the value of the content property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a {@code set} method for the content property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * {@link String }
         *
         * @return The value of the content property.
         */
        public List<Object> getContent() {
            if (content == null) {
                content = new ArrayList<>();
            }
            return this.content;
        }

    }

}
