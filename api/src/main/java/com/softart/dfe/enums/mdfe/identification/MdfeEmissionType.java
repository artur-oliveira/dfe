package com.softart.dfe.enums.mdfe.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfeEmissionType implements DFEnum.Codeable {
    NORMAL("1", "Normal"),
    CONTINGENCY("2", "Contingência");
    private final String code;
    private final String description;


    public static MdfeEmissionType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
