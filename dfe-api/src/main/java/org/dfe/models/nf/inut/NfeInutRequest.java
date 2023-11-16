package org.dfe.models.nf.inut;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import br.inf.portalfiscal.nfe.send.TRetInutNFe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.inut.AfterInut;
import org.dfe.interfaces.process.nf.inut.BeforeInut;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.common.NfInutValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
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
