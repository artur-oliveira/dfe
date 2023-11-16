package org.dfe.models.mdfe.status_service;

import br.inf.portalfiscal.mdfe.classes.TConsStatServ;
import br.inf.portalfiscal.mdfe.classes.TRetConsStatServ;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.mdfe.status_service.AfterStatusService;
import org.dfe.interfaces.process.mdfe.status_service.BeforeStatusService;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.mdfe.MdfeStatusServiceValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record MdfeStatusServiceRequest(
        TConsStatServ data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<MdfeStatusServiceValidator> validators,
        Collection<BeforeStatusService> beforeRequest,
        Collection<AfterStatusService> afterRequest
) implements SefazRequest<TConsStatServ, TRetConsStatServ> {


}
