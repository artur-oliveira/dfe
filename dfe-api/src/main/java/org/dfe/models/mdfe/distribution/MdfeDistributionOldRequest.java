package org.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.distribution.DistDFeInt;
import br.inf.portalfiscal.mdfe.distribution.RetDistDFeInt;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.AfterWebServiceRequest;
import org.dfe.interfaces.process.BeforeWebServiceRequest;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.Validator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;
import java.util.Collections;

@Builder
public record MdfeDistributionOldRequest(
        DistDFeInt data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider
) implements SefazRequest<DistDFeInt, RetDistDFeInt> {
    @Override
    public Collection<? extends Validator<DistDFeInt>> validators() {
        return Collections.emptyList();
    }

    @Override
    public Collection<? extends BeforeWebServiceRequest<DistDFeInt>> beforeRequest() {
        return Collections.emptyList();
    }

    @Override
    public Collection<? extends AfterWebServiceRequest<DistDFeInt, RetDistDFeInt>> afterRequest() {
        return Collections.emptyList();
    }
}
