package org.dfe.enums.nf.emitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@AllArgsConstructor
@Getter
public enum CRT implements DFEnum.Codeable {
    SIMPLES("1", "Simples Nacional"),
    SIMPLES_EXCESS("2", "Simples Nacional, excesso sublimite de receita bruta;"),
    NORMAL("3", "Regime Normal"),
    MEI("4", "Simples Nacional – Microempreendedor Individual – MEI");
    private final String code;
    private final String description;

}
