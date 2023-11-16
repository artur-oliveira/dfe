package org.dfe.enums.cte.identification;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteDateDelivery implements DFEnum.Codeable {
    UNDEFINED("0", "Sem data definida"),
    ON_DATE("1", "Na data"),
    UNTIL_DATE("2", "Até a data"),
    AS_OF_DATE("3", "A partir da data"),
    PERIOD("4", "No período");
    private final String code;
    private final String description;

    public static CteDateDelivery valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
