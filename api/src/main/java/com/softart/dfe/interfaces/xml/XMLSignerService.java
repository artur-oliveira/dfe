package com.softart.dfe.interfaces.xml;

import com.softart.dfe.exceptions.security.XMLSignException;
import com.softart.dfe.interfaces.internal.config.Config;

public interface XMLSignerService {

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
