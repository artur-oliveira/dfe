package org.dfe.models.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.cancel.AfterCancel;
import org.dfe.interfaces.process.nf.cancel.BeforeCancel;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.common.NfCancelValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;


@Builder
public record NfeCancelRequest(
        TEnvEvento data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfCancelValidator> validators,
        Collection<BeforeCancel> beforeRequest,
        Collection<AfterCancel> afterRequest
) implements SefazRequest<TEnvEvento, TRetEnvEvento> {

}
