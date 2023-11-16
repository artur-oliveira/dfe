package org.dfe.enums.nf.prod.vehicle;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

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
