package com.softart.dfe.models.nf.query_register;

import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import com.softart.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.NfeQueryRegisterValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public final class QueryRegisterRequest implements SefazRequest<TConsCad, TRetConsCad> {

    public TConsCad data;
    public Config config;
    public XMLSignerService signer;
    public ConfigureProvider configureProvider;
    public Collection<NfeQueryRegisterValidator> validators;
    public Collection<BeforeQueryRegister> beforeRequest;
    public Collection<AfterQueryRegister> afterRequest;

}
