package org.dfe.models.cte4.event;

import br.inf.portalfiscal.cte.send400.TEvento;
import br.inf.portalfiscal.cte.send400.TRetEvento;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte4.event.AfterEvent;
import org.dfe.interfaces.process.cte4.event.BeforeEvent;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte4.Cte4EventValidator;
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
        Collection<Cte4EventValidator> validators,
        Collection<BeforeEvent> beforeRequest,
        Collection<AfterEvent> afterRequest
) implements SefazRequest<TEvento, TRetEvento> {
}
