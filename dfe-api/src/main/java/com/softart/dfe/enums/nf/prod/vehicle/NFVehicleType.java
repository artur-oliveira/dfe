package com.softart.dfe.enums.nf.prod.vehicle;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFVehicleType implements DFEnum.Codeable {

    CYCLOMETER("02", "CICLOMOTO"),
    SCOOTER("03", "MOTONETA"),
    MOTORCYCLE("04", "MOTOCICLO"),
    TRYCICLE("05", "TRICICLO"),
    AUTOMOBILE("06", "AUTOMÓVEL"),
    MICRO_BUS("07", "MICRO-ÔNIBUS"),
    BUS("08", "ÔNIBUS"),
    TRAILER("10", "REBOQUE"),
    SEMI_TRAILER("11", "SEMIRREBOQUE"),
    VAN("13", "CAMIONETA"),
    TRUCK("14", "CAMINHÃO"),
    TRACTOR_TRUCK("17", "CAMINHÃO TRATOR"),
    WHEELS_TRACTOR("18", "TRATOR RODAS"),
    CRAWLER_TRACTOR("19", "TRATOR ESTEIRAS"),
    MIXED_TRACTOR("20", "TRATOR MISTO"),
    QUADRICYCLE("21", "QUADRICICLO"),
    ESP_BUS("22", "ESP / ÔNIBUS"),
    MINI_TRUCK("23", "CAMINHONETE"),
    CHARGE("24", "CARGA/CAM"),
    UTILITY("25", "UTILITÁRIO"),
    ENGINE_HOME("26", "MOTOR-CASA");

    private final String code;
    private final String description;

    NFVehicleType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFVehicleType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}

