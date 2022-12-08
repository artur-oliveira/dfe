package com.softart.dfe.interfaces.internal.cte;

import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.cte.CteOsQrCode;
import com.softart.dfe.models.internal.cte.CteQrCode;
import com.softart.dfe.models.internal.cte.GtveQrCode;

public interface QrCodeGenerator {

    String generate(CteQrCode cteQrCode) throws NoProviderFound;

    String generate(GtveQrCode cteQrCode) throws NoProviderFound;

    String generate(CteOsQrCode cteQrCode) throws NoProviderFound;
}
