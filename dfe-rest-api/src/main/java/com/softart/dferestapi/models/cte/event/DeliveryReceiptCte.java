package com.softart.dferestapi.models.cte.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.util.DateUtils;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class DeliveryReceiptCte {
    @JsonIgnore
    private String chCTe;
    @Size(min = 1)
    private String nSeqEvento;
    @Size(min = 15, max = 15)
    private String nProt;
    private String image;
    @Builder.Default
    private String dhEntrega = DateUtils.nowString();
    @NotNull
    private String nDoc;
    @NotNull
    private String xNome;
    @NotNull
    private String latitude;
    @NotNull
    private String longitude;
    @NotEmpty
    private List<String> nfes;

}
