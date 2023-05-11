package com.softart.dfe.models.nf.query_protocol;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
import br.inf.portalfiscal.nfe.send.TRetConsSitNFe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import com.softart.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.common.NfQueryProtocolValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record QueryProtocolRequest(
        TConsSitNFe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfQueryProtocolValidator> validators,
        Collection<BeforeQueryProtocol> beforeRequest,
        Collection<AfterQueryProtocol> afterRequest
) implements SefazRequest<TConsSitNFe, TRetConsSitNFe> {

}
