package org.dfe.enums.mdfe.identification;

import org.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfeTransporterType implements DFEnum.Codeable {
    ETC("1", "ETC"),
    TAC("2", "TAC"),
    CTC("3", "CTC");
    private final String code;
    private final String description;
}
