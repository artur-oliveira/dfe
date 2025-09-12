package org.dfe.interfaces.internal.nf;

import org.dfe.components.internal.nfe.QrCodeGeneratorFactory;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.security.XMLSignException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.internal.nf.NfQrCode;
import org.dfe.models.nf.authorization.Nf;

import java.security.GeneralSecurityException;

public interface NfceQrCodeUrl {

    String get(UF uf, Environment environment) throws NoProviderFound;

    default String generate(Nf nf, NfceConfig config, XMLSignerService xmlSigner) throws NoProviderFound, GeneralSecurityException, XMLSignException {
        return QrCodeGeneratorFactory.getInstance().generate(NfQrCode.builder().nf(nf).config(config).xmlSigner(xmlSigner).build());
    }

}
