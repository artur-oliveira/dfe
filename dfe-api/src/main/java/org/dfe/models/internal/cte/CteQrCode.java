package org.dfe.models.internal.cte;

import org.dfe.models.cte.reception.Cte;
import lombok.Builder;

@Builder
public record CteQrCode(
        Cte cte
) {

}
