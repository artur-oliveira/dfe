package com.softart.dfe.enums.cte.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CteProcessEmission implements DFEnum.Codeable {
    APPLICATION("0", "Emissão de CT-e com aplicativo do contribuinte"),
    SEBRAE("3", "Emissão CT-e pelo contribuinte com aplicativo fornecido pelo SEBRAE");

    private final String code;
    private final String description;
}
