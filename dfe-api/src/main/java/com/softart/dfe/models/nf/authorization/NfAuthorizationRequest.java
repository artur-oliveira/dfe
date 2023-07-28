package com.softart.dfe.models.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import com.softart.dfe.interfaces.process.nf.authorization.BeforeAuthorization;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.common.NfAuthorizationValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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
