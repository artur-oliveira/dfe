package com.softart.dfe.enums.internal.city;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityAC implements DFEnum.Codeable {
    AC_ACRELANDIA("1200013", "Acrelândia", UF.AC),
    AC_ASSIS_BRASIL("1200054", "Assis Brasil", UF.AC),
    AC_BRASILEIA("1200104", "Brasiléia", UF.AC),
    AC_BUJARI("1200138", "Bujari", UF.AC),
    AC_CAPIXABA("1200179", "Capixaba", UF.AC),
    AC_CRUZEIRO_DO_SUL("1200203", "Cruzeiro do Sul", UF.AC),
    AC_EPITACIOLANDIA("1200252", "Epitaciolândia", UF.AC),
    AC_FEIJO("1200302", "Feijó", UF.AC),
    AC_JORDAO("1200328", "Jordão", UF.AC),
    AC_MANCIO_LIMA("1200336", "Mâncio Lima", UF.AC),
    AC_MANOEL_URBANO("1200344", "Manoel Urbano", UF.AC),
    AC_MARECHAL_THAUMATURGO("1200351", "Marechal Thaumaturgo", UF.AC),
    AC_PLACIDO_DE_CASTRO("1200385", "Plácido de Castro", UF.AC),
    AC_PORTO_WALTER("1200393", "Porto Walter", UF.AC),
    AC_RIO_BRANCO("1200401", "Rio Branco", UF.AC),
    AC_RODRIGUES_ALVES("1200427", "Rodrigues Alves", UF.AC),
    AC_SANTA_ROSA_DO_PURUS("1200435", "Santa Rosa do Purus", UF.AC),
    AC_SENADOR_GUIOMARD("1200450", "Senador Guiomard", UF.AC),
    AC_SENA_MADUREIRA("1200500", "Sena Madureira", UF.AC),
    AC_TARAUACA("1200609", "Tarauacá", UF.AC),
    AC_XAPURI("1200708", "Xapuri", UF.AC),
    AC_PORTO_ACRE("1200807", "Porto Acre", UF.AC),
    ;
    private final String code;
    private final String description;
    private final UF uf;

    CityAC(String code, String description, UF uf) {
        this.code = code;
        this.description = description;
        this.uf = uf;
    }
}