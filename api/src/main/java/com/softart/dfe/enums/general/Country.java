package com.softart.dfe.enums.general;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum Country implements DFEnum.Codeable {
    BRAZIL("1058", "BRASIL");

    private final String code;
    private final String description;

    Country(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
