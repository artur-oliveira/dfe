package com.softart.dfe.interfaces.process.nf.substitute_cancel;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;

public interface AfterSubstituteCancel extends AfterWebServiceRequest<TEnvEvento, TRetEnvEvento> {
}
