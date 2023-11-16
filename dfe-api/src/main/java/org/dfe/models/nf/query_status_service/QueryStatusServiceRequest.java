package org.dfe.models.nf.query_status_service;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import br.inf.portalfiscal.nfe.send.TRetConsStatServ;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import org.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.common.NfQueryStatusServiceValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;


@Builder
public record QueryStatusServiceRequest(
        TConsStatServ data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfQueryStatusServiceValidator> validators,
        Collection<BeforeQueryStatusService> beforeRequest,
        Collection<AfterQueryStatusService> afterRequest
) implements SefazRequest<TConsStatServ, TRetConsStatServ> {


}
