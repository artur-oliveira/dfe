package com.softart.dfe.components.internal.cte;

import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.cte.QrCodeCteURL;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.cte.CteQrCode;

public class QrCodeUrlGenerator extends QrCodeGeneratorFactory {

    @Override
    public String generate(CteQrCode cteQrCode) throws NoProviderFound {
        String url = QrCodeCteURL.get(UF.valueOfCode(cteQrCode.getCte().getInfCte().getIde().getCuf()), Environment.valueOfCode(cteQrCode.getCte().getInfCte().getIde().getTpAmb()));
        return url + "?chCTe=" + AccessKeyParserFactory.cte().fromId(cteQrCode.getCte().getInfCte().getId()) + "&tpAmb=" + cteQrCode.getCte().getInfCte().getIde().getTpAmb();

    }
}
