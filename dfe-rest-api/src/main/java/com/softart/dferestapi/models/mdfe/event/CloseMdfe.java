package com.softart.dferestapi.models.mdfe.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.enums.internal.UF;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class CloseMdfe {
    @JsonIgnore
    private String chMDFe;
    @Size(min = 15)
    private String nProt;
    @NotNull
    private UF cUf;
    @NotNull
    @Size(min = 7, max = 7)
    private String cMun;

}
