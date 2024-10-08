package org.dfe.enums.mdfe.distribution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@Getter
@AllArgsConstructor
public enum MdfeDfeCompression implements DFEnum.Codeable {
    NO("0", "Sem compactação"),
    GZIP("1", "Compactação padrão GZip");

    private final String code;
    private final String description;
}
