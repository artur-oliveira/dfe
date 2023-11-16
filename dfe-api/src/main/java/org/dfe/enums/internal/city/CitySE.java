package org.dfe.enums.internal.city;

import org.dfe.components.internal.DFEnum;
import org.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CitySE implements DFEnum.Codeable {
    SE_AMPARO_DE_SAO_FRANCISCO("2800100", "Amparo de São Francisco"),
    SE_AQUIDABA("2800209", "Aquidabã"),
    SE_ARACAJU("2800308", "Aracaju"),
    SE_ARAUA("2800407", "Arauá"),
    SE_AREIA_BRANCA("2800506", "Areia Branca"),
    SE_BARRA_DOS_COQUEIROS("2800605", "Barra Dos Coqueiros"),
    SE_BOQUIM("2800670", "Boquim"),
    SE_BREJO_GRANDE("2800704", "Brejo Grande"),
    SE_CAMPO_DO_BRITO("2801009", "Campo do Brito"),
    SE_CANHOBA("2801108", "Canhoba"),
    SE_CANINDE_DE_SAO_FRANCISCO("2801207", "Canindé de São Francisco"),
    SE_CAPELA("2801306", "Capela"),
    SE_CARIRA("2801405", "Carira"),
    SE_CARMOPOLIS("2801504", "Carmópolis"),
    SE_CEDRO_DE_SAO_JOAO("2801603", "Cedro de São João"),
    SE_CRISTINAPOLIS("2801702", "Cristinápolis"),
    SE_CUMBE("2801900", "Cumbe"),
    SE_DIVINA_PASTORA("2802007", "Divina Pastora"),
    SE_ESTANCIA("2802106", "Estância"),
    SE_FEIRA_NOVA("2802205", "Feira Nova"),
    SE_FREI_PAULO("2802304", "Frei Paulo"),
    SE_GARARU("2802403", "Gararu"),
    SE_GENERAL_MAYNARD("2802502", "General Maynard"),
    SE_GRACHO_CARDOSO("2802601", "Gracho Cardoso"),
    SE_ILHA_DAS_FLORES("2802700", "Ilha Das Flores"),
    SE_INDIAROBA("2802809", "Indiaroba"),
    SE_ITABAIANA("2802908", "Itabaiana"),
    SE_ITABAIANINHA("2803005", "Itabaianinha"),
    SE_ITABI("2803104", "Itabi"),
    SE_ITAPORANGA_D_AJUDA("2803203", "Itaporanga D´ajuda"),
    SE_JAPARATUBA("2803302", "Japaratuba"),
    SE_JAPOATA("2803401", "Japoatã"),
    SE_LAGARTO("2803500", "Lagarto"),
    SE_LARANJEIRAS("2803609", "Laranjeiras"),
    SE_MACAMBIRA("2803708", "Macambira"),
    SE_MALHADA_DOS_BOIS("2803807", "Malhada Dos Bois"),
    SE_MALHADOR("2803906", "Malhador"),
    SE_MARUIM("2804003", "Maruim"),
    SE_MOITA_BONITA("2804102", "Moita Bonita"),
    SE_MONTE_ALEGRE_DE_SERGIPE("2804201", "Monte Alegre de Sergipe"),
    SE_MURIBECA("2804300", "Muribeca"),
    SE_NEOPOLIS("2804409", "Neópolis"),
    SE_NOSSA_SENHORA_APARECIDA("2804458", "Nossa Senhora Aparecida"),
    SE_NOSSA_SENHORA_DA_GLORIA("2804508", "Nossa Senhora da Glória"),
    SE_NOSSA_SENHORA_DAS_DORES("2804607", "Nossa Senhora Das Dores"),
    SE_NOSSA_SENHORA_DE_LOURDES("2804706", "Nossa Senhora de Lourdes"),
    SE_NOSSA_SENHORA_DO_SOCORRO("2804805", "Nossa Senhora do Socorro"),
    SE_PACATUBA("2804904", "Pacatuba"),
    SE_PEDRA_MOLE("2805000", "Pedra Mole"),
    SE_PEDRINHAS("2805109", "Pedrinhas"),
    SE_PINHAO("2805208", "Pinhão"),
    SE_PIRAMBU("2805307", "Pirambu"),
    SE_POCO_REDONDO("2805406", "Poço Redondo"),
    SE_POCO_VERDE("2805505", "Poço Verde"),
    SE_PORTO_DA_FOLHA("2805604", "Porto da Folha"),
    SE_PROPRIA("2805703", "Propriá"),
    SE_RIACHAO_DO_DANTAS("2805802", "Riachão do Dantas"),
    SE_RIACHUELO("2805901", "Riachuelo"),
    SE_RIBEIROPOLIS("2806008", "Ribeirópolis"),
    SE_ROSARIO_DO_CATETE("2806107", "Rosário do Catete"),
    SE_SALGADO("2806206", "Salgado"),
    SE_SANTA_LUZIA_DO_ITANHY("2806305", "Santa Luzia do Itanhy"),
    SE_SANTANA_DO_SAO_FRANCISCO("2806404", "Santana do São Francisco"),
    SE_SANTA_ROSA_DE_LIMA("2806503", "Santa Rosa de Lima"),
    SE_SANTO_AMARO_DAS_BROTAS("2806602", "Santo Amaro Das Brotas"),
    SE_SAO_CRISTOVAO("2806701", "São Cristóvão"),
    SE_SAO_DOMINGOS("2806800", "São Domingos"),
    SE_SAO_FRANCISCO("2806909", "São Francisco"),
    SE_SAO_MIGUEL_DO_ALEIXO("2807006", "São Miguel do Aleixo"),
    SE_SIMAO_DIAS("2807105", "Simão Dias"),
    SE_SIRIRI("2807204", "Siriri"),
    SE_TELHA("2807303", "Telha"),
    SE_TOBIAS_BARRETO("2807402", "Tobias Barreto"),
    SE_TOMAR_DO_GERU("2807501", "Tomar do Geru"),
    SE_UMBAUBA("2807600", "Umbaúba"),
    ;
    private final String code;
    private final String description;

    CitySE(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public UF getUf() {
        return UF.valueOf(name().substring(0, 2));
    }
}