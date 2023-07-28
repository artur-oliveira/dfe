package com.softart.dfe.enums.nf.payment;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

/*



 */
@Getter
public enum NFPaymentType implements DFEnum.Codeable {

    MONEY("01", "Dinheiro"),
    CHECK("02", "Cheque"),
    CREDIT_CARD("03", "Cartão de Crédito"),
    DEBIT_CARD("04", "Cartão de Débito"),
    STORE_CREDIT("05", "Crédito Loja"),
    FOOD_TICKET("10", "Vale Alimentação"),
    MEAL_TICKET("11", "Vale Refeição"),
    GIFT_CARD("12", "Vale Presente"),
    FUEL_TICKET("13", "Vale Combustível"),
    BANK_SLIP("15", "Boleto Bancário"),
    BANK_DEPOSIT("16", "Depósito Bancário"),
    PIX("17", "Pagamento Instantâneo (PIX)"),
    BANK_TRANSFER("18", "Transferência bancária, Carteira Digital"),
    LOYALTY_CASHBACK_VIRTUAL_CREDIT("19", "Programa de fidelidade, Cashback, Crédito Virtual"),
    NO_PAYMENT("90", " Sem pagamento"),
    OTHER("99", "Outros"),
    ;

    private final String code;
    private final String description;

    NFPaymentType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFPaymentType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
