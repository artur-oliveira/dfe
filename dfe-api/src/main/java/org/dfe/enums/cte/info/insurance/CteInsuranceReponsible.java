package org.dfe.enums.cte.info.insurance;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dfe.components.internal.DFEnum;

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
