package org.dfe.models.cte.distribution;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte.distribution.AfterDistribution;
import org.dfe.interfaces.process.cte.distribution.BeforeDistribution;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte.CteDistributionValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record CteDistributionRequest(
        DistDFeInt data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<CteDistributionValidator> validators,
        Collection<BeforeDistribution> beforeRequest,
        Collection<AfterDistribution> afterRequest
) implements SefazRequest<DistDFeInt, RetDistDFeInt> {
}
