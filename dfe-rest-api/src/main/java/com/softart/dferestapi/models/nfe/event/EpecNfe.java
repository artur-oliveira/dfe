package com.softart.dferestapi.models.nfe.event;

import br.inf.portalfiscal.nfe.event_epec.TUf;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.enums.nf.identification.NFType;
import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class EpecNfe {
    @JsonIgnore
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
