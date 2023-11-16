package org.dfe.services.mdfe.event;

import org.dfe.components.security.signer.XmlSigner;
import org.dfe.components.sefaz.DfeServiceFactory;
import org.dfe.components.validation.ValidatorFactory;
import org.dfe.components.wsdl.ConfigureProviderFactory;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.process.mdfe.MdfeProcessService;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.models.internal.process.MdfeProcess;
import org.dfe.services.mdfe.query_situation.MdfeQuerySituationService;
import org.dfe.services.mdfe.query_situation.MdfeQuerySituationServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
public final class MdfeEventServiceImpl implements MdfeEventService {
    private final MdfeConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final MdfeProcessService process = MdfeProcess.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
    private MdfeQuerySituationService mdfeQuerySituationService;

    @Override
    public MdfeQuerySituationService getMdfeQuerySituationService() {
        if (Objects.isNull(mdfeQuerySituationService))
            setMdfeQuerySituationService(new MdfeQuerySituationServiceImpl(getConfig()));
        return mdfeQuerySituationService;
    }
}
