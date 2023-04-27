package com.softart.dfe.services.nf.cancel;

import com.softart.dfe.components.security.signer.XmlSigner;
import com.softart.dfe.components.sefaz.DfeServiceFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.interfaces.process.nf.NfProcessService;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.models.internal.process.NfProcess;
import com.softart.dfe.services.nf.query_protocol.NfeQueryProtocolService;
import com.softart.dfe.services.nf.query_protocol.NfeQueryProtocolServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
public final class NfeCancelServiceImpl implements NfeCancelService {
    private final NfeConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final NfProcessService process = NfProcess.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
    private NfeQueryProtocolService nfQueryProtocolService;

    @Override
    public NfeQueryProtocolService getNfQueryProtocolService() {
        if (Objects.isNull(nfQueryProtocolService))
            setNfQueryProtocolService(new NfeQueryProtocolServiceImpl(getConfig()));
        return nfQueryProtocolService;
    }
}
