package org.dfe.enums.nf.prod.tax;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;


@Getter
public enum NFCSTIPI implements DFEnum.Codeable {

    ENTRANCE_WITH_CREDIT_RECOVERY("00", "Entrada com recuperação de crédito"),
    TAXED_ENTRANCE_WITH_ZERO_ALIQUOT("01", "Entrada tributada com alíquota zero"),
    EXCEPMT_ENTRANCE("02", "Entrada isenta"),
    NOT_TAXED_ENTRANCE("03", "Entrada não-tributada"),
    IMMUNE_ENTRANCE("04", "Entrada imune"),
    ENTRANCE_WITH_SUSPENSION("05", "Entrada com suspensão"),
    OTHER_ENTRANCES("49", "Outras entradas"),
    TAXED_DEPARTURE_WITH_ZERO_ALIQUOT("51", "Saída tributada com alíquota zero"),
    EXCEPMT_DEPARTURE("52", "Saída isenta"),
    NOT_TAXED_DEPARTURE("53", "Saída não-tributada"),
    IMMUNE_DEPARTURE("54", "Saída imune"),
    DEPARTURE_WITH_SUSPENSION("55", "Saída com suspensão"),
    TAXED_DEPARTURE("50", "Saída tributada"),
    OTHER_DEPARTURES("99", "Outras saídas");

    private final String code;
    private final String description;

    NFCSTIPI(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFCSTIPI valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
