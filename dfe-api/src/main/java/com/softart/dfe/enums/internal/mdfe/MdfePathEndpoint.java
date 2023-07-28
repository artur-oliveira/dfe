package com.softart.dfe.enums.internal.mdfe;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfePathEndpoint implements DFEnum.Codeable {
    RECEPTION("reception", "Recepção"),
    QUERY_RECEIPT("return_reception", "Consulta recibo"),
    EVENT("event", "Eventos"),
    QUERY_SITUATION("query_situation", "Consulta situação"),
    STATUS_SERVICE("status_service", "Status do serviço"),
    QUERY_UNCLOSED("query_unclosed", "Consulta não encerrados"),
    DISTRIBUTION("distribution", "Distribuição"),
    DISTRIBUTION_OLD("distributionold", "Distribuição Antiga"),
    RECEPTION_SYNC("reception_sync", "Recepção síncrona");

    private final String code;
    private final String description;
}
