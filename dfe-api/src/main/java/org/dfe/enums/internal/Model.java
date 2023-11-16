package org.dfe.enums.internal;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;

@Getter
public enum Model implements DFEnum.Codeable {
    NFE("55", "NF-e"),
    CTE("57", "CT-e"),
    MDFE("58", "MDF-e"),
    GTVE("64", "GTV-e"),
    NFCE("65", "NFC-e"),
    CTE_OS("67", "CT-e OS");

    private final String code;
    private final String description;

    Model(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Collection<Model> hasAuthorizers() {
        return Arrays.asList(Model.NFE, Model.NFCE, Model.CTE);
    }

    public static Model valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
