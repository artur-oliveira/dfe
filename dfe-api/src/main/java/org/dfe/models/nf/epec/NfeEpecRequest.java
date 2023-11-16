package org.dfe.models.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.epec.AfterEpec;
import org.dfe.interfaces.process.nf.epec.BeforeEpec;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.NfeEpecValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;


@Builder
public record NfeEpecRequest(
        TEnvEvento data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfeEpecValidator> validators,
        Collection<BeforeEpec> beforeRequest,
        Collection<AfterEpec> afterRequest
) implements SefazRequest<TEnvEvento, TRetEnvEvento> {

}
