package com.softart.dfe.enums.nf.prod.vehicle;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFVehicleOperation implements DFEnum.Codeable {

    DEALERSHIP("1", "Venda concessionária"),
    FINAL_CONSUMER("2", "Faturamento direto para consumidor final"),
    LARGE_CONSUMER("3", "Venda direta para grandes consumidores (frotista, governo, ...)"),
    OTHER("0", "Outros");

    private final String code;
    private final String description;

    NFVehicleOperation(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFVehicleOperation valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
