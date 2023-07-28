package com.softart.dfe.enums.internal.city;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityAC implements DFEnum.Codeable {
    AC_ACRELANDIA("1200013", "Acrelândia"),
    AC_ASSIS_BRASIL("1200054", "Assis Brasil"),
    AC_BRASILEIA("1200104", "Brasiléia"),
    AC_BUJARI("1200138", "Bujari"),
    AC_CAPIXABA("1200179", "Capixaba"),
    AC_CRUZEIRO_DO_SUL("1200203", "Cruzeiro do Sul"),
    AC_EPITACIOLANDIA("1200252", "Epitaciolândia"),
    AC_FEIJO("1200302", "Feijó"),
    AC_JORDAO("1200328", "Jordão"),
    AC_MANCIO_LIMA("1200336", "Mâncio Lima"),
    AC_MANOEL_URBANO("1200344", "Manoel Urbano"),
    AC_MARECHAL_THAUMATURGO("1200351", "Marechal Thaumaturgo"),
    AC_PLACIDO_DE_CASTRO("1200385", "Plácido de Castro"),
    AC_PORTO_WALTER("1200393", "Porto Walter"),
    AC_RIO_BRANCO("1200401", "Rio Branco"),
    AC_RODRIGUES_ALVES("1200427", "Rodrigues Alves"),
    AC_SANTA_ROSA_DO_PURUS("1200435", "Santa Rosa do Purus"),
    AC_SENADOR_GUIOMARD("1200450", "Senador Guiomard"),
    AC_SENA_MADUREIRA("1200500", "Sena Madureira"),
    AC_TARAUACA("1200609", "Tarauacá"),
    AC_XAPURI("1200708", "Xapuri"),
    AC_PORTO_ACRE("1200807", "Porto Acre"),
    ;
    private final String code;
    private final String description;

    CityAC(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public UF getUf() {
        return UF.valueOf(name().substring(0, 2));
    }
}