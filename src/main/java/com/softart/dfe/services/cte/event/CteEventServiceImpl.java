package com.softart.dfe.services.cte.event;

import com.softart.dfe.components.sefaz.DfeFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.process.cte.CteProcess;
import com.softart.dfe.interfaces.xml.XMLSigner;
import com.softart.dfe.models.internal.process.DefaultCteProcess;
import com.softart.dfe.services.cte.query_situation.CteQuerySituationService;
import com.softart.dfe.services.cte.query_situation.CteQuerySituationServiceImpl;
import com.softart.dfe.services.nf.query_protocol.NfeQueryProtocolServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
public final class CteEventServiceImpl extends AbstractCteEventService {
    private final CteConfig config;
    private final XMLSigner xmlSigner;
    private final CteProcess process = new DefaultCteProcess();
    private final DfeFactory providerFactory = DfeFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
    private CteQuerySituationService cteQuerySituationService;

    @Override
    public CteQuerySituationService getCteQuerySituationService() {
        if (Objects.isNull(cteQuerySituationService))
            setCteQuerySituationService(new CteQuerySituationServiceImpl(getConfig(), getXmlSigner()));
        return cteQuerySituationService;
    }
}
