package com.softart.dferestapi.models.info;

import com.softart.dfe.enums.general.Country;
import com.softart.dfe.enums.internal.UF;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Address {

    @NotBlank
    @Size(min = 2)
    @Column(name = "location", nullable = false)
    private String location;
    @NotBlank
    @Size(min = 2)
    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;
    @NotBlank
    @Size(min = 1)
    @Column(name = "number", nullable = false)
    private String number;
    @NotBlank
    @Column(name = "city_code", nullable = false)
    @Size(min = 7, max = 7)
    private String cityCode;
    @Column(name = "city_description", nullable = false)
    @NotBlank
    @Size(min = 7, max = 7)
    private String cityDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "uf", nullable = false)
    private UF uf;

    @Size(min = 1)
    @Column(name = "complement")
    private String complement;

    @Column(name = "country", columnDefinition = "VARCHAR(255) DEFAULT '1058'", nullable = false)
    @Builder.Default
    private Country country = Country.BRASIL;

    @Size(min = 6, max = 14)
    private String phone;

}
