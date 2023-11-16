package org.dfe.enums.cte.identification;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CteServiceType implements DFEnum.Codeable {
    NORMAL("0", "Normal"),
    SUBCONTRACTING("1", "Subcontratação"),
    REDISPATCH("2", "Redespacho"),
    INTERMEDIARY_REDISPATCH("3", "Redespacho Intermediário"),
    MULTIMODAL("4", "Serviço Vinculado a  Multimodal"),
    PEOPLE("6", "Transporte de Pessoas"),
    VALUE("7", "Transporte de Valores"),
    PACKAGE("8", "Excesso de Bagagem"),
    GTV("9", "GTV"),
    ;
    private final String code;
    private final String description;

    public static CteServiceType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
