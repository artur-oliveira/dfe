package com.softart.dfe.services.nf.epec;

import com.softart.dfe.components.sefaz.DfeFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.process.nf.NfProcess;
import com.softart.dfe.interfaces.xml.XMLSigner;
import com.softart.dfe.models.internal.process.DefaultNfProcess;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public final class NfeEpecServiceImpl extends AbstractNfeEpecService {
    private final NfConfig config;
    private final XMLSigner xmlSigner;
    private final NfProcess process = new DefaultNfProcess();
    private final DfeFactory providerFactory = DfeFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
}
