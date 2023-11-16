package org.dfe.enums.nf.identification;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;


@Getter
public enum NFPrintType implements DFEnum.Codeable {

    NO_DANFE("0", "Sem geração de DANFE"),
    PORTRAIT_DANFE("1", "DANFE normal, Retrato"),
    LANDSCAPE_DANFE("2", "DANFE normal, Paisagem"),
    SIMPLIFIED_DANFE("3", "DANFE Simplificado;"),
    NFCE_DANFE("4", "DANFE NFC-e"),
    NFE_ELETRONIC_MESSAGE_DANFE("5", "DANFE NFC-e em mensagem eletrônica");

    private final String code;
    private final String description;

    NFPrintType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFPrintType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
