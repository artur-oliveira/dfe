package org.dfe.enums.nf.prod.tax;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFSubstituteICMSModality implements DFEnum.Codeable {
    TABULATED_PRICE("0", "Preço tabelado ou máximo sugerido"),
    NEGATIVE_LIST("1", "Lista Negativa (valor)"),
    POSITIVE_LIST("2", "Lista Positiva (valor)"),
    NEUTRAL("3", "Lista Neutra (valor)"),
    MVA("4", "Margem Valor Agregado (%)"),
    SCHEDULE("5", "Pauta (Valor)"),
    OPERATION_VALUE("6", "Valor da operação");

    private final String code;
    private final String description;

    NFSubstituteICMSModality(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFSubstituteICMSModality valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
