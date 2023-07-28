package com.softart.dfe.models.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import com.softart.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import com.softart.dfe.enums.nf.version.NFEventVersion;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.util.StringUtils;
import lombok.*;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SendNfeInterestedActor implements DFObject, XMLAdapter<SendNfeInterestedActor, TEnvEvento> {

    protected final String idLote = StringUtils.random();
    protected final String versao = NFEventVersion.getDefault().getVersion();
    protected List<NfeInterestedActor> evento;

    public static SendNfeInterestedActor build(List<NfeInterestedActor> event) {
        return SendNfeInterestedActor.builder().evento(event).build();
    }

    public static SendNfeInterestedActor build(NfeInterestedActor event) {
        return build(Collections.singletonList(event));
    }

    public static SendNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj, String nseq, NFDownloadAuthorization authorization, Config config) {
        return build(NfeInterestedActor.build(accessKey, cpf, cnpj, nseq, authorization, config));
    }

    public static SendNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj, Config config) {
        return interestedActor(accessKey, cpf, cnpj, "1", config);
    }

    public static SendNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj, String nseq, Config config) {
        return interestedActor(accessKey, cpf, cnpj, nseq, NFDownloadAuthorization.YES, config);
    }

}
