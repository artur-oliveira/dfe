package com.softart.dfe.enums.cte.modal;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CteWaterwayDirection implements DFEnum.Codeable {
    N("N", "Norte"),
    L("L", "Leste"),
    S("S", "Sul"),
    O("O", "Oeste"),
    ;

    private final String code;
    private final String description;

    public static CteWaterwayDirection valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
