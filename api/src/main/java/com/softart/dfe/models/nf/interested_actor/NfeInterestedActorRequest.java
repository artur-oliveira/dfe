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
import lombok.*;

import java.util.Collection;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class NfeInterestedActorRequest implements SefazRequest<TEnvEvento, TRetEnvEvento> {

    public TEnvEvento data;
    public Config config;
    public XMLSignerService signer;
    public ConfigureProvider configureProvider;
    public Collection<NfeInterestedActorValidator> validators;
    public Collection<BeforeInterestedActor> beforeRequest;
    public Collection<AfterInterestedActor> afterRequest;

}
