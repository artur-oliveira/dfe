package org.dfe.models.nf.substitute_cancel;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import org.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.NfceSubstituteCancelValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;


@Builder
public record NfceSubstituteCancelRequest(
        TEnvEvento data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfceSubstituteCancelValidator> validators,
        Collection<BeforeSubstituteCancel> beforeRequest,
        Collection<AfterSubstituteCancel> afterRequest
) implements SefazRequest<TEnvEvento, TRetEnvEvento> {


}
