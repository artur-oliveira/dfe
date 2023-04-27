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
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public final class QueryGtinRequest implements SefazRequest<TConsGTIN, TRetConsGTIN> {

    public TConsGTIN data;
    public Config config;
    public XMLSignerService signer;
    public ConfigureProvider configureProvider;
    public Collection<NfQueryGtinValidator> validators;
    public Collection<BeforeQueryGtin> beforeRequest;
    public Collection<AfterQueryGtin> afterRequest;

}
