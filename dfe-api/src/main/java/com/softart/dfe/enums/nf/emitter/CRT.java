package com.softart.dfe.enums.nf.emitter;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CRT implements DFEnum.Codeable {
    SIMPLES("1", "Simples Nacional"),
    SIMPLES_EXCESS("2", "Simples Nacional, excesso sublimite de receita bruta;"),
    NORMAL("3", "Regime Normal");
    private final String code;
    private final String description;

}
