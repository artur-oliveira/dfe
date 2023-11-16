package org.dfe.enums.cte.modal;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteOsHighwayVehicleProprietary implements DFEnum.Codeable {
    CODE_0("0", "TAC – Agregado"),
    CODE_1("1", "TAC Independente"),
    CODE_2("2", "Outros");

    private final String code;
    private final String description;

    public static CteOsHighwayVehicleProprietary valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
