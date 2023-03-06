package com.softart.dfe.services.cte.status_service;

import com.softart.dfe.components.security.signer.XmlSigner;
import com.softart.dfe.components.sefaz.DfeServiceFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.process.cte.CteProcessService;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.models.internal.process.CteProcess;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public final class CteStatusServiceServiceImpl implements CteStatusServiceService {
    private final CteConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final CteProcessService process = CteProcess.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
}
