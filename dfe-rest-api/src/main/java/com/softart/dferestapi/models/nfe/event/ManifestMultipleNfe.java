package com.softart.dferestapi.models.nfe.event;

import com.softart.dfe.enums.nf.NFEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class ManifestMultipleNfe {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class ManifestData {
        @Size(min = 44, max = 44)
        @NotBlank
        private String chNFe;
        @Size(min = 15)
        private String xJust;
        @Size(min = 1)
        @NotBlank
        @Builder.Default
        private String nSeqEvento = "1";
        @NotNull
        private NFEvent tpEvento;

        @AssertTrue
        public boolean hasTpEventoInManifestationEvents() {
            return NFEvent.manifestation().contains(getTpEvento());
        }
    }


    @NotEmpty
    @Valid
    private List<ManifestData> data;
}
