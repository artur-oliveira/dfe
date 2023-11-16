package org.dfe.enums.mdfe.identification;

import org.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfeProcessEmissionType implements DFEnum.Codeable {
    APPLICATION("0", "Emissão de MDF-e com aplicativo do contribuinte;");
    private final String code;
    private final String description;
}
