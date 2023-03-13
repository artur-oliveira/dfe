package com.softart.dferestapi.models.nfe.manifestation;

import com.softart.dfe.enums.nf.NFEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
        private String nSeqEvento = "1";
        @NotNull
        private NFEvent tpEvento;

        @AssertTrue
        public boolean hasTpEventoInManifestationEvents() {
            return NFEvent.manifestation().contains(getTpEvento());
        }
    }

    private List<ManifestData> data;
}
