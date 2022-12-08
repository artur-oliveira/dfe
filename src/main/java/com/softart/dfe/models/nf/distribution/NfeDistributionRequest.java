package com.softart.dfe.models.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.nf.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.NfeDistributionValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSigner;
import lombok.*;

import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class NfeDistributionRequest implements SefazRequest<TDistDFeInt, TRetDistDFeInt> {
    public TDistDFeInt data;
    public Config config;
    public XMLSigner signer;
    public ConfigureProvider configureProvider;
    public Collection<NfeDistributionValidator> validators;
    public Collection<BeforeDistribution> beforeRequest;
    public Collection<AfterDistribution> afterRequest;

}
