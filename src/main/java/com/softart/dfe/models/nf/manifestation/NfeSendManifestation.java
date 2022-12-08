package com.softart.dfe.models.nf.manifestation;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFEvent;
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
public class NfeSendManifestation implements DFObject, XMLAdapter<NfeSendManifestation, TEnvEvento> {

    protected final String idLote = StringUtils.random();
    protected final String versao = NFEventVersion.getDefault().getVersion();
    protected List<NfeManifestation> evento;

    public static NfeSendManifestation build(NfeManifestation event) {
        return NfeSendManifestation.builder().evento(Collections.singletonList(event)).build();
    }

    public static NfeSendManifestation operationConfirmation(String accessKey, String sequenceNumber, Config conf) {
        return build(NfeManifestation
                .builder()
                .infEvento(NfeManifestation.InfEvento
                        .builder()
                        .tpEvento(NFEvent.OPERATION_CONFIRMATION.getCode())
                        .cOrgao(UF.RFB.getCode())
                        .tpAmb(conf.environment().getCode())
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .chNFe(accessKey)
                        .nSeqEvento(sequenceNumber)
                        .detEvento(NfeManifestation.InfEvento.DetEvento.builder().descEvento(NFEvent.OPERATION_CONFIRMATION.getDescription()).build())
                        .build())
                .build());
    }

    public static NfeSendManifestation operationScience(String accessKey, String sequenceNumber, Config conf) {
        return build(NfeManifestation
                .builder()
                .infEvento(NfeManifestation.InfEvento
                        .builder()
                        .tpEvento(NFEvent.OPERATION_SCIENCE.getCode())
                        .cOrgao(UF.RFB.getCode())
                        .tpAmb(conf.environment().getCode())
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .chNFe(accessKey)
                        .nSeqEvento(sequenceNumber)
                        .detEvento(NfeManifestation.InfEvento.DetEvento.builder().descEvento(NFEvent.OPERATION_SCIENCE.getDescription()).build())
                        .build())
                .build());
    }

    public static NfeSendManifestation operationIgnorance(String accessKey, String sequenceNumber, String motive, Config conf) {
        return build(NfeManifestation
                .builder()
                .infEvento(NfeManifestation.InfEvento
                        .builder()
                        .tpEvento(NFEvent.OPERATION_IGNORANCE.getCode())
                        .cOrgao(UF.RFB.getCode())
                        .tpAmb(conf.environment().getCode())
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .chNFe(accessKey)
                        .nSeqEvento(sequenceNumber)
                        .detEvento(NfeManifestation.InfEvento.DetEvento.builder().descEvento(NFEvent.OPERATION_IGNORANCE.getDescription()).xJust(motive).build())
                        .build())
                .build());
    }

    public static NfeSendManifestation operationNotPerformed(String accessKey, String sequenceNumber, String motive, Config conf) {
        return build(NfeManifestation
                .builder()
                .infEvento(NfeManifestation.InfEvento
                        .builder()
                        .tpEvento(NFEvent.OPERATION_NOT_PERFORMED.getCode())
                        .cOrgao(UF.RFB.getCode())
                        .tpAmb(conf.environment().getCode())
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .chNFe(accessKey)
                        .nSeqEvento(sequenceNumber)
                        .detEvento(NfeManifestation.InfEvento.DetEvento.builder().descEvento(NFEvent.OPERATION_NOT_PERFORMED.getDescription()).xJust(motive).build())
                        .build())
                .build());
    }

}
