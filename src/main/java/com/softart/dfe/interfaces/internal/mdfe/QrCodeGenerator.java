package com.softart.dfe.interfaces.internal.mdfe;

import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.mdfe.MdfeQrCode;

public interface QrCodeGenerator {

    /**
     * It generates a QR Code image in PNG format, based on the data provided in the `qrCode` parameter
     *
     * @param qrCode The object that contains the data to be generated.
     * @return A string with the base64 of the image.
     */
    String generate(MdfeQrCode qrCode) throws NoProviderFound;

}
