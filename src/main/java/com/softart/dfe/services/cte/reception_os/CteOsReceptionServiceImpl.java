package com.softart.dfe.services.cte.reception_os;

import com.softart.dfe.components.sefaz.DfeFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.process.cte.CteProcess;
import com.softart.dfe.interfaces.xml.XMLSigner;
import com.softart.dfe.models.internal.process.DefaultCteProcess;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class CteOsReceptionServiceImpl extends AbstractCteOsReceptionService {
    private final CteConfig config;
    private final XMLSigner xmlSigner;
    private final CteProcess process = new DefaultCteProcess();
    private final DfeFactory providerFactory = DfeFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
}
