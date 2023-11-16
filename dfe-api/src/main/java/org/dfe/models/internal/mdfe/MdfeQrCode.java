package org.dfe.models.internal.mdfe;

import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.mdfe.reception_sync.Mdfe;
import lombok.Builder;

@Builder
public record MdfeQrCode(
        Mdfe mdfe,
        MdfeConfig config,
        XMLSignerService xmlSigner
) {
}
