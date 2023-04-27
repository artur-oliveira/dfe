package com.softart.dfe.enums.cte.modal;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CteRailwayTrafficType implements DFEnum.Codeable {
    CODE_0("0", "Próprio"),
    CODE_1("1", "Mútuo"),
    CODE_2("2", "Rodoferroviário"),
    CODE_3("3", "Rodoviário");

    private final String code;
    private final String description;

    public static CteRailwayTrafficType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
