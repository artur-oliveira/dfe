package com.softart.dfe.models.internal.cte;

import com.softart.dfe.models.cte.reception.Cte;
import lombok.Builder;

@Builder
public record CteQrCode(
        Cte cte
) {

}
