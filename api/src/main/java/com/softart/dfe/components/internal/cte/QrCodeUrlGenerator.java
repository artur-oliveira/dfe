package com.softart.dfe.components.internal.cte;

import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.cte.QrCodeCteURL;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.cte.CteOsQrCode;
import com.softart.dfe.models.internal.cte.CteQrCode;
import com.softart.dfe.models.internal.cte.GtveQrCode;

/**
 * The QrCodeUrlGenerator class generates a URL for a QR code for a Brazilian Electronic CT-e document based on the UF,
 * access key, and environment.
 */
public class QrCodeUrlGenerator extends QrCodeGeneratorFactory {

    /**
     * This Java function generates a URL for a CTe QR code based on the UF, access key, and environment.
     *
     * @param uf        The abbreviation of the Brazilian state where the CT-e (Electronic Freight Note) was issued.
     * @param accessKey The access key is a unique identifier for a Brazilian Electronic CT-e (Conhecimento de Transporte
     *                  Eletrônico) document. It is composed of 44 alphanumeric characters and is used to access and validate the document
     *                  in the Brazilian tax system.
     * @param tpAmb     tpAmb stands for "Tipo de Ambiente" which means "Environment Type" in English. It is a parameter used
     *                  in the Brazilian electronic invoicing system to indicate the environment in which the CT-e (Conhecimento de
     *                  Transporte Eletrônico) was issued. It can have two possible
     * @return The method is returning a String that represents a URL for generating a QR code for a CTe (Conhecimento de
     * Transporte Eletrônico) document. The URL includes the access key and the environment type (tpAmb) as parameters.
     * @throws NoProviderFound Exception throwed if no provider is found
     */
    String generate(String uf, String accessKey, String tpAmb) throws NoProviderFound {
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
