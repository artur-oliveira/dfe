package com.softart.dfe.enums.cte.info.insurance;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteInsuranceReponsible implements DFEnum.Codeable {

    CODE_4("4", "Emitente do CT-e OS;"),
    CODE_5("5", "Tomador de Serviço");

    private final String code;
    private final String description;

    public static CteInsuranceReponsible valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
