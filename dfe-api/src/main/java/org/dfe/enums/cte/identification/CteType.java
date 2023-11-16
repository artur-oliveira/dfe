package org.dfe.enums.cte.identification;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteType implements DFEnum.Codeable {
    NORMAL("0", "CT-e Normal"),
    VALUES_COMPLEMENT("1", "CT-e de Complemento de Valores"),
    ANULLMENT("2", "CT-e de Anulação"),
    SUBSTITUTE("3", "CT-e Substituto"),
    GTVE("4", "GTV-e");

    private final String code;
    private final String description;

    public static CteType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
