package org.dfe.enums.internal.nf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@Getter
@AllArgsConstructor
public enum NfcePathEndpoint implements DFEnum.Codeable {
    AUTHORIZATION("authorization", "Autorização"),
    RETURN_AUTHORIZATION("return_authorization", "Consulta recibo"),
    EVENT("event_generic", "Evento genérico"),
    INUTILIZATION("inutilization", "Inutilização"),
    QUERY_PROTOCOL("query_protocol", "Consulta protocolo"),
    STATUS_SERVICE("status_service", "Consulta status do serviço");

    private final String code;
    private final String description;
}
