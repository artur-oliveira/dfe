package com.softart.dfe.interfaces.process.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;

public interface AfterInterestedActor extends AfterWebServiceRequest<TEnvEvento, TRetEnvEvento> {
}
