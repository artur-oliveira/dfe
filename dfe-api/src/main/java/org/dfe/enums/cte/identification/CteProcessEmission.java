package org.dfe.enums.cte.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@AllArgsConstructor
@Getter
public enum CteProcessEmission implements DFEnum.Codeable {
    APPLICATION("0", "Emissão de CT-e com aplicativo do contribuinte"),
    SEBRAE("3", "Emissão CT-e pelo contribuinte com aplicativo fornecido pelo SEBRAE");

    private final String code;
    private final String description;
}
