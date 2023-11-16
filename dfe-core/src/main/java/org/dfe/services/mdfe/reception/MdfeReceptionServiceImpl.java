package org.dfe.services.mdfe.reception;

import org.dfe.components.security.signer.XmlSigner;
import org.dfe.components.sefaz.DfeServiceFactory;
import org.dfe.components.validation.ValidatorFactory;
import org.dfe.components.wsdl.ConfigureProviderFactory;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.process.mdfe.MdfeProcessService;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.internal.process.MdfeProcess;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public final class MdfeReceptionServiceImpl implements MdfeReceptionService {
    private final MdfeConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final MdfeProcessService process = MdfeProcess.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
}
