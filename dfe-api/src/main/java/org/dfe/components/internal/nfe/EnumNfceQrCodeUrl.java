package org.dfe.components.internal.nfe;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.internal.nf.QrCodeNfceURL;
import org.dfe.exceptions.security.XMLSignException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.internal.nf.NfceQrCodeUrl;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.internal.nf.NfQrCode;
import org.dfe.models.nf.authorization.Nf;

import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class EnumNfceQrCodeUrl implements NfceQrCodeUrl {
    @Override
    public String get(UF uf, Environment environment) throws NoProviderFound {
        QrCodeNfceURL serviceURL = Arrays.stream(QrCodeNfceURL.values()).filter(it -> it.allow(uf, environment)).findFirst().orElseThrow(NoProviderFound::new);
        return environment.production() ? serviceURL.production() : serviceURL.homologation();
    }


}
