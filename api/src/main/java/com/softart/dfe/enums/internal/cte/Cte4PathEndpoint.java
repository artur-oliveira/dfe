package com.softart.dfe.enums.internal.cte;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cte4PathEndpoint implements DFEnum.Codeable {
    AUTHORIZATION("authorization400", "Autorização"),
    QUERY_PROTOCOL("query_protocol400", "Consulta protocolo"),
    QUERY_SITUATION("query_situation400", "Consulta situação"),
    STATUS_SERVICE("status_service400", "Consulta status do serviço"),
    DISTRIBUTION("distribution", "Distribuição"),
    RECEPTION_SYNC("reception_sync400", "Recepção CT-e síncrono"),
    RECEPTION_GTVE("reception_gtve400", "Recepção GTV-e"),
    RECEPTION_OS("reception_os400", "Recepção CT-e OS"),
    EVENT("event400", "Eventos");

    private final String code;
    private final String description;
}
