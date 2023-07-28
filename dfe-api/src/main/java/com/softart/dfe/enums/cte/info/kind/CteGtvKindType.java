package com.softart.dfe.enums.cte.info.kind;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteGtvKindType implements DFEnum.Codeable {
    NUMERIC("1", "Numerário"),
    CHECK("2", "Cheque"),
    COIN("3", "Moeda"),
    OTHER("4", "Outros"),
    ;

    private final String code;
    private final String description;

    public static CteGtvKindType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
