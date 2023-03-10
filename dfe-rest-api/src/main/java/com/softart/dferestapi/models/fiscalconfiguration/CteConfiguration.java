package com.softart.dferestapi.models.fiscalconfiguration;

import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CteConfiguration {

    @NotNull
    @Builder.Default
    @Min(0)
    @Column(name = "cte_serie", columnDefinition = "TINYINT DEFAULT 0", nullable = false)
    private Short serie = 0;

    @Builder.Default
    @NotNull
    @Min(0)
    @Column(name = "cte_number_production", columnDefinition = "INT DEFAULT 0", nullable = false)
    private Integer numberProduction = 0;

    @Builder.Default
    @NotNull
    @Min(0)
    @Column(name = "cte_number_homologation", columnDefinition = "INT DEFAULT 0", nullable = false)
    private Integer numberHomologation = 0;

    @Builder.Default
    @Column(name = "cte_emission_type", columnDefinition = "VARCHAR(255) DEFAULT 'NORMAL'", nullable = false)
    @Enumerated(EnumType.STRING)
    private CteEmissionType emissionType = CteEmissionType.NORMAL;

    @Builder.Default
    @Column(name = "cte_environment", columnDefinition = "VARCHAR(255) DEFAULT 'HOMOLOGATION'", nullable = false)
    @Enumerated(EnumType.STRING)
    private Environment environment = Environment.HOMOLOGATION;

}
