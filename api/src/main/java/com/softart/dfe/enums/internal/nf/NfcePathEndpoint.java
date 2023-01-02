package com.softart.dfe.enums.internal.nf;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NfcePathEndpoint implements DFEnum.Codeable {
    AUTHORIZATION("authorization", "Autorização"),
    RETURN_AUTHORIZATION("return_authorization", "Consulta recibo"),
    EVENT_CANCEL("event_cancel", "Evento de cancelamento"),
    EVENT_SUBSTITUTE_CANCEL("event_substitute_cancel", "Evento de cancelamento por substituição"),
    INUTILIZATION("inutilization", "Inutilização"),
    QUERY_PROTOCOL("query_protocol", "Consulta protocolo"),
    STATUS_SERVICE("status_service", "Consulta status do serviço");

    private final String code;
    private final String description;
}
