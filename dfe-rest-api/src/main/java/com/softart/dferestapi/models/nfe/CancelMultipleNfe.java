package com.softart.dferestapi.models.nfe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CancelMultipleNfe {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class CancelNfeData {
        @Size(min = 44, max = 44)
        @NotBlank
        private String chNFe;

        @Size(min = 15)
        @NotBlank
        private String xJust;

        @NotBlank
        @Size(min = 15)
        private String nProt;
    }

    @NotEmpty
    private List<CancelNfeData> data;
}
