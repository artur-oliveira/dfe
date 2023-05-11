package com.softart.dfe.models.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsSitMDFe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.mdfe.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.mdfe.MdfeQuerySituationValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record MdfeQuerySituationRequest(
        TConsSitMDFe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<MdfeQuerySituationValidator> validators,
        Collection<BeforeQuerySituation> beforeRequest,
        Collection<AfterQuerySituation> afterRequest
) implements SefazRequest<TConsSitMDFe, TRetConsSitMDFe> {

}
