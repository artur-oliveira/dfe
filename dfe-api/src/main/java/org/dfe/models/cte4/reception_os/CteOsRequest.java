package org.dfe.models.cte4.reception_os;

import br.inf.portalfiscal.cte.send400.TCTeOS;
import br.inf.portalfiscal.cte.send400.TRetCTeOS;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte4.reception_os.AfterReceptionCteOs;
import org.dfe.interfaces.process.cte4.reception_os.BeforeReceptionCteOs;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte4.Cte4ReceptionCteOsValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record CteOsRequest(
        TCTeOS data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<Cte4ReceptionCteOsValidator> validators,
        Collection<BeforeReceptionCteOs> beforeRequest,
        Collection<AfterReceptionCteOs> afterRequest
) implements SefazRequest<TCTeOS, TRetCTeOS> {


}
