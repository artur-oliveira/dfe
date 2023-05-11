package com.softart.dfe.interfaces.internal.nf;

import com.softart.dfe.exceptions.security.XMLSignException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.nf.NfQrCode;

import java.security.GeneralSecurityException;

public interface QrCodeGenerator {


    /**
     * The function returns a String representing the version.
     *
     * @return A string representing the version.
     */
    String getVersion();

    /**
     * This Java function generates a QR code for a given NfQrCode object.
     *
     * @param nfQrCode nfQrCode is an object of type NfQrCode, which contains information about the configuration, access
     *                 key, version, and other details of a Brazilian electronic invoice (NF-e) QR code.
     * @return The method is returning a String that represents a URL for a QR code, generated based on the parameters
     * passed in the `nfQrCode` object. The URL includes a set of parameters separated by the "|" character, which are used
     * to generate a hash that is also included in the URL.
     * @throws NoProviderFound          if no provider is found
     * @throws GeneralSecurityException GeneralSecurityException
     * @throws XMLSignException         is emission type is offline and cannot sign the XML
     */
    String generate(NfQrCode nfQrCode) throws NoProviderFound, GeneralSecurityException, XMLSignException;
}
