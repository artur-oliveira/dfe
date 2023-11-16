package org.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import br.inf.portalfiscal.mdfe.classes.TRetDistDFe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.mdfe.distribution.AfterDistribution;
import org.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.mdfe.MdfeDistributionValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record MdfeDistributionRequest(
        TDistDFe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<MdfeDistributionValidator> validators,
        Collection<BeforeDistribution> beforeRequest,
        Collection<AfterDistribution> afterRequest
) implements SefazRequest<TDistDFe, TRetDistDFe> {


}
