package com.softart.dfe.models.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.epec.AfterEpec;
import com.softart.dfe.interfaces.process.nf.epec.BeforeEpec;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.NfeEpecValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSigner;
import lombok.*;

import java.util.Collection;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class NfeEpecRequest implements SefazRequest<TEnvEvento, TRetEnvEvento> {

    public TEnvEvento data;
    public Config config;
    public XMLSigner signer;
    public ConfigureProvider configureProvider;
    public Collection<NfeEpecValidator> validators;
    public Collection<BeforeEpec> beforeRequest;
    public Collection<AfterEpec> afterRequest;

}
