package com.softart.dferestapi.models.nfe;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String xJust;
}
