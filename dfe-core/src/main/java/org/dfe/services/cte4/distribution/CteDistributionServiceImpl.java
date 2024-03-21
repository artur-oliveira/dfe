package org.dfe.services.cte4.distribution;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.dfe.components.security.signer.XmlSigner;
import org.dfe.components.sefaz.DfeServiceFactory;
import org.dfe.components.validation.ValidatorFactory;
import org.dfe.components.wsdl.ConfigureProviderFactory;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.process.cte4.Cte4ProcessService;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.internal.process.Cte4Process;

@RequiredArgsConstructor
@Getter
@Setter
public final class CteDistributionServiceImpl implements CteDistributionService {
    private final CteConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final Cte4ProcessService process = Cte4Process.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
}
