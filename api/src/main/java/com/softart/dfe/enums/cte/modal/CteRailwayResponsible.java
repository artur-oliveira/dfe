package com.softart.dfe.enums.cte.modal;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CteRailwayResponsible implements DFEnum.Codeable {
    ORIGIN("1", "Ferrovia de origem"),
    DESTINY("2", "Ferrovia de destino");

    private final String code;
    private final String description;

    public static CteRailwayResponsible valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
