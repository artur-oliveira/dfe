package com.softart.dfe.models.internal.cte;

import com.softart.dfe.models.cte.reception_gtve.Gtve;
import lombok.Builder;

@Builder
public record GtveQrCode(
        Gtve gtve
) {
}
