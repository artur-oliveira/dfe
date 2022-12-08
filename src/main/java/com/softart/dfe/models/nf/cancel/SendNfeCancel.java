package com.softart.dfe.models.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import com.softart.dfe.enums.nf.version.NFEventVersion;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.DFObject;
import com.softart.dfe.interfaces.xml.XMLAdapter;
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
public class SendNfeCancel implements DFObject, XMLAdapter<SendNfeCancel, TEnvEvento> {

    protected final String idLote = StringUtils.random();
    protected final String versao = NFEventVersion.getDefault().getVersion();
    protected List<NfeCancel> evento;

    public static SendNfeCancel build(NfeCancel event) {
        return SendNfeCancel.builder().evento(Collections.singletonList(event)).build();
    }

    public static SendNfeCancel cancel(String chaveDeAcesso, String protocolo, String motivo, String nseq, Config conf) {
        return SendNfeCancel.build(NfeCancel
                .builder()
                .infEvento(NfeCancel
                        .InfEvento
                        .builder()
                        .chNFe(chaveDeAcesso)
                        .nSeqEvento(nseq)
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .cOrgao(conf.environment().getCode())
                        .tpAmb(conf.environment().getCode())
                        .detEvento(NfeCancel.InfEvento.DetEvento.builder().nProt(protocolo).xJust(motivo).build())
                        .build())
                .build());
    }

}
