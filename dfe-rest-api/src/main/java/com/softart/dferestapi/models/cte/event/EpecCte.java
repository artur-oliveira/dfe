package com.softart.dferestapi.models.cte.event;

import br.inf.portalfiscal.cte.send.TUf;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.models.cte.event.CteEpec;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class EpecCte {
    @JsonIgnore
    private String chCTe;
    @Builder.Default
    private String xJust = CteEvent.EPEC.getDefaultMessage();
    @NotEmpty
    private String vicms;
    @NotEmpty
    private String vicmsst;
    @NotEmpty
    private String vtPrest;
    @NotEmpty
    private String vCarga;
    private CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4 toma4;
    @NotEmpty
    private String modal;
    @NotEmpty
    private TUf ufIni;
    @NotEmpty
    private TUf ufFim;
    @NotEmpty
    private String tpCTe;
    @NotEmpty
    private String dhEmi;
}
