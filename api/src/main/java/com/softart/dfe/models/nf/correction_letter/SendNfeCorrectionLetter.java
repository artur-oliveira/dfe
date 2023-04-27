package com.softart.dfe.models.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
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
public class SendNfeCorrectionLetter implements DFObject, XMLAdapter<SendNfeCorrectionLetter, TEnvEvento> {
    protected final String idLote = StringUtils.random();
    protected final String versao = NFEventVersion.getDefault().getVersion();
    protected List<NfeCorrectionLetter> evento;

    public static SendNfeCorrectionLetter correctionLetter(String accessKey, String correction, String nseq, Config conf) {
        return correctionLetter(Collections.singletonList(NfeCorrectionLetter.builder().infEvento(NfeCorrectionLetter.InfEvento.builder().chNFe(accessKey).nSeqEvento(nseq).cnpj(conf.cnpj()).cpf(conf.cpf()).cOrgao(conf.uf().getCode()).tpAmb(conf.environment().getCode()).detEvento(NfeCorrectionLetter.InfEvento.DetEvento.builder().xCorrecao(correction).build()).build()).build()));
    }

    public static SendNfeCorrectionLetter correctionLetter(List<NfeCorrectionLetter> evento) {
        return SendNfeCorrectionLetter.builder().evento(evento).build();
    }
}
