package org.dfe.components.internal.mdfe;

import org.dfe.components.internal.parser.AccessKeyParserFactory;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.internal.mdfe.QrCodeMdfeURL;
import org.dfe.enums.mdfe.identification.MdfeEmissionType;
import org.dfe.exceptions.security.XMLSignException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.models.internal.mdfe.MdfeQrCode;

import java.util.Objects;

/**
 * The QrCodeUrlGenerator class generates a URL for a MDFe QR code based on the provided UF, access key, and environment.
 */
final class QrCodeUrlGenerator extends QrCodeGeneratorFactory {

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
    String generateNormal(String uf, String accessKey, String tpAmb) throws NoProviderFound {
        String url = QrCodeMdfeURL.get(UF.valueOfCode(uf), Environment.valueOfCode(tpAmb));
        return url + "?chMDFe=" + AccessKeyParserFactory.mdfe().fromId(accessKey) + "&tpAmb=" + tpAmb;

    }

    /**
     * The function generates a contingency QR code for a MDFe document and signs it with a SHA1 base64 access key.
     *
     * @param qrCode The parameter qrCode is an object of type MdfeQrCode, which contains information about the MDF-e
     *               (Manifesto Eletrônico de Documentos Fiscais) and the configuration for generating the QR Code.
     * @return The method is returning a String that represents a QR code with a digital signature. The QR code contains
     * information about a MDF-e (Manifesto Eletrônico de Documentos Fiscais) and the digital signature is generated using
     * the access key and a SHA1 hash algorithm.
     */
    String generateContingency(MdfeQrCode qrCode) throws NoProviderFound, XMLSignException {
        String qrCodeNormal = generateNormal(qrCode.mdfe().getInfMDFe().getIde().getCuf(), qrCode.mdfe().getInfMDFe().getId(), qrCode.mdfe().getInfMDFe().getIde().getTpAmb());
        return qrCodeNormal + "&sign=" + qrCode.xmlSigner().signAccessKeyWithSha1Base64(
                AccessKeyParserFactory.mdfe().fromId(qrCode.mdfe().getInfMDFe().getId()),
                qrCode.config()
        );
    }

    @Override
    public String generate(MdfeQrCode qrCode) throws NoProviderFound, XMLSignException {
        if (Objects.equals(MdfeEmissionType.valueOfCode(qrCode.mdfe().getInfMDFe().getIde().getTpEmis()), MdfeEmissionType.NORMAL)) {
            return generateNormal(qrCode.mdfe().getInfMDFe().getIde().getCuf(), qrCode.mdfe().getInfMDFe().getId(), qrCode.mdfe().getInfMDFe().getIde().getTpAmb());
        }
        return generateContingency(qrCode);
    }

}
