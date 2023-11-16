package org.dfe.interfaces.process.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento;
import org.dfe.interfaces.process.AfterWebServiceRequest;

public interface AfterEpec extends AfterWebServiceRequest<TEnvEvento, TRetEnvEvento> {
}
