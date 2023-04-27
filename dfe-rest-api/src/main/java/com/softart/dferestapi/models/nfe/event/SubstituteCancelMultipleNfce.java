package com.softart.dferestapi.models.nfe.event;

import com.softart.dfe.enums.nf.NFEvent;
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
public final class SubstituteCancelMultipleNfce {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class SubstituteCancelNfceData {
        @Size(min = 44, max = 44)
        @NotBlank
        private String chNFe;
        @Size(min = 44, max = 44)
        @NotBlank
        private String chNFeRef;
        @Size(min = 15)
        @NotBlank
        @Builder.Default
        private String xJust = NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage();
        @NotBlank
        @Size(min = 15)
        private String nProt;
    }

    @NotEmpty
    @Valid
    private List<SubstituteCancelNfceData> data;
}
