package com.softart.dferestapi.models.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.auth.RoleType;
import com.softart.dferestapi.models.fiscalconfiguration.CteConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.MdfeConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.NfceConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.NfeConfiguration;
import com.softart.dferestapi.models.info.Address;
import com.softart.dferestapi.models.info.BasicInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(
        name = "company",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_account_cpf", columnNames = {"account_id", "cpf"}),
                @UniqueConstraint(name = "unique_account_cnpj", columnNames = {"account_id", "cnpj"})
        }
)
@DynamicInsert
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "fetch.fullCompany",
                includeAllAttributes = true
        )
})
@SuppressWarnings("unused")
public final class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Valid
    @NotNull
    @Embedded
    private BasicInfo info;

    @Valid
    @NotNull
    @Embedded
    private Address address;

    @Valid
    @Embedded
    private NfeConfiguration nfeConfiguration;

    @Valid
    @Embedded
    private NfceConfiguration nfceConfiguration;

    @Valid
    @Embedded
    private CteConfiguration cteConfiguration;

    @Valid
    @Embedded
    private MdfeConfiguration mdfeConfiguration;

    @JsonIgnore
    @AssertTrue
    public boolean hasNfeConfigurationOnlyIfAccountHasRole() {
        return Objects.isNull(getNfeConfiguration()) || (Objects.nonNull(getNfeConfiguration()) && getAccount().hasRole(RoleType.NFE));
    }

    @JsonIgnore
    @AssertTrue
    public boolean hasNfceConfigurationOnlyIfAccountHasRole() {
        return Objects.isNull(getNfceConfiguration()) || (Objects.nonNull(getNfceConfiguration()) && getAccount().hasRole(RoleType.NFCE));
    }

    @JsonIgnore
    @AssertTrue
    public boolean hasCteConfigurationOnlyIfAccountHasRole() {
        return Objects.isNull(getCteConfiguration()) || (Objects.nonNull(getCteConfiguration()) && getAccount().hasRole(RoleType.CTE));
    }

    @JsonIgnore
    @AssertTrue
    public boolean hasMdfeConfigurationOnlyIfAccountHasRole() {
        return Objects.isNull(getMdfeConfiguration()) || (Objects.nonNull(getMdfeConfiguration()) && getAccount().hasRole(RoleType.MDFE));
    }
}
