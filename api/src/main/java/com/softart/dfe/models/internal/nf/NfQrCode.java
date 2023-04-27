package com.softart.dfe.models.internal.nf;

import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.models.nf.authorization.Nf;
import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public final class NfQrCode {
    private Nf nf;
    private NfceConfig config;
    private XMLSignerService xmlSigner;
}
