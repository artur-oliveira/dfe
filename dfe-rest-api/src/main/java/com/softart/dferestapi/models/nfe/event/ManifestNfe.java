package com.softart.dferestapi.models.nfe.event;

import com.softart.dfe.enums.nf.NFEvent;
import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class ManifestNfe {

    @Size(min = 44, max = 44)
    @NotBlank
    private String chNFe;
    @Size(min = 1)
    @NotBlank
    @Builder.Default
    private String nSeqEvento = "1";
    @Size(min = 15)
    private String xJust;
    @NotNull
    private NFEvent tpEvento;

    @AssertTrue
    public boolean hasTpEventoInManifestationEvents() {
        return NFEvent.manifestation().contains(getTpEvento());
    }
}
