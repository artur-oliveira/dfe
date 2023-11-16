package org.dfe.enums.mdfe.distribution;

import org.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfeDfeCompression implements DFEnum.Codeable {
    NO("0", "Sem compactação"),
    GZIP("1", "Compactação padrão GZip");

    private final String code;
    private final String description;
}
