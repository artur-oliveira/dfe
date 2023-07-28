package com.softart.dfe.models.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.nf.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.NfeDistributionValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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
