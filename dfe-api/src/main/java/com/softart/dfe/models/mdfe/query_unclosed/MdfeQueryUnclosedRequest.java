package com.softart.dfe.models.mdfe.query_unclosed;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.mdfe.MdfeQueryUnclosedValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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
