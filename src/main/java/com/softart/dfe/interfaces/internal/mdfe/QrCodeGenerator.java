package com.softart.dfe.interfaces.internal.mdfe;

import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.mdfe.MdfeQrCode;

public interface QrCodeGenerator {

    String generate(MdfeQrCode qrCode) throws NoProviderFound;

}
