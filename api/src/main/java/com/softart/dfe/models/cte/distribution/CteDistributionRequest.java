package com.softart.dfe.models.cte.distribution;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.cte.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.cte.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.cte.CteDistributionValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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
