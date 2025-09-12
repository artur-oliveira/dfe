package org.dfe.models.nf.event;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
import lombok.Builder;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.event.AfterEvent;
import org.dfe.interfaces.process.nf.event.BeforeEvent;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.common.NfEventValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;

import java.util.Collection;


@Builder
public record NfEventRequest(
        TEnvEvento data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfEventValidator> validators,
        Collection<BeforeEvent> beforeRequest,
        Collection<AfterEvent> afterRequest
) implements SefazRequest<TEnvEvento, TRetEnvEvento> {

}
