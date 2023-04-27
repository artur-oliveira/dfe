package com.softart.dferestapi.models.nfe.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class InterestedActorNfe {
    @JsonIgnore
    private String chNFe;
    @CPF
    private String cpf;
    @CNPJ
    private String cnpj;
    @Builder.Default
    @NotBlank
    private String nseq = "1";
    @Builder.Default
    @NotNull
    private NFDownloadAuthorization tpAutorizacao = NFDownloadAuthorization.YES;

    @AssertTrue(message = "must have cpf or cnpj")
    public boolean hasCpfOrCnpj() {
        return (Objects.nonNull(getCpf()) && getCpf().trim().length() != 0) || (Objects.nonNull(getCnpj()) && getCnpj().trim().length() != 0);
    }
}
