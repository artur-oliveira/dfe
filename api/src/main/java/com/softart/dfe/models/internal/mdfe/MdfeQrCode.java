package com.softart.dfe.models.internal.mdfe;

import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.models.mdfe.reception_sync.Mdfe;
import lombok.Builder;

@Builder
public record MdfeQrCode(
        Mdfe mdfe,
        MdfeConfig config,
        XMLSignerService xmlSigner
) {
}
