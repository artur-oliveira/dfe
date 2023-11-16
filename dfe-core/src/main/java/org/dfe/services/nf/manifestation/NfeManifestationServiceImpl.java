package org.dfe.services.nf.manifestation;

import org.dfe.components.security.signer.XmlSigner;
import org.dfe.components.sefaz.DfeServiceFactory;
import org.dfe.components.validation.ValidatorFactory;
import org.dfe.components.wsdl.ConfigureProviderFactory;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.process.nf.NfProcessService;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.internal.process.NfProcess;
import org.dfe.services.nf.query_protocol.NfeQueryProtocolService;
import org.dfe.services.nf.query_protocol.NfeQueryProtocolServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
public final class NfeManifestationServiceImpl implements NfeManifestationService {
    private final NfeConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final NfProcessService process = NfProcess.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
    private NfeQueryProtocolService nfeQueryProtocolService;

    @Override
    public NfeQueryProtocolService getNfeQueryProtocolService() {
        if (Objects.isNull(nfeQueryProtocolService))
            setNfeQueryProtocolService(new NfeQueryProtocolServiceImpl(getConfig()));
        return nfeQueryProtocolService;
    }
}
