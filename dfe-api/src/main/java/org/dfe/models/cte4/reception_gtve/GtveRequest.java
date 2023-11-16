package org.dfe.models.cte4.reception_gtve;

import br.inf.portalfiscal.cte.send400.TGTVe;
import br.inf.portalfiscal.cte.send400.TRetGTVe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import org.dfe.interfaces.process.cte4.reception_gtve.BeforeReceptionGtve;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte4.Cte4ReceptionGtveValidator;
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
        Collection<Cte4ReceptionGtveValidator> validators,
        Collection<BeforeReceptionGtve> beforeRequest,
        Collection<AfterReceptionGtve> afterRequest
) implements SefazRequest<TGTVe, TRetGTVe> {

}
