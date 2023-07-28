package com.softart.dfe.enums.cte.info.document;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CtePreviousDocType implements DFEnum.Codeable {

    ATRE("07", "ATRE"),
    DTA("08", "DTA (Despacho de Transito Aduaneiro)"),
    INTERNATIONAL_AIR_WAYBILL("09", "Conhecimento Aéreo Internacional"),
    INTERNATIONAL_WAYBILL("10", "Conhecimento - Carta de Porte Internacional"),
    SEPARATE("11", "Conhecimento Avulso"),
    TIF("12", "TIF (Transporte Internacional Ferroviário)"),
    BL("13", "BL (Bill of Lading)");

    private final String code;
    private final String description;

    public static CtePreviousDocType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
