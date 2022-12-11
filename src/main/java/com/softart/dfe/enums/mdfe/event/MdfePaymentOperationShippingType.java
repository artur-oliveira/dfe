package com.softart.dfe.enums.mdfe.event;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfePaymentOperationShippingType implements DFEnum.Codeable {
    CODE_01("01", "Vale Pedágio"),
    CODE_02("02", "Impostos, taxas e contribuições"),
    CODE_03("03", "Despesas (bancárias, meios de pagamento, outras)"),
    CODE_99("99", "Outros"),
    ;
    private final String code;
    private final String description;

    public static MdfePaymentOperationShippingType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
