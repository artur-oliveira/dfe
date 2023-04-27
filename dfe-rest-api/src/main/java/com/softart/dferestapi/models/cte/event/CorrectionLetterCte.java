package com.softart.dferestapi.models.cte.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.models.cte.event.CteCorrectionLetter;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class CorrectionLetterCte {
    @JsonIgnore
    private String chCTe;
    @Size(min = 1)
    private String nSeqEvento;
    @NotEmpty
    @Builder.Default
    private List<InfCorrecao> infCorrecao = new ArrayList<>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class InfCorrecao implements DFObject, XMLAdapter<CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao, br.inf.portalfiscal.cte.send.InfCorrecao> {
        private String grupoAlterado;
        private String campoAlterado;
        private String valorAlterado;
        private String nroItemAlterado;
    }
}
