package com.softart.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.DistDFeInt;
import br.inf.portalfiscal.mdfe.classes.RetDistDFeInt;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.mdfe.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.mdfe.MdfeDistributionValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSigner;
import lombok.*;

import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class MdfeDistributionRequest implements SefazRequest<DistDFeInt, RetDistDFeInt> {
    public DistDFeInt data;
    public Config config;
    public XMLSigner signer;
    public ConfigureProvider configureProvider;
    public Collection<MdfeDistributionValidator> validators;
    public Collection<BeforeDistribution> beforeRequest;
    public Collection<AfterDistribution> afterRequest;
}
