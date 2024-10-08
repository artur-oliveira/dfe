package org.dfe.enums.cte.identification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dfe.components.internal.DFEnum;

@Getter
@RequiredArgsConstructor
public enum CteWithdraw implements DFEnum.Codeable {
    YES("0", "Sim"),
    NO("1", "Não");

    private final String code;
    private final String description;

    public static CteWithdraw valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
