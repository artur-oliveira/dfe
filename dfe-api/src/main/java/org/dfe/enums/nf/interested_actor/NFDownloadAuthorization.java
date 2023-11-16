package org.dfe.enums.nf.interested_actor;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFDownloadAuthorization implements DFEnum.Codeable {
    YES("1", "Permite o transportador autorizado pelo emitente ou destinatário autorizar outros transportadores para ter acesso ao download da NF-e"),
    NO("0", "Não permite");

    private final String code;
    private final String description;

    NFDownloadAuthorization(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFDownloadAuthorization valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
