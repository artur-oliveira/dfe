package org.dfe.enums.nf.identification;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFProcessEmission implements DFEnum.Codeable {

    APPLICATION("0", "Emissão de NF-e com aplicativo do contribuinte"),
    FISCAL_SINGLE("1", "Emissão de NF-e avulsa pelo Fisco"),
    FISCAL_SITE_SINGLE("2", "Emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco"),
    FISCAL_APPLICATION("3", "Emissão NF-e pelo contribuinte com aplicativo fornecido pelo Fisco");

    private final String code;
    private final String description;

    NFProcessEmission(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFProcessEmission valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
