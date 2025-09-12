package org.dfe.enums.nf.prod.vehicle;

import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@Getter
public enum NFVehicleChassis implements DFEnum.Codeable {

    RESCHEDULED("R", "Remarcado"),
    NORMAL("N", "Normal");

    private final String code;
    private final String description;

    NFVehicleChassis(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFVehicleChassis valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
