package org.dfe.enums.nf.prod.tax;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;


@Getter
public enum NFICMSModality implements DFEnum.Codeable {

    MVA("0", "Margem Valor Agregado (%)"),
    SCHEDULE("1", "Pauta (Valor)"),
    TABULATED_PRICE("2", "Preço Tabelado Máx. (valor)"),
    OPERATION_VALUE("3", "Valor da operação");

    private final String code;
    private final String description;

    NFICMSModality(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFICMSModality valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
