package org.dfe.models.cte.reception_gtve;

import br.inf.portalfiscal.cte.send.TGTVe;
import br.inf.portalfiscal.cte.send.TRetGTVe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte.reception_gtve.AfterReceptionGtve;
import org.dfe.interfaces.process.cte.reception_gtve.BeforeReceptionGtve;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte.CteReceptionGtveValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record GtveRequest(
        TGTVe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<CteReceptionGtveValidator> validators,
        Collection<BeforeReceptionGtve> beforeRequest,
        Collection<AfterReceptionGtve> afterRequest
) implements SefazRequest<TGTVe, TRetGTVe> {

}
