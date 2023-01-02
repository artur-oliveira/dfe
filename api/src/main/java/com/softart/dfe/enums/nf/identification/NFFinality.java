package com.softart.dfe.enums.nf.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFFinality implements DFEnum.Codeable {

    NORMAL("1", "NF-e normal"),
    ADDITIONAL("2", "NF-e complementar"),
    ADJUSTMENT("3", "NF-e de ajuste"),
    DEVOLUTION("4", "Devolução de mercadoria");

    private final String code;
    private final String description;

    NFFinality(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFFinality valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
