package org.dfe.models.cte.query_situation;

import br.inf.portalfiscal.cte.send.TConsSitCTe;
import br.inf.portalfiscal.cte.send.TRetConsSitCTe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte.query_situation.AfterQuerySituation;
import org.dfe.interfaces.process.cte.query_situation.BeforeQuerySituation;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte.CteQuerySituationValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record CteQuerySituationRequest(
        TConsSitCTe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<CteQuerySituationValidator> validators,
        Collection<BeforeQuerySituation> beforeRequest,
        Collection<AfterQuerySituation> afterRequest
) implements SefazRequest<TConsSitCTe, TRetConsSitCTe> {


}
