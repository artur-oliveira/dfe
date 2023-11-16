package org.dfe.models.cte.inutilization;

import br.inf.portalfiscal.cte.send.TInutCTe;
import br.inf.portalfiscal.cte.send.TRetInutCTe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import org.dfe.interfaces.process.cte.inutilization.BeforeInutilization;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte.CteInutilizationValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;


@Builder
public record CteInutilizationRequest(
        TInutCTe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<CteInutilizationValidator> validators,
        Collection<BeforeInutilization> beforeRequest,
        Collection<AfterInutilization> afterRequest
) implements SefazRequest<TInutCTe, TRetInutCTe> {
}
