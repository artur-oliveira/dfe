package org.dfe.enums.internal.city;

import org.dfe.components.internal.DFEnum;
import org.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityRO implements DFEnum.Codeable {
    RO_ALTA_FLORESTA_D_OESTE("1100015", "Alta Floresta D´oeste"),
    RO_ARIQUEMES("1100023", "Ariquemes"),
    RO_CABIXI("1100031", "Cabixi"),
    RO_CACOAL("1100049", "Cacoal"),
    RO_CEREJEIRAS("1100056", "Cerejeiras"),
    RO_COLORADO_DO_OESTE("1100064", "Colorado do Oeste"),
    RO_CORUMBIARA("1100072", "Corumbiara"),
    RO_COSTA_MARQUES("1100080", "Costa Marques"),
    RO_ESPIGAO_D_OESTE("1100098", "Espigão D´oeste"),
    RO_GUAJARA_MIRIM("1100106", "Guajará-mirim"),
    RO_JARU("1100114", "Jaru"),
    RO_JI_PARANA("1100122", "Ji-paraná"),
    RO_MACHADINHO_D_OESTE("1100130", "Machadinho D´oeste"),
    RO_NOVA_BRASILANDIA_D_OESTE("1100148", "Nova Brasilândia D´oeste"),
    RO_OURO_PRETO_DO_OESTE("1100155", "Ouro Preto do Oeste"),
    RO_PIMENTA_BUENO("1100189", "Pimenta Bueno"),
    RO_PORTO_VELHO("1100205", "Porto Velho"),
    RO_PRESIDENTE_MEDICI("1100254", "Presidente Médici"),
    RO_RIO_CRESPO("1100262", "Rio Crespo"),
    RO_ROLIM_DE_MOURA("1100288", "Rolim de Moura"),
    RO_SANTA_LUZIA_D_OESTE("1100296", "Santa Luzia D´oeste"),
    RO_VILHENA("1100304", "Vilhena"),
    RO_SAO_MIGUEL_DO_GUAPORE("1100320", "São Miguel do Guaporé"),
    RO_NOVA_MAMORE("1100338", "Nova Mamoré"),
    RO_ALVORADA_D_OESTE("1100346", "Alvorada D´oeste"),
    RO_ALTO_ALEGRE_DOS_PARECIS("1100379", "Alto Alegre Dos Parecis"),
    RO_ALTO_PARAISO("1100403", "Alto Paraíso"),
    RO_BURITIS("1100452", "Buritis"),
    RO_NOVO_HORIZONTE_DO_OESTE("1100502", "Novo Horizonte do Oeste"),
    RO_CACAULANDIA("1100601", "Cacaulândia"),
    RO_CAMPO_NOVO_DE_RONDONIA("1100700", "Campo Novo de Rondônia"),
    RO_CANDEIAS_DO_JAMARI("1100809", "Candeias do Jamari"),
    RO_CASTANHEIRAS("1100908", "Castanheiras"),
    RO_CHUPINGUAIA("1100924", "Chupinguaia"),
    RO_CUJUBIM("1100940", "Cujubim"),
    RO_GOVERNADOR_JORGE_TEIXEIRA("1101005", "Governador Jorge Teixeira"),
    RO_ITAPUA_DO_OESTE("1101104", "Itapuã do Oeste"),
    RO_MINISTRO_ANDREAZZA("1101203", "Ministro Andreazza"),
    RO_MIRANTE_DA_SERRA("1101302", "Mirante da Serra"),
    RO_MONTE_NEGRO("1101401", "Monte Negro"),
    RO_NOVA_UNIAO("1101435", "Nova União"),
    RO_PARECIS("1101450", "Parecis"),
    RO_PIMENTEIRAS_DO_OESTE("1101468", "Pimenteiras do Oeste"),
    RO_PRIMAVERA_DE_RONDONIA("1101476", "Primavera de Rondônia"),
    RO_SAO_FELIPE_D_OESTE("1101484", "São Felipe D´oeste"),
    RO_SAO_FRANCISCO_DO_GUAPORE("1101492", "São Francisco do Guaporé"),
    RO_SERINGUEIRAS("1101500", "Seringueiras"),
    RO_TEIXEIROPOLIS("1101559", "Teixeirópolis"),
    RO_THEOBROMA("1101609", "Theobroma"),
    RO_URUPA("1101708", "Urupá"),
    RO_VALE_DO_ANARI("1101757", "Vale do Anari"),
    RO_VALE_DO_PARAISO("1101807", "Vale do Paraíso"),
    ;
    private final String code;
    private final String description;

    CityRO(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public UF getUf() {
        return UF.valueOf(name().substring(0, 2));
    }
}