package com.softart.dfe.enums.nf.prod.tax;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFMerchandiseOrigin implements DFEnum.Codeable {

    NATIONAL("0", "Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8"),
    FOREIGN_DIRECT_IMPORTATION("1", "Estrangeira - Importação direta, exceto a indicada no código 6"),
    FOREIGN_INTERN_MARKET("2", "Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7"),
    NATIONAL_WITH_IMPORT_CONTENT_ABOVE_40_AND_BELOW_70("3", "Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%"),
    NATIONAL_ADJUSTMENT("4", "Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas nos Ajustes"),
    NATIONAL_WITH_IMPORT_CONTENT_BELOW_40("5", "Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%"),
    FOREIGN_WITHOUT_SIMILAR_NATIONAL("6", "Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural"),
    FOREIGN_INTERN_MARKET_WITHOUT_SIMILAR_NATIONAL("7", "Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e gás natural"),
    NATIONAL_WITH_IMPORT_CONTENT_ABOVE_70("8", "Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%");
    private final String code;
    private final String description;

    NFMerchandiseOrigin(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFMerchandiseOrigin valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
