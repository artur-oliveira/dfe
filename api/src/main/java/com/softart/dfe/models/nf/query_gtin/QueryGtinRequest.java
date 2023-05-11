package com.softart.dfe.models.nf.query_gtin;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import com.softart.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.common.NfQueryGtinValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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
