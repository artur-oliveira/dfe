package com.softart.dfe.models.nf.inut;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import br.inf.portalfiscal.nfe.send.TRetInutNFe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.inut.AfterInut;
import com.softart.dfe.interfaces.process.nf.inut.BeforeInut;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.common.NfInutValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.*;

import java.util.Collection;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class NfeInutRequest implements SefazRequest<TInutNFe, TRetInutNFe> {

    public TInutNFe data;
    public Config config;
    public XMLSignerService signer;
    public ConfigureProvider configureProvider;
    public Collection<NfInutValidator> validators;
    public Collection<BeforeInut> beforeRequest;
    public Collection<AfterInut> afterRequest;

}
