package com.softart.dfe.interfaces.internal.nf;

import com.softart.dfe.exceptions.security.XMLSignException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.nf.NfQrCode;

import java.security.GeneralSecurityException;

public interface QrCodeGenerator {

    /**
     * `getVersion()` returns the version of the QrCode
     *
     * @return The version of the QrCode.
     */
    String getVersion();

    /**
     * It generates a QR code.
     *
     * @param nfQrCode This is the object that contains all the information that you want to encode in the QR code.
     * @return A String
     */
    String generate(NfQrCode nfQrCode) throws NoProviderFound, GeneralSecurityException, XMLSignException;
}
