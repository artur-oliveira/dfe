package com.softart.dfe.enums.nf.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFIntermediatorIndicative implements DFEnum.Codeable {

    NO("0", "Operação sem intermediador (em site ou plataforma própria)"),
    YES("1", "Operação em site ou plataforma de terceiros (intermediadores/marketplace)");

    private final String code;
    private final String description;

    NFIntermediatorIndicative(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFIntermediatorIndicative valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
