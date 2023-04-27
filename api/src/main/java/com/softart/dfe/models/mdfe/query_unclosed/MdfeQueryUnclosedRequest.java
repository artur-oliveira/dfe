package com.softart.dfe.models.mdfe.query_unclosed;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.mdfe.MdfeQueryUnclosedValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class MdfeQueryUnclosedRequest implements SefazRequest<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc> {
    public TConsMDFeNaoEnc data;
    public Config config;
    public XMLSignerService signer;
    public ConfigureProvider configureProvider;
    public Collection<MdfeQueryUnclosedValidator> validators;
    public Collection<BeforeQueryUnclosed> beforeRequest;
    public Collection<AfterQueryUnclosed> afterRequest;
}
