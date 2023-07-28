package com.softart.dfe.models.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import com.softart.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.NfeInterestedActorValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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
