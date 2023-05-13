package com.softart.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.distribution.DistDFeInt;
import br.inf.portalfiscal.mdfe.distribution.RetDistDFeInt;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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
