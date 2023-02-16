package com.softart.dfe.components.internal.nfe;

import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import com.softart.dfe.enums.internal.nf.QrCodeNfceURL;
import com.softart.dfe.exceptions.security.XMLSignException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.nf.NfQrCode;
import com.softart.dfe.util.Base64Utils;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.HashUtils;
import com.softart.dfe.util.StringUtils;

import java.security.GeneralSecurityException;
import java.util.Objects;

final class QrCodeV2UrlGenerator extends QrCodeGeneratorFactory {
    private static final String QR_CODE_VERSION = "2";

    private static String createHash(String params, String csc) throws GeneralSecurityException {
        return HashUtils.sha1(params + csc);
    }

    @Override
    public String getVersion() {
        return QR_CODE_VERSION;
    }

    public String generate(NfQrCode nfQrCode) throws NoProviderFound, GeneralSecurityException, XMLSignException {
        String url = QrCodeNfceURL.get(nfQrCode.getConfig().uf(), nfQrCode.getConfig().environment());

        final StringBuilder params = new StringBuilder();
        params.append(AccessKeyParserFactory.nfe().fromId(nfQrCode.getNf().toObject().getInfNFe().getId()))
                .append("|")
                .append(getVersion())
                .append("|")
                .append(nfQrCode.getConfig().environment().getCode())
                .append("|");

        if (nfQrCode.getNf().isOffline()) {
            params.append(StringUtils.padZeroStart(DateUtils.zoned(nfQrCode.getNf().dhEmi()).getDayOfMonth(), 2))
                    .append("|")
                    .append(nfQrCode.getNf().VNF())
                    .append("|")
                    .append(HashUtils.hex(Base64Utils.decodeBinary(NfUnmarshallerFactory.getInstance().nfe(nfQrCode.getXmlSigner().signNfe(NfMarshallerFactory.getInstance().nfe(nfQrCode.getNf().toObject()), nfQrCode.getConfig())).getValue().getSignature().getSignedInfo().getReference().getDigestValue())))
                    .append("|");
        }

        params.append(nfQrCode.getConfig().cscId());

        return url
                .replace("?", "")
                .concat("?p=")
                .concat(params.toString())
                .concat("|")
                .concat(Objects.requireNonNull(StringUtils.upper(createHash(params.toString(), nfQrCode.getConfig().csc()))));
    }
}
