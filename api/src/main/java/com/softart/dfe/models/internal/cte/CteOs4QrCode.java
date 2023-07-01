package com.softart.dfe.models.internal.cte;

import com.softart.dfe.models.cte4.reception_gtve.Gtve;
import com.softart.dfe.models.cte4.reception_os.CteOs;
import com.softart.dfe.models.cte4.reception_sync.Cte;
import lombok.Builder;

@Builder
public record CteOs4QrCode(
        CteOs cteOs
) {

}
