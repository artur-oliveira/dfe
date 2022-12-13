//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.09.08 às 10:05:07 AM BRT 
//


package br.inf.portalfiscal.nfe.distribution;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.inf.portalfiscal.nfe.distribuicao package.
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

    private final static QName _DistDFeInt_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "distDFeInt");
    private final static QName _ResEvento_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "resEvento");
    private final static QName _ResNFe_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "resNFe");
    private final static QName _RetDistDFeInt_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "retDistDFeInt");
    private final static QName _Signature_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Signature");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.nfe.distribuicao
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
     * Create an instance of {@link TRetDistDFeInt }
     */
    public TRetDistDFeInt createTRetDistDFeInt() {
        return new TRetDistDFeInt();
    }

    /**
     * Create an instance of {@link TRetDistDFeInt.LoteDistDFeInt }
     */
    public TRetDistDFeInt.LoteDistDFeInt createTRetDistDFeIntLoteDistDFeInt() {
        return new TRetDistDFeInt.LoteDistDFeInt();
    }

    /**
     * Create an instance of {@link TDistDFeInt }
     */
    public TDistDFeInt createTDistDFeInt() {
        return new TDistDFeInt();
    }

    /**
     * Create an instance of {@link TResEvento }
     */
    public TResEvento createTResEvento() {
        return new TResEvento();
    }

    /**
     * Create an instance of {@link TResNFe }
     */
    public TResNFe createTResNFe() {
        return new TResNFe();
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
     * Create an instance of {@link TRetDistDFeInt.LoteDistDFeInt.DocZip }
     */
    public TRetDistDFeInt.LoteDistDFeInt.DocZip createTRetDistDFeIntLoteDistDFeIntDocZip() {
        return new TRetDistDFeInt.LoteDistDFeInt.DocZip();
    }

    /**
     * Create an instance of {@link TDistDFeInt.DistNSU }
     */
    public TDistDFeInt.DistNSU createTDistDFeIntDistNSU() {
        return new TDistDFeInt.DistNSU();
    }

    /**
     * Create an instance of {@link TDistDFeInt.ConsNSU }
     */
    public TDistDFeInt.ConsNSU createTDistDFeIntConsNSU() {
        return new TDistDFeInt.ConsNSU();
    }

    /**
     * Create an instance of {@link TDistDFeInt.ConsChNFe }
     */
    public TDistDFeInt.ConsChNFe createTDistDFeIntConsChNFe() {
        return new TDistDFeInt.ConsChNFe();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDistDFeInt }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "distDFeInt")
    public JAXBElement<TDistDFeInt> createDistDFeInt(TDistDFeInt value) {
        return new JAXBElement<TDistDFeInt>(_DistDFeInt_QNAME, TDistDFeInt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TResEvento }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "resEvento")
    public JAXBElement<TResEvento> createResEvento(TResEvento value) {
        return new JAXBElement<TResEvento>(_ResEvento_QNAME, TResEvento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TResNFe }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "resNFe")
    public JAXBElement<TResNFe> createResNFe(TResNFe value) {
        return new JAXBElement<TResNFe>(_ResNFe_QNAME, TResNFe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRetDistDFeInt }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "retDistDFeInt")
    public JAXBElement<TRetDistDFeInt> createRetDistDFeInt(TRetDistDFeInt value) {
        return new JAXBElement<TRetDistDFeInt>(_RetDistDFeInt_QNAME, TRetDistDFeInt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignatureType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Signature")
    public JAXBElement<SignatureType> createSignature(SignatureType value) {
        return new JAXBElement<SignatureType>(_Signature_QNAME, SignatureType.class, null, value);
    }

}
