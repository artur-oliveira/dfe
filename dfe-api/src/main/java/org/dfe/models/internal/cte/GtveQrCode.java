package org.dfe.models.internal.cte;

import org.dfe.models.cte.reception_gtve.Gtve;
import lombok.Builder;

@Builder
public record GtveQrCode(
        Gtve gtve
) {
}
