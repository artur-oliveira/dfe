package org.dfe.enums.internal.city;

import org.dfe.components.internal.DFEnum;
import org.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityES implements DFEnum.Codeable {
    ES_AFONSO_CLAUDIO("3200102", "Afonso Cláudio"),
    ES_AGUIA_BRANCA("3200136", "Águia Branca"),
    ES_AGUA_DOCE_DO_NORTE("3200169", "Água Doce do Norte"),
    ES_ALEGRE("3200201", "Alegre"),
    ES_ALFREDO_CHAVES("3200300", "Alfredo Chaves"),
    ES_ALTO_RIO_NOVO("3200359", "Alto Rio Novo"),
    ES_ANCHIETA("3200409", "Anchieta"),
    ES_APIACA("3200508", "Apiacá"),
    ES_ARACRUZ("3200607", "Aracruz"),
    ES_ATILIO_VIVACQUA("3200706", "Atilio Vivacqua"),
    ES_BAIXO_GUANDU("3200805", "Baixo Guandu"),
    ES_BARRA_DE_SAO_FRANCISCO("3200904", "Barra de São Francisco"),
    ES_BOA_ESPERANCA("3201001", "Boa Esperança"),
    ES_BOM_JESUS_DO_NORTE("3201100", "Bom Jesus do Norte"),
    ES_BREJETUBA("3201159", "Brejetuba"),
    ES_CACHOEIRO_DE_ITAPEMIRIM("3201209", "Cachoeiro de Itapemirim"),
    ES_CARIACICA("3201308", "Cariacica"),
    ES_CASTELO("3201407", "Castelo"),
    ES_COLATINA("3201506", "Colatina"),
    ES_CONCEICAO_DA_BARRA("3201605", "Conceição da Barra"),
    ES_CONCEICAO_DO_CASTELO("3201704", "Conceição do Castelo"),
    ES_DIVINO_DE_SAO_LOURENCO("3201803", "Divino de São Lourenço"),
    ES_DOMINGOS_MARTINS("3201902", "Domingos Martins"),
    ES_DORES_DO_RIO_PRETO("3202009", "Dores do Rio Preto"),
    ES_ECOPORANGA("3202108", "Ecoporanga"),
    ES_FUNDAO("3202207", "Fundão"),
    ES_GOVERNADOR_LINDENBERG("3202256", "Governador Lindenberg"),
    ES_GUACUI("3202306", "Guaçuí"),
    ES_GUARAPARI("3202405", "Guarapari"),
    ES_IBATIBA("3202454", "Ibatiba"),
    ES_IBIRACU("3202504", "Ibiraçu"),
    ES_IBITIRAMA("3202553", "Ibitirama"),
    ES_ICONHA("3202603", "Iconha"),
    ES_IRUPI("3202652", "Irupi"),
    ES_ITAGUACU("3202702", "Itaguaçu"),
    ES_ITAPEMIRIM("3202801", "Itapemirim"),
    ES_ITARANA("3202900", "Itarana"),
    ES_IUNA("3203007", "Iúna"),
    ES_JAGUARE("3203056", "Jaguaré"),
    ES_JERONIMO_MONTEIRO("3203106", "Jerônimo Monteiro"),
    ES_JOAO_NEIVA("3203130", "João Neiva"),
    ES_LARANJA_DA_TERRA("3203163", "Laranja da Terra"),
    ES_LINHARES("3203205", "Linhares"),
    ES_MANTENOPOLIS("3203304", "Mantenópolis"),
    ES_MARATAIZES("3203320", "Marataízes"),
    ES_MARECHAL_FLORIANO("3203346", "Marechal Floriano"),
    ES_MARILANDIA("3203353", "Marilândia"),
    ES_MIMOSO_DO_SUL("3203403", "Mimoso do Sul"),
    ES_MONTANHA("3203502", "Montanha"),
    ES_MUCURICI("3203601", "Mucurici"),
    ES_MUNIZ_FREIRE("3203700", "Muniz Freire"),
    ES_MUQUI("3203809", "Muqui"),
    ES_NOVA_VENECIA("3203908", "Nova Venécia"),
    ES_PANCAS("3204005", "Pancas"),
    ES_PEDRO_CANARIO("3204054", "Pedro Canário"),
    ES_PINHEIROS("3204104", "Pinheiros"),
    ES_PIUMA("3204203", "Piúma"),
    ES_PONTO_BELO("3204252", "Ponto Belo"),
    ES_PRESIDENTE_KENNEDY("3204302", "Presidente Kennedy"),
    ES_RIO_BANANAL("3204351", "Rio Bananal"),
    ES_RIO_NOVO_DO_SUL("3204401", "Rio Novo do Sul"),
    ES_SANTA_LEOPOLDINA("3204500", "Santa Leopoldina"),
    ES_SANTA_MARIA_DE_JETIBA("3204559", "Santa Maria de Jetibá"),
    ES_SANTA_TERESA("3204609", "Santa Teresa"),
    ES_SAO_DOMINGOS_DO_NORTE("3204658", "São Domingos do Norte"),
    ES_SAO_GABRIEL_DA_PALHA("3204708", "São Gabriel da Palha"),
    ES_SAO_JOSE_DO_CALCADO("3204807", "São José do Calçado"),
    ES_SAO_MATEUS("3204906", "São Mateus"),
    ES_SAO_ROQUE_DO_CANAA("3204955", "São Roque do Canaã"),
    ES_SERRA("3205002", "Serra"),
    ES_SOORETAMA("3205010", "Sooretama"),
    ES_VARGEM_ALTA("3205036", "Vargem Alta"),
    ES_VENDA_NOVA_DO_IMIGRANTE("3205069", "Venda Nova do Imigrante"),
    ES_VIANA("3205101", "Viana"),
    ES_VILA_PAVAO("3205150", "Vila Pavão"),
    ES_VILA_VALERIO("3205176", "Vila Valério"),
    ES_VILA_VELHA("3205200", "Vila Velha"),
    ES_VITORIA("3205309", "Vitória"),
    ;
    private final String code;
    private final String description;

    CityES(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public UF getUf() {
        return UF.valueOf(name().substring(0, 2));
    }
}