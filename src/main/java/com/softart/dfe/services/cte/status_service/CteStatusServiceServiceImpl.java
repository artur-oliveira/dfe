package com.softart.dfe.services.cte.status_service;

import com.softart.dfe.components.sefaz.DfeFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.process.cte.CteProcess;
import com.softart.dfe.interfaces.xml.XMLSigner;
import com.softart.dfe.models.internal.process.DefaultCteProcess;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public final class CteStatusServiceServiceImpl extends AbstractCteStatusServiceService {
    private final CteConfig config;
    private final XMLSigner xmlSigner;
    private final CteProcess process = new DefaultCteProcess();
    private final DfeFactory providerFactory = DfeFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
}
