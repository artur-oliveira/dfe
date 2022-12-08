package com.softart.dfe.models.internal.nf;

import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.xml.XMLSigner;
import com.softart.dfe.models.nf.authorization.Nf;
import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class NfQrCode {
    private Nf nf;
    private NfConfig config;
    private XMLSigner xmlSigner;
}
