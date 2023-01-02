package com.softart.dfe.enums.cte.modal;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CteAerialHandling implements DFEnum.Codeable {

    CODE_01("01", "certificado do expedidor para embarque de animal vivo"),

    CODE_02("02", "artigo perigoso conforme Declaração do Expedidor anexa"),

    CODE_03("03", "somente em aeronave cargueira"),

    CODE_04("04", "artigo - declaração do expedidor não requerida"),

    CODE_05("05", "artigo perigoso em quantidade isenta"),

    CODE_06("06", "gelo seco para refrigeração (especificar no campo observações a quantidade)"),

    CODE_07("07", "não restrito (especificar a Disposição Especial no campo observações)"),

    CODE_08("08", "artigo perigoso em carga consolidada (especificar a quantidade no campo observações)"),
    CODE_09("09", "autorização da autoridade governamental anexa (especificar no campo observações)"),

    CODE_10("10", "baterias de íons de lítio em conformidade com a Seção II da PI965 – CAO"),
    CODE_11("11", "baterias de íons de lítio em conformidade com a Seção II da PI966"),
    CODE_12("12", "baterias de íons de lítio em conformidade com a Seção II da PI967"),
    CODE_13("13", "baterias de metal lítio em conformidade com a Seção II da PI968 — CAO"),

    CODE_14("14", "baterias de metal lítio em conformidade com a Seção II da PI969"),

    CODE_15("15", "baterias de metal lítio em conformidade com a Seção II da PI970"),
    CODE_99("99", "outro (especificar no campo observações)");

    private final String code;
    private final String description;

    public static CteAerialHandling valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
