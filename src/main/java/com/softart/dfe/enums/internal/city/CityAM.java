package com.softart.dfe.enums.internal.city;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityAM implements DFEnum.Codeable {
    AM_ALVARAES("1300029", "Alvarães", UF.AM),
    AM_AMATURA("1300060", "Amaturá", UF.AM),
    AM_ANAMA("1300086", "Anamã", UF.AM),
    AM_ANORI("1300102", "Anori", UF.AM),
    AM_APUI("1300144", "Apuí", UF.AM),
    AM_ATALAIA_DO_NORTE("1300201", "Atalaia do Norte", UF.AM),
    AM_AUTAZES("1300300", "Autazes", UF.AM),
    AM_BARCELOS("1300409", "Barcelos", UF.AM),
    AM_BARREIRINHA("1300508", "Barreirinha", UF.AM),
    AM_BENJAMIN_CONSTANT("1300607", "Benjamin Constant", UF.AM),
    AM_BERURI("1300631", "Beruri", UF.AM),
    AM_BOA_VISTA_DO_RAMOS("1300680", "Boa Vista do Ramos", UF.AM),
    AM_BOCA_DO_ACRE("1300706", "Boca do Acre", UF.AM),
    AM_BORBA("1300805", "Borba", UF.AM),
    AM_CAAPIRANGA("1300839", "Caapiranga", UF.AM),
    AM_CANUTAMA("1300904", "Canutama", UF.AM),
    AM_CARAUARI("1301001", "Carauari", UF.AM),
    AM_CAREIRO("1301100", "Careiro", UF.AM),
    AM_CAREIRO_DA_VARZEA("1301159", "Careiro da Várzea", UF.AM),
    AM_COARI("1301209", "Coari", UF.AM),
    AM_CODAJAS("1301308", "Codajás", UF.AM),
    AM_EIRUNEPE("1301407", "Eirunepé", UF.AM),
    AM_ENVIRA("1301506", "Envira", UF.AM),
    AM_FONTE_BOA("1301605", "Fonte Boa", UF.AM),
    AM_GUAJARA("1301654", "Guajará", UF.AM),
    AM_HUMAITA("1301704", "Humaitá", UF.AM),
    AM_IPIXUNA("1301803", "Ipixuna", UF.AM),
    AM_IRANDUBA("1301852", "Iranduba", UF.AM),
    AM_ITACOATIARA("1301902", "Itacoatiara", UF.AM),
    AM_ITAMARATI("1301951", "Itamarati", UF.AM),
    AM_ITAPIRANGA("1302009", "Itapiranga", UF.AM),
    AM_JAPURA("1302108", "Japurá", UF.AM),
    AM_JURUA("1302207", "Juruá", UF.AM),
    AM_JUTAI("1302306", "Jutaí", UF.AM),
    AM_LABREA("1302405", "Lábrea", UF.AM),
    AM_MANACAPURU("1302504", "Manacapuru", UF.AM),
    AM_MANAQUIRI("1302553", "Manaquiri", UF.AM),
    AM_MANAUS("1302603", "Manaus", UF.AM),
    AM_MANICORE("1302702", "Manicoré", UF.AM),
    AM_MARAA("1302801", "Maraã", UF.AM),
    AM_MAUES("1302900", "Maués", UF.AM),
    AM_NHAMUNDA("1303007", "Nhamundá", UF.AM),
    AM_NOVA_OLINDA_DO_NORTE("1303106", "Nova Olinda do Norte", UF.AM),
    AM_NOVO_AIRAO("1303205", "Novo Airão", UF.AM),
    AM_NOVO_ARIPUANA("1303304", "Novo Aripuanã", UF.AM),
    AM_PARINTINS("1303403", "Parintins", UF.AM),
    AM_PAUINI("1303502", "Pauini", UF.AM),
    AM_PRESIDENTE_FIGUEIREDO("1303536", "Presidente Figueiredo", UF.AM),
    AM_RIO_PRETO_DA_EVA("1303569", "Rio Preto da Eva", UF.AM),
    AM_SANTA_ISABEL_DO_RIO_NEGRO("1303601", "Santa Isabel do Rio Negro", UF.AM),
    AM_SANTO_ANTONIO_DO_ICA("1303700", "Santo Antônio do Içá", UF.AM),
    AM_SAO_GABRIEL_DA_CACHOEIRA("1303809", "São Gabriel da Cachoeira", UF.AM),
    AM_SAO_PAULO_DE_OLIVENCA("1303908", "São Paulo de Olivença", UF.AM),
    AM_SAO_SEBASTIAO_DO_UATUMA("1303957", "São Sebastião do Uatumã", UF.AM),
    AM_SILVES("1304005", "Silves", UF.AM),
    AM_TABATINGA("1304062", "Tabatinga", UF.AM),
    AM_TAPAUA("1304104", "Tapauá", UF.AM),
    AM_TEFE("1304203", "Tefé", UF.AM),
    AM_TONANTINS("1304237", "Tonantins", UF.AM),
    AM_UARINI("1304260", "Uarini", UF.AM),
    AM_URUCARA("1304302", "Urucará", UF.AM),
    AM_URUCURITUBA("1304401", "Urucurituba", UF.AM),
    ;
    private final String code;
    private final String description;
    private final UF uf;

    CityAM(String code, String description, UF uf) {
        this.code = code;
        this.description = description;
        this.uf = uf;
    }
}