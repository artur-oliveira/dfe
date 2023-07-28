package com.softart.dfe.models.cte.reception_os;

import br.inf.portalfiscal.cte.send.TCTeOS;
import br.inf.portalfiscal.cte.send.TRetCTeOS;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.cte.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.process.cte.reception_os.BeforeReceptionCteOs;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.cte.CteReceptionCteOsValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record CteOsRequest(
        TCTeOS data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<CteReceptionCteOsValidator> validators,
        Collection<BeforeReceptionCteOs> beforeRequest,
        Collection<AfterReceptionCteOs> afterRequest
) implements SefazRequest<TCTeOS, TRetCTeOS> {


}
