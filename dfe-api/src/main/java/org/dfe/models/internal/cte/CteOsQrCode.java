package org.dfe.models.internal.cte;

import org.dfe.models.cte.reception_os.CteOs;
import lombok.Builder;

@Builder
public record CteOsQrCode(
        CteOs cteOs
) {

}
