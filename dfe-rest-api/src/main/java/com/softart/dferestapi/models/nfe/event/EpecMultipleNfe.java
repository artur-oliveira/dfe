package com.softart.dferestapi.models.nfe.event;

import br.inf.portalfiscal.nfe.event_epec.TUf;
import com.softart.dfe.enums.nf.identification.NFType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class EpecMultipleNfe {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class EpecData {
        @NotBlank
        @Size(min = 44, max = 44)
        private String chNFe;
        @NotNull
        private Date dhEmi;
        @NotNull
        private NFType tpNF;
        @NotNull
        private TUf uf;
        @NotBlank
        private String cnpj;
        @NotBlank
        private String cpf;
        @NotBlank
        private String idEstrangeiro;
        @NotBlank
        private String ie;
        @NotBlank
        private String ieDest;
        @NotNull
        @DecimalMin("0.00")
        private BigDecimal vnf;
        @NotNull
        @DecimalMin("0.00")
        private BigDecimal vicms;
        @NotNull
        @DecimalMin("0.00")
        private BigDecimal vst;
    }


    @NotEmpty
    @Valid
    private List<EpecData> data;
}
