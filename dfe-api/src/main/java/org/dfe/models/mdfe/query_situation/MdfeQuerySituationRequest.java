package org.dfe.models.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsSitMDFe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.mdfe.query_situation.AfterQuerySituation;
import org.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.mdfe.MdfeQuerySituationValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record MdfeQuerySituationRequest(
        TConsSitMDFe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<MdfeQuerySituationValidator> validators,
        Collection<BeforeQuerySituation> beforeRequest,
        Collection<AfterQuerySituation> afterRequest
) implements SefazRequest<TConsSitMDFe, TRetConsSitMDFe> {

}
