package com.softart.dferestapi.models.mdfe.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.models.mdfe.event.MdfePaymentOperation;
import lombok.*;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class PaymentOperationMdfe {
    @JsonIgnore
    private String chMDFe;
    private MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfViagens infViagens;
    @Builder.Default
    private List<MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag> infPag = new ArrayList<>();
    @Size(min = 15)
    private String nProt;
    @Size(min = 1)
    private String nSeqEvento;
}
