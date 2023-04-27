package com.softart.dferestapi.models.cte.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class MultimodalCte {
    @JsonIgnore
    private String chCTe;
    @Size(min = 1)
    private String nSeqEvento;
    private String xRegistro;
    private String nDoc;
}
