package com.softart.dfe.enums.cte.modal;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CteWaterwayNavigation implements DFEnum.Codeable {
    CODE_0("0", "Interior"),
    CODE_1("1", "Cabotagem"),
    ;

    private final String code;
    private final String description;

    public static CteWaterwayNavigation valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
