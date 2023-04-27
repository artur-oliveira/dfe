package com.softart.dferestapi.models.mdfe.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class CancelMdfe {
    @JsonIgnore
    private String chMDFe;

    @Size(min = 15)
    @NotBlank
    @Builder.Default
    private String xJust = MdfeEvent.CANCEL.getDefaultMessage();

    @Size(min = 15)
    private String nProt;
}
