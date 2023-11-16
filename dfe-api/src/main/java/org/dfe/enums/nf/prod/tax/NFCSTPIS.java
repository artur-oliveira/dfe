package org.dfe.enums.nf.prod.tax;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;


@Getter
public enum NFCSTPIS implements DFEnum.Codeable {
    TAXABLE_OPERATION_CUMULATIVE_NON_CUMULATIVE("01", "Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo))"),
    TAXABLE_OPERATION_DIFFERENTIATED_ALIQUOT("02", "Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada))"),
    TAXABLE_OPERATION_SOLD_AMOUNT("03", "Operação Tributável (base de cálculo = quantidade vendida x alíquota por unidade de produto)"),
    TAXABLE_OPERATION_SINGLE_PHASE_ZERO_ALIQUOT("04", "Operação Tributável (tributação monofásica (alíquota zero))"),
    TAXABLE_OPERATION_TRIBUTARY_SUBSTITUTION("05", "Operação Tributável (Substituição Tributária)"),
    TAXABLE_OPERATION_ZERO_ALIQUOT("06", "Operação Tributável (alíquota zero)"),
    EXEMPT_OPERATION("07", "Operação Isenta da Contribuição;"),
    OPERATION_WITHOUT_INCIDENCE("08", "Operação Sem Incidência da Contribuição"),
    OPERATION_WITH__SUSPENSION("09", "Operação com Suspensão da Contribuição"),
    OTHER_DEPARTURE_OPERATION("49", "Outras Operações de Saída"),

    OPERATION_WITH_CREDIT_RIGHTS_LINKED_EXCLUSIVELY_REVENUE_TAXED_INTERNAL_MARKET("50", "Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno"),
    OPERATION_WITH_CREDIT_RIGHTS_LINKED_EXCLUSIVELY_REVENUE_NOT_TAXED_INTERNAL_MARKET("51", "Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno"),
    OPERATION_WITH_CREDIT_RIGHTS_LINKED_EXCLUSIVELY_EXPORT_REVENUE("52", "Operação com Direito a Crédito – Vinculada Exclusivamente a Receita de Exportação"),
    OPERATION_WITH_CREDIT_RIGHTS_LINKED_REVENUE_TAXED_AND_NOT_TAXED_INTERNAL_MARKET("53", "Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno"),
    OPERATION_WITH_CREDIT_RIGHTS_LINKED_REVENUE_TAXED_INTERNAL_MARKET_AND_EXPORT_REVENUE("54", "Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação"),
    OPERATION_WITH_CREDIT_RIGHTS_LINKED_REVENUE_NOT_TAXED_INTERNAL_MARKET_AND_EXPORT_REVENUE("55", "Operação com Direito a Crédito - Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;"),
    OPERATION_WITH_CREDIT_RIGHTS_LINKED_REVENUE_TAXED_AND_NOT_TAXED_INTERNAL_MARKET_AND_EXPORT_REVENUE("56", "Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação"),

    PRESUMED_CREDIT_OPERATION_WITH_CREDIT_RIGHTS_LINKED_EXCLUSIVELY_REVENUE_TAXED_INTERNAL_MARKET("60", "Crédito Presumido - Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno"),
    PRESUMED_CREDIT_OPERATION_WITH_CREDIT_RIGHTS_LINKED_EXCLUSIVELY_REVENUE_NOT_TAXED_INTERNAL_MARKET("61", "Crédito Presumido - peração com Direito a Crédito - Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno"),
    PRESUMED_CREDIT_OPERATION_WITH_CREDIT_RIGHTS_LINKED_EXCLUSIVELY_EXPORT_REVENUE("62", "Crédito Presumido - Operação com Direito a Crédito – Vinculada Exclusivamente a Receita de Exportação"),
    PRESUMED_CREDIT_OPERATION_WITH_CREDIT_RIGHTS_LINKED_REVENUE_TAXED_AND_NOT_TAXED_INTERNAL_MARKET("63", "Crédito Presumido - Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno"),
    PRESUMED_CREDIT_OPERATION_WITH_CREDIT_RIGHTS_LINKED_REVENUE_TAXED_INTERNAL_MARKET_AND_EXPORT_REVENUE("64", "Crédito Presumido - Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação"),
    PRESUMED_CREDIT_OPERATION_WITH_CREDIT_RIGHTS_LINKED_REVENUE_NOT_TAXED_INTERNAL_MARKET_AND_EXPORT_REVENUE("65", "Crédito Presumido - Operação com Direito a Crédito - Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;"),
    PRESUMED_CREDIT_OPERATION_WITH_CREDIT_RIGHTS_LINKED_REVENUE_TAXED_AND_NOT_TAXED_INTERNAL_MARKET_AND_EXPORT_REVENUE("66", "Crédito Presumido - Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação"),
    PRESUMED_CREDIT_OTHER_OPERATIONS("67", "Crédito Presumido - Outras Operações;"),

    ACQUISITION_OPERATION_WITHOUT_CREDIT_PERMISSION("70", "Operação de Aquisição sem Direito a Crédito"),
    ACQUISITION_OPERATION_WITH_EXCEMPTION("71", "Operação de Aquisição com Isenção"),
    ACQUISITION_OPERATION_WITH_SUSPENSION("72", "Operação de Aquisição com Suspensão"),
    ACQUISITION_OPERATION_ZERO_ALIQUOT("73", "Operação de Aquisição a Alíquota Zero"),
    ACQUISITION_OPERATION_WITHOUT_INCIDENCE("74", "Operação de Aquisição; sem Incidência da Contribuição"),
    ACQUISITION_OPERATION_WITH_TRIBUTARY_SUBSTITUTION("75", "Operação de Aquisição por Substituição Tributária"),

    OTHER_ENTRANCE_OPERATIONS("98", "Outras Operações de Entrada"),
    OTHER_OPERATIONS("99", "Outras Operações");

    private final String code;
    private final String description;

    NFCSTPIS(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFCSTPIS valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
