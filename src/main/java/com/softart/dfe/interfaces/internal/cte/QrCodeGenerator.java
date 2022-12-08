package com.softart.dfe.interfaces.internal.cte;

import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.cte.CteQrCode;

public interface QrCodeGenerator {

    String generate(CteQrCode cteQrCode) throws NoProviderFound;
}
