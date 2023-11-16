package org.dfe.enums.nf.prod.tax;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFCSOSN implements DFEnum.Codeable {

    TAXED_BY_NATIONAL_SIMPLES_WITH_CREDIT_PERMISSION("101", "Tributada pelo Simples Nacional com permissão de crédito."),
    TAXED_BY_NATIONAL_SIMPLES_WITHOUT_CREDIT_PERMISSION("102", "Tributada pelo Simples Nacional sem permissão de crédito."),
    ICMS_EXCEMPT_FOR_GROSS_REVENUE("103", "Isenção do ICMS no Simples Nacional para faixa de receita bruta."),
    IMMUNE("300", "Imune"),
    NOT_TAXED_BY_NATIONAL_SIMPLES("400", "Não tributada pelo Simples Nacional"),
    TAXED_BY_NATIONAL_SIMPLES_WITH_CREDIT_PERMISSION_AND_CHARGE_BY_TRIBUTARY_SUBSTITUTION("201", "Tributada pelo Simples Nacional com permissão de crédito e com cobrança do ICMS por Substituição Tributária"),
    TAXED_BY_NATIONAL_SIMPLES_WITHOUT_CREDIT_PERMISSION_AND_CHARGE_BY_TRIBUTARY_SUBSTITUTION("202", "Tributada pelo Simples Nacional sem permissão de crédito e com cobrança do ICMS por Substituição Tributária"),
    ICMS_EXCEMPT_FOR_GROSS_REVENUE_AND_CHARGE_BY_TRIBUTARY_SUBSTITUTION("203", "Isenção do ICMS nos Simples Nacional para faixa de receita bruta e com cobrança do ICMS por Substituição Tributária"),
    ICMS_CHARGED_PREVIOUSLY_BY_TRIBUTARY_SUBSTITUTION("500", "ICMS cobrado anteriormente por substituição tributária (substituído) ou por antecipação."),
    OTHER("900", "Outros");
    private final String code;
    private final String description;

    NFCSOSN(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFCSOSN valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
