package com.softart.dfe.models.nf.substitute_cancel;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import com.softart.dfe.enums.nf.version.NFEventVersion;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.util.StringUtils;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SendNfceSubstituteCancel implements DFObject, XMLAdapter<SendNfceSubstituteCancel, TEnvEvento> {

    protected final String idLote = StringUtils.random();
    protected final String versao = NFEventVersion.getDefault().getVersion();
    protected List<NfceSubstituteCancel> evento;

    public static SendNfceSubstituteCancel build(NfceSubstituteCancel event) {
        return SendNfceSubstituteCancel.builder().evento(Collections.singletonList(event)).build();
    }

    public static SendNfceSubstituteCancel build(List<NfceSubstituteCancel.InfEvento> infEventos) {
        return SendNfceSubstituteCancel.builder().evento(infEventos.stream().map(it -> NfceSubstituteCancel.builder().infEvento(it).build()).collect(Collectors.toList())).build();
    }

    public static SendNfceSubstituteCancel cancel(String accessKey, String accessKeyRef, String protocol, String justification, String sequence, Config conf) {
        return SendNfceSubstituteCancel.build(NfceSubstituteCancel
                .builder()
                .infEvento(NfceSubstituteCancel.InfEvento.build(accessKey, accessKeyRef, protocol, justification, sequence, conf))
                .build());
    }

}
