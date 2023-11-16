package org.dfe.models.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import org.dfe.interfaces.process.nf.authorization.BeforeAuthorization;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.common.NfAuthorizationValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;


@Builder
public record NfAuthorizationRequest(
        TEnviNFe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfAuthorizationValidator> validators,
        Collection<BeforeAuthorization> beforeRequest,
        Collection<AfterAuthorization> afterRequest
) implements SefazRequest<TEnviNFe, TRetEnviNFe> {


}
