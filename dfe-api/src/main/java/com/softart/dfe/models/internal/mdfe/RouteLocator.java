package com.softart.dfe.models.internal.mdfe;

import com.softart.dfe.enums.internal.UF;
import lombok.Builder;

@Builder
public record RouteLocator(
        UF start,
        UF end,
        boolean includeStartEnd
) {

}
