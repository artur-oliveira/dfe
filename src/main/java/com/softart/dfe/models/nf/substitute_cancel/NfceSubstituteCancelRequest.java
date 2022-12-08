package com.softart.dfe.models.nf.substitute_cancel;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.nf.NfceSubstituteCancelValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSigner;
import lombok.*;

import java.util.Collection;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class NfceSubstituteCancelRequest implements SefazRequest<TEnvEvento, TRetEnvEvento> {

    public TEnvEvento data;
    public Config config;
    public XMLSigner signer;
    public ConfigureProvider configureProvider;
    public Collection<NfceSubstituteCancelValidator> validators;
    public Collection<BeforeSubstituteCancel> beforeRequest;
    public Collection<AfterSubstituteCancel> afterRequest;

}
