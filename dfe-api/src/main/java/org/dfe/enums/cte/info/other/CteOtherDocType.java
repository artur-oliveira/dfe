package org.dfe.enums.cte.info.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@AllArgsConstructor
@Getter
public enum CteOtherDocType implements DFEnum.Codeable {
    DECLARATION("00", "Declaração"),
    PIPELINE("10", "Dutoviário"),
    CFE_SAT("59", "CF-e SAT"),
    NFCE("65", "NFC-e"),
    OUTROS("99", "Outros");
    private final String code;

    private final String description;

    public static CteOtherDocType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
