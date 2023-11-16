package org.dfe.enums.nf;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFSend implements DFEnum.Codeable {

    ASYNC("0", "Processamento assíncrono"),

    SYNC("1", "Processamento síncrono");

    private final String code;
    private final String description;

    NFSend(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFSend valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
