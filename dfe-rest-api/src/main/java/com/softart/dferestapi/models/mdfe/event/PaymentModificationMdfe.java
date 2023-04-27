package com.softart.dferestapi.models.mdfe.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.models.mdfe.event.MdfePaymentModification;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class PaymentModificationMdfe {
    @JsonIgnore
    private String chMDFe;
    @Size(min = 1)
    @NotEmpty
    @Builder.Default
    private List<MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag> infPag = new ArrayList<>();
    @Size(min = 15)
    private String nProt;
    @Size(min = 1)
    private String nSeqEvento;
}
