package org.dfe.models.nf.query_gtin;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import org.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.common.NfQueryGtinValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record QueryGtinRequest(
        TConsGTIN data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfQueryGtinValidator> validators,
        Collection<BeforeQueryGtin> beforeRequest,
        Collection<AfterQueryGtin> afterRequest
) implements SefazRequest<TConsGTIN, TRetConsGTIN> {

}
