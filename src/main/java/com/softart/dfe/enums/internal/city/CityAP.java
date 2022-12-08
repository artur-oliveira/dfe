package com.softart.dfe.enums.internal.city;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityAP implements DFEnum.Codeable {
    AP_SERRA_DO_NAVIO("1600055", "Serra do Navio", UF.AP),
    AP_AMAPA("1600105", "Amapá", UF.AP),
    AP_PEDRA_BRANCA_DO_AMAPARI("1600154", "Pedra Branca do Amapari", UF.AP),
    AP_CALCOENE("1600204", "Calçoene", UF.AP),
    AP_CUTIAS("1600212", "Cutias", UF.AP),
    AP_FERREIRA_GOMES("1600238", "Ferreira Gomes", UF.AP),
    AP_ITAUBAL("1600253", "Itaubal", UF.AP),
    AP_LARANJAL_DO_JARI("1600279", "Laranjal do Jari", UF.AP),
    AP_MACAPA("1600303", "Macapá", UF.AP),
    AP_MAZAGAO("1600402", "Mazagão", UF.AP),
    AP_OIAPOQUE("1600501", "Oiapoque", UF.AP),
    AP_PORTO_GRANDE("1600535", "Porto Grande", UF.AP),
    AP_PRACUUBA("1600550", "Pracuúba", UF.AP),
    AP_SANTANA("1600600", "Santana", UF.AP),
    AP_TARTARUGALZINHO("1600709", "Tartarugalzinho", UF.AP),
    AP_VITORIA_DO_JARI("1600808", "Vitória do Jari", UF.AP),
    ;
    private final String code;
    private final String description;
    private final UF uf;

    CityAP(String code, String description, UF uf) {
        this.code = code;
        this.description = description;
        this.uf = uf;
    }
}