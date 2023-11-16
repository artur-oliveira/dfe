package org.dfe.enums.internal.cte;

import org.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CtePathEndpoint implements DFEnum.Codeable {
    AUTHORIZATION("authorization", "Autorização"),
    QUERY_RECEIPT("return_reception", "Consulta recibo"),
    INUTILIZATION("inutilization", "Inutilização"),
    QUERY_PROTOCOL("query_protocol", "Consulta protocolo"),
    QUERY_SITUATION("query_situation", "Consulta situação"),
    STATUS_SERVICE("status_service", "Consulta status do serviço"),
    DISTRIBUTION("distribution", "Distribuição"),
    RECEPTION("reception", "Recepção CT-e"),
    RECEPTION_SYNC("reception_sync", "Recepção CT-e síncrono"),
    RECEPTION_GTVE("reception_gtve", "Recepção GTV-e"),
    RECEPTION_OS("reception_os", "Recepção CT-e OS"),
    EVENT("event", "Eventos");

    private final String code;
    private final String description;
}
