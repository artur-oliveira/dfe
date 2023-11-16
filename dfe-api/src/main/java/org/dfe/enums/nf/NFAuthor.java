package org.dfe.enums.nf;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFAuthor implements DFEnum.Codeable {

    ISSUER("1", "Empresa emitente"),
    RECIPIENT("2", "Empresa destinatária"),
    COMPANY("3", "Empresa"),
    FISCAL("5", "Fisco"),
    RFB("6", "RFB"),
    OTHER("9", "Outros");

    private final String code;
    private final String description;

    NFAuthor(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFAuthor valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
