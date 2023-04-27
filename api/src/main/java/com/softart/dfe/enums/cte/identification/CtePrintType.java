package com.softart.dfe.enums.cte.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CtePrintType implements DFEnum.Codeable {
    PORTRAIT("1", "Retrato"),
    LANDSCAPE("2", "Paisagem");

    private final String code;
    private final String description;
}
