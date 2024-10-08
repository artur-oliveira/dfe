package org.dfe.enums.nf.identification;

import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@Getter
public enum NFOperationDestiny implements DFEnum.Codeable {

    INTERNAL("1", "Operação interna"),
    INTERESTATE("2", "Operação interestadual"),
    EXTERIOR("3", "Operação exterior");

    private final String code;
    private final String description;

    NFOperationDestiny(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFOperationDestiny valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
