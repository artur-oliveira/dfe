package com.softart.dferestapi.models.nfe.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.enums.nf.NFEvent;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class SubstituteCancelNfce {
    @JsonIgnore
    private String chNFe;
    @JsonIgnore
    private String chNFeRef;
    @Size(min = 15)
    @NotBlank
    @Builder.Default
    private String xJust = NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage();
}
