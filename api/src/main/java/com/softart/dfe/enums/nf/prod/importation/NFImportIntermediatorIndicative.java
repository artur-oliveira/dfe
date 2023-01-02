package com.softart.dfe.enums.nf.prod.importation;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;


@Getter
public enum NFImportIntermediatorIndicative implements DFEnum.Codeable {

    OWN("1", "Importação por conta própria"),
    ACCOUNT_AND_ORDER("2", "Importação por conta e ordem"),
    ORDER("3", "Importação por encomenda");

    private final String code;
    private final String description;

    NFImportIntermediatorIndicative(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFImportIntermediatorIndicative valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
