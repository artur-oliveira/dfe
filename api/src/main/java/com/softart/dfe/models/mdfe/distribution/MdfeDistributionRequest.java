package com.softart.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import br.inf.portalfiscal.mdfe.classes.TRetDistDFe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.mdfe.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.mdfe.MdfeDistributionValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.*;

import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class MdfeDistributionRequest implements SefazRequest<TDistDFe, TRetDistDFe> {
    public TDistDFe data;
    public Config config;
    public XMLSignerService signer;
    public ConfigureProvider configureProvider;
    public Collection<MdfeDistributionValidator> validators;
    public Collection<BeforeDistribution> beforeRequest;
    public Collection<AfterDistribution> afterRequest;
}
