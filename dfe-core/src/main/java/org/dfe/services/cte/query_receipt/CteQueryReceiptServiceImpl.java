package org.dfe.services.cte.query_receipt;

import org.dfe.components.security.signer.XmlSigner;
import org.dfe.components.sefaz.DfeServiceFactory;
import org.dfe.components.validation.ValidatorFactory;
import org.dfe.components.wsdl.ConfigureProviderFactory;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.process.cte.CteProcessService;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.internal.process.CteProcess;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public final class CteQueryReceiptServiceImpl implements CteQueryReceiptService {
    private final CteConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final CteProcessService process = CteProcess.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
}
