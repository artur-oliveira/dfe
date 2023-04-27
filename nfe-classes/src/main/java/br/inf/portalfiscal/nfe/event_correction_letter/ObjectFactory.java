//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.09.08 às 05:51:48 PM BRT 
//


package br.inf.portalfiscal.nfe.event_correction_letter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.nfe.event_correction_letter package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Evento_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "evento");
    private final static QName _EnvEvento_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "envEvento");
    private final static QName _ProcEventoNFe_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "procEventoNFe");
    private final static QName _RetEnvEvento_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "retEnvEvento");
    private final static QName _Signature_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Signature");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.nfe.event_correction_letter
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReferenceType }
     */
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link SignedInfoType }
     */
    public SignedInfoType createSignedInfoType() {
        return new SignedInfoType();
    }

    /**
     * Create an instance of {@link TretEvento }
     */
    public TretEvento createTretEvento() {
        return new TretEvento();
    }

    /**
     * Create an instance of {@link TEvento }
     */
    public TEvento createTEvento() {
        return new TEvento();
    }

    /**
     * Create an instance of {@link TEvento.InfEvento }
     */
    public TEvento.InfEvento createTEventoInfEvento() {
        return new TEvento.InfEvento();
    }

    /**
     * Create an instance of {@link DetEvento }
     */
    public DetEvento createDetEvento() {
        return new DetEvento();
    }

    /**
     * Create an instance of {@link TEnvEvento }
     */
    public TEnvEvento createTEnvEvento() {
        return new TEnvEvento();
    }

    /**
     * Create an instance of {@link TProcEvento }
     */
    public TProcEvento createTProcEvento() {
        return new TProcEvento();
    }

    /**
     * Create an instance of {@link TRetEnvEvento }
     */
    public TRetEnvEvento createTRetEnvEvento() {
        return new TRetEnvEvento();
    }

    /**
     * Create an instance of {@link SignatureType }
     */
    public SignatureType createSignatureType() {
        return new SignatureType();
    }

    /**
     * Create an instance of {@link SignatureValueType }
     */
    public SignatureValueType createSignatureValueType() {
        return new SignatureValueType();
    }

    /**
     * Create an instance of {@link TransformsType }
     */
    public TransformsType createTransformsType() {
        return new TransformsType();
    }

    /**
     * Create an instance of {@link TransformType }
     */
    public TransformType createTransformType() {
        return new TransformType();
    }

    /**
     * Create an instance of {@link KeyInfoType }
     */
    public KeyInfoType createKeyInfoType() {
        return new KeyInfoType();
    }

    /**
     * Create an instance of {@link X509DataType }
     */
    public X509DataType createX509DataType() {
        return new X509DataType();
    }

    /**
     * Create an instance of {@link ReferenceType.DigestMethod }
     */
    public ReferenceType.DigestMethod createReferenceTypeDigestMethod() {
        return new ReferenceType.DigestMethod();
    }

    /**
     * Create an instance of {@link SignedInfoType.CanonicalizationMethod }
     */
    public SignedInfoType.CanonicalizationMethod createSignedInfoTypeCanonicalizationMethod() {
        return new SignedInfoType.CanonicalizationMethod();
    }

    /**
     * Create an instance of {@link SignedInfoType.SignatureMethod }
     */
    public SignedInfoType.SignatureMethod createSignedInfoTypeSignatureMethod() {
        return new SignedInfoType.SignatureMethod();
    }

    /**
     * Create an instance of {@link TretEvento.InfEvento }
     */
    public TretEvento.InfEvento createTretEventoInfEvento() {
        return new TretEvento.InfEvento();
    }

    /**
     * Create an instance of {@link TEvento.InfEvento.DetEvento }
     */
    public TEvento.InfEvento.DetEvento createTEventoInfEventoDetEvento() {
        return new TEvento.InfEvento.DetEvento();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TEvento }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "evento")
    public JAXBElement<TEvento> createEvento(TEvento value) {
        return new JAXBElement<TEvento>(_Evento_QNAME, TEvento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TEnvEvento }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "envEvento")
    public JAXBElement<TEnvEvento> createEnvEvento(TEnvEvento value) {
        return new JAXBElement<TEnvEvento>(_EnvEvento_QNAME, TEnvEvento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TProcEvento }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "procEventoNFe")
    public JAXBElement<TProcEvento> createProcEventoNFe(TProcEvento value) {
        return new JAXBElement<TProcEvento>(_ProcEventoNFe_QNAME, TProcEvento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRetEnvEvento }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "retEnvEvento")
    public JAXBElement<TRetEnvEvento> createRetEnvEvento(TRetEnvEvento value) {
        return new JAXBElement<TRetEnvEvento>(_RetEnvEvento_QNAME, TRetEnvEvento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignatureType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Signature")
    public JAXBElement<SignatureType> createSignature(SignatureType value) {
        return new JAXBElement<SignatureType>(_Signature_QNAME, SignatureType.class, null, value);
    }

}
