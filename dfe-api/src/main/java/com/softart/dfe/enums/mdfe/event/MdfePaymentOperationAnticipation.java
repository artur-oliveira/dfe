package com.softart.dfe.enums.mdfe.event;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfePaymentOperationAnticipation implements DFEnum.Codeable {

    CODE_0("0", "Não permite antecipar"),
    CODE_1("1", "Permite antecipar as parcelas"),
    CODE_2("2", "Permite antecipar as parcelas mediante  confirmação");

    private final String code;
    private final String description;

    public static MdfePaymentOperationAnticipation valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
