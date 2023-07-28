package com.softart.dfe.models.cte4.reception_sync;

import br.inf.portalfiscal.cte.send400.TCTe;
import br.inf.portalfiscal.cte.send400.TRetCTe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.cte4.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.process.cte4.reception_sync.BeforeReceptionCteSync;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.cte4.Cte4ReceptionCteSyncValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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
