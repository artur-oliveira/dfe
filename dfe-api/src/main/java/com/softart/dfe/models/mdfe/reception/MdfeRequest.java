package com.softart.dfe.models.mdfe.reception;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetEnviMDFe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.mdfe.reception.AfterReception;
import com.softart.dfe.interfaces.process.mdfe.reception.BeforeReception;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.mdfe.MdfeReceptionValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
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

