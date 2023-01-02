package com.softart.dfe.enums.cte.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteHourDelivery implements DFEnum.Codeable {
    UNDEFINED("0", "Sem data definida"),
    ON_HOUR("1", "No horário"),
    UNTIL_HOUR("2", "Até o horário"),
    AS_OF_HOUR("3", "A partir do horário"),
    INTERVAL("4", "No intervalo");
    private final String code;
    private final String description;

    public static CteHourDelivery valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
