package com.softart.dfe.models.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.cancel.AfterCancel;
import com.softart.dfe.interfaces.process.nf.cancel.BeforeCancel;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.common.NfCancelValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSigner;
import lombok.*;

import java.util.Collection;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class NfeCancelRequest implements SefazRequest<TEnvEvento, TRetEnvEvento> {

    public TEnvEvento data;
    public Config config;
    public XMLSigner signer;
    public ConfigureProvider configureProvider;
    public Collection<NfCancelValidator> validators;
    public Collection<BeforeCancel> beforeRequest;
    public Collection<AfterCancel> afterRequest;

}
