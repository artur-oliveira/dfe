package com.softart.dfe.interfaces.internal.mdfe;

import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.mdfe.MdfeQrCode;

public interface QrCodeGenerator {

    /**
     * This Java function generates an MDFe QR code and throws an exception if no provider is found.
     *
     * @param qrCode qrCode is an object of type MdfeQrCode which is likely used to generate a QR code. It may contain
     *               information such as the MDF-e (Manifesto Eletrônico de Documentos Fiscais) data, which is a Brazilian electronic
     *               document used for the transportation of
     * @return A String is being returned.
     * @throws NoProviderFound if no provider is found.
     */
    String generate(MdfeQrCode qrCode) throws NoProviderFound;

}
