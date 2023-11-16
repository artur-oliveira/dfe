package org.dfe.models.cte4.reception_sync;

import br.inf.portalfiscal.cte.send400.TCTe;
import br.inf.portalfiscal.cte.send400.TRetCTe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte4.reception_sync.AfterReceptionCteSync;
import org.dfe.interfaces.process.cte4.reception_sync.BeforeReceptionCteSync;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte4.Cte4ReceptionCteSyncValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record CteSyncRequest(
        TCTe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<Cte4ReceptionCteSyncValidator> validators,
        Collection<BeforeReceptionCteSync> beforeRequest,
        Collection<AfterReceptionCteSync> afterRequest
) implements SefazRequest<TCTe, TRetCTe> {


}
