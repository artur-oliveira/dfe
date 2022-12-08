package com.softart.dfe.services.nf.cancel;

import com.softart.dfe.components.sefaz.DfeFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.process.nf.NfProcess;
import com.softart.dfe.interfaces.xml.XMLSigner;
import com.softart.dfe.models.internal.process.DefaultNfProcess;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;
import com.softart.dfe.services.nf.query_protocol.NfeQueryProtocolServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
public final class NfeCancelServiceImpl extends AbstractNfeCancelService {
    private final NfConfig config;
    private final XMLSigner xmlSigner;
    private final NfProcess process = new DefaultNfProcess();
    private final DfeFactory providerFactory = DfeFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
    private NfQueryProtocolService nfQueryProtocolService;

    public NfQueryProtocolService getNfQueryProtocolService() {
        if (Objects.isNull(nfQueryProtocolService))
            setNfQueryProtocolService(new NfeQueryProtocolServiceImpl(getConfig(), getXmlSigner()));
        return nfQueryProtocolService;
    }
}
