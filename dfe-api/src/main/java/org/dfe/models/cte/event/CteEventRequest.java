package org.dfe.models.cte.event;

import br.inf.portalfiscal.cte.send.TEvento;
import br.inf.portalfiscal.cte.send.TRetEvento;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte.event.AfterEvent;
import org.dfe.interfaces.process.cte.event.BeforeEvent;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte.CteEventValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record CteEventRequest(
        TEvento data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<CteEventValidator> validators,
        Collection<BeforeEvent> beforeRequest,
        Collection<AfterEvent> afterRequest
) implements SefazRequest<TEvento, TRetEvento> {
}
