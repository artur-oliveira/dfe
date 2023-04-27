package com.softart.dferestapi.models.mdfe.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class TransportConfirmationMdfe {
    @JsonIgnore
    private String chMDFe;
    @Size(min = 15)
    private String nProt;
}
