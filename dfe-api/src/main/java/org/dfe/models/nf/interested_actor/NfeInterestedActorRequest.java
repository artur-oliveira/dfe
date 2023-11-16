package org.dfe.models.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import org.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.NfeInterestedActorValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;


@Builder
public record NfeInterestedActorRequest(
        TEnvEvento data,
        Config config,
        XMLSignerService signer,

        ConfigureProvider configureProvider,
        Collection<NfeInterestedActorValidator> validators,
        Collection<BeforeInterestedActor> beforeRequest,
        Collection<AfterInterestedActor> afterRequest
) implements SefazRequest<TEnvEvento, TRetEnvEvento> {

}
