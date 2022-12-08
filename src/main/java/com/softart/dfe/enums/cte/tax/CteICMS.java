package com.softart.dfe.enums.cte.tax;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CteICMS implements DFEnum.Codeable {
    NORMAL("00", "tributação normal ICMS"),
    REDUCTION("20", "tributação com BC reduzida do ICMS"),
    EXCEMPT("40", "ICMS isenção;"),
    NOT_TAXED("41", "ICMS não tributada;"),
    DEFERRAL("51", "ICMS diferido"),
    TRIBUTARY_SUBSTITUTION("60", "ICMS cobrado por substituição tributária"),
    OTHER("90", "ICMS outros"),
    OTHER_UF("90", "ICMS Outra UF"),
    SIMPLES("90", "ICMS Simples Nacional");

    private final String code;
    private final String description;

    public static CteICMS valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }


}
