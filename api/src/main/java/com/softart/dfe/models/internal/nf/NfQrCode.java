package com.softart.dfe.models.internal.nf;

import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.models.nf.authorization.Nf;
import lombok.Builder;

@Builder
public record NfQrCode(
        Nf nf,
        NfceConfig config,
        XMLSignerService xmlSigner
) {

}
