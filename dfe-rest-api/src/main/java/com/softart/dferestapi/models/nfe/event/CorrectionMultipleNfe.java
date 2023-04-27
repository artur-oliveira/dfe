package com.softart.dferestapi.models.nfe.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CorrectionMultipleNfe {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class CorrectionData {
        @Size(min = 44, max = 44)
        @NotBlank
        private String chNFe;

        @Size(min = 15)
        @NotBlank
        private String xCorrecao;

        @NotBlank
        @Size(min = 1)
        private String nSeqEvento;
    }


    @NotEmpty
    @Valid
    private List<CorrectionData> data;
}
