package com.softart.dfe.enums.cte.info.document;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CteNfType implements DFEnum.Codeable {
    AVULSA("01", "NF Modelo 01/1A e Avulsa"),
    PRODUCER("04", "NF de Produtor");
    private final String code;
    private final String description;

    public static CteNfType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
