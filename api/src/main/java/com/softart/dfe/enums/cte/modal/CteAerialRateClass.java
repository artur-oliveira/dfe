package com.softart.dfe.enums.cte.modal;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CteAerialRateClass implements DFEnum.Codeable {
    M("M", "Tarifa Mínima"),
    G("G", "Tarifa Geral"),
    E("E", "Tarifa Específica");

    private final String code;
    private final String description;

    public static CteAerialRateClass valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
