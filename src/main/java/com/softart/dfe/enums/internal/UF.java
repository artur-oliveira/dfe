package com.softart.dfe.enums.internal;

import br.inf.portalfiscal.nfe.send.TNFe;
import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.city.*;
import com.softart.dfe.models.nf.authorization.Nf;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Getter
public enum UF implements DFEnum.Codeable {
    AC("12", "AC", "Acre", Arrays.asList(CityAC.values())),
    AL("27", "AL", "Alagoas", Arrays.asList(CityAL.values())),
    AP("16", "AP", "Amapá", Arrays.asList(CityAP.values())),
    AM("13", "AM", "Amazonas", Arrays.asList(CityAM.values())),
    BA("29", "BA", "Bahia", Arrays.asList(CityBA.values())),
    CE("23", "CE", "Ceará", Arrays.asList(CityCE.values())),
    DF("53", "DF", "Distrito Federal", Arrays.asList(CityDF.values())),
    ES("32", "ES", "Espírito Santo", Arrays.asList(CityES.values())),
    GO("52", "GO", "Goiás", Arrays.asList(CityGO.values())),
    MA("21", "MA", "Maranhão", Arrays.asList(CityMA.values())),
    MT("51", "MT", "Mato Grosso", Arrays.asList(CityMT.values())),
    MS("50", "MS", "Mato Grosso do Sul", Arrays.asList(CityMS.values())),
    MG("31", "MG", "Minas Gerais", Arrays.asList(CityMG.values())),
    PA("15", "PA", "Pará", Arrays.asList(CityPA.values())),
    PB("25", "PB", "Paraíba", Arrays.asList(CityPB.values())),
    PR("41", "PR", "Paraná", Arrays.asList(CityPR.values())),
    PE("26", "PE", "Pernambuco", Arrays.asList(CityPE.values())),
    PI("22", "PI", "Piauí", Arrays.asList(CityPI.values())),
    RJ("33", "RJ", "Rio de Janeiro", Arrays.asList(CityRJ.values())),
    RN("24", "RN", "Rio Grande do Norte", Arrays.asList(CityRN.values())),
    RS("43", "RS", "Rio Grande do Sul", Arrays.asList(CityRS.values())),
    RO("11", "RO", "Rondônia", Arrays.asList(CityRO.values())),
    RR("14", "RR", "Roraima", Arrays.asList(CityRR.values())),
    SC("42", "SC", "Santa Catarina", Arrays.asList(CitySC.values())),
    SP("35", "SP", "São Paulo", Arrays.asList(CitySP.values())),
    SE("28", "SE", "Sergipe", Arrays.asList(CitySE.values())),
    TO("17", "TO", "Tocantins", Arrays.asList(CityTO.values())),
    NACIONAL("90", "NC", "Nacional", Collections.emptyList()),
    RFB("91", "RFB", "RFB", Collections.emptyList()),
    EX("99", "EX", "Exterior", Collections.emptyList());

    private final String code;
    private final String description;
    private final String fullDescription;

    private final Collection<DFEnum.Codeable> cities;

    UF(String code, String description, String fullDescription, Collection<DFEnum.Codeable> cities) {
        this.code = code;
        this.description = description;
        this.fullDescription = fullDescription;
        this.cities = cities;
    }

    public static Collection<UF> states() {
        return Arrays.stream(values()).filter(it -> !Arrays.asList(UF.NACIONAL, UF.RFB, UF.EX).contains(it)).collect(Collectors.toList());
    }

    public static UF valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

    public static UF valueOfNf(Nf nf) {
        return valueOfCode(nf.getInfNFe().getIde().getCuf());
    }

    public static UF valueOfNf(TNFe tnFe) {
        return valueOfCode(tnFe.getInfNFe().getIde().getCUF());
    }
}
