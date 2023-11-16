package org.dfe.enums.nf.recipient;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFRecipientIndicative implements DFEnum.Codeable {

    ICMS("1", "Contribuinte ICMS (informar a IE do destinatário);"),
    EXCEPMT("2", "Contribuinte isento de Inscrição no cadastro de Contribuintes"),
    NON_CONTRIBUTOR("9", "Não Contribuinte, que pode ou não possuir Inscrição");

    private final String code;
    private final String description;

    NFRecipientIndicative(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFRecipientIndicative valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
