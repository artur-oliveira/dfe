package com.softart.dfe.models.nf.inut;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import br.inf.portalfiscal.nfe.send.TRetInutNFe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.inut.AfterInut;
import com.softart.dfe.interfaces.process.nf.inut.BeforeInut;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.common.NfInutValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;


@Builder
public record NfeInutRequest(
        TInutNFe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfInutValidator> validators,
        Collection<BeforeInut> beforeRequest,
        Collection<AfterInut> afterRequest
) implements SefazRequest<TInutNFe, TRetInutNFe> {


}
