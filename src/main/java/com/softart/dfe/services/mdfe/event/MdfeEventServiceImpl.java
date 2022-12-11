package com.softart.dfe.services.mdfe.event;

import com.softart.dfe.components.sefaz.DfeFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.process.cte.CteProcess;
import com.softart.dfe.interfaces.process.mdfe.MdfeProcess;
import com.softart.dfe.interfaces.xml.XMLSigner;
import com.softart.dfe.models.internal.process.DefaultCteProcess;
import com.softart.dfe.models.internal.process.DefaultMdfeProcess;
import com.softart.dfe.services.mdfe.query_situation.MdfeQuerySituationService;
import com.softart.dfe.services.mdfe.query_situation.MdfeQuerySituationServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
public final class MdfeEventServiceImpl extends AbstractMdfeEventService {
    private final MdfeConfig config;
    private final XMLSigner xmlSigner;
    private final MdfeProcess process = new DefaultMdfeProcess();
    private final DfeFactory providerFactory = DfeFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
    private MdfeQuerySituationService mdfeQuerySituationService;

    @Override
    public MdfeQuerySituationService getMdfeQuerySituationService() {
        if (Objects.isNull(mdfeQuerySituationService))
            setMdfeQuerySituationService(new MdfeQuerySituationServiceImpl(getConfig(), getXmlSigner()));
        return mdfeQuerySituationService;
    }
}
