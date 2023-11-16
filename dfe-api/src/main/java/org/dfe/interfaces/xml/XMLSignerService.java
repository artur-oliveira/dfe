package org.dfe.interfaces.xml;

import org.dfe.exceptions.security.XMLSignException;
import org.dfe.interfaces.internal.config.Config;

public interface XMLSignerService {

    /**
     * This function signs an access key with SHA1 and encodes it in Base64 for a given chDFe and configuration.
     *
     * @param chDFe  chDFe is a string parameter that represents the XML document to be signed. It typically contains the
     *               electronic invoice or other electronic document that needs to be signed.
     * @param config The "config" parameter is an object of type "Config" that contains configuration information required
     *               for signing the XML document. This could include information such as the private key, certificate, and other
     *               settings related to the signing process.
     * @return The method is returning a string that represents the access key signed with SHA1 and encoded in Base64
     * format.
     */
    String signAccessKeyWithSha1Base64(String chDFe, Config config) throws XMLSignException;

    /**
     * It signs the XML document passed as a parameter and returns the signed XML document
     *
     * @param xml    The XML to be signed.
     * @param config The configuration object that contains the information about the certificate and the keystore.
     * @return The signed XML.
     */
    String signEvent(String xml, Config config) throws XMLSignException;

    /**
     * It signs the XML document passed as a parameter and returns the signed XML document
     *
     * @param xml    The XML to be signed.
     * @param config The configuration object that contains the information about the certificate and the keystore.
     * @return The signed XML.
     */
    String signInut(String xml, Config config) throws XMLSignException;

    /**
     * It signs the XML document passed as a parameter and returns the signed XML document
     *
     * @param xml    The XML to be signed.
     * @param config The configuration object that contains the information about the certificate and the keystore.
     * @return The signed XML.
     */
    String signNfe(String xml, Config config) throws XMLSignException;

    /**
     * It signs the XML document passed as a parameter and returns the signed XML document
     *
     * @param xml    The XML to be signed.
     * @param config The configuration object that contains the information about the certificate and the keystore.
     * @return The signed XML.
     */
    String signCte(String xml, Config config) throws XMLSignException;

    /**
     * It signs the XML document passed as a parameter and returns the signed XML document
     *
     * @param xml    The XML to be signed.
     * @param config The configuration object that contains the information about the certificate and the keystore.
     * @return The signed XML.
     */
    String signMdfe(String xml, Config config) throws XMLSignException;

}
