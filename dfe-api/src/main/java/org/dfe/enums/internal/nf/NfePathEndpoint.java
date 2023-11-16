package org.dfe.enums.internal.nf;

import org.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NfePathEndpoint implements DFEnum.Codeable {
    AUTHORIZATION("authorization", "Autorização"),
    RETURN_AUTHORIZATION("return_authorization", "Consulta recibo"),
    EVENT_CANCEL("event_cancel", "Evento de cancelamento"),
    INUTILIZATION("inutilization", "Inutilização"),
    QUERY_PROTOCOL("query_protocol", "Consulta protocolo"),
    QUERY_REGISTER("query_register", "Consulta cadastro"),
    STATUS_SERVICE("status_service", "Consulta status do serviço"),
    DISTRIBUTION("distribution", "Distribuição"),
    EVENT_EPEC("event_epec", "Evento de EPEC"),
    EVENT_MANIFESTATION("event_manifestation", "Evento de manifestação"),
    EVENT_CORRECTION_LETTER("event_correction_letter", "Evento de carta de correção"),
    EVENT_INTERESTED_ACTOR("event_interested_actor", "Evento de ator interessado"),
    QUERY_GTIN("query_gtin", "Consulta GTIN");

    private final String code;
    private final String description;
}
