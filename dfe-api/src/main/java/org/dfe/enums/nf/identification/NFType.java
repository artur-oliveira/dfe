package org.dfe.enums.nf.identification;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFType implements DFEnum.Codeable {

    INCOMING("0", "Nota de entrada"),
    OUTGOING("1", "Nota de saída");

    private final String code;
    private final String description;

    NFType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
