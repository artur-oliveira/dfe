package org.dfe.models.mdfe.event;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import br.inf.portalfiscal.mdfe.classes.TRetEvento;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.mdfe.event.AfterEvent;
import org.dfe.interfaces.process.mdfe.event.BeforeEvent;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.mdfe.MdfeEventValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record MdfeEventRequest(
        TEvento data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<MdfeEventValidator> validators,
        Collection<BeforeEvent> beforeRequest,
        Collection<AfterEvent> afterRequest
) implements SefazRequest<TEvento, TRetEvento> {

}
