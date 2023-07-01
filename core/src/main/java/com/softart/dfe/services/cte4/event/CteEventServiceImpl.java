package com.softart.dfe.services.cte4.event;

import com.softart.dfe.components.security.signer.XmlSigner;
import com.softart.dfe.components.sefaz.DfeServiceFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.process.cte4.Cte4ProcessService;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.models.internal.process.Cte4Process;
import com.softart.dfe.services.cte4.query_situation.CteQuerySituationService;
import com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
public final class CteEventServiceImpl implements CteEventService {
    private final CteConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final Cte4ProcessService process = Cte4Process.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
    private CteQuerySituationService cteQuerySituationService;

    @Override
    public CteQuerySituationService getCteQuerySituationService() {
        if (Objects.isNull(cteQuerySituationService))
            setCteQuerySituationService(new CteQuerySituationServiceImpl(getConfig()));
        return cteQuerySituationService;
    }
}
