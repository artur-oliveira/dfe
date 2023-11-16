package org.dfe.models.nf.query_register;

import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import org.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.nf.NfeQueryRegisterValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record QueryRegisterRequest(
        TConsCad data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<NfeQueryRegisterValidator> validators,
        Collection<BeforeQueryRegister> beforeRequest,
        Collection<AfterQueryRegister> afterRequest
) implements SefazRequest<TConsCad, TRetConsCad> {


}
