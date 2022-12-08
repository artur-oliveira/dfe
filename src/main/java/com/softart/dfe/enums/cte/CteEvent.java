package com.softart.dfe.enums.cte;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum CteEvent implements DFEnum.Codeable {

    STATUS_SERVICE("STATUS", "Consulta status serviço"),
    INUTILIZATION("INUTILIZAR", "Inutilizacao", System.getProperty("DEFAULT_CTE_INUTILIZATION_MESSAGE", "Numeracao pulada por conta de erros na emissao")),
    QUERY_SITUATION("CONSULTAR", "Consulta situação"),
    CANCEL("110111", "Cancelamento", System.getProperty("DEFAULT_CTE_CANCEL_MESSAGE", "Cancelamento solicitado por conta de erros na emissao")),
    CORRECTION_LETTER("110110", "Carta de Correcao", null);
    private final String code;
    private final String description;
    private final String defaultMessage;

    CteEvent(String code, String description, String defaultMessage) {
        this.code = code;
        this.description = description;
        this.defaultMessage = defaultMessage;
    }

    CteEvent(String code, String description) {
        this(code, description, null);
    }

    public static CteEvent valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
