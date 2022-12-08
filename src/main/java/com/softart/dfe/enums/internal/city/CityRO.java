package com.softart.dfe.enums.internal.city;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityRO implements DFEnum.Codeable {
    RO_ALTA_FLORESTA_D_OESTE("1100015", "Alta Floresta D´oeste", UF.RO),
    RO_ARIQUEMES("1100023", "Ariquemes", UF.RO),
    RO_CABIXI("1100031", "Cabixi", UF.RO),
    RO_CACOAL("1100049", "Cacoal", UF.RO),
    RO_CEREJEIRAS("1100056", "Cerejeiras", UF.RO),
    RO_COLORADO_DO_OESTE("1100064", "Colorado do Oeste", UF.RO),
    RO_CORUMBIARA("1100072", "Corumbiara", UF.RO),
    RO_COSTA_MARQUES("1100080", "Costa Marques", UF.RO),
    RO_ESPIGAO_D_OESTE("1100098", "Espigão D´oeste", UF.RO),
    RO_GUAJARA_MIRIM("1100106", "Guajará-mirim", UF.RO),
    RO_JARU("1100114", "Jaru", UF.RO),
    RO_JI_PARANA("1100122", "Ji-paraná", UF.RO),
    RO_MACHADINHO_D_OESTE("1100130", "Machadinho D´oeste", UF.RO),
    RO_NOVA_BRASILANDIA_D_OESTE("1100148", "Nova Brasilândia D´oeste", UF.RO),
    RO_OURO_PRETO_DO_OESTE("1100155", "Ouro Preto do Oeste", UF.RO),
    RO_PIMENTA_BUENO("1100189", "Pimenta Bueno", UF.RO),
    RO_PORTO_VELHO("1100205", "Porto Velho", UF.RO),
    RO_PRESIDENTE_MEDICI("1100254", "Presidente Médici", UF.RO),
    RO_RIO_CRESPO("1100262", "Rio Crespo", UF.RO),
    RO_ROLIM_DE_MOURA("1100288", "Rolim de Moura", UF.RO),
    RO_SANTA_LUZIA_D_OESTE("1100296", "Santa Luzia D´oeste", UF.RO),
    RO_VILHENA("1100304", "Vilhena", UF.RO),
    RO_SAO_MIGUEL_DO_GUAPORE("1100320", "São Miguel do Guaporé", UF.RO),
    RO_NOVA_MAMORE("1100338", "Nova Mamoré", UF.RO),
    RO_ALVORADA_D_OESTE("1100346", "Alvorada D´oeste", UF.RO),
    RO_ALTO_ALEGRE_DOS_PARECIS("1100379", "Alto Alegre Dos Parecis", UF.RO),
    RO_ALTO_PARAISO("1100403", "Alto Paraíso", UF.RO),
    RO_BURITIS("1100452", "Buritis", UF.RO),
    RO_NOVO_HORIZONTE_DO_OESTE("1100502", "Novo Horizonte do Oeste", UF.RO),
    RO_CACAULANDIA("1100601", "Cacaulândia", UF.RO),
    RO_CAMPO_NOVO_DE_RONDONIA("1100700", "Campo Novo de Rondônia", UF.RO),
    RO_CANDEIAS_DO_JAMARI("1100809", "Candeias do Jamari", UF.RO),
    RO_CASTANHEIRAS("1100908", "Castanheiras", UF.RO),
    RO_CHUPINGUAIA("1100924", "Chupinguaia", UF.RO),
    RO_CUJUBIM("1100940", "Cujubim", UF.RO),
    RO_GOVERNADOR_JORGE_TEIXEIRA("1101005", "Governador Jorge Teixeira", UF.RO),
    RO_ITAPUA_DO_OESTE("1101104", "Itapuã do Oeste", UF.RO),
    RO_MINISTRO_ANDREAZZA("1101203", "Ministro Andreazza", UF.RO),
    RO_MIRANTE_DA_SERRA("1101302", "Mirante da Serra", UF.RO),
    RO_MONTE_NEGRO("1101401", "Monte Negro", UF.RO),
    RO_NOVA_UNIAO("1101435", "Nova União", UF.RO),
    RO_PARECIS("1101450", "Parecis", UF.RO),
    RO_PIMENTEIRAS_DO_OESTE("1101468", "Pimenteiras do Oeste", UF.RO),
    RO_PRIMAVERA_DE_RONDONIA("1101476", "Primavera de Rondônia", UF.RO),
    RO_SAO_FELIPE_D_OESTE("1101484", "São Felipe D´oeste", UF.RO),
    RO_SAO_FRANCISCO_DO_GUAPORE("1101492", "São Francisco do Guaporé", UF.RO),
    RO_SERINGUEIRAS("1101500", "Seringueiras", UF.RO),
    RO_TEIXEIROPOLIS("1101559", "Teixeirópolis", UF.RO),
    RO_THEOBROMA("1101609", "Theobroma", UF.RO),
    RO_URUPA("1101708", "Urupá", UF.RO),
    RO_VALE_DO_ANARI("1101757", "Vale do Anari", UF.RO),
    RO_VALE_DO_PARAISO("1101807", "Vale do Paraíso", UF.RO),
    ;
    private final String code;
    private final String description;
    private final UF uf;

    CityRO(String code, String description, UF uf) {
        this.code = code;
        this.description = description;
        this.uf = uf;
    }
}