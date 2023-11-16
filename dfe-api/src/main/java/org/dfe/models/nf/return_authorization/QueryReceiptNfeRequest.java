package org.dfe.models.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import org.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.common.NfReturnAuthorizationValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record QueryReceiptNfeRequest(
        TConsReciNFe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfReturnAuthorizationValidator> validators,
        Collection<BeforeReturnAuthorization> beforeRequest,
        Collection<AfterReturnAuthorization> afterRequest
) implements SefazRequest<TConsReciNFe, TRetConsReciNFe> {


}
