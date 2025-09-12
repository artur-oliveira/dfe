package org.dfe.enums.mdfe.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dfe.components.internal.DFEnum;

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
