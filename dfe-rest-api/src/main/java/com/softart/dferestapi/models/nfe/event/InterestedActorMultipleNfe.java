package com.softart.dferestapi.models.nfe.event;

import com.softart.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class InterestedActorMultipleNfe {

    @NotEmpty
    @Valid
    private List<InterestedActorData> data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class InterestedActorData {
        @NotBlank
        @Size(min = 44, max = 44)
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
}
