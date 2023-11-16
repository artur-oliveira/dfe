package org.dfe.components.internal.nfe;

import org.dfe.components.internal.parser.AccessKeyParserFactory;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.internal.nf.QrCodeNfceURL;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.exceptions.security.XMLSignException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.models.internal.nf.NfQrCode;
import org.dfe.util.Base64Utils;
import org.dfe.util.DateUtils;
import org.dfe.util.HashUtils;
import org.dfe.util.StringUtils;

import java.security.GeneralSecurityException;
import java.util.Objects;

final class QrCodeV2UrlGenerator extends QrCodeGeneratorFactory {
    private static final String QR_CODE_VERSION = "2";

    /**
     * This function creates a SHA-1 hash by concatenating two input strings.
     *
     * @param params The "params" parameter is a string that contains some data that needs to be hashed. The exact contents
     *               of this string depend on the specific use case and requirements of the application that is using this method.
     * @param csc    The parameter "csc" is likely an abbreviation for "Card Security Code", which is a three or four digit
     *               number found on the back of a credit or debit card. It is also known as the CVV (Card Verification Value) or CVC
     *               (Card Verification Code).
     * @return The method `createHash` is returning a `String` which is the SHA-1 hash of the concatenation of the `params`
     * and `csc` strings.
     * @throws GeneralSecurityException GeneralSecurityException
     */
    private static String createHash(String params, String csc) throws GeneralSecurityException {
        return HashUtils.sha1(params + csc);
    }

    @Override
    public String getVersion() {
        return QR_CODE_VERSION;
    }

    String getParams(String chNFe, String tpAmb, String tpEmis, String dhEmi, String vNF, byte[] digestValue, String cscId) {
        final StringBuilder params = new StringBuilder();
        params.append(AccessKeyParserFactory.nfe().fromId(chNFe))
                .append("|")
                .append(getVersion())
                .append("|")
                .append(tpAmb)
                .append("|");

        if (NFEmissionType.isOffline(tpEmis)) {
            params.append(StringUtils.padZeroStart(DateUtils.zoned(dhEmi).getDayOfMonth(), 2))
                    .append("|")
                    .append(vNF)
                    .append("|")
                    .append(HashUtils.hex(Base64Utils.decodeBinary(digestValue)))
                    .append("|");
        }

        params.append(cscId);

        return params.toString();
    }

    String generate(String uf, String chNFe, String tpAmb, String tpEmis, String dhEmi, String vNF, byte[] digestValue, String cscId, String csc) throws NoProviderFound, GeneralSecurityException {
        String url = QrCodeNfceURL.get(UF.valueOfCode(uf), Environment.valueOfCode(tpAmb));
        String params = getParams(
                AccessKeyParserFactory.nfe().fromId(chNFe),
                tpAmb,
                tpEmis,
                dhEmi,
                vNF,
                digestValue,
                cscId
        );

        return url
                .replace("?", "")
                .concat("?p=")
                .concat(params)
                .concat("|")
                .concat(Objects.requireNonNull(StringUtils.upper(createHash(params, csc))));
    }

    public String generate(NfQrCode nfQrCode) throws NoProviderFound, GeneralSecurityException, XMLSignException {
        return generate(
                nfQrCode.config().uf().getCode(),
                AccessKeyParserFactory.nfe().fromId(nfQrCode.nf().toObject().getInfNFe().getId()),
                nfQrCode.config().environment().getCode(),
                nfQrCode.nf().ide().getTpEmis(),
                nfQrCode.nf().dhEmi(),
                nfQrCode.nf().VNF(),
                nfQrCode.nf().isOffline() ? NfUnmarshallerFactory.getInstance().nfe(nfQrCode.xmlSigner().signNfe(NfMarshallerFactory.getInstance().nfe(nfQrCode.nf().toObject()), nfQrCode.config())).getValue().getSignature().getSignedInfo().getReference().getDigestValue() : null,
                nfQrCode.config().cscId(),
                nfQrCode.config().csc()
        );
    }
}
