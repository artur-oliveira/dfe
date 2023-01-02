package com.softart.dfe.enums.cte.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum CteEmissionType implements DFEnum.Codeable {
    NORMAL("1", "Normal"),
    EPEC("4", "EPEC pela SVC"),
    FSDA("5", "Contingência FSDA"),
    SVCRS("7", "Autorização pela SVC-RS"),
    SVCSP("8", "Autorização pela SVC-SP");

    private final String code;
    private final String description;

    CteEmissionType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
