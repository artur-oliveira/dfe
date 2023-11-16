package org.dfe.enums.cte.modal;

import org.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CteAerialDangerUnidType implements DFEnum.Codeable {
    CODE_1("1", "KG"),
    CODE_2("2", "KG G (quilograma bruto)"),
    CODE_3("3", "LITROS"),
    CODE_4("4", "TI (índice de transporte para radioativos); 5- Unidades (apenas para artigos perigosos medidos em unidades que não se enquadram nos itens acima. Exemplo: baterias, celulares, equipamentos, veículos, dentre outros)"),
    ;

    private final String code;
    private final String description;

    public static CteAerialDangerUnidType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
