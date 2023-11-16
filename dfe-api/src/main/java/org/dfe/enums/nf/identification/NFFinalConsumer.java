package org.dfe.enums.nf.identification;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFFinalConsumer implements DFEnum.Codeable {

    NO("0", "Consumidor normal"),

    YES("1", "Consumidor final");

    private final String code;
    private final String description;

    NFFinalConsumer(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFFinalConsumer valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
