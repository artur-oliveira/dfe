package org.dfe.models.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetMDFe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.mdfe.reception_sync.AfterReceptionSync;
import org.dfe.interfaces.process.mdfe.reception_sync.BeforeReceptionSync;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.mdfe.MdfeReceptionSyncValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record MdfeSyncRequest(
        TMDFe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<MdfeReceptionSyncValidator> validators,
        Collection<BeforeReceptionSync> beforeRequest,
        Collection<AfterReceptionSync> afterRequest
) implements SefazRequest<TMDFe, TRetMDFe> {

}

