package com.softart.dfe.enums.cte.info.kind;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteCashType implements DFEnum.Codeable {
    NATIONAL("1", "Nacional"),
    INTERNATIONAL("2", "Internacional"),
    ;

    private final String code;
    private final String description;

    public static CteCashType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
