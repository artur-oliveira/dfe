package com.softart.dfe.enums.cte.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;

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

    public static CteEmissionType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

    public static Collection<CteEmissionType> cte() {
        return Arrays.asList(CteEmissionType.NORMAL, CteEmissionType.EPEC, CteEmissionType.SVCRS, CteEmissionType.SVCSP);
    }
}
