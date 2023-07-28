package com.softart.dfe.components.security.signer;

import com.softart.dfe.exceptions.security.XMLSignException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.util.Base64Utils;
import com.softart.dfe.util.XMLStringUtils;
import com.softart.dfe.util.XMLUtils;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public final class DefaultXmlSigner extends XmlSigner {

    private static final String C14NEXC = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    private static final String SIGN_INUTILIZATION = "infInut";
    private static final String SIGN_EVENT = "infEvento";
    private static final String SIGN_CTE = "infCte";
    private static final String SIGN_MDFE = "infMDFe";
    private static final String SIGN_NFE = "infNFe";

    public DefaultXmlSigner() {
        System.setProperty("com.sun.org.apache.xml.internal.security.ignoreLineBreaks", "true");
    }

    /**
     * It takes an XML string, a KeyStoreInfo object and an element name, and returns the signed XML string
     *
     * @param xml      the XML to be signed
     * @param info     KeyStoreInfo object
     * @param signable The element that will be signed.
     * @return The signed XML.
     */
    private static String sign(String xml, KeyStoreInfo info, String signable) throws XMLSignException {
        try (StringReader reader = new StringReader(xml)) {
            try (StringWriter writer = new StringWriter()) {
                final XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance();
                final List<Transform> transforms = new ArrayList<>(2);
                transforms.add(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
                transforms.add(signatureFactory.newTransform(C14NEXC, (TransformParameterSpec) null));
                final KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
                final X509Data x509Data = keyInfoFactory.newX509Data(Collections.singletonList(info.getKeyEntryCertificate()));
                final KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
                final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                documentBuilderFactory.setNamespaceAware(true);
                final Document document = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(reader));
                final NodeList elements = document.getElementsByTagName(signable);

                for (int i = 0; i < elements.getLength(); i++) {
                    final Element element = (Element) elements.item(i);
                    final String id = element.getAttribute(XMLStringUtils.ID_ATTRIBUTE);
                    element.setIdAttribute(XMLStringUtils.ID_ATTRIBUTE, true);
                    final Reference reference = signatureFactory.newReference("#" + id, signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transforms, null, null);
                    final SignedInfo signedInfo = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(reference));
                    final XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);
                    signature.sign(new DOMSignContext(info.getKeyEntryPrivateKey(), element.getParentNode()));
                }
                XMLUtils.getTransformer().transform(new DOMSource(document), new StreamResult(writer));
                return writer.toString();
            }
        } catch (Exception e) {
            throw new XMLSignException(e);
        }
    }

    @Override
    public String signInut(String evento, Config config) throws XMLSignException {
        try {
            return DefaultXmlSigner.sign(evento, config.info(), SIGN_INUTILIZATION);
        } catch (XMLSignException e) {
            throw e;
        } catch (Exception e) {
            throw new XMLSignException(e);
        }
    }

    @Override
    public String signEvent(String evento, Config config) throws XMLSignException {
        try {
            return DefaultXmlSigner.sign(evento, config.info(), SIGN_EVENT);
        } catch (XMLSignException e) {
            throw e;
        } catch (Exception e) {
            throw new XMLSignException(e);
        }
    }

    @Override
    public String signNfe(String evento, Config config) throws XMLSignException {
        try {
            return DefaultXmlSigner.sign(evento, config.info(), SIGN_NFE);
        } catch (XMLSignException e) {
            throw e;
        } catch (Exception e) {
            throw new XMLSignException(e);
        }
    }

    @Override
    public String signCte(String evento, Config config) throws XMLSignException {
        try {
            return DefaultXmlSigner.sign(evento, config.info(), SIGN_CTE);
        } catch (XMLSignException e) {
            throw e;
        } catch (Exception e) {
            throw new XMLSignException(e);
        }
    }

    @Override
    public String signMdfe(String evento, Config config) throws XMLSignException {
        try {
            return DefaultXmlSigner.sign(evento, config.info(), SIGN_MDFE);
        } catch (XMLSignException e) {
            throw e;
        } catch (Exception e) {
            throw new XMLSignException(e);
        }
    }

    @Override
    public String signAccessKeyWithSha1Base64(String chDFe, Config config) throws XMLSignException {
        try {

            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initSign(config.info().getKeyEntryPrivateKey());
            signature.update(chDFe.getBytes());

            return Base64Utils.decodeBinary(signature.sign());
        } catch (Exception e) {
            throw new XMLSignException(e);
        }
    }

}