package org.dfe.enums.nf.prod.tax;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;


@Getter
public enum NFICMSExcemptionMotive implements DFEnum.Codeable {

    TAXI("1", "Táxi"),
    HANDICAPPED("2", "Deficiente Físico"),
    AGRICULTURAL("3", "Produtor Agropecuário"),
    LESSOR_FLEET("4", "Frotista/Locadora"),
    CONSULAR_DIPLOMATIC("5", "Diplomático/Consular"),
    AMAZONIA_UTILITY("6", "Utilitários e Motocicletas da Amazônia Ocidental e Áreas; de Livre Comércio (Resolução 714/88 e 790/94 – CONTRAN e suas alterações)"),
    SUFRAMA("7", "SUFRAMA"),
    PUBLIC_OFFICE_SALE("8", "Venda a Órgão Público"),
    OTHER("9", "Outros. (NT 2011/004)"),
    DISABLED_DRIVER("10", "Deficiente Condutor (Convênio ICMS 38/12)"),
    DISABLED_NON_DRIVER("11", "Deficiente Não Condutor (Convênio ICMS 38/12)"),
    RIO_2016_OLYMPICS("16", "Olimpíadas Rio 2016 (NT 2015.002);"),
    FISCAL_SOLICITATION("90", "Solicitado pelo Fisco (NT2016.002)");

    private final String code;
    private final String description;

    NFICMSExcemptionMotive(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFICMSExcemptionMotive valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
