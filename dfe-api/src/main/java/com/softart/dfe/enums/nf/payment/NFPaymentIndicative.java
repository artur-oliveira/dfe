package com.softart.dfe.enums.nf.payment;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFPaymentIndicative implements DFEnum.Codeable {

    IN_CASH("0", "Pagamento à Vista"),
    DEFERRED("1", "Pagamento à Prazo"),
    ;

    private final String code;
    private final String description;

    NFPaymentIndicative(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFPaymentIndicative valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
