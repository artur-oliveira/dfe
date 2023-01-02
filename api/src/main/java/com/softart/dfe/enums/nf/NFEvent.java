package com.softart.dfe.enums.nf;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFEvent implements DFEnum.Codeable {

    CANCEL("110111", "Cancelamento", System.getProperty("DEFAULT_NFE_CANCEL_MESSAGE", "Cancelamento solicitado por conta de erros na emissao")),
    SUBSTITUTE_CANCEL("110112", "Cancelamento por substituicao", System.getProperty("DEFAULT_NFE_SUBSTITUTE_CANCEL_MESSAGE", "Cancelamento solicitado por conta de erros na emissao")),
    CORRECTION_LETTER("110110", "Carta de Correcao", null),
    EPEC("110140", "EPEC", null),
    INTERESTED_ACTOR("110150", "Ator interessado na NF-e", null),
    OPERATION_CONFIRMATION("210200", "Confirmacao da Operacao", null),
    OPERATION_SCIENCE("210210", "Ciencia da Operacao", null),
    OPERATION_IGNORANCE("210220", "Desconhecimento da Operacao", System.getProperty("DEFAULT_NFE_IGNORANCE_OPERATION_MESSAGE", "Nao reconheco essa nota emitida")),
    OPERATION_NOT_PERFORMED("210240", "Operacao nao Realizada", System.getProperty("DEFAULT_NFE_OPERATION_NOT_PERFORMED_MESSAGE", "Essa operacao nao foi realizada")),
    INUTILIZATION("INUTILIZAR", "Inutilizacao", System.getProperty("DEFAULT_NFE_INUTILIZATION_MESSAGE", "Numeracao pulada por conta de erros na emissao")),
    QUERY_PROTOCOL("CONSULTAR", "Consulta protocolo", null),
    QUERY_STATUS_SERVICE("STATUS", "Consulta status serviço", null);

    private final String code;
    private final String description;
    private final String defaultMessage;

    NFEvent(String code, String description, String defaultMessage) {
        this.code = code;
        this.description = description;
        this.defaultMessage = defaultMessage;
    }

    public static NFEvent valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
