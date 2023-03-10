package com.softart.dferestapi.models.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.enums.nf.emitter.CRT;
import com.softart.dfe.enums.nf.recipient.NFRecipientIndicative;
import com.softart.dfe.util.Functions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public final class BasicInfo {
    @CNPJ
    @Size(max = 14, min = 14)
    @Column(name = "cnpj")
    private String cnpj;
    @CPF
    @Size(max = 11, min = 11)
    @Column(name = "cpf")
    private String cpf;

    @Size(min = 2)
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 1)
    @Column(name = "fantasy_name", nullable = false)
    private String fantasyName;

    @Size(min = 2)
    @Column(name = "state_registration")
    private String stateRegistration;

    @Size(min = 2)
    @Column(name = "substitute_state_registration")
    private String substituteStateRegistration;

    @Size(min = 2)
    @Column(name = "city_registration")
    private String cityRegistration;

    @Size(min = 7, max = 7)
    @Column(name = "cnae")
    private String cnae;

    @Column(name = "crt", columnDefinition = "VARCHAR(255) DEFAULT 'NORMAL'", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private CRT crt = CRT.NORMAL;

    @Column(name = "recipient_indicative", columnDefinition = "VARCHAR(255) DEFAULT 'ICMS'", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private NFRecipientIndicative recipientIndicative = NFRecipientIndicative.ICMS;

    @Column(name = "email")
    @Email
    private String email;

    @Transient
    @AssertTrue
    @JsonIgnore
    public boolean hasCpfOrCnpj() {
        return !Functions.isNullOrEmpty(getCnpj()) || !Functions.isNullOrEmpty(getCpf());
    }

    @Transient
    @AssertTrue
    @JsonIgnore
    public boolean isOnlyCpfOrCnpj() {
        return Functions.isNullOrEmpty(getCnpj()) != Functions.isNullOrEmpty(getCpf());
    }
}
