package com.softart.dfe.enums.nf.prod;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFProductTotalityIndicative implements DFEnum.Codeable {

    YES("0", "Valor do item (vProd) não compõe o valor total da NF-e"),
    NO("1", "Valor do item (vProd) compõe o valor total da NFe (vProd) (v2.0)");

    private final String code;
    private final String description;

    NFProductTotalityIndicative(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFProductTotalityIndicative valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
