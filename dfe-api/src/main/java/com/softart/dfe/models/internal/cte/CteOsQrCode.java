package com.softart.dfe.models.internal.cte;

import com.softart.dfe.models.cte.reception_os.CteOs;
import lombok.Builder;

@Builder
public record CteOsQrCode(
        CteOs cteOs
) {

}
