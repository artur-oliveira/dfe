package org.dfe.models.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import org.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.NfeCorrectionLetterValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;


@Builder
public record NfeCorrectionLetterRequest(
        TEnvEvento data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfeCorrectionLetterValidator> validators,
        Collection<BeforeCorrectionLetter> beforeRequest,
        Collection<AfterCorrectionLetter> afterRequest
) implements SefazRequest<TEnvEvento, TRetEnvEvento> {

}
