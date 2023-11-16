package org.dfe.enums.nf.prod.vehicle;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFVehicleFuelType implements DFEnum.Codeable {

    ALCOHOL("01", "Álcool"),
    GASOLINE("02", "Gasolina"),
    DIESEL("03", "Diesel"),
    GASGEN("04", "Gasogênio"),
    METHANE("05", "Gás Metano"),
    ELETRIC_INTERNAL_FONT("06", "Elétrico/Fonte Interna"),
    ELETRIC_EXTERNAL_FONT("07", "Elétrico/Fonte Externa"),
    GASOLINE_COMBUSTIVE_NATURAL_GAS("08", "Gasolina/Gás Natural Combustível"),
    ALCOHOL_COMBUSTIVE_NATURAL_GAS("09", "Álcool/Gás Natural Combustível"),
    DIESEL_COMBUSTIVE_NATURAL_GAS("10", "Diesel/Gas Natural Combustível"),
    OBSERVATION("11", "Vide/Campo/Observação"),
    ALCOHOL_VEHICULAR_NATURAL_GAS("12", "Álcool/Gás Natural Veicular"),
    GASOLINE_VEHICULAR_NATURAL_GAS("13", "Gasolina/Gás Natural Veicular"),
    DIESEL_VEHICULAR_NATURAL_GAS("14", "Diesel/Gás Natural Veicular"),
    VEHICULAR_NATURAL_GAS("15", "Gás Natural Veicular"),
    ALCOHOL_GASOLINE("16", "Álcool/Gasolina"),
    GASOLINE_ALCOHOL_VEHICULAR_NATURAL_GAS("17", "Gasolina/Álcool/Gás Natural Veicular"),
    GASOLINE_ELETRIC("18", "Gasolina/eletrico");

    private final String code;
    private final String description;

    NFVehicleFuelType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFVehicleFuelType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
