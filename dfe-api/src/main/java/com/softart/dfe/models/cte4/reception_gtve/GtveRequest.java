package com.softart.dfe.models.cte4.reception_gtve;

import br.inf.portalfiscal.cte.send400.TGTVe;
import br.inf.portalfiscal.cte.send400.TRetGTVe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.BeforeReceptionGtve;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.cte4.Cte4ReceptionGtveValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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
