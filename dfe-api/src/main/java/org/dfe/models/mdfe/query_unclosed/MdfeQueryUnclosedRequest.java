package org.dfe.models.mdfe.query_unclosed;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import org.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.mdfe.MdfeQueryUnclosedValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record MdfeQueryUnclosedRequest(
        TConsMDFeNaoEnc data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<MdfeQueryUnclosedValidator> validators,
        Collection<BeforeQueryUnclosed> beforeRequest,
        Collection<AfterQueryUnclosed> afterRequest
) implements SefazRequest<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc> {

}
