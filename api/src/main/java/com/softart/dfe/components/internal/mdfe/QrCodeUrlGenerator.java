package com.softart.dfe.components.internal.mdfe;

import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.mdfe.QrCodeMdfeURL;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.mdfe.MdfeQrCode;

public class QrCodeUrlGenerator extends QrCodeGeneratorFactory {

    private String generate(String uf, String accessKey, String tpAmb) throws NoProviderFound {
        String url = QrCodeMdfeURL.get(UF.valueOfCode(uf), Environment.valueOfCode(tpAmb));
        return url + "?chMDFe=" + AccessKeyParserFactory.mdfe().fromId(accessKey) + "&tpAmb=" + tpAmb;

    }

    @Override
    public String generate(MdfeQrCode qrCode) throws NoProviderFound {
        return generate(qrCode.getMdfe().getInfMDFe().getIde().getCuf(), qrCode.getMdfe().getInfMDFe().getId(), qrCode.getMdfe().getInfMDFe().getIde().getTpAmb());
    }

}
