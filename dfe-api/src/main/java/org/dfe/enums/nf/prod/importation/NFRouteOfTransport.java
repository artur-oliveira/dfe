package org.dfe.enums.nf.prod.importation;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;


@Getter
public enum NFRouteOfTransport implements DFEnum.Codeable {

    MARITIME("1", "Marítima"),
    RIVER("2", "Fluvial"),
    LACOUS("3", "Lacustre"),
    AIR("4", "Aérea"),
    POSTAL("5", "Postal"),
    RAILWAY("6", "Ferroviária"),
    HIGHWAY("7", "Rodoviária");

    private final String code;
    private final String description;

    NFRouteOfTransport(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFRouteOfTransport valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
