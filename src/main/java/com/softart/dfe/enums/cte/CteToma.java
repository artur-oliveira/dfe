package com.softart.dfe.enums.cte;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteToma implements DFEnum.Codeable {
    REMITTER("0", "Remetente"),
    DISPATCHER("1", "Expedidor"),
    RECEIVER("2", "Recebedor"),
    REMITTEE("3", "Destinatário"),
    OTHER("4", "Outro"),
    ;

    private final String code;
    private final String description;

    public static CteToma valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
