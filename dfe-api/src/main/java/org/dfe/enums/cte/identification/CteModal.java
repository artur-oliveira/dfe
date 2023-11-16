package org.dfe.enums.cte.identification;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteModal implements DFEnum.Codeable {
    RODOVIARIO("01", "Rodoviário"),
    AEREO("02", "Aéreo"),
    AQUAVIARIO("03", "Aquaviário"),
    FERROVIARIO("04", "Ferroviário"),
    DUTOVIARIO("05", "Dutoviário"),
    MULTIMODAL("06", "Multimodal"),
    ;

    private final String code;
    private final String description;

    public static CteModal valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
