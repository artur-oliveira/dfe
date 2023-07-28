package com.softart.dfe.enums.cte.info.unid;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CteUnidType implements DFEnum.Codeable {
    CONTAINER("1", "Container"),
    ULD("2", "ULD"),
    PALLET("3", "Pallet"),
    OTHER("4", "Outros");
    private final String code;
    private final String description;

    public static CteUnidType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
