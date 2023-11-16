package org.dfe.models.internal.nf;

import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.nf.authorization.Nf;
import lombok.Builder;

@Builder
public record NfQrCode(
        Nf nf,
        NfceConfig config,
        XMLSignerService xmlSigner
) {

}
