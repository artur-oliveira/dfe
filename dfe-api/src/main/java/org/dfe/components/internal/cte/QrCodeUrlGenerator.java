package org.dfe.components.internal.cte;

import org.dfe.components.internal.parser.AccessKeyParserFactory;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.internal.cte.QrCodeCteURL;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.models.internal.cte.*;

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
        return generate(cteQrCode.cte().getInfCte().getIde().getCuf(), cteQrCode.cte().getInfCte().getId(), cteQrCode.cte().getInfCte().getIde().getTpAmb());
    }

    @Override
    public String generate(Cte4QrCode cteQrCode) throws NoProviderFound {
        return generate(cteQrCode.cte().getInfCte().getIde().getCuf(), cteQrCode.cte().getInfCte().getId(), cteQrCode.cte().getInfCte().getIde().getTpAmb());
    }

    @Override
    public String generate(GtveQrCode gtveQrCode) throws NoProviderFound {
        return generate(gtveQrCode.gtve().getInfCte().getIde().getCuf(), gtveQrCode.gtve().getInfCte().getId(), gtveQrCode.gtve().getInfCte().getIde().getTpAmb());
    }

    @Override
    public String generate(Gtve4QrCode gtveQrCode) throws NoProviderFound {
        return generate(gtveQrCode.gtve().getInfCte().getIde().getCuf(), gtveQrCode.gtve().getInfCte().getId(), gtveQrCode.gtve().getInfCte().getIde().getTpAmb());
    }

    @Override
    public String generate(CteOsQrCode cteOsQrCode) throws NoProviderFound {
        return generate(cteOsQrCode.cteOs().getInfCte().getIde().getCuf(), cteOsQrCode.cteOs().getInfCte().getId(), cteOsQrCode.cteOs().getInfCte().getIde().getTpAmb());
    }

    @Override
    public String generate(CteOs4QrCode cteOsQrCode) throws NoProviderFound {
        return generate(cteOsQrCode.cteOs().getInfCte().getIde().getCuf(), cteOsQrCode.cteOs().getInfCte().getId(), cteOsQrCode.cteOs().getInfCte().getIde().getTpAmb());
    }
}
