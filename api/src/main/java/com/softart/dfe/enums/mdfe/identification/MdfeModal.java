package com.softart.dfe.enums.mdfe.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfeModal implements DFEnum.Codeable {
    RODOVIARIO("1", "Rodoviário"),
    AEREO("2", "Aéreo"),
    AQUAVIARIO("3", "Aquaviário"),
    FERROVIARIO("4", "Ferroviário");

    private final String code;
    private final String description;

    public static MdfeModal valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
