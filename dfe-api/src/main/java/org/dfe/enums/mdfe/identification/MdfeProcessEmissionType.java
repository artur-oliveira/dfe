package org.dfe.enums.mdfe.identification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@Getter
@AllArgsConstructor
public enum MdfeProcessEmissionType implements DFEnum.Codeable {
    APPLICATION("0", "Emissão de MDF-e com aplicativo do contribuinte;");
    private final String code;
    private final String description;
}
