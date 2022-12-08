package com.softart.dfe.enums.internal.city;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityRR implements DFEnum.Codeable {
    RR_AMAJARI("1400027", "Amajari", UF.RR),
    RR_ALTO_ALEGRE("1400050", "Alto Alegre", UF.RR),
    RR_BOA_VISTA("1400100", "Boa Vista", UF.RR),
    RR_BONFIM("1400159", "Bonfim", UF.RR),
    RR_CANTA("1400175", "Cantá", UF.RR),
    RR_CARACARAI("1400209", "Caracaraí", UF.RR),
    RR_CAROEBE("1400233", "Caroebe", UF.RR),
    RR_IRACEMA("1400282", "Iracema", UF.RR),
    RR_MUCAJAI("1400308", "Mucajaí", UF.RR),
    RR_NORMANDIA("1400407", "Normandia", UF.RR),
    RR_PACARAIMA("1400456", "Pacaraima", UF.RR),
    RR_RORAINOPOLIS("1400472", "Rorainópolis", UF.RR),
    RR_SAO_JOAO_DA_BALIZA("1400506", "São João da Baliza", UF.RR),
    RR_SAO_LUIZ("1400605", "São Luiz", UF.RR),
    RR_UIRAMUTA("1400704", "Uiramutã", UF.RR),
    ;
    private final String code;
    private final String description;
    private final UF uf;

    CityRR(String code, String description, UF uf) {
        this.code = code;
        this.description = description;
        this.uf = uf;
    }
}