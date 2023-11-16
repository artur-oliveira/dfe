package org.dfe.enums.internal.city;

import org.dfe.components.internal.DFEnum;
import org.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityDF implements DFEnum.Codeable {
    DF_BRASILIA("5300108", "Brasília"),
    ;
    private final String code;
    private final String description;

    CityDF(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public UF getUf() {
        return UF.valueOf(name().substring(0, 2));
    }
}