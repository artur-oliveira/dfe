package com.softart.dfe.models.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import com.softart.dfe.enums.internal.UF;
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
public class SendNfeEpec implements DFObject, XMLAdapter<SendNfeEpec, TEnvEvento> {

    protected final String idLote = StringUtils.random();
    protected final String versao = NFEventVersion.getDefault().getVersion();
    protected List<NfeEpec> evento;

    public static SendNfeEpec build(NfeEpec event) {
        return SendNfeEpec.builder().evento(Collections.singletonList(event)).build();
    }

    public static SendNfeEpec epec(String accessKey, NfeEpec.InfEvento.DetEvento detEvento, Config config) {
        return build(NfeEpec.builder()
                .infEvento(NfeEpec.InfEvento.builder()
                        .chNFe(accessKey)
                        .tpAmb(config.environment().getCode())
                        .cnpj(config.cnpj())
                        .cpf(config.cpf())
                        .cOrgao(UF.RFB.getCode())
                        .nSeqEvento("1")
                        .detEvento(detEvento)
                        .build())
                .build());
    }

}
