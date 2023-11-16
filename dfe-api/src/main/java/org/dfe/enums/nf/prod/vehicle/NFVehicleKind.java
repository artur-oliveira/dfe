package org.dfe.enums.nf.prod.vehicle;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFVehicleKind implements DFEnum.Codeable {


    PASSENGER("1", "Passageiro"),
    CHARGE("2", "Carga"),
    MIXED("3", "Misto"),
    RACE("4", "Corrida"),
    TRACTION("5", "Tração"),
    SPECIAL("6", "Especial");

    private final String code;
    private final String description;

    NFVehicleKind(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFVehicleKind valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
