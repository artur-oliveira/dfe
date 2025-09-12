package org.dfe.interfaces.process.nf.event;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
import org.dfe.interfaces.process.AfterWebServiceRequest;

public interface AfterEvent extends AfterWebServiceRequest<TEnvEvento, TRetEnvEvento> {
}
