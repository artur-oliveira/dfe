package org.dfe.models.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.distribution.AfterDistribution;
import org.dfe.interfaces.process.nf.distribution.BeforeDistribution;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.NfeDistributionValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record NfeDistributionRequest(
        TDistDFeInt data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfeDistributionValidator> validators,
        Collection<BeforeDistribution> beforeRequest,
        Collection<AfterDistribution> afterRequest
) implements SefazRequest<TDistDFeInt, TRetDistDFeInt> {

}
