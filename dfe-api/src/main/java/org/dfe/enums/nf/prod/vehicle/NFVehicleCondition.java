package org.dfe.enums.nf.prod.vehicle;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFVehicleCondition implements DFEnum.Codeable {

    FINISHED("1", "Acabado"),
    UNFINISHED("2", "Inacabado"),
    SEMIFINISHED("3", "Semiacabado");

    private final String code;
    private final String description;

    NFVehicleCondition(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFVehicleCondition valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
