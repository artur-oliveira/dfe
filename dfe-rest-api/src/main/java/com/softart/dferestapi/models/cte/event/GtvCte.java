package com.softart.dferestapi.models.cte.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.models.cte.event.CteGtv;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class GtvCte {
    @JsonIgnore
    private String chCTe;
    @Size(min = 1)
    private String nSeqEvento;
    @NotEmpty
    @Size(min = 1)
    private List<CteGtv.InfEvento.DetEvento.EvGTV.InfGTV> infGTV;
}
