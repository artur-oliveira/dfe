package org.dfe.enums.cte.info.transport;

import org.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CteTransportUnid implements DFEnum.Codeable {
    TRACTION("1", "Rodoviário Tração"),
    TRAILER("2", "Rodoviário Reboque"),
    SHIP("3", "Navio"),
    FERRY("4", "Balsa"),
    AIRCRAFT("5", "Aeronave"),
    WAGON("6", "Vagão"),
    OTHER("7", "Outros");
    private final String code;
    private final String description;

    public static CteTransportUnid valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
