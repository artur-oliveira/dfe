package com.softart.dfe.enums.internal.city;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityMS implements DFEnum.Codeable {
    MS_AGUA_CLARA("5000203", "Água Clara"),
    MS_ALCINOPOLIS("5000252", "Alcinópolis"),
    MS_AMAMBAI("5000609", "Amambaí"),
    MS_ANASTACIO("5000708", "Anastácio"),
    MS_ANAURILANDIA("5000807", "Anaurilândia"),
    MS_ANGELICA("5000856", "Angélica"),
    MS_ANTONIO_JOAO("5000906", "Antônio João"),
    MS_APARECIDA_DO_TABOADO("5001003", "Aparecida do Taboado"),
    MS_AQUIDAUANA("5001102", "Aquidauana"),
    MS_ARAL_MOREIRA("5001243", "Aral Moreira"),
    MS_BANDEIRANTES("5001508", "Bandeirantes"),
    MS_BATAGUASSU("5001904", "Bataguassu"),
    MS_BATAYPORA("5002001", "Batayporã"),
    MS_BELA_VISTA("5002100", "Bela Vista"),
    MS_BODOQUENA("5002159", "Bodoquena"),
    MS_BONITO("5002209", "Bonito"),
    MS_BRASILANDIA("5002308", "Brasilândia"),
    MS_CAARAPO("5002407", "Caarapó"),
    MS_CAMAPUA("5002605", "Camapuã"),
    MS_CAMPO_GRANDE("5002704", "Campo Grande"),
    MS_CARACOL("5002803", "Caracol"),
    MS_CASSILANDIA("5002902", "Cassilândia"),
    MS_CHAPADAO_DO_SUL("5002951", "Chapadão do Sul"),
    MS_CORGUINHO("5003108", "Corguinho"),
    MS_CORONEL_SAPUCAIA("5003157", "Coronel Sapucaia"),
    MS_CORUMBA("5003207", "Corumbá"),
    MS_COSTA_RICA("5003256", "Costa Rica"),
    MS_COXIM("5003306", "Coxim"),
    MS_DEODAPOLIS("5003454", "Deodápolis"),
    MS_DOIS_IRMAOS_DO_BURITI("5003488", "Dois Irmãos do Buriti"),
    MS_DOURADINA("5003504", "Douradina"),
    MS_DOURADOS("5003702", "Dourados"),
    MS_ELDORADO("5003751", "Eldorado"),
    MS_FATIMA_DO_SUL("5003801", "Fátima do Sul"),
    MS_FIGUEIRAO("5003900", "Figueirão"),
    MS_GLORIA_DE_DOURADOS("5004007", "Glória de Dourados"),
    MS_GUIA_LOPES_DA_LAGUNA("5004106", "Guia Lopes da Laguna"),
    MS_IGUATEMI("5004304", "Iguatemi"),
    MS_INOCENCIA("5004403", "Inocência"),
    MS_ITAPORA("5004502", "Itaporã"),
    MS_ITAQUIRAI("5004601", "Itaquiraí"),
    MS_IVINHEMA("5004700", "Ivinhema"),
    MS_JAPORA("5004809", "Japorã"),
    MS_JARAGUARI("5004908", "Jaraguari"),
    MS_JARDIM("5005004", "Jardim"),
    MS_JATEI("5005103", "Jateí"),
    MS_JUTI("5005152", "Juti"),
    MS_LADARIO("5005202", "Ladário"),
    MS_LAGUNA_CARAPA("5005251", "Laguna Carapã"),
    MS_MARACAJU("5005400", "Maracaju"),
    MS_MIRANDA("5005608", "Miranda"),
    MS_MUNDO_NOVO("5005681", "Mundo Novo"),
    MS_NAVIRAI("5005707", "Naviraí"),
    MS_NIOAQUE("5005806", "Nioaque"),
    MS_NOVA_ALVORADA_DO_SUL("5006002", "Nova Alvorada do Sul"),
    MS_NOVA_ANDRADINA("5006200", "Nova Andradina"),
    MS_NOVO_HORIZONTE_DO_SUL("5006259", "Novo Horizonte do Sul"),
    MS_PARAISO_DAS_AGUAS("5006275", "Paraíso das Águas"),
    MS_PARANAIBA("5006309", "Paranaíba"),
    MS_PARANHOS("5006358", "Paranhos"),
    MS_PEDRO_GOMES("5006408", "Pedro Gomes"),
    MS_PONTA_PORA("5006606", "Ponta Porã"),
    MS_PORTO_MURTINHO("5006903", "Porto Murtinho"),
    MS_RIBAS_DO_RIO_PARDO("5007109", "Ribas do Rio Pardo"),
    MS_RIO_BRILHANTE("5007208", "Rio Brilhante"),
    MS_RIO_NEGRO("5007307", "Rio Negro"),
    MS_RIO_VERDE_DE_MATO_GROSSO("5007406", "Rio Verde de Mato Grosso"),
    MS_ROCHEDO("5007505", "Rochedo"),
    MS_SANTA_RITA_DO_PARDO("5007554", "Santa Rita do Pardo"),
    MS_SAO_GABRIEL_DO_OESTE("5007695", "São Gabriel do Oeste"),
    MS_SETE_QUEDAS("5007703", "Sete Quedas"),
    MS_SELVIRIA("5007802", "Selvíria"),
    MS_SIDROLANDIA("5007901", "Sidrolândia"),
    MS_SONORA("5007935", "Sonora"),
    MS_TACURU("5007950", "Tacuru"),
    MS_TAQUARUSSU("5007976", "Taquarussu"),
    MS_TERENOS("5008008", "Terenos"),
    MS_TRES_LAGOAS("5008305", "Três Lagoas"),
    MS_VICENTINA("5008404", "Vicentina"),
    ;
    private final String code;
    private final String description;

    CityMS(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public UF getUf() {
        return UF.valueOf(name().substring(0, 2));
    }
}