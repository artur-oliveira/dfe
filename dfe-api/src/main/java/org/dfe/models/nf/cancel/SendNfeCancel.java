package org.dfe.models.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import org.dfe.enums.nf.version.NFEventVersion;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.models.nf.authorization.NfProcessed;
import org.dfe.util.StringUtils;
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
public class SendNfeCancel implements DFObject, XMLAdapter<SendNfeCancel, TEnvEvento> {

    protected final String idLote = StringUtils.random();
    protected final String versao = NFEventVersion.getDefault().getVersion();
    protected List<NfeCancel> evento;

    public static SendNfeCancel build(List<NfeCancel> event) {
        return SendNfeCancel.builder().evento(event).build();
    }

    public static SendNfeCancel build(NfeCancel event) {
        return build(Collections.singletonList(event));
    }

    public static NfeCancel nfeCancel(String accessKey, String protocol, String motive, String sequenceNumber, Config conf) {
        return NfeCancel.builder().infEvento(NfeCancel
                .InfEvento
                .builder()
                .chNFe(accessKey)
                .nSeqEvento(sequenceNumber)
                .cnpj(conf.cnpj())
                .cpf(conf.cpf())
                .cOrgao(conf.uf().getCode())
                .tpAmb(conf.environment().getCode())
                .detEvento(NfeCancel.InfEvento.DetEvento.builder().nProt(protocol).xJust(motive).build())
                .build()).build();
    }

    public static NfeCancel nfeCancel(NfProcessed processed, String motive, String sequenceNumber, Config conf) {
        return NfeCancel.builder().infEvento(NfeCancel
                .InfEvento
                .builder()
                .chNFe(processed.getProtNFe().getInfProt().getChNFe())
                .nSeqEvento(sequenceNumber)
                .cnpj(conf.cnpj())
                .cpf(conf.cpf())
                .cOrgao(conf.uf().getCode())
                .tpAmb(conf.environment().getCode())
                .detEvento(NfeCancel.InfEvento.DetEvento.builder().nProt(processed.getProtNFe().getInfProt().getNProt()).xJust(motive).build())
                .build()).build();
    }

    public static SendNfeCancel cancel(String chaveDeAcesso, String protocolo, String motivo, String nseq, Config conf) {
        return SendNfeCancel.build(nfeCancel(chaveDeAcesso, protocolo, motivo, nseq, conf));
    }

    public static SendNfeCancel build(List<NfProcessed> processeds, String motive, NfConfig config) {
        return build(processeds.stream().map(it -> nfeCancel(it, motive, "1", config)).collect(Collectors.toList()));
    }

    public static SendNfeCancel build(NfProcessed processed, String motive, NfConfig config) {
        return build(Collections.singletonList(processed), motive, config);
    }
}
