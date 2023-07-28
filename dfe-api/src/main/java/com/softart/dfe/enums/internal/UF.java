package com.softart.dfe.enums.internal;

import br.inf.portalfiscal.nfe.send.TNFe;
import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.city.*;
import com.softart.dfe.models.nf.authorization.Nf;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public enum UF implements DFEnum.Codeable {
    AC("12", "AC", "Acre", Arrays.asList(CityAC.values()), Arrays.asList("AM", "RO")),
    AL("27", "AL", "Alagoas", Arrays.asList(CityAL.values()), Arrays.asList("PE", "SE", "BA")),
    AP("16", "AP", "Amapá", Arrays.asList(CityAP.values()), Collections.singletonList("PA")),
    AM("13", "AM", "Amazonas", Arrays.asList(CityAM.values()), Arrays.asList("AC", "RO", "RR", "MT", "PA")),
    BA("29", "BA", "Bahia", Arrays.asList(CityBA.values()), Arrays.asList("AL", "SE", "PE", "PI", "TO", "GO", "MG", "ES")),
    CE("23", "CE", "Ceará", Arrays.asList(CityCE.values()), Arrays.asList("PI", "RN", "PB", "PE")),
    DF("53", "DF", "Distrito Federal", Arrays.asList(CityDF.values()), Collections.singletonList("GO")),
    ES("32", "ES", "Espírito Santo", Arrays.asList(CityES.values()), Arrays.asList("BA", "MG", "RJ")),
    GO("52", "GO", "Goiás", Arrays.asList(CityGO.values()), Arrays.asList("DF", "TO", "BA", "MG", "MS", "MT")),
    MA("21", "MA", "Maranhão", Arrays.asList(CityMA.values()), Arrays.asList("PA", "TO", "PI")),
    MG("31", "MG", "Minas Gerais", Arrays.asList(CityMG.values()), Arrays.asList("BA", "ES", "RJ", "SP", "GO", "DF")),
    MS("50", "MS", "Mato Grosso do Sul", Arrays.asList(CityMS.values()), Arrays.asList("MT", "GO", "MG", "SP", "PR")),
    MT("51", "MT", "Mato Grosso", Arrays.asList(CityMT.values()), Arrays.asList("PA", "RO", "AM", "TO", "GO", "MS")),
    PA("15", "PA", "Pará", Arrays.asList(CityPA.values()), Arrays.asList("AM", "AP", "MA", "MT", "TO")),
    PB("25", "PB", "Paraíba", Arrays.asList(CityPB.values()), Arrays.asList("CE", "RN", "PE")),
    PE("26", "PE", "Pernambuco", Arrays.asList(CityPE.values()), Arrays.asList("PB", "CE", "PI", "BA", "AL")),
    PI("22", "PI", "Piauí", Arrays.asList(CityPI.values()), Arrays.asList("MA", "TO", "BA", "PE", "CE")),
    PR("41", "PR", "Paraná", Arrays.asList(CityPR.values()), Arrays.asList("MS", "SP", "SC")),
    RJ("33", "RJ", "Rio de Janeiro", Arrays.asList(CityRJ.values()), Arrays.asList("SP", "MG", "ES")),
    RN("24", "RN", "Rio Grande do Norte", Arrays.asList(CityRN.values()), Arrays.asList("CE", "PB")),
    RS("43", "RS", "Rio Grande do Sul", Arrays.asList(CityRS.values()), Collections.singletonList("SC")),
    RO("11", "RO", "Rondônia", Arrays.asList(CityRO.values()), Arrays.asList("AM", "AC", "MT")),
    RR("14", "RR", "Roraima", Arrays.asList(CityRR.values()), Arrays.asList("AM", "PA")),
    SC("42", "SC", "Santa Catarina", Arrays.asList(CitySC.values()), Arrays.asList("PR", "RS")),
    SP("35", "SP", "São Paulo", Arrays.asList(CitySP.values()), Arrays.asList("PR", "MS", "MG", "RJ")),
    SE("28", "SE", "Sergipe", Arrays.asList(CitySE.values()), Arrays.asList("BA", "AL")),
    TO("17", "TO", "Tocantins", Arrays.asList(CityTO.values()), Arrays.asList("GO", "MT", "PA", "MA", "PI", "BA")),
    NACIONAL("90", "NC", "Nacional", Collections.emptyList()),
    RFB("91", "RFB", "RFB", Collections.emptyList()),
    EX("99", "EX", "Exterior", Collections.emptyList()),
    SU("SU", "SU", "Suframa", Collections.emptyList());

    private final String code;
    private final String description;
    private final String fullDescription;
    private final Collection<DFEnum.Codeable> cities;
    private final Collection<String> frontiers;

    UF(String code, String description, String fullDescription, Collection<DFEnum.Codeable> cities) {
        this(code, description, fullDescription, cities, Collections.emptySet());
    }

    UF(String code, String description, String fullDescription, Collection<DFEnum.Codeable> cities, Collection<String> frontiers) {
        this.code = code;
        this.description = description;
        this.fullDescription = fullDescription;
        this.cities = cities;
        this.frontiers = frontiers;
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

    public static Map<UF, List<UF>> getUfGraph() {
        return UF.states().stream().collect(Collectors.toMap(it -> it, UF::getUfFrontiers));
    }

    public List<UF> getUfFrontiers() {
        return getFrontiers().stream().map(UF::valueOf).collect(Collectors.toList());
    }
}
