package com.softart.dfe.enums.cte.info.charge;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CteChargeUnid implements DFEnum.Codeable {
    M3("00", "M3"),

    KG("01", "KG"),

    TON("02", "TON"),

    UNIDADE("03", "UNIDADE"),

    LITROS("04", "LITROS"),

    MMBTU("05", "MMBTU");

    private final String code;
    private final String description;

    public static CteChargeUnid valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
