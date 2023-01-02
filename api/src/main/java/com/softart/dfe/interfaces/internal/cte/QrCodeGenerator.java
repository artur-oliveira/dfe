package com.softart.dfe.interfaces.internal.cte;

import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.cte.CteOsQrCode;
import com.softart.dfe.models.internal.cte.CteQrCode;
import com.softart.dfe.models.internal.cte.GtveQrCode;

public interface QrCodeGenerator {

    /**
     * Generates a QR Code for the given CteQrCode object
     *
     * @param cteQrCode The object that contains the data to be encoded in the QR Code.
     * @return A String with the QR Code in Base64.
     */
    String generate(CteQrCode cteQrCode) throws NoProviderFound;

    /**
     * It generates a QR code for the given CteQrCode object.
     *
     * @param cteQrCode This is the object that contains the data to be encoded in the QR Code.
     * @return A String containing the QR Code in Base64 format.
     */
    String generate(GtveQrCode cteQrCode) throws NoProviderFound;

    /**
     * Generates a QR Code image in PNG format, based on the given CTe OS QR Code object
     *
     * @param cteQrCode The object that contains the data to be encoded in the QR Code.
     * @return A String with the QR Code in Base64 format.
     */
    String generate(CteOsQrCode cteQrCode) throws NoProviderFound;
}
