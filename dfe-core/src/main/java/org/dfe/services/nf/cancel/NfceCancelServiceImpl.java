package org.dfe.services.nf.cancel;

import org.dfe.components.security.signer.XmlSigner;
import org.dfe.components.sefaz.DfeServiceFactory;
import org.dfe.components.validation.ValidatorFactory;
import org.dfe.components.wsdl.ConfigureProviderFactory;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.process.nf.NfProcessService;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.internal.process.NfProcess;
import org.dfe.services.nf.query_protocol.NfceQueryProtocolService;
import org.dfe.services.nf.query_protocol.NfceQueryProtocolServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
public final class NfceCancelServiceImpl implements NfceCancelService {
    private final NfceConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final NfProcessService process = NfProcess.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
    private NfceQueryProtocolService nfQueryProtocolService;

    @Override
    public NfceQueryProtocolService getNfQueryProtocolService() {
        if (Objects.isNull(nfQueryProtocolService))
            setNfQueryProtocolService(new NfceQueryProtocolServiceImpl(getConfig()));
        return nfQueryProtocolService;
    }
}
