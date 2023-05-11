package com.softart.dfe.models.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import com.softart.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.common.NfReturnAuthorizationValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.*;

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
