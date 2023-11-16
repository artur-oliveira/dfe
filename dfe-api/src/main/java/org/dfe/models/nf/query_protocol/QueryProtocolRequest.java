package org.dfe.models.nf.query_protocol;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
import br.inf.portalfiscal.nfe.send.TRetConsSitNFe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import org.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.common.NfQueryProtocolValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
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
