package org.dfe.models.mdfe.reception;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetEnviMDFe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.mdfe.reception.AfterReception;
import org.dfe.interfaces.process.mdfe.reception.BeforeReception;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.mdfe.MdfeReceptionValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record MdfeRequest(
        TEnviMDFe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<MdfeReceptionValidator> validators,
        Collection<BeforeReception> beforeRequest,
        Collection<AfterReception> afterRequest
) implements SefazRequest<TEnviMDFe, TRetEnviMDFe> {

}

