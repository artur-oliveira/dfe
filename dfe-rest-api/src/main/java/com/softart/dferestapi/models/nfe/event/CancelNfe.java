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
public final class CancelNfe {
    @JsonIgnore
    private String chNFe;

    @Size(min = 15)
    @NotBlank
    @Builder.Default
    private String xJust = NFEvent.CANCEL.getDefaultMessage();

    @Size(min = 15)
    private String nProt;
}
