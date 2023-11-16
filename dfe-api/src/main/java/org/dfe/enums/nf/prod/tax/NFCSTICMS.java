package org.dfe.enums.nf.prod.tax;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFCSTICMS implements DFEnum.Codeable {

    FULLY_TAXED("00", "Tributada integralmente"),
    TAXED_WITH_ICMS_CHARGE_BY_TRIBUTARY_SUBSTITUTION("10", "Tributada e com cobrança do ICMS por substituição tributária"),
    TAXED_WITH_REDUCTION("20", "Com redução de base de cálculo"),
    EXEMPTED_OR_NOT_TAXED_WITH_ICMS_CHARGE_BY_TRIBUTARY_SUBSTITUTION("30", "Isenta ou não tributada e com cobrança do ICMS por substituição tributária"),
    EXEMPTED("40", "Isenta"),
    NOT_TAXED("41", "Não tributada"),
    SUSPENDED("50", "Suspensão"),
    DEFERRAL("51", "Diferimento"),
    TAXED_WITH_PREVIOUSLY_ICMS_CHARGE_BY_TRIBUTARY_SUBSTITUTION("60", "ICMS cobrado anteriormente por substituição tributária"),
    TAXED_WITH_REDUCTION_WITH_ICMS_CHARGE_BY_TRIBUTARY_SUBSTITUTION("70", "Com redução de base de cálculo e cobrança do ICMS por substituição tributária"),
    OTHER("90", "Outros"),
    ;
    private final String code;
    private final String description;

    NFCSTICMS(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFCSTICMS valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
