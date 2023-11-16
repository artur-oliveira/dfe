package org.dfe.enums.internal.city;

import org.dfe.components.internal.DFEnum;
import org.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityAP implements DFEnum.Codeable {
    AP_SERRA_DO_NAVIO("1600055", "Serra do Navio"),
    AP_AMAPA("1600105", "Amapá"),
    AP_PEDRA_BRANCA_DO_AMAPARI("1600154", "Pedra Branca do Amapari"),
    AP_CALCOENE("1600204", "Calçoene"),
    AP_CUTIAS("1600212", "Cutias"),
    AP_FERREIRA_GOMES("1600238", "Ferreira Gomes"),
    AP_ITAUBAL("1600253", "Itaubal"),
    AP_LARANJAL_DO_JARI("1600279", "Laranjal do Jari"),
    AP_MACAPA("1600303", "Macapá"),
    AP_MAZAGAO("1600402", "Mazagão"),
    AP_OIAPOQUE("1600501", "Oiapoque"),
    AP_PORTO_GRANDE("1600535", "Porto Grande"),
    AP_PRACUUBA("1600550", "Pracuúba"),
    AP_SANTANA("1600600", "Santana"),
    AP_TARTARUGALZINHO("1600709", "Tartarugalzinho"),
    AP_VITORIA_DO_JARI("1600808", "Vitória do Jari"),
    ;
    private final String code;
    private final String description;

    CityAP(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public UF getUf() {
        return UF.valueOf(name().substring(0, 2));
    }
}