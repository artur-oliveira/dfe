package org.dfe.enums.nf.prod.vehicle;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFVehicleRestriction implements DFEnum.Codeable {

    NO("0", "Não há"),
    FIDUCIARY("1", "Alienação Fiduciária"),
    MERCANTILE("2", "Arrendamento Mercantil"),
    DOMAIN_RESERVATION("3", "Reserva de Domínio"),
    PLEDGE("4", "Penhor de Veículo"),
    OTHER("9", "Outras");

    private final String code;
    private final String description;

    NFVehicleRestriction(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFVehicleRestriction valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
