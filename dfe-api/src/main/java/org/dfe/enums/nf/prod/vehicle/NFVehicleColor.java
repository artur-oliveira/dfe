package org.dfe.enums.nf.prod.vehicle;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;


@Getter
public enum NFVehicleColor implements DFEnum.Codeable {

    YELLOW("01", "Amarelo"),
    BLUE("02", "Azul"),
    BEIGE("03", "Bege"),
    WHITE("04", "Branca"),
    GREY("05", "Cinza"),
    GOLDEN("06", "Dourada"),
    GARNET("07", "Grená"),
    ORANGE("08", "Laranja"),
    BROWN("09", "Marrom"),
    SILVER("10", "Prata"),
    BLACK("11", "Preta"),
    PINK("12", "Rosa"),
    PURPLE("13", "Roxa"),
    GREEN("14", "Verde"),
    RED("15", "Vermelha"),
    FANTASY("16", "Fantasia");

    private final String code;
    private final String description;

    NFVehicleColor(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFVehicleColor valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
