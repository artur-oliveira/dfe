package org.dfe.services.nf.authorization;

import org.dfe.components.security.signer.XmlSigner;
import org.dfe.components.sefaz.DfeServiceFactory;
import org.dfe.components.validation.ValidatorFactory;
import org.dfe.components.wsdl.ConfigureProviderFactory;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.process.nf.NfProcessService;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.internal.process.NfProcess;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public final class NfceAuthorizationServiceImpl implements NfceAuthorizationService {
    private final NfceConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final NfProcessService process = NfProcess.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
}
