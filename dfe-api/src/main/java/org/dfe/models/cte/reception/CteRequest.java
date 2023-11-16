package org.dfe.models.cte.reception;

import br.inf.portalfiscal.cte.send.TEnviCTe;
import br.inf.portalfiscal.cte.send.TRetEnviCTe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte.reception.AfterReception;
import org.dfe.interfaces.process.cte.reception.BeforeReception;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte.CteReceptionCteValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record CteRequest(
        TEnviCTe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<CteReceptionCteValidator> validators,
        Collection<BeforeReception> beforeRequest,
        Collection<AfterReception> afterRequest
) implements SefazRequest<TEnviCTe, TRetEnviCTe> {
}
