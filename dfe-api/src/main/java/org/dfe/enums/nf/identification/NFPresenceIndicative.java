package org.dfe.enums.nf.identification;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFPresenceIndicative implements DFEnum.Codeable {

    NOT_APPLY("0", "Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste)"),
    PRESENTIAL("1", "Operação presencial"),
    NOT_PRESENTIAL_INTERNET("2", "Operação não presencial, pela Internet"),
    NOT_PRESENTIAL_TELEMARKETING("3", "Operação não presencial, Teleatendimento"),
    HOME_DELIVERY("4", "NFC-e em operação com entrega a domicílio"),
    PRESENTIAL_OUTSIDE_ESTABLISHMENT("5", "Operação presencial, fora do estabelecimento; (incluído NT2016.002"),
    OTHER("9", "Operação não presencial, outros");

    private final String code;
    private final String description;

    NFPresenceIndicative(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFPresenceIndicative valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
