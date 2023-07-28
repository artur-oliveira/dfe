package com.softart.dfe.interfaces.process.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;

public interface AfterCancel extends AfterWebServiceRequest<TEnvEvento, TRetEnvEvento> {
}
