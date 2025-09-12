package org.dfe.enums.nf.payment;

import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@Getter
public enum NFPaymentIntegration implements DFEnum.Codeable {

    INTEGRATED("1", "Pagamento integrado com o sistema de automação da empresa (Ex.: equipamento TEF, Comércio Eletrônico)"),
    NOT_INTEGRATED("2", "Pagamento não integrado com o sistema de automação da empresa (Ex.: equipamento POS)"),
    ;

    private final String code;
    private final String description;

    NFPaymentIntegration(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFPaymentIntegration valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
