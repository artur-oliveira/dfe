package com.softart.dfe.enums.internal.city;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityDF implements DFEnum.Codeable {
    DF_BRASILIA("5300108", "Brasília", UF.DF),
    ;
    private final String code;
    private final String description;
    private final UF uf;

    CityDF(String code, String description, UF uf) {
        this.code = code;
        this.description = description;
        this.uf = uf;
    }
}