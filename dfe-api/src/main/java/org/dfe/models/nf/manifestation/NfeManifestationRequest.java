package org.dfe.models.nf.manifestation;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import org.dfe.interfaces.process.nf.manifestation.BeforeManifestation;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.NfeManifestationValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record NfeManifestationRequest(
        TEnvEvento data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfeManifestationValidator> validators,
        Collection<BeforeManifestation> beforeRequest,
        Collection<AfterManifestation> afterRequest
) implements SefazRequest<TEnvEvento, TRetEnvEvento> {

}
