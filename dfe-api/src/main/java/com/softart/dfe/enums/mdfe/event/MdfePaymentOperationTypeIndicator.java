package com.softart.dfe.enums.mdfe.event;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfePaymentOperationTypeIndicator implements DFEnum.Codeable {
    IN_CASH("0", "Pagamento à Vista"),
    DEFERRED("1", "Pagamento à Prazo");
    private final String code;
    private final String description;

    public static MdfePaymentOperationTypeIndicator valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
