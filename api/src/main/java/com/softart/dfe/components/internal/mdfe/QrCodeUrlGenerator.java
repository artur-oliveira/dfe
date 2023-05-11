package com.softart.dfe.components.internal.mdfe;

import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.mdfe.QrCodeMdfeURL;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.mdfe.MdfeQrCode;

/**
 * The QrCodeUrlGenerator class generates a URL for a MDFe QR code based on the provided UF, access key, and environment.
 */
public class QrCodeUrlGenerator extends QrCodeGeneratorFactory {

    /**
     * This Java function generates a URL for a MDFe QR code based on the provided UF, access key, and environment.
     *
     * @param uf        The "uf" parameter is a String representing the Brazilian state where the MDF-e (Manifesto Eletrônico de
     *                  Documentos Fiscais) was issued.
     * @param accessKey The access key is a unique identifier for a MDF-e (Manifesto Eletrônico de Documentos Fiscais)
     *                  document in Brazil. It is composed of 44 alphanumeric characters and is used to track and verify the authenticity of
     *                  the document.
     * @param tpAmb     tpAmb stands for "Tipo de Ambiente" which means "Environment Type" in English. It is a parameter used
     *                  in the generation of a QR code for the MDF-e (Manifesto Eletrônico de Documentos Fiscais) document in Brazil. It
     *                  indicates whether the document
     * @return The method is returning a String that represents a URL for generating a QR code for a MDF-e (Manifesto
     * Eletrônico de Documentos Fiscais) document. The URL includes the MDF-e access key and the environment type (tpAmb).
     * @throws NoProviderFound if no provider is found.
     */
    private String generate(String uf, String accessKey, String tpAmb) throws NoProviderFound {
        String url = QrCodeMdfeURL.get(UF.valueOfCode(uf), Environment.valueOfCode(tpAmb));
        return url + "?chMDFe=" + AccessKeyParserFactory.mdfe().fromId(accessKey) + "&tpAmb=" + tpAmb;

    }

    @Override
    public String generate(MdfeQrCode qrCode) throws NoProviderFound {
        return generate(qrCode.getMdfe().getInfMDFe().getIde().getCuf(), qrCode.getMdfe().getInfMDFe().getId(), qrCode.getMdfe().getInfMDFe().getIde().getTpAmb());
    }

}
