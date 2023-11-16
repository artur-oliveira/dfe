package org.dfe.interfaces.process.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import org.dfe.interfaces.process.AfterWebServiceRequest;

public interface AfterCorrectionLetter extends AfterWebServiceRequest<TEnvEvento, TRetEnvEvento> {
}
