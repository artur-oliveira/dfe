package com.softart.dfe.enums.cte.modal;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteOsHighwaysShippingType implements DFEnum.Codeable {
    CODE_1("1", "Eventual"),
    CODE_2("2", "Continuo");

    private final String code;
    private final String description;

    public static CteOsHighwaysShippingType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
