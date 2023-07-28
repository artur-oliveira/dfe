package com.softart.dfe.enums.nf.payment;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFPaymentCardBrand implements DFEnum.Codeable {

    VISA("01", "Visa"),
    MASTERCARD("02", "Mastercard"),
    AMERICAN_EXPRESS("03", "American Express"),
    SOROCRED("04", "Sorocred"),
    DINERS_CLUB("05", "Diners Club"),
    ELO("06", "Elo"),
    HIPERCARD("07", "Hipercard"),
    AURA("08", "Aura"),
    CABAL("09", "Cabal"),
    OTHER("99", "Outros"),
    ;

    private final String code;
    private final String description;

    NFPaymentCardBrand(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFPaymentCardBrand valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
