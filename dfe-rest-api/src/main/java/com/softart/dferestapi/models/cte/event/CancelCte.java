package com.softart.dferestapi.models.cte.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.enums.cte.CteEvent;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class CancelCte {
    @JsonIgnore
    private String chCTe;

    @Size(min = 15)
    @NotBlank
    @Builder.Default
    private String xJust =  CteEvent.CANCEL.getDefaultMessage();

    @Size(min = 15)
    private String nProt;
}
