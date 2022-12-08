package com.softart.dfe.components.internal.cte;

import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.cte.QrCodeCteURL;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.cte.CteOsQrCode;
import com.softart.dfe.models.internal.cte.CteQrCode;
import com.softart.dfe.models.internal.cte.GtveQrCode;

public class QrCodeUrlGenerator extends QrCodeGeneratorFactory {

    private String generate(String uf, String accessKey, String tpAmb) throws NoProviderFound {
        String url = QrCodeCteURL.get(UF.valueOfCode(uf), Environment.valueOfCode(tpAmb));
        return url + "?chCTe=" + AccessKeyParserFactory.cte().fromId(accessKey) + "&tpAmb=" + tpAmb;

    }

    @Override
    public String generate(CteQrCode cteQrCode) throws NoProviderFound {
        return generate(cteQrCode.getCte().getInfCte().getIde().getCuf(), cteQrCode.getCte().getInfCte().getId(), cteQrCode.getCte().getInfCte().getIde().getTpAmb());
    }

    @Override
    public String generate(GtveQrCode gtveQrCode) throws NoProviderFound {
        return generate(gtveQrCode.getGtve().getInfCte().getIde().getCuf(), gtveQrCode.getGtve().getInfCte().getId(), gtveQrCode.getGtve().getInfCte().getIde().getTpAmb());
    }

    @Override
    public String generate(CteOsQrCode cteOsQrCode) throws NoProviderFound {
        return generate(cteOsQrCode.getCteOs().getInfCte().getIde().getCuf(), cteOsQrCode.getCteOs().getInfCte().getId(), cteOsQrCode.getCteOs().getInfCte().getIde().getTpAmb());
    }
}
