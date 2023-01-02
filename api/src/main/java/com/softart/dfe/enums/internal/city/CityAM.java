package com.softart.dfe.enums.internal.city;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.UF;
import lombok.Getter;

@Getter
public enum CityAM implements DFEnum.Codeable {
    AM_ALVARAES("1300029", "Alvarães"),
    AM_AMATURA("1300060", "Amaturá"),
    AM_ANAMA("1300086", "Anamã"),
    AM_ANORI("1300102", "Anori"),
    AM_APUI("1300144", "Apuí"),
    AM_ATALAIA_DO_NORTE("1300201", "Atalaia do Norte"),
    AM_AUTAZES("1300300", "Autazes"),
    AM_BARCELOS("1300409", "Barcelos"),
    AM_BARREIRINHA("1300508", "Barreirinha"),
    AM_BENJAMIN_CONSTANT("1300607", "Benjamin Constant"),
    AM_BERURI("1300631", "Beruri"),
    AM_BOA_VISTA_DO_RAMOS("1300680", "Boa Vista do Ramos"),
    AM_BOCA_DO_ACRE("1300706", "Boca do Acre"),
    AM_BORBA("1300805", "Borba"),
    AM_CAAPIRANGA("1300839", "Caapiranga"),
    AM_CANUTAMA("1300904", "Canutama"),
    AM_CARAUARI("1301001", "Carauari"),
    AM_CAREIRO("1301100", "Careiro"),
    AM_CAREIRO_DA_VARZEA("1301159", "Careiro da Várzea"),
    AM_COARI("1301209", "Coari"),
    AM_CODAJAS("1301308", "Codajás"),
    AM_EIRUNEPE("1301407", "Eirunepé"),
    AM_ENVIRA("1301506", "Envira"),
    AM_FONTE_BOA("1301605", "Fonte Boa"),
    AM_GUAJARA("1301654", "Guajará"),
    AM_HUMAITA("1301704", "Humaitá"),
    AM_IPIXUNA("1301803", "Ipixuna"),
    AM_IRANDUBA("1301852", "Iranduba"),
    AM_ITACOATIARA("1301902", "Itacoatiara"),
    AM_ITAMARATI("1301951", "Itamarati"),
    AM_ITAPIRANGA("1302009", "Itapiranga"),
    AM_JAPURA("1302108", "Japurá"),
    AM_JURUA("1302207", "Juruá"),
    AM_JUTAI("1302306", "Jutaí"),
    AM_LABREA("1302405", "Lábrea"),
    AM_MANACAPURU("1302504", "Manacapuru"),
    AM_MANAQUIRI("1302553", "Manaquiri"),
    AM_MANAUS("1302603", "Manaus"),
    AM_MANICORE("1302702", "Manicoré"),
    AM_MARAA("1302801", "Maraã"),
    AM_MAUES("1302900", "Maués"),
    AM_NHAMUNDA("1303007", "Nhamundá"),
    AM_NOVA_OLINDA_DO_NORTE("1303106", "Nova Olinda do Norte"),
    AM_NOVO_AIRAO("1303205", "Novo Airão"),
    AM_NOVO_ARIPUANA("1303304", "Novo Aripuanã"),
    AM_PARINTINS("1303403", "Parintins"),
    AM_PAUINI("1303502", "Pauini"),
    AM_PRESIDENTE_FIGUEIREDO("1303536", "Presidente Figueiredo"),
    AM_RIO_PRETO_DA_EVA("1303569", "Rio Preto da Eva"),
    AM_SANTA_ISABEL_DO_RIO_NEGRO("1303601", "Santa Isabel do Rio Negro"),
    AM_SANTO_ANTONIO_DO_ICA("1303700", "Santo Antônio do Içá"),
    AM_SAO_GABRIEL_DA_CACHOEIRA("1303809", "São Gabriel da Cachoeira"),
    AM_SAO_PAULO_DE_OLIVENCA("1303908", "São Paulo de Olivença"),
    AM_SAO_SEBASTIAO_DO_UATUMA("1303957", "São Sebastião do Uatumã"),
    AM_SILVES("1304005", "Silves"),
    AM_TABATINGA("1304062", "Tabatinga"),
    AM_TAPAUA("1304104", "Tapauá"),
    AM_TEFE("1304203", "Tefé"),
    AM_TONANTINS("1304237", "Tonantins"),
    AM_UARINI("1304260", "Uarini"),
    AM_URUCARA("1304302", "Urucará"),
    AM_URUCURITUBA("1304401", "Urucurituba"),
    ;
    private final String code;
    private final String description;

    CityAM(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public UF getUf() {
        return UF.valueOf(name().substring(0, 2));
    }
}