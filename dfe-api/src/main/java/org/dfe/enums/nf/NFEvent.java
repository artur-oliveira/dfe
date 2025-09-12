package org.dfe.enums.nf;

import lombok.Getter;
import org.dfe.components.internal.DFEnum;

import java.util.Arrays;
import java.util.Collection;

@Getter
public enum NFEvent implements DFEnum.Codeable {

    CANCEL("110111", "Cancelamento", System.getProperty("org.dfe.nf.message.cancel", "Erro de emissao")),
    SUBSTITUTE_CANCEL("110112", "Cancelamento por substituicao", System.getProperty("org.dfe.nf.message.cancel", "Erro de emissao")),
    CORRECTION_LETTER("110110", "Carta de Correcao", null),
    EPEC("110140", "EPEC", null),
    INTERESTED_ACTOR("110150", "Ator interessado na NF-e", null),
    OPERATION_CONFIRMATION("210200", "Confirmacao da Operacao", null),
    OPERATION_SCIENCE("210210", "Ciencia da Operacao", null),
    OPERATION_IGNORANCE("210220", "Desconhecimento da Operacao", System.getProperty("org.dfe.nf.message.ignorance", "Nota nao reconhecida")),
    OPERATION_NOT_PERFORMED("210240", "Operacao nao Realizada", System.getProperty("org.dfe.nf.message.not_performed", "Operacao nao realizada")),
    INUTILIZATION("INUTILIZAR", "Inutilizacao", System.getProperty("org.dfe.nf.message.inutilization", "Erro de emissao")),
    QUERY_PROTOCOL("CONSULTAR", "Consulta protocolo", null),
    QUERY_REGISTER("CONS-CAD", "Consulta cadastro", null),
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

    public static Collection<NFEvent> manifestation() {
        return Arrays.asList(NFEvent.OPERATION_IGNORANCE, NFEvent.OPERATION_SCIENCE, NFEvent.OPERATION_NOT_PERFORMED, NFEvent.OPERATION_CONFIRMATION);
    }
}
