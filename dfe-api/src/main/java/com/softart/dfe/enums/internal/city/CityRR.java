package com.softart.dfe.enums.internal.city;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityRR implements DFEnum.Codeable {
    RR_AMAJARI("1400027", "Amajari"),
    RR_ALTO_ALEGRE("1400050", "Alto Alegre"),
    RR_BOA_VISTA("1400100", "Boa Vista"),
    RR_BONFIM("1400159", "Bonfim"),
    RR_CANTA("1400175", "Cantá"),
    RR_CARACARAI("1400209", "Caracaraí"),
    RR_CAROEBE("1400233", "Caroebe"),
    RR_IRACEMA("1400282", "Iracema"),
    RR_MUCAJAI("1400308", "Mucajaí"),
    RR_NORMANDIA("1400407", "Normandia"),
    RR_PACARAIMA("1400456", "Pacaraima"),
    RR_RORAINOPOLIS("1400472", "Rorainópolis"),
    RR_SAO_JOAO_DA_BALIZA("1400506", "São João da Baliza"),
    RR_SAO_LUIZ("1400605", "São Luiz"),
    RR_UIRAMUTA("1400704", "Uiramutã"),
    ;
    private final String code;
    private final String description;

    CityRR(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public UF getUf() {
        return UF.valueOf(name().substring(0, 2));
    }
}